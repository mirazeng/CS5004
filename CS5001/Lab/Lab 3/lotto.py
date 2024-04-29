import random

# asking user's name and feedback with game rules
user_name = input("Hello! What is your name?")
print(f"Cool! Nice to meet you, {user_name}. let's play!")
print(f"thinking of a number between 1 to 5")

# asking user about their "thinking" number
user_input = input("Enter your guess: ")

# generating the random number

number = random.randint(1, 5)

# compare user_input with random generating number
if number > int(user_input):
    print(f"Sorry, your guessing is too low \n"
          f"My number was: {number}")

    # adding extra conditionals
elif number < int(user_input):
    print("Sorry, your guess is too high \n"
          f"My number was: {number}")

else:
    print("Yay, you guessed my number!")
