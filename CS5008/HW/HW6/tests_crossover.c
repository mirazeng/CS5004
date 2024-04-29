// gcc tests_crossover.c binsearch.c -o crossover
// ./crossover

#include "binsearch.h"
#include <stdio.h>

// test crossover with empty array
int test_empty_array()
{
    printf("---Test test_empty_array begin: ---\n");
    int A[] = {};
    int n = 0;
    int expected = -1;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_empty_array end:---\n");
        return 1;
    }
}

// test crossover with one element array
int test_one_element_array()
{
    printf("\n---Test test_one_element_array begin: ---\n");
    int A[] = {1};
    int n = 1;
    int expected = -1;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_one_element_array end:---\n");
        return 1;
    }
}

// test crossover with one negative element array
int test_one_negative_element_array()
{
    printf("\n---Test test_one_negative_element_array begin: ---\n");
    int A[] = {-1};
    int n = 1;
    // the first negative element is at index 0
    int expected = 0;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_one_negative_element_array end:---\n");
        return 1;
    }
}

// test crossover with one positive element and one negative element
int test_one_positive_one_negative_element_array()
{
    printf("\n---Test test_one_positive_one_negative_element_array begin: ---\n");
    int A[] = {1, -1};
    int n = 2;
    // the first negative element is at index 1
    int expected = 1;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_one_positive_one_negative_element_array end:---\n");
        return 1;
    }
}

// test crossover with all negative elements
int test_all_negative_elements()
{
    printf("\n---Test test_all_negative_elements begin: ---\n");
    int A[] = {-1, -2, -3, -4, -5};
    int n = 5;
    // the first negative element is at index 0
    int expected = 0;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_all_negative_elements end:---\n");
        return 1;
    }
}

// test crossover with all positive elements
int test_all_positive_elements()
{
    printf("\n---Test test_all_positive_elements begin: ---\n");
    int A[] = {1, 2, 3, 4, 5};
    int n = 5;
    // there is no negative element in the array
    int expected = -1;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_all_positive_elements end:---\n");
        return 1;
    }
}

// test crossover with negative elements at the last index
int test_negative_elements_at_last_index()
{
    printf("\n---Test test_negative_elements_at_last_index begin: ---\n");
    int A[] = {1, 2, 3, 4, -5};
    int n = 5;
    // the first negative element is at index 4
    int expected = 4;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_negative_elements_at_last_index end:---\n");
        return 1;
    }
}

// test crossover with middle element as negative
int test_middle_element_as_negative()
{
    printf("\n---Test test_middle_element_as_negative begin: ---\n");
    int A[] = {1, 2, -3, -1, -2};
    int n = 5;
    int expected = 2;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_middle_element_as_negative end:---\n");
        return 1;
    }
}

// test crossover with all negative elements that are the same
int test_same_negative_elements()
{
    printf("\n---Test test_same_negative_elements begin: ---\n");
    int A[] = {1,1,-1, -1, -1, -1, -1};
    int n = 6;
    // should only return the first encountered negative element
    int expected = 2;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_same_negative_elements end:---\n");
        return 1;
    }
}

// test crossover with an array of large size
int test_array_with_large_element()
{
    printf("\n---Test test_array_with_large_element begin: ---\n");
    // create an array of 10001 elements
    int A[10001];
    // add elements from 10000 to -1
    for(int i = 10000; i >= -1; i--){
        if(i == 0){
        }
        else{
            int position = 10000 - i;
            A[position] = i;
        }
    }
    int n = 10001;
    // the first negative element is at index 10000
    int expected = 10000;
    int result = crossover(A, n);
    if (result != expected) {
        printf("expected result should be %d, but it is %d.\n", expected, result);
        return 0;
    } else {
        printf("---Test test_array_with_large_element end:---\n");
        return 1;
    }
}

int main()
{
    int total_tests = 10;
    int passed_tests = 0;

    // Test the function crossover.
    passed_tests += test_empty_array();
    passed_tests += test_one_element_array();
    passed_tests += test_one_negative_element_array();

    passed_tests += test_one_positive_one_negative_element_array();

    passed_tests += test_all_negative_elements();
    passed_tests += test_all_positive_elements();

    passed_tests += test_negative_elements_at_last_index();

    passed_tests += test_middle_element_as_negative();

    passed_tests += test_same_negative_elements();

    passed_tests += test_array_with_large_element();

    // print the result
    printf("Ran %d tests, passed %d tests, failed %d tests\n", total_tests, passed_tests, (total_tests - passed_tests));
    return 0;
}
