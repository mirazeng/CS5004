'''
Wenqing Zeng
CS 5001, Fall 2023
Homework 1 Program 3

This is a program about computing office area
'''

# get the constances

CONVERSION_VALUE = 0.092903
COST_PER_SQUAREMETER = 21.10

    
def main():

    # get the user input
    length = float(input("Enter the length of the office (in feet) "))
    width = float(input("Enter the width of the office (in feet) "))

    # compute the area of office
    office_area_squarefeet = length * width

    # convert sqft to sqmeter
    office_area_squaremeter = office_area_squarefeet * CONVERSION_VALUE

    # compute the cost
    cost_per_month = office_area_squaremeter * COST_PER_SQUAREMETER

    # output
    print(f"The area of the office is {office_area_squarefeet:.2f} square feet"
          f"\n...which is {office_area_squaremeter:.2f} sqaure meters"
          f"\n......and you will pay €{cost_per_month:.2f} per month")
    

if __name__ == "__main__":
    main()
