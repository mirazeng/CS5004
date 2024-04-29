// gcc test_defragment.c defrag.c -o defrag
// ./defrag

#include  <stdio.h>
#include "defrag.h"

// This test is about input array no longer need defragmentation
// It should return the original array
int test_no_defrag_necessary()
{
    printf("---Test test_no_frag_necessary() begin: ---\n");

    int array_1[] = {4, 3, 5, 2, -1, -1, -1, -1};

    // The expected result
    int expected_1[] = {4, 3, 5, 2, -1, -1, -1, -1};

    defragment(array_1, 8);

    // Print the array with a for loop by using an iterator i
    for (int i = 0; i < 8; i += 1) {
        if (array_1[i] != expected_1[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n", i, expected_1[i], array_1[i]);
            return 0;
        }
    }
    printf("---Test test_no_defrag_necessary() end ---\n");
    return 1;
}

// This test is about input array need defragmentation
// It should return the array where all the -1s are in the end
int test_defrag()
{
    printf("---Test test_defrag begin(): ---\n");

    int array_2[] = {4, 2, 6, -1, 8, -1, -1, 3, 4, -1, 8, 2};

    // The expected result
    int expected_2[] = {4, 2, 6, 8, 3, 4, 8, 2, -1, -1, -1, -1};

    defragment(array_2, 12);

    // Print the array with a for loop by using an iterator i
    for (int i = 0; i < 12; i += 1) {
        if (array_2[i] != expected_2[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n", i, expected_2[i], array_2[i]);
            return 0;
        }
    }
    printf("---Test test_defrag() end ---\n");
    return 1;
}

// This test is about input array with all -1s
// defragmentation function should not change the array
int test_special_case_1()
{
    printf("---Test test_special_cases1() begin: ---\n");

    int array_3[] = {-1, -1, -1, -1, -1, -1};

    // The expected result
    int expected_3[] = {-1, -1, -1, -1, -1, -1};

    defragment(array_3, 6);

    // Print the array with a for loop by using an iterator i
    for (int i = 0; i < 6; i += 1) {
        if (array_3[i] != expected_3[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n", i, expected_3[i], array_3[i]);
            return 0;
        }
    }
    printf("---Test test_special_cases1() end ---\n");
    return 1;
}

// This test is about input array without -1
// defragmentation function should not change the array
int test_special_case_2()
{
    printf("---Test test_special_case_2() begin: ---\n");

    int array_4[] = {2, 3, 4, 5, 6, 7, 8, 9};

    // The expected result
    int expected_4[] = {2, 3, 4, 5, 6, 7, 8, 9};

    defragment(array_4, 8);

    // Print the array with a for loop by using an iterator i
    for (int i = 0; i < 8; i += 1) {
        if (array_4[i] != expected_4[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n", i, expected_4[i], array_4[i]);
            return 0;
        }
    }
    printf("---Test test_special_case_2() end ---\n");
    return 1;
}

// This test is about input array is empty
// defragmentation function should not change the array
int test_special_case_3()
{
    printf("---Test test_special_case_3() begin: ---");

    // Initialize an empty array
    int array_5[] = {};

    // Calling function as array is empty
    // its size is passed as 0
    defragment(array_5, 0);

    // Initialize a result variable
    int result = 0;

    // Check if the size of the array is still 0 after defragmentation
    if (sizeof(array_5) == 0) {
        // Print a message indicating the array is still empty,
        // which means the function worked as expected.
        printf("The array is empty\n");
        result = 1;
    } else {
        // if size is not 0, print a message indicating an issue.
        // This means the function might have modified the array.
        printf("The array is not empty");
        result = 0;
    }
    printf("---Test test_special_case_3() end ---\n");
    return result;
}


int main()
{
    int total_tests = 5;
    // Initialize a tracker of tests passed
    int tests_passed = 0;

    // Run the tests
    // Print two line breakers for better readability
    tests_passed += test_no_defrag_necessary();
    printf("\n");
    printf("\n");

    tests_passed += test_defrag();
    printf("\n");
    printf("\n");

    tests_passed += test_special_case_1();
    printf("\n");
    printf("\n");

    tests_passed += test_special_case_2();
    printf("\n");
    printf("\n");

    tests_passed += test_special_case_3();
    printf("\n");
    printf("\n");

    printf("Ran %d tests, passed %d tests, failed %d tests\n", total_tests, tests_passed, total_tests - tests_passed);
}