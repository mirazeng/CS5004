// gcc tests_queues.c queues.c -o queues
// ./queues

#include <stdio.h>
#include "queues.h"

// Test the combine function when no array is empty
int test_merge_queues()
{
    printf("===== Test test_merge_queues() begin =======\n");


    int array_1[] = {2, 2, 3, 5, 7, 8};
    // Get the size of the array
    // by dividing the total size of the array by the size of the first element
    int size_1 = sizeof(array_1) / sizeof(array_1[0]);

    int array_2[] = {2, 4, 5, 5, 7, 9, 10, 11};
    int size_2 = sizeof(array_2) / sizeof(array_2[0]);

    // The expected result of the combined array
    int expected_1[] = {2, 2, 2, 3, 4, 5, 5,
                        5, 7, 7, 8, 9, 10, 11
    };


    // Create a new array to store the result
    int result_1[size_1 + size_2];
    combine(array_1, size_1, array_2, size_2, result_1);


    // Print the array by using a for loop with iterator i
    for (int i = 0; i < size_1 + size_2; i++) {
        if (result_1[i] != expected_1[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n",
                   i, expected_1[i], result_1[i]);
            return 0;
        }
        printf("%d ", result_1[i]);
    }
    printf("\n===== Test test_merge_queues() end ========= \n");
    return 1;
}


// Test the combine function when first array is empty
int test_special_merge_1()
{
    printf("===== Test test_special_merge_1() begin ====\n");


    int array_3[] = {};
    // Get the size of the array
    // by dividing the total size of the array by the size of the first element
    int size_3 = sizeof(array_3) / sizeof(array_3[0]);

    int array_4[] = {3, 3, 4, 5, 6, 8, 9};
    int size_4 = sizeof(array_4) / sizeof(array_4[0]);


    // The expected result of the combined array
    int expected_2[] = {3, 3, 4, 5, 6, 8, 9};


    // Create a new array to store the result
    int result_2[size_3 + size_4];
    combine(array_3, size_3, array_4, size_4, result_2);


    // Print the array by using a for loop with iterator i
    for (int i = 0; i < size_3 + size_4; i++) {
        if (result_2[i] != expected_2[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n",
                   i, expected_2[i], result_2[i]);
            return 0;
        }
        printf("%d ", result_2[i]);
    }
    printf("\n===== Test test_special_merge_1() end ====== \n");
    return 1;
}

// Test the combine function when second array is empty
int test_special_merge_2()
{
    printf("===== Test test_special_merge_2() begin ====\n");


    int array_5[] = {3, 3, 4, 5, 6, 8, 9};
    // Get the size of the array
    // by dividing the total size of the array by the size of the first element
    int size_5 = sizeof(array_5) / sizeof(array_5[0]);

    int array_6[] = {};
    int size_6 = sizeof(array_6) / sizeof(array_6[0]);


    // The expected result of the combined array
    int expected_3[] = {3, 3, 4, 5, 6, 8, 9};


    // Create a new array to store the result
    int result_3[size_5 + size_6];
    combine(array_5, size_5, array_6, size_6, result_3);


    // Print the array by using a for loop with iterator i
    for (int i = 0; i < size_5 + size_6; i++) {
        if (result_3[i] != expected_3[i]) {
            printf("Element at index %d does not match: expected %d but got %d\n",
                   i, expected_3[i], result_3[i]);
            return 0;
        }
        printf("%d ", result_3[i]);
    }
    printf("\n===== Test test_special_merge_2() end ====== \n");
    return 1;
}


// Test the combine function two empty arrays
int test_special_merge_3()
{
    printf("===== Test test_special_merge_3() begin ====\n");


    int array_7[] = {};
    // Get the size of the array
    // by dividing the total size of the array by the size of the first element
    int size_7 = sizeof(array_7) / sizeof(array_7[0]);

    int array_8[] = {};
    int size_8 = sizeof(array_8) / sizeof(array_8[0]);


    // The expected result of the combined array
    int expected_4[] = {};


    // Create a new array to store the result
    int result_4[size_7 + size_8];
    combine(array_7, size_7, array_8, size_8, result_4);

    int result = 0;

    // Check if the size of the array is still 0 after defragmentation
    if (sizeof(result_4) == 0) {
        // Print a message indicating the array is still empty,
        // which means the function worked as expected.
        printf("The array is empty");
        result = 1;
    } else {
        // if size is not 0, print a message indicating an issue.
        // This means the function might have modified the array.
        printf("The array is not empty");
        result = 0;
    }

    printf("\n===== Test test_special_merge_3() end ====== \n");
    return result;
}


int main()
{
    int total_tests = 4;
    // Initialize a tracker of tests passed
    int tests_passed = 0;

    // Print the result of each test
    // Print two line breakers for better readability
    tests_passed += test_merge_queues();
    printf("\n");
    printf("\n");

    tests_passed += test_special_merge_1();
    printf("\n");
    printf("\n");

    tests_passed += test_special_merge_2();
    printf("\n");
    printf("\n");

    tests_passed += test_special_merge_3();
    printf("\n");
    printf("\n");

    printf("Ran %d tests, passed %d tests, failed %d tests\n",
           total_tests, tests_passed, total_tests - tests_passed);
}
