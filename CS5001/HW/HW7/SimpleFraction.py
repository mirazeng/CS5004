"""
Wenqing Zeng
CS 5001 Homework 7
This class is about rational number operation
"""


class SimpleFraction:
    """
    Class: SimpleFraction
        represent mathematical fraction and its operation

    Attributes:
        numerator - int - numerator of the fraction
        denominator - int - denominator of the fraction

    Methods:
        get_numerator():
        get_denominator():
        make_reciprocal():
        validate():
        multiply(other):
        divide(other):
        __str__():
        __eq__(other):

    Raises:
        ValueError and TypeError

    """

    def __init__(self, numerator=1, denominator=1):
        """
            Constructor: __init__():
                Initialize a SimpleFraction instance
            Parameters:
                numerator - int - The numerator of the fraction
                denominator - int - The denominator of the fraction
            Raises:
                ValueError: If numerator & denominator are not integer
                            or if the denominator is zero
            """
        if type(numerator) is not int:
            raise ValueError
        if type(denominator) is not int or denominator == 0:
            raise ValueError
        self.numerator = numerator
        self.denominator = denominator

    def get_numerator(self):
        """
            Method: get_numerator():
                retrieves numerator of fraction object
            Instance of class: self
            Returns - int - the numerator of the fraction

            """
        return self.numerator

    def get_denominator(self):
        """
            Method: get_denominator():
                retrieves denominator of fraction object
            Instance of class: self
            Returns - int - the denominator of the fraction

            """
        return self.denominator

    def make_reciprocal(self):
        """
            Method: make_reciprocal():
                Creates the reciprocal of the current fraction
            Instance of class: self
            Returns SimpleFraction, a new instance representing reciprocal
            Raises:
                ValueError: If the numerator of the fraction is zero,
                            as reciprocal would be undefined
            """
        # call class constractor get new instance
        rn = self.get_numerator()
        if rn == 0:
            raise ValueError
        else:
            # swap the numerator and denominator to get reciprocal
            new_frac = SimpleFraction(self.denominator, self.numerator)
            # return this new instance
            return new_frac

    def validate(self):
        """
            Method: validate():
                check if numerator and denominator is integer
            Instance of class: self
            Raises:
                ValueError:  If either the numerator or denominator
                            is not an integer
            """
        if type(self.numerator) or type(self.denominator) is not int:
            raise ValueError

    def multiply(self, other):
        """
            Method: multiply()
                Multiplies the current fraction by another number or fraction
            Parameters:
                other int or SimpleFraction, to multiply with
            Returns SimpleFraction, a new instance representing the product
            Raises:
                TypeError: If 'other' is neither an integer
                        nor a SimpleFraction
            """
        if type(other) is int:
            # multiply the numerator if other is an integer
            return SimpleFraction(self.numerator * other, self.denominator)
        elif type(other) is SimpleFraction:
            # multiply the numerators and denominators
            return SimpleFraction(self.numerator * other.get_numerator(),
                                  self.denominator * other.get_denominator())
        else:
            raise TypeError

    def divide(self, other):
        """
            Method: divide()
                Division of current fraction by another number or fraction
                operating by multiply the fraction represented by instance
            Parameters:
                other (int or SimpleFraction): number or fraction to divide by
            Returns SimpleFraction, a new instance representing the result
            Raises:
                TypeError: If 'other' is neither an integer
                        nor a SimpleFraction

            """
        # divide is to multiply the reciprocal
        if type(other) is int:
            temp = SimpleFraction(1, other)
            return self.multiply(temp)
        else:
            return self.multiply(other.make_reciprocal())

    def __str__(self):
        """
            Method: __str__():
                Returns a string representation of instance
            Instance of class: self
            Returns - str - string representation of the fraction
           """
        return f"{self.numerator}/{self.denominator}"

    def __eq__(self, other):
        """
            Method: __eq__():
              Compares current SimpleFraction instance to another one
            Parameters:
                other (SimpleFraction): The fraction to compare with
            Instance of class: self
            Returns - boolean - True if they are equal, False otherwise
            """
        if (self.numerator / self.denominator ==
                other.get_numerator() / other.get_denominator()):
            return True
        else:
            return False
