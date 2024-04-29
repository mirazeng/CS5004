'''
    CS5001
    Spring 2020
    Lab 3
    Shapes Lab
    Find the Shape areas based on input from the user. Then,
    Wash, rinse and repeat with iteration!
    
'''

PI = 3.1415

def menu(message):
    answer = input(message)
    answer = answer.upper() # convert to uppercase for comparison
    # set the answer to 'Invalid Choice' if user input is invalid
    if(answer != 'S' and answer != 'C' and answer != 'T' and answer != 'Q'):
        answer = 'Invalid Choice' 
    return answer


def calc_area(choice):
    ''' function do_area
        Input: choice - the type of shape selected by the user
        Returns: area of a shape, depending on the type chosen
        Does: Asks the user for shape's dimensions to cacluate area
    '''
    if choice == 'S':
        length = float(input('Enter the square length: '))
        return round((length * length),2)
    elif choice == 'C':
        radius = float(input('Enter the circle radius: '))
        return round((PI * radius**2),2)
    elif choice == 'T':
        base = float(input('Enter the triangle base: '))
        height = float(input('Enter the triangle height: '))
        return round((0.5 * base * height),2)
    return 0
    
def main():
    answer = ''
    while answer != 'Q':
        question = ('Select the Shape you want:\n' +
        ' S: Square\n C: Circle\n T: Triangle\n' +
        ' Q: Quit?\n Your answer: ')
        answer = menu(question)
        if answer == 'Invalid Choice':
            print(answer, '...please choose again')
        elif answer != 'Q':
            print('Area = ', calc_area(answer))
        else:
            print('Thanks for using my Shape program!')

main()
            
    
