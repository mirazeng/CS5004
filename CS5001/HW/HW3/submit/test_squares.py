'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 3: test function for chessboard valid input
'''

import chessboard as cb


def test_check_valid_row(row, expect):
    '''
    Function: test_check_valid_row()
        Tests the function check_valid_row()
    Parameters:
        row (str or int) — The row to be checked
        expect — boolean — The expected output of the check_valid_row()
    Returns: None — but print test results to the console
    Ensure: row and expected value are in correct type
    '''
    actual = cb.check_valid_row(row)
    print("Row: {}, expected: {}, Actual: {}".format(row, expect, actual))


def test_check_valid_column(col, expect):
    '''
    Function: test_check_valid_column()
        Tests the function check_valid_column()
    Parameters:
        col — str — The column to be checked
        expect — boolean — The expected output of check_valid_column()
    Returns: None — but print test results to the console
    Ensure: col and expected value are in correct type
    '''
    actual = cb.check_valid_column(col)
    print("Column: {}, expected: {}, Actual: {}".format(col, expect, actual))


def test_squares():
    '''
    Function: test_squares()
        Drive the test functions (check column and row)
    Parameters: None
    Returns: None — calls functions and print to terminal
    Ensure: No parameter is passed to this function when calling
    '''

    '''
    Test Cases: test_check_valid_column
    test 1: Input (i) -> Expected result: False
    test 2: Input (A) -> Expected result: True
    test 3: Input (B) -> Expected result: True
    '''
    test_check_valid_column("i", False)
    test_check_valid_column("A", True)
    test_check_valid_column("B", True)

    '''
    Test Cases: test_check_valid_row
    test 1: Input (1) -> Expected result: True
    test 2: Input (2) -> Expected result: True
    test 3: Input (3) -> Expected result: True
    '''
    test_check_valid_row(1, True)
    test_check_valid_row(2, True)
    test_check_valid_row(3, True)
