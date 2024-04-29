'''
Wenqing Zeng
CS 5001, Fall 2023
Homework 4 Program 1

This is a program to decode RLE data
'''


def decode(data: list) -> list:
    '''

    Function -- decocde()
        Decodes a list with repeating elements based on adjacent value
    Parameters:
        data -- list -- A list of alternating elements and repetition counts
    Returns a list containing the decoded elements
    '''
    new_list = []
    for x in range(0, len(data), 2):
        character = data[x]
        repetition = data[x + 1]
        for i in range(repetition):
            new_list.append(character)
    return new_list