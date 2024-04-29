import random

MAX_ATTEMPT = 5
USER_ATTEMPT = 0

user_name = input("Hello! What is your name?")
print(f"Cool! Nice to meet you, {user_name}. Let's play!")
print("I am thinking of a number between 1 to 100.")
print(f"You have {MAX_ATTEMPT} attempts.")

number = random.randint(1, 100)

while USER_ATTEMPT < MAX_ATTEMPT:
    USER_ATTEMPT += 1
    user_input = int(input("Enter your guess: "))

    if number > user_input:
        print("Nope, too low.")
    elif number < user_input:
        print("Nope, too high.")
    else:
        print("Yay, you guessed my number!")
        break

    if USER_ATTEMPT == MAX_ATTEMPT:
        print(f"Nice try! But you lost this time. \nThe number was {number}")
