#include <stdio.h>

// use trinary search to find the target element in the array
// use mid1 and mid2 to divide the array into 3 parts
// and implement the search algorithm, also an extension of binary search
// this is a O(log3(n)) algorithm (which is essentially O(log(n)) algorithm)
int trinary_search(int A[], int n, int element)
{
    // initialize trackers
    int left = 0; // the left end of the array
    int right = n - 1; // the right end of the array

    while (left <= right) {

        // find the 1/3 length of the array
        int third = (right - left) / 3;
        // find the two midpoints
        int midpoint1 = left + third;
        int midpoint2 = right - third;

        // check if the element is at the midpoints
        if (A[midpoint1] == element) {
            return midpoint1;
        }
        if (A[midpoint2] == element) {
            return midpoint2;
        }

        // handle searching
        // find respective third interval to search
        if (element < A[midpoint1]) {
            right = midpoint1 - 1;
        } else if (element > A[midpoint2]) {
            left = midpoint2 + 1;
        } else {
            // search between the two midpoints
            // moving both midpoints towards the element
            left = midpoint1 + 1;
            right = midpoint2 - 1;

        }
    }
    // element not found
    return -1;
}

// use binary search to find the first negative element in the array
// this is a O(log(n)) algorithm
int crossover(int A[], int n)
{
    // initialize length trackers
    int left = 0;
    int right = n - 1;

    // initialize result variable
    int result = -1;

    while (left <= right) {
        // find the midpoint by dividing the current length of the array by 2
        int mid = (left + right) / 2;

        // if the element at the midpoint is negative
        if (A[mid] < 0) {
            result = mid; // may encounter first negative element
            right = mid - 1; // to check if the left side has no more negative elements
        } else {
            // if the element at the midpoint is positive
            // search the right side of the array
            left = mid + 1;
        }
    }
    // return the result
    return result;
}

//int main() {
//    // test trinary search
//    int A[] = {0,1, 2, 3, 4, 5, 8, 13, 21, 34, 55};
//    int n = sizeof(A) / sizeof(A[0]);
//    int element = 4;
//    int result = trinary_search(A, n, element);
//    if (result == -1) {
//        printf("Element not found in the array\n");
//    } else {
//        printf("Element found in array A at index: %d\n", result);
//    }
//
//    // test crossover
//    int A1[] = {55,22,67,1,-2,-99,-10,-2,-5,-7,-9};
//    int n1 = sizeof(A1) / sizeof(A1[0]);
//    int result1 = crossover(A1, n1);
//    if (result1 == 0) {
//        printf("Element not found in the array\n");
//    } else {
//        printf("Element found in array A1 at index: %d\n", result1);
//    }
//    return 0;
//}