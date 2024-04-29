'''
    CS 5001
    Lab 1
    Fall 2023
    Wenqing Zeng
'''

def main():

    #always come with comments
    #check out the CS5001 style guide

    #get the default rate for loyalty discount
    DISCOUNT = 0.1
    #make constance ALL CAP
    #no ticket vs TICKET but TICKET_price
    #plz try to spot all constances in the problem
    
    #get the user input 
    ticket =  int(input("How many tickets do you want?"))
    popcorn = int(input("How many buckets of popcorn?"))
    drink = int(input("How many drinks?"))

    #compute the total and total after discount
    total = ticket * 7.95 + popcorn * 8.95 + drink * 4.25
    discount_total = total - total * DISCOUNT

    #output
    print(f"Total cost is${total:.2f}")
    print(f"Your price after the discount is${discount_total:.2f}")

    #just carry out one print funtion 

if __name__ == "__main__":
    main()
