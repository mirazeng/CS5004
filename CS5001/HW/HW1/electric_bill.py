'''
Wenqing Zeng
CS 5001, Fall 2023
Homework 1 Program 1

This is a program to calculate utilities
'''
    
def main():

    # get the user input
    supply_cost = float(input("What is the supplier fee per kWh?"))
    delivery_cost = float(input("What is the power fee per kWh?"))
    electricity_usage = float(input("How many kWh were used this month?"))

    # compute cost of supply and delivery
    supply_charge = electricity_usage * supply_cost
    power_delivery_charge = electricity_usage * delivery_cost

    # add total
    total = supply_charge + power_delivery_charge

    # output
    print(f"Your electric bill this month is ${total:.2f}")
    

if __name__ == "__main__":
    main()
