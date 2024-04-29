# include "file_operation.h"
# include <stdio.h>

// Test whether function read_file_lines can read a file with 3 lines properly.
int test_read_file_lines_regular() {

    printf("\n---Test test_read_file_lines_regular begin: ---\n");

    int result = read_file_lines("three_line.txt");
    if (result == 3) {
        printf("Test passed and this file has %d lines\n", result);
    } else {
        printf("Test failed\n");
        return 0;
    }
    printf("---Test test_read_file_lines_regular end---\n");
    return 1;
}

// Test whether function read_file_lines can read a file with 0 lines properly.
int test_read_file_lines_empty() {

    printf("\n---Test test_read_file_lines_empty begin: ---\n");

    int result = read_file_lines("empty.txt");
    if (result == 0) {
        printf("Test passed and this file has %d lines\n", result);
    } else {
        printf("Test failed\n");
        return 0;
    }
    printf("---Test test_read_file_lines_empty end---\n");
    return 1;
}

// Test whether function read_file_lines can read a file that does not exist.
int test_read_file_lines_nonexistent() {

    printf("\n---Test test_read_file_lines_nonexistent begin: ---\n");

    int result = read_file_lines("nonexistent.txt");
    if (result == 0) {
        printf("Test passed and this file is not exist\n");
    } else {
        printf("Test failed\n");
        return 0;
    }
    printf("---Test test_read_file_lines_nonexistent end---\n");
    return 1;
}
