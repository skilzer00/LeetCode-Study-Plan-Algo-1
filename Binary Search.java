// Approach 1: Binary Search
// Intuition

// Binary search is a textbook algorithm based on the idea to compare the target value to the middle element of the array.

// If the target value is equal to the middle element - we're done.

// If the target value is smaller - continue to search on the left.

// If the target value is larger - continue to search on the right.

// Algorithm

// Initialise left and right pointers : left = 0, right = n - 1.

// While left <= right :

// Compare middle element of the array nums[pivot] to the target value target.

// If the middle element is the target target = nums[pivot] : return pivot.

// If the target is not yet found :

// If target < nums[pivot], continue the search on the left right = pivot - 1.

// Else continue the search on the right left = pivot + 1.

class Solution {
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length-1;
      int pivot = 0;
      while(left<=right){
        pivot = left + (right-left)/2;
        if(nums[pivot]==target) return pivot;
        if(target < nums[pivot]) right=pivot-1;
        else left=pivot+1;
      }
      return -1;
      
    }
}
