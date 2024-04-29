'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 3: determine chessboard square color
'''


def black_or_white(row, column):
    '''
     Function: black_or_white()
         Determines the color of a chessboard square based on its row and column
     Parameters:
         row — str or int — The row number (assumed to be between 1 and 8)
         column — str — The column character (assumed to be between 'a' and 'h')
     Returns: str, Returns "BLACK" or "WHITE" based on given position
     Ensure: input row is between 1 and 8, input column is between 'a' and 'h'
    '''

    if int(row) % 2 == 1 and ord(column) % 2 == 1:
        result = "BLACK"
    elif int(row) % 2 == 0 and ord(column) % 2 == 1:
        result = "WHITE"
    elif int(row) % 2 == 1 and ord(column) % 2 == 0:
        result = "WHITE"
    else:
        result = "BLACK"
    return result


