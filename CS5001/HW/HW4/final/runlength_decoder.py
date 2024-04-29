'''
    Wenqing Zeng
    CS 5001, Fall 2023
    Homework 4 Program 1

    This is a program to decode RLE data
'''


def decode(data: list) -> list:
    '''
    Function: decode()
        Decode a run-length encoded list
    Parameters:
        data — list — A list containing elements and their run-length counts
    Returns: list, A decoded list
    Ensure:
        The function produces result: an empty list when data has no elements
    '''

    # Create a list to store the decoded elements
    new_list = []

    # Loop through 'data' list, skipping one element each time
    for x in range(0, len(data), 2):
        # Extract the character and its repetition count
        character = data[x]
        repetition = data[x + 1]

        # Append the character 'repetition' number of times to 'new_list'
        for i in range(repetition):
            new_list.append(character)

    return new_list
