#include "quicksort.h"
#include "stdio.h"

// test quicksort with one element array
int test_with_one_element()
{
    printf("--- test_with_one_element ---\n");
    int A[] = {1};
    int size = 1;

    quicksort(A, size);

    if (A[0] != 1) {
        printf("expected sorted array to be [1], but got %d at at index 0\n", A[0]);
        return 0;
    }
    printf("--- test_with_one_element ---\n");
    return 1;
}



// test quicksort with normal array
int test_with_normal_array()
{
    printf("\n--- test_with_normal_array ---\n");
    int A[] = {3,8,10,9,6,7,5,4,19,21,2};
    int size = 11;

    quicksort(A, size);

    if (A[0] != 2 || A[1] != 3 || A[2] != 4 || A[3] != 5 || A[4] != 6 || A[5] != 7
    || A[6] != 8 || A[7] != 9 || A[8] != 10 || A[9] != 19 || A[10] != 21) {
        for (int i = 0; i < size; i++) {
            printf("expected sorted array to be [2,3,4,5,6,7,8,9,10,19,21], "
                   "but got %d at at index %d\n", A[i], i);
            return 0;
        }
    }
    printf("--- test_with_normal_array ---\n");
    return 1;
}


//int main() {
//
//    int total_tests = 2;
//    int passed_tests = 0;
//
//    passed_tests += test_with_one_element();
//    passed_tests += test_with_normal_array();
//
//    // Print the test result.
//    printf("Ran %d tests, passed %d tests, failed %d tests\n",
//           total_tests, passed_tests, total_tests - passed_tests);
//    return 0;
//}