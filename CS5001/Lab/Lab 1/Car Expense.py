'''
    CS 5001
    Lab 1
    Fall 2023
    Wenqing Zeng
'''

    #left constance outside of the def main()


def main():

    #get the default value of car insurance
    INSURANCE = 1600 / 12
    # get all constance from the problem

    #get the user input
    miles =  float(input("How many miles per month do you drive?"))
    gas_price = float(input("What is the average price of a gallon of gas?"))
    fuel_effi = float(input("How many miles per gallon does your car get on average?"))

    #compute maintenance and fuel_effi
    maintenance = miles * 0.005

        #总燃油成本 = （里程数 * 汽油价格）/ 燃油效率 
    fuel = (miles * gas_price) / fuel_effi

    total = INSURANCE + maintenance + fuel

    #output
    print(f"Your total expense per month is${total:.2f}")
    

if __name__ == "__main__":
    main()
