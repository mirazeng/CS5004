// =============================================================== Pseudocode

// find_left_bound(A, n, element) - find the leftmost index of the target value
// {
//     left = 0;
//     right = n - 1;
//     int first;
//     while (left <= right) {
//         mid = (left + right) / 2;
//     if (A[mid] == element) {
//         first = mid;

//         // keep reaching to the left
//         // make sure to find the most left bound
//         //make sure to find the most left bound
//         right = mid - 1;
//     else if (A[mid] < element){
//        left = mid + 1;
//     }
//     else if (A[mid] > element){
//         right = mid - 1;
//     } else {}
//     }
//     return first;
// }

// find_right_bound(A, n, element) - find the rightmost index of the target value
// {
//     left = 0;
//     right = n - 1;
//     int last;
//     while (left <= right) {
//         mid = (left + right) / 2;
//     if (A[mid] == element) {
//         last = mid;'
//     //keep reaching to the right
//         left = mid + 1;
//     }
//     else if (A[mid] < element) {
//         left = mid + 1;
//     }
//     else if (A[mid] > element){
//        right = mid - 1;
//     } else {}
//     }
//     return last;
// }

// search_range(A, n, element) - find the range of the target value
// {
//     left = find_left_bound(A, n, element);
//     right = find_right_bound(A, n, element);
//     return (left, right);
// }


// ========================================================================= Big O notation

// The time complexity of the search_range function is O(log n)
// because we are using binary search to find the left and right bounds of the target value.

// The space complexity is O(1)
// because we are not using any additional data structures.


// ===================== Test cases

// A = [-1,0,1,1,1] and element = 1
// search_range(A, 5, 1) => (2, 4)

// A = [0,1] and element = 0
// search_range(A, 2, 0) => (0, 0)

// A = [0,1] and element = 2
// search_range(A, 2, 2) => (-1, -1)

// A = [1,1,1,1,1] and element = 1
// search_range(A, 5, 1) => (0, 4)