'''
    Wenqing Zeng
    CS 5001, Fall 2023
    Homework 4 Program 3

    This is a program to check if UPC is valid
'''


def is_valid_upc(list_of_integers: list) -> bool:
    '''
    Function: is_valid_upc()
        Check the validity of a UPC represented using a list of integers
    Parameters:
        list_of_integers — list — A list of integers representing UPC
    Returns: boolean, True if the UPC is valid, False otherwise
    Ensure: List contains integers; Order is right to left
    '''

    # Reverse the list to start the UPC algorithm
    list_of_integers.reverse()

    # Check for invalid input: Length less than 2 or all zeros
    if len(list_of_integers) < 2:
        return False
    else:
        if list_of_integers.count(0) == len(list_of_integers):
            return False

    # Initialize variables
    tracker = 0
    sum_total = 0

    # Loop through each integer in the list
    for x in list_of_integers:
        # Initialize multipliers for each iteration
        even_num = 0
        odd_num = 0

        # Check if the current position is even or odd
        if tracker % 2 != 0:
            even_num = x * 3
        else:
            odd_num = x

        # Update the total sum
        sum_total += even_num + odd_num

        # Increment the tracker
        tracker += 1

    # Final check if the sum_total is a multiple of 10
    if sum_total % 10 == 0:
        return True
    else:
        return False
