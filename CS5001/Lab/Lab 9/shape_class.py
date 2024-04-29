import random

PI = 3.1415

'''
    Class: Square.
    It knows how to draw itself, calculate its area, compare to other
    Shapes (for equality) and calculate its perimeter. Some code
    duplication in these classes since we're not using inheritance, but
    since Python is a dynamically typed language we don't need inheritance
    to implement protocol/interfaces
'''    
class Square:
    def __init__(self, length):
        self.length = length
        self.name = 'Square'
    def perimeter(self):
        return self.length * 4
    def area(self):
        return round(self.length**2,2)
    def __str__(self):
        return self.name + " with length of " + str(self.length)
    def __eq__(self, other):
        if self.area() == other.area():
            return True
        return False

'''
    Class: Triange.
    It knows how to draw itself, calculate its area, compare to other
    Shapes (for equality) and calculate its perimeter. Some code
    duplication in these classes since we're not using inheritance, but
    since Python is a dynamically typed language we don't need inheritance
    to implement protocol/interfaces
'''    
class Triangle:
    def __init__(self, base, height):
        self.base = base
        self.height = height
        self.name = 'Triangle'
    def area(self):
        return round(0.5 * self.base * self.height, 2)
    def perimeter(self):
        return self.base + self.height + \
               (self.base ** 2 + self.height ** 2) ** 0.5
    def __str__(self):
        return self.name + " with base of " + str(round(self.base, 1)) + \
               " & height of " + str(self.height)
    def __eq__(self, other):
        if self.area() == other.area():
            return True
        return False

'''
    Class: Circle.
    It knows how to draw itself, calculate its area, compare to other
    Shapes (for equality) and calculate its perimeter. Some code
    duplication in these classes since we're not using inheritance, but
    since Python is a dynamically typed language we don't need inheritance
    to implement protocol/interfaces
'''    
class Circle:
    def __init__(self, radius):
        self.radius = radius
        self.name = 'Circle'
    def area(self):
        return round(PI * self.radius**2, 2)
    def perimeter(self):
        return 2 * PI * self.radius
    def __str__(self):
        return self.name + " with a radius of " + str(self.radius)
    def __eq__(self, other):
        if self.area() == other.area():
            return True
        return False

def shape_factory():
    ''' Function shape_factory
        Input: nothing
        Returns: a random shape object (aka "instance")
    '''
    attribute_data = random.randint(2,10)
    shape_choice = random.randint(1,3)
    if shape_choice == 1:
        return Square(attribute_data)
    elif shape_choice == 2:
        return Triangle(attribute_data/3, attribute_data)
    return Circle(attribute_data)

def main():
    # construct random shapes and load them into a list.
    print("Hi there! Let's make some Shapes!")
    shapes = []
    for i in range(10):
        shapes.append(shape_factory())
    for each in shapes:
        print("{} : has an area of {}".format(each, each.area()))
        print()

    # now let's test our equality method. Plug in any shape that
    # responds to the __eq__ message, using area() to compare
    if shapes[0] == shapes[1]:
        print(shapes[0], end = " ")
        print( " is equal to ", end = " ")
        print(shapes[1])
    else:
        print(shapes[0], end = " ")
        print( " is not equal to ", end = " ")
        print(shapes[1])

main()
