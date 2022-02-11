// Approach #2 (Binary Search) [Accepted]
// It is not difficult to see that this could be solved using a classic algorithm - Binary search. Let us see how the search space could be halved each time below.

// Scenario #1: isBadVersion(mid) => false

//  1 2 3 4 5 6 7 8 9
//  G G G G G G B B B       G = Good, B = Bad
//  |       |       |
// left    mid    right
// Let us look at the first scenario above where isBadVersion(mid) \Rightarrow falseisBadVersion(mid)⇒false. We know that all versions preceding and including midmid are all good. So we set left = mid + 1left=mid+1 to indicate that the new search space is the interval [mid + 1, right][mid+1,right] (inclusive).

// Scenario #2: isBadVersion(mid) => true

//  1 2 3 4 5 6 7 8 9
//  G G G B B B B B B       G = Good, B = Bad
//  |       |       |
// left    mid    right
// The only scenario left is where isBadVersion(mid) \Rightarrow trueisBadVersion(mid)⇒true. This tells us that midmid may or may not be the first bad version, but we can tell for sure that all versions after midmid can be discarded. Therefore we set right = midright=mid as the new search space of interval [left,mid][left,mid] (inclusive).

// In our case, we indicate leftleft and rightright as the boundary of our search space (both inclusive). This is why we initialize left = 1left=1 and right = nright=n. How about the terminating condition? We could guess that leftleft and rightright eventually both meet and it must be the first bad version, but how could you tell for sure?

// The formal way is to prove by induction, which you can read up yourself if you are interested. Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.

// If you are setting mid = \frac{left + right}{2}mid= 
// 2
// left+right
// ​
//  , you have to be very careful. Unless you are using a language that does not overflow such as Python, left + rightleft+right could overflow. One way to fix this is to use left + \frac{right - left}{2}left+ 
// 2
// right−left
// ​
//   instead.

// If you fall into this subtle overflow bug, you are not alone. Even Jon Bentley's own implementation of binary search had this overflow bug and remained undetected for over twenty years.

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while(left<right){
            mid = left + (right-left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
        
    }
}

// Complexity analysis

// Time complexity : O(logn). The search space is halved each time, so the time complexity is O(logn).

// Space complexity : O(1).
