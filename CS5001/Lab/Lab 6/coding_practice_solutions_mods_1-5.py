"""
    Coding Practice Sample Answers
    You may have done it differently - and that's okay!
"""

# ############ MODULE 1 ###################################

"""
    length.py
"""
def main():
    length = float(input("Enter length: "))

    inches = length * 39.3701
    print("The length in inches is", inches)
    print("The length in feet is", inches / 12)
    print("The length in miles is", inches / 12 / 5280)


if __name__ == "__main__":
    main()

# #########################################################

"""
    rectangle.py
"""
def main():
    width = float(input("Enter width: "))
    height = float(input("Enter height: "))

    area = width * height
    perimeter = 2 * (width + height)   
    diagonal = ((width ** 2) + (height ** 2)) ** 0.5

    print("The area of the rectangle is", area)
    print("The perimeter of the rectangle is", perimeter)
    print("The diagonal of the rectangle is", diagonal)


if __name__ == "__main__":
    main()

# #########################################################

"""
    price_per_liter.py
"""

def main():
    six_pack = float(input("Price per six-pack: "))
    two_liter = float(input("Price per two-liter: "))

    total_liters = 0.355 * 6

    print()
    print("Six-pack price per liter:", six_pack / total_liters)
    print("Two-liter price per liter:", two_liter / 2)


if __name__ == "__main__":
    main()

# #########################################################

"""
    bookends
"""

def main():
    num = int(input("Enter number: "))

    print("The first number is", num // 1000)
    print("The last number is", num % 10)


if __name__ == "__main__":
    main()


# ############ MODULE 2 ###################################

"""
    Plus
"""
def plus(num1, num2):
    '''
    A function that returns the sum of two numeric values.
    :param num1: a numeric value to be added to num2.
    :param num2: a numeric value to be added to num1.
    :return: the sum of num1 and num2.
    '''
    return num1 + num2


def main():
    print(plus(5, 4))
    return


if __name__ == "__main__":
    main()


# #########################################################


"""
    Equal
"""

def is_equal(arg1, arg2):
    '''
    A function that returns if the two arguments are equal
    '''
    return arg1 == arg2


def main():
    print(is_equal(42, 42))
    print(is_equal(5, 6))


if __name__ == "__main__":
    main()


# #########################################################


"""
    Volume of Sphere
"""

def volume_sphere(radius):
    '''
    A function that returns the volume of a sphere. pi = 3.14159.
    :param radius: a numeric value representing the radius of the
        sphere in question.
    :return: a numeric value representing the volume of the sphere,
        whose radius was provided.
    '''
    volume = 4 / 3 * 3.14159 * (radius ** 3)
    return volume


def main():
    print(volume_sphere(5))
    print(volume_sphere(6.0))
    return


if __name__ == "__main__":
    main()


# ############ MODULE 3 ###################################

"""
    Clamping
"""

def main():
    num = int(input("Enter value: "))
    if num > 100:
        print("Too big, clamping required")
        num = 100
    elif num < 1:
        print("Too small, clamping required")
        num = 1
    print("Value is", num)


if __name__ == "__main__":
    main()


# #########################################################

"""
    3 Letter Months
"""

def main():
    month = input("Enter month: ")
    # determine the number of days
    if month == "Jan" or month == "January" or month == "1":
        days = 31
    elif month == "Feb" or month == "February" or month == "2":
        days = 28
    elif month == "Mar" or month == "March" or month == "3":
        days = 31
    elif month == "Apr" or month == "April" or month == "4":
        days = 30
    elif month == "May" or month == "5":
        days = 31
    elif month == "Jun" or month == "June" or month == "6":
        days = 30
    elif month == "Jul" or month == "July" or month == "7":
        days = 31
    elif month == "Aug" or month == "August" or month == "8":
        days = 31
    elif month == "Sep" or month == "September" or month == "9":
        days = 30
    elif month == "Oct" or month == "October" or month == "10":
        days = 31
    elif month == "Nov" or month == "November" or month == "11":
        days = 30
    elif month == "Dec" or month == "December" or month == "12":
        days = 31
    else:
        days = "Unknown"
    print(month, "has", days, "days")


if __name__ == "__main__":
    main()

# ############ MODULE 4 ###################################

"""
    Diagonal String
"""

def diagonal_string(string):
    space = 0
    index = 0
    result = ""

    while index < len(string):
        result += space * " " + string[index] + "\n"
        space += 1
        index += 1

    return result.strip()

# #########################################################

"""
    to_numbers 
"""

def to_numbers(nums):
    num_list = list()
    count = 0
    while count < len(nums):
        num_list.append(float(nums[count]))
        count += 1

    return num_list

# #########################################################

"""
    add_spaces 
"""

def add_spaces(word):
    index = 1
    space = " "
    result = ""
    if len(word) > 0:
        result = word[0]

    while index < len(word):
        result += 3 * space + word[index]
        index += 1

    return result
