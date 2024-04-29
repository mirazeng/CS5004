import random

MAX_ATTEMPT = 5
USER_ATTEMPT = 0

# asking user's name and feedback with game rules
user_name = input("Hello! What is your name?")
print(f"Cool! Nice to meet you, {user_name}. let's play!")
print(f"thinking of a number between 1 to 100")
print("You have 5 attempts")

# generate the random number
number = random.randint(1, 100)
print(number)

# identify what element/part is looping
# we have 5 times try, and the attempt will be lesser and lesser until
# and this is only thing changing USER_ATTEMPT + 1 < MAX_ATTEMPT
# user gets the answer
# out of attempts
# we are looping the attempt until it reaches its max attempts

while USER_ATTEMPT < MAX_ATTEMPT:

    USER_ATTEMPT += 1
    print(USER_ATTEMPT)
    user_input = input("Enter your guess: ")

    if number > int(user_input):
        print("nope, too low")
        if USER_ATTEMPT == MAX_ATTEMPT:
            print(f"Nice try! But you lost this time \n"
                  f"The number was {number}")
        # adding extra conditionals
    elif number < int(user_input):
        print("nope, too high")
        if USER_ATTEMPT == MAX_ATTEMPT:
            print(f"Nice try! But you lost this time \n"
                  f"The number was {number}")
    else:
        print("Yay, you guessed my number!")
        print(f"great job! you won in {USER_ATTEMPT} try")
        break

# surpass the attempts but still keep going
# need to stop the loop after trying 5 times
