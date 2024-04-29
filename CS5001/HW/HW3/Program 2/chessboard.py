'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 3: chessboard check input
'''


def check_valid_row(row):
    '''
     Function: check_valid_row()
         Validates the row input based ASCII code
     Parameters:
         row — str or int — The input row number
     Returns: boolean, True if the row is a valid input; otherwise, False
     Ensure: Input is between 1 and 8
     '''
    if ord(str(row)) < 49 or ord(str(row)) > 56:
        return False
    else:
        return True


def check_valid_column(column):
    '''
     Function: check_valid_column()
         Validates the column input based ASCII code
     Parameters:
         column — str — The input column number
     Returns: boolean, True if the column is a valid input; otherwise, False
     Ensure: Input is between a and h
     '''
    if ord(column.lower()) < 97 or ord(column.lower()) > 104:
        return False
    else:
        return True
