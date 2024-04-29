// gcc tests_trinary.c binsearch.c -o trinary
// ./trinary
#include <stdio.h>
#include "binsearch.h"

// test trinary_search with empty array
int test_with_empty_array()
{
    printf("---Test test_with_empty_array begin: ---\n");
    int A[] = {};
    int n = 0;
    int element = 1;
    int expected = -1;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_with_empty_array end:---\n");
        return 1;
    }
}

// test trinary_search with single element in array
int test_with_one_element_array()
{
    printf("\n---Test test_with_one_element_array begin: ---\n");
    int A[] = {1};
    int n = 1;
    int element = 1;
    int expected = 0;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_with_one_element_array end:---\n");
        return 1;
    }
}

// test trinary_search with 2 elements array
int test_with_two_elements_array()
{
    printf("\n---Test test_with_two_elements_array begin: ---\n");
    int A[] = {1, 2};
    int n = 2;
    int element = 2;
    int expected = 1;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_with_two_elements_array end:---\n");
        return 1;
    }
}

// test trinary_search with 3 elements array
int test_with_three_elements_array()
{
    printf("\n---Test test_with_three_elements_array begin: ---\n");
    int A[] = {1, 2, 3};
    int n = 3;
    int element = 3;
    int expected = 2;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_with_three_elements_array end:---\n");
        return 1;
    }
}

// test trinary_search with element at first index
int test_element_at_first_index()
{
    printf("\n---Test test_element_at_first_index begin: ---\n");
    int A[] = {1, 2, 3, 4, 5};
    int n = 5;
    int element = 1;
    int expected = 0;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_element_at_first_index end:---\n");
        return 1;
    }

}

// test trinary_search with element at last index
int test_element_at_last_index()
{
    printf("\n---Test test_element_at_last_index begin: ---\n");
    int A[] = {1, 2, 3, 4, 5};
    int n = 5;
    int element = 5;
    int expected = 4;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_element_at_last_index end:---\n");
        return 1;
    }

}

// test trinary_search with element at midpoint1 index
int test_element_at_midpoint1_index()
{
    printf("\n---Test test_element_at_midpoint1_index begin: ---\n");
    int A[] = {1, 2, 3, 4, 5};
    int n = 5;
    int element = 3;
    int expected = 2;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_element_at_midpoint1_index end:---\n");
        return 1;
    }
}

// test trinary_search with element at midpoint2 index
int test_element_at_midpoint2_index()
{
    printf("\n---Test test_element_at_midpoint2_index begin: ---\n");
    int A[] = {1, 2, 3, 4, 5};
    int n = 5;
    int element = 4;
    int expected = 3;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_element_at_midpoint2_index end:---\n");
        return 1;
    }
}

// test trinary_search with element not found in array
int test_no_element_in_array()
{
    printf("\n---Test test_no_element_in_array begin: ---\n");
    int A[] = {1, 2, 3, 4, 5};
    int n = 5;
    int element = 99;
    int expected = -1;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_no_element_in_array end:---\n");
        return 1;
    }
}

// test trinary_search with regular array
int test_regular_array()
{
    printf("\n---Test test_regular_array begin: ---\n");
    int A[] = {-9, -2, 1, 5, 5, 8, 13, 21, 34, 55};
    int n = 10;
    int element = 34;
    int expected = 8;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_regular_array end:---\n");
        return 1;
    }
}

// test trinary_search with an array that has a lot of elements
int test_large_array()
{
    printf("\n---Test test_large_array begin: ---\n");
    // create an array with 10000 elements
    int A[1000];
    for (int i = 0; i < 1000; i++) {
        A[i] = i;
    }
    int n = 1000;
    // the target element is 9997
    int element = 996;
    int expected = 996;
    int result = trinary_search(A, n, element);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    }
    else{
        printf("---Test test_large_array end:---\n");
        return 1;
    }
}

int main()
{
    int total_tests = 11;
    int tests_passed = 0;

    // Test the function trinary_search.
    tests_passed += test_with_empty_array();

    tests_passed += test_with_one_element_array();
    tests_passed += test_with_two_elements_array();
    tests_passed += test_with_three_elements_array();

    tests_passed += test_element_at_first_index();
    tests_passed += test_element_at_last_index();

    tests_passed += test_element_at_midpoint1_index();
    tests_passed += test_element_at_midpoint2_index();

    tests_passed += test_no_element_in_array();
    tests_passed += test_regular_array();
    tests_passed += test_large_array();

    // Print the test result.
    printf("Ran %d tests, passed %d tests, failed %d tests\n", total_tests, tests_passed, total_tests - tests_passed);
    return 0;
}