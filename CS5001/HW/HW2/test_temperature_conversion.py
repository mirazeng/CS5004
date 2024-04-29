'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 2: Temperature Converter Test Code
'''

import temperature_conversion  

def test_convert_fahrenheit_to_celsius(temperature, expect):
    answer = temperature_conversion.convert_fahrenheit_to_celsius(temperature)
    print("Converting {} F to Celsius --".format(temperature))
    print(">> result = {:.1f} expected = {:.1f} \n".format(answer, expect))

def test_convert_celsius_to_fahrenheit(temperature, expect):
    answer = temperature_conversion.convert_celsius_to_fahrenheit(temperature)
    print("Converting {} C to fahrenheit --".format(temperature))
    print(">> result = {:.1f} expected = {:.1f} \n".format(answer, expect))

def main():
    '''
    Test Cases: convert_fahrenheit_to_celsius
    test 1: Input (32) -> Expected result: 0.0
    test 2: Input (100) -> Expected result: 37.8
    test 3: Input (212) -> Expected result: 100.0
    test 4: Input (85.1) -> Expected result: 29.5
    '''
    test_convert_fahrenheit_to_celsius(32, 0.0)
    test_convert_fahrenheit_to_celsius(100, 37.8)
    test_convert_fahrenheit_to_celsius(212, 100.0)
    test_convert_fahrenheit_to_celsius(85.1, 29.5)
    
    '''
    Test Cases:convert_celsius_to_fahrenheit
    Test 1: Input (0) -> Expected result: 32.0
    test 2: Input (37.8) -> Expected result: 100.0
    test 3: Input (100) -> Expected result: 212
    '''
    test_convert_celsius_to_fahrenheit(0, 32.0)
    test_convert_celsius_to_fahrenheit(37.8, 100)
    test_convert_celsius_to_fahrenheit(100, 212)

if __name__ == "__main__":
    main()
