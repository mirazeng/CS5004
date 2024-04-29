'''
Wenqing Zeng
CS 5001, Fall 2023
Homework 1 Program 2

This is a program to calculate banknotes for currency
'''

'''
Test case #1:
Input: $427
Output: 8 fifties, 1 twenties, 0 tens, 1 fives, 2 ones

Test case #2:
Input: $32
Output: 0 fifties, 1 twenties, 1 tens, 0 fives, 2 ones

Test case #3:
Input: $9
Output: 0 fifties, 0 twenties, 0 tens, 5 fives, 4 ones
'''

# get the constance

FIFTY = 50
TWENTY = 20
TEN = 10 
FIVE = 5
ONE = 1

    
def main():

    # get the user input
    withdraw = int(input("Welcome to PDQ Bank! Amount to withdraw? $"))

    # give user the feedback
    print(f"Cha-ching! You asked for ${withdraw}")

    # compute changes for 50
    quantity_50 = withdraw // FIFTY
    remainder_50 = withdraw % FIFTY

    # compute changes for 20
    quantity_20 = remainder_50 // TWENTY
    remainder_20 = remainder_50 % TWENTY

    # compute changes for 10
    quantity_10 = remainder_20 // TEN
    remainder_10 = remainder_20 % TEN   

    # compute changes for 5
    quantity_5 = remainder_10 // FIVE
    remainder_5 = remainder_10 % FIVE

    # compute changes for 1
    quantity_1 = remainder_5 

    # output
    print(f"That breaks down to: \n {quantity_50} fifties"
          f"\n {quantity_20} twenties \n {quantity_10} tens"
          f"\n {quantity_5} fives \n {quantity_1} ones")
    

if __name__ == "__main__":
    main()
