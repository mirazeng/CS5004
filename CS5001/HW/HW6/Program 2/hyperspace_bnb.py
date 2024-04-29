"""
Wenqing Zeng
CS 5001 Homework 6 program 2
This program is about travel bookings
"""

# index and constants
NAME_INDEX = 0
ID_INDEX = 1
CREDIT_INDEX = 2
REQUEST_ID = 0
REQUEST_BOOKING = 1
UPDATE_CREDIT_INDEX = 1
EXPENSE = 500


def load_travelers(travelers_file_name: str):
    """
        Function: load_travelers():
            Load traveler information from a file into a dictionary
        Parameters:
            travelers_file_name - str - The name of the file to read from
        Returns - dict - a dictionary with user IDs as keys
                        lists containing names and credits as values
                - None - if the file is missing
        Exceptions:
            FileNotFoundError: If the specified file does not exist

        """
    # initialize a dictionary container
    travelers_info = {}
    try:
        with (open(travelers_file_name, mode="r") as in_file):
            travelers_info = {}
            for line in in_file:
                line = line.strip("\n")
                user_info = line.split("@")
                name = user_info[NAME_INDEX]
                user_id = user_info[ID_INDEX]
                user_credit = int(user_info[CREDIT_INDEX])
                # user id as a key since it is one and only
                travelers_info[user_id] = [name, user_credit]
    except FileNotFoundError:
        print("Sorry, file is missing")

    return travelers_info


def process_requests(travelers_info: dict, request_file_name: str):
    """
      Function: process_requests():
        Process booking requests from a file and update traveler information
      Parameters:
        travelers_info - dict - a dictionary with user IDs as keys
                        lists containing names and credits as values
        request_file_name - str - The name of the file to read from
      Returns: This function overwrites "bookings.txt" with each booking
      Exceptions:
        FileNotFoundError: If the request file does not exist
      """
    try:
        with open(request_file_name, mode="r") as in_file:

            user_temp = []
            for line in in_file:
                line = line.strip("\n")
                user_temp.append(line.split())

            # make empty list containers
            booking_week = []
            booked_week = []
            booking_id = []
            booking_name = []
            user_booking = []
            for element in user_temp:
                user_id = element[REQUEST_ID]
                user_booking = element[REQUEST_BOOKING]
                name = travelers_info[user_id][NAME_INDEX]
                user_credit = travelers_info[user_id][UPDATE_CREDIT_INDEX]

                if user_booking not in booking_week and user_credit >= EXPENSE:
                    booking_week.append(user_booking)
                    booking_id.append(user_id)
                    booking_name.append(name)

                    # update users credit back in the dictionary
                    travelers_info[user_id][UPDATE_CREDIT_INDEX] -= EXPENSE
                    booked_week.append(user_booking)

                    with open("bookings.txt", mode="w") as outfile:
                        for element in booking_week:
                            index = booking_week.index(element)
                            outfile.write(f"{booking_week[index]} - "
                                          f"{booking_id[index]} - "
                                          f"{booking_name[index]} \n")

    except FileNotFoundError:
        print("Sorry, file is missing")
