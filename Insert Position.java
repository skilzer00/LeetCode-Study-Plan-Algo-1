// Approach 1: Binary Search
// Intuition

// Based on the description of the problem, we can see that it could be a good match with the binary search algorithm.

// Binary search is a search algorithm that find the position of a target value within a sorted array.

// Usually, within binary search, we compare the target value to the middle element of the array at each iteration.

// If the target value is equal to the middle element, the job is done.

// If the target value is less than the middle element, continue to search on the left.

// If the target value is greater than the middle element, continue to search on the right.
  
// o mark the search boundaries, one could use two pointers: left and right. Starting from left = 0 and right = n - 1, we then move either of the pointers according to various situations:

// While left <= right:

// Pivot index is the one in the middle: pivot = (left + right) / 2. The pivot also divides the original array into two subarray.

// If the target value is equal to the pivot element: target == nums[pivot], we're done.

// If the target value is less than the pivot element target < nums[pivot], continue to search on the left subarray by moving the right pointer right = pivot - 1.

// If the target value is greater than the pivot element target > nums[pivot], continue to search on the right subarray by moving the left pointer left = pivot + 1.

// What if the target value is not found?

// In this case, the loop will be stopped at the moment when right < left and nums[right] < target < nums[left]. Hence, the proper position to insert the target is at the index left.
  
// Integer Overflow

// Let us now stress the fact that pivot = (left + right) // 2 works fine for Python3, which has arbitrary precision integers, but it could cause some issues in Java and C++.

// If left + right is greater than the maximum int value 2^{31} - 12 
// 31
//  −1, it overflows to a negative value. In Java, it would trigger an exception of ArrayIndexOutOfBoundsException, and in C++ it causes an illegal write, which leads to memory corruption and unpredictable results.

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int pivot = 0;
        while(left<=right){
            pivot = left + (right-left)/2;
            if (nums[pivot]==target) return pivot;
            if(target< nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
            
        }
        return left;
        
    }
}

// Time complexity : O(logN).
// Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.
