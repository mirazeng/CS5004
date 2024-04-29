'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 2: Windchill Index Doctest
'''

# Import file as alias
import temperature_conversion as tc

# Import doctest
import doctest


# Get constance
SPEED_CONVERSION_FACTOR = 1.61


def windchill_formula(temperature_celsius, speed_kilometer):
    '''
    Function: windchill_formula()
        Calculates windchill index based on given formula, a helper function
    Parameters:
        temperature_celsius - float - in celsius 
        speed_kilometer - float - in kilometers per hour
    Returns: float, windchill index based on given formula
    '''
    windchill_index = 13.12
    windchill_index = windchill_index + (0.6215 * temperature_celsius)
    windchill_index = windchill_index - (11.37 * (speed_kilometer ** 0.16))
    speed_calculation = speed_kilometer ** 0.16
    # += adding value to variable and assign it back to itself
    windchill_index += 0.3965 * temperature_celsius * speed_calculation

    return windchill_index


def calculate_windchill(temperature, speed):
    """
    Function: calculate_windchill
        Calculates windchill based on international formula (Metric)
    Parameters:
        temperature in Fahrenheit
        speed in miles per hour
    Returns: windchill index (floating point value) based on applied formula
    Require: temp/speed in metric units
    Ensure: metric -> imperial unit conversions prior to calculation

    return the value of windchill index in fahrenheit
    >>> calculate_windchill(32, 100)
    15.993595289668303
    >>> calculate_windchill(212, 120)
    268.9539227117166
    """

    # Convert temperature in celsius
    temperature_celsius = tc.convert_fahrenheit_to_celsius(temperature)

    # Convert speed in kilometer
    speed_kilometer = speed * SPEED_CONVERSION_FACTOR

    # Calculating windchill_index in Celsius
    windchill_index = windchill_formula(temperature_celsius, speed_kilometer)

    # Covert windchill_index in fahrenheit
    result = tc.convert_celsius_to_fahrenheit(windchill_index)

    # Return the result
    return result


doctest.testmod()
