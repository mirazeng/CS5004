"""
Wenqing Zeng
CS 5001 Homework 7
This is the test suite for class SimpleFraction
"""

import unittest

from SimpleFraction import SimpleFraction


class TestSimpleFraction(unittest.TestCase):
    # positive tests
    """
    Class: TestSimpleFraction
        A set of unit tests for the SimpleFraction class

    Methods:
        test_init():
        test_get_numerator():
        test_get_denominator():
        test_make_reciprocal():
        test_multiply():
        test_divide():
        test_validate():
        test_bad_init():
        test_bad_fraction():

        """

    def test_init(self):
        """
            Method: test_init():
                Tests that SimpleFraction is initialized
                with correct numerator and denominator
            Instance of class: self
            """
        r = SimpleFraction(2, 3)
        self.assertEqual(r.numerator, 2)
        self.assertEqual(r.denominator, 3)

    def test_get_numerator(self):
        """
            Method: test_get_numerator():
                Tests method correctly returns the fraction's numerator
            Instance of class: self
            """
        r = SimpleFraction(2, 3)
        self.assertEqual(r.get_numerator(), 2, 'Incorrect Numerator')

    def test_get_denominator(self):
        """
            Method: test_get_denominator():
                Tests method correctly returns the fraction's denominator
            Instance of class: self
            """
        r = SimpleFraction(2, 3)
        self.assertEqual(r.get_denominator(), 3, "Incorrect Denominator")

    def test_make_reciprocal(self):
        """
            Method: test_make_reciprocal():
                Tests this method correctly creates the reciprocal
                implement getter to check if it is correct
            Instance of class: self
            """
        r = SimpleFraction(2, 3)
        result = r.make_reciprocal()
        self.assertEqual(result.get_numerator(), 3, "Incorrect Rationals")
        self.assertEqual(result.get_denominator(), 2, "Incorrect Rationals")

    def test_multiply(self):
        """
            Method: test_multiply():
                Tests the multiplication of two SimpleFraction instances
                or a SimpleFraction with an integer
                implement getter to check if it is correct
            Instance of class: self
        """
        r1 = SimpleFraction(2, 3)
        r2 = SimpleFraction(6, 7)
        result = r1.multiply(r2)
        self.assertEqual(result.get_numerator(), 12, "Wrong calculation")
        self.assertEqual(result.get_denominator(), 21, "Wrong calculation")

    def test_divide(self):
        """
            Method: test_divide():
                Tests the division of one instance by another
                implement getter to check if it is correct
            Instance of class: self
        """
        r1 = SimpleFraction(2, 3)
        r2 = SimpleFraction(6, 7)
        result = r1.divide(r2)
        self.assertEqual(result.get_numerator(), 14, "Wrong calculation")
        self.assertEqual(result.get_denominator(), 18, "Wrong calculation")

    def test_validate(self):
        """
            Method: test_validate():
                Tests the validate method to ensure for integer
                numerator and denominator
                implement getter to check if it is correct
            Instance of class: self
        """
        r = SimpleFraction(2, 3)
        self.assertEqual(r.get_numerator(), 2, "Integer in need")
        self.assertEqual(r.get_denominator(), 3, "Integer in need")

    # negative test
    def test_bad_init(self):
        """
            Method:test_bad_init():
                Tests that if initializing SimpleFraction with non-integer values
            Instance of class: self
            Raises:
                ValueError If the numerator and denominator is not integer
            """
        with self.assertRaises(ValueError):
            r = SimpleFraction(2.1, 3.1)

    def test_bad_fraction(self):
        """
            Method: test_bad_fraction():
                Tests that if initializing denominator with 0
            Instance of class: self
            Raises:
                ValueError If the denominator is 0
        """
        with self.assertRaises(ValueError):
            r = SimpleFraction(2, 0)


if __name__ == '__main__':
    unittest.main()
