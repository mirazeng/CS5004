// gcc main.c funwstring.c funwchar.c -o test
// ./test

#include <stdio.h>
#include "funwithall.h"

// This part of test is about funwstring.c:
// Test the function shift letters to the right
int test_right_shift()
{
    printf("---Test test_right_shift begin: ---\n");

    // initialize the string
    char string_1[] = {'T', 'h', 'a', 'n', 'k', 'U', '0', '8', '\0'};
    // initialize the expected result
    char expected[] = {'T', 'h', 'a', 'n', 'k', 'U', '0', '8', '\0'};
    // get the size of the string
    // sizeof(string_1) returns the size of the string in bytes
    int size_1 = sizeof(string_1) / sizeof(char);

    shift(string_1, 26);

    // compare the result with the expected result
    for (int i = 0; i < size_1; i++) {
        if (string_1[i] != expected[i]) {
            printf("Element at index %d does not match: expected %c but got %c\n", i, expected[i], string_1[i]);
            return 0;
        }
    }
    printf("\n---Test test_right_shift end---\n");
    return 1;
}

// Test the function shift letters to the left
int test_left_shift()
{
    printf("---Test test_left_shift begin: ---\n");

    // initialize the string
    char string_2[] = {'$', '3', '.', '2', 'd', 'o', 'l', 'l', 'a', 'r', 's'};
    // initialize the expected result
    char expected[] = {'$', '3', '.', '2', 't', 'e', 'b', 'b', 'q', 'h', 'i'};
    // get the size of the string
    // sizeof(string_2) returns the size of the string in bytes
    int size_2 = sizeof(string_2) / sizeof(char);

    shift(string_2, -10);

    // compare the result with the expected result
    for (int i = 0; i < size_2; i++) {
        if (string_2[i] != expected[i]) {
            printf("Element at index %d does not match: expected %c but got %c\n", i, expected[i], string_2[i]);
            return 0;
        }
    }
    printf("\n---Test test_left_shift end---\n");
    return 1;
}

// Test the function with no shift
int test_zero_shift()
{
    printf("---Test test_zero_shift begin: ---\n");

    // initialize the string
    char string_3[] = {'a', 'p', 'p', 'l', 'e', '\0'};
    // initialize the expected result
    char expected[] = {'a', 'p', 'p', 'l', 'e', '\0'};
    // get the size of the string
    // sizeof(string_3) returns the size of the string in bytes
    int size_3 = sizeof(string_3) / sizeof(char);

    shift(string_3, 0);

    // compare the result with the expected result
    for (int i = 0; i < size_3; i++) {
        if (string_3[i] != expected[i]) {
            printf("Element at index %d does not match: expected %c but got %c\n", i, expected[i], string_3[i]);
            return 0;
        }
    }
    printf("\n---Test test_zero_shift end---\n");
    return 1;
}

// Test the function with array stops in the middle
int test_special_shift()
{
    printf("---Test test_special_shift begin: ---\n");

    // initialize the string
    char string_4[] = {'a', 'p', 'p', '\0', 'l', 'e', '\0'};

    // initialize the expected result
    // if the expected looks like this {'b', 'q', 'q', '\0'}, it would still be correct,
    // since in C the '\0' marks end of string, cutting off the rest no matter if they exist or not
    char expected[] = {'b', 'q', 'q', '\0', 'l', 'e', '\0'};

    // get the size of the string
    // sizeof(string_4) returns the size of the string in bytes
    int size_4 = sizeof(string_4) / sizeof(char);

    shift(string_4, 1);

    // compare the result with the expected result
    for (int i = 0; i < size_4; i++) {
        if (string_4[i] != expected[i]) {
            printf("Element at index %d does not match: expected %c but got %c\n", i, expected[i], string_4[i]);
            return 0;
        }
    }
    printf("\n---Test test_special_shift end---\n");
    return 1;
}

//========================================================================================================
//========================================================================================================

// This part of test is about funwchar.c
// Test the function next with lower case
int test_next_lower()
{
    printf("---Test test_next_lower begin: ---\n");

    // initialize the character
    char ch_1 = {'z'};

    // initialize the expected result
    char expected = {'a'};

    // get the next character
    char moved_ch = next(ch_1);

    // compare the result with the expected result by tracking the result
    int result;
    if (moved_ch != expected) {
        printf("Element does not match: expected %c but got %c\n", expected, moved_ch);
        result = 0;
    } else {
        result = 1;
    }
    printf("\n---Test test_next_lower end---\n");
    return result;
}

// Test the function next with upper case
int test_next_upper()
{
    printf("---Test test_next_upper begin: ---\n");

    // initialize the character
    char ch_2 = {'a'};
    char ch_3 = {'h'};
    char ch_4 = {'z'};
    char ch_5 = {'&'};

    // initialize the expected result
    char expected = {'b'};

    // get the next character
    char moved_ch = next(ch_2);
    printf("%c",next(ch_2));
    printf("%c",next(ch_3));
    printf("%c",next(ch_4));
    printf("%c", next(ch_5));

    // compare the result with the expected result by tracking the result
    int result;
    if (moved_ch != expected) {
        printf("Element does not match: expected %c but got %c\n", expected, moved_ch);
        result = 0;
    } else {
        result = 1;
    }
    printf("\n---Test test_next_upper end---\n");
    return result;
}

//============================================================================== //

// Test the function change letter cases from upper case
int test_change_case_upper()
{

    printf("---Test test_change_case_upper begin: ---\n");

    // initialize the character
    char ch_3 = {'Z'};

    // initialize the expected result
    char expected = {'z'};

    // get the next character
    char changed_ch = change_case(ch_3);

    // compare the result with the expected result by tracking the result
    int result;
    if (changed_ch != expected) {
        printf("Element does not match: expected %c but got %c\n", expected, changed_ch);
        result = 0;
    } else {
        result = 1;
    }

    printf("\n---Test test_change_case_upper end---\n");
    return result;
}

// Test the function change letter cases from lower case
int test_change_case_lower()
{
    printf("---Test test_change_case_lower begin: ---\n");

    // initialize the character
    char ch_4 = {'a'};

    // initialize the expected result
    char expected = {'A'};

    // get the next character
    char changed_ch = change_case(ch_4);

    // compare the result with the expected result by tracking the result
    int result;
    if (changed_ch != expected) {
        printf("Element does not match: expected %c but got %c\n", expected, changed_ch);
        result = 0;
    } else {
        result = 1;
    }
    printf("\n---Test test_change_case_lower end---\n");
    return result;
}




int main()
{
    int total_tests = 8;
    int tests_passed = 0;

    // run the tests with better readability
    tests_passed += test_right_shift();
    printf("\n");
    tests_passed += test_left_shift();
    printf("\n");
    tests_passed += test_zero_shift();
    printf("\n");
    tests_passed += test_special_shift();
    printf("\n");
    printf("========================================\n");
    tests_passed += test_next_lower();
    printf("\n");
    tests_passed += test_next_upper();
    printf("\n");
    tests_passed += test_change_case_upper();
    printf("\n");
    tests_passed += test_change_case_lower();
    printf("\n");

    printf("Ran %d tests, passed %d tests, failed %d tests\n", total_tests, tests_passed, total_tests - tests_passed);
}