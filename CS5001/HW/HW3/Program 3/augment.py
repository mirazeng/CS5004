# import random
#
#
# # Function to map number to choice
# def map_choice_to_string(choice):
#     if choice == 1:
#         return "ROCK"
#     elif choice == 2:
#         return "PAPER"
#     elif choice == 3:
#         return "SCISSORS"
#
#
# # Function to get player Pokemon
# def get_player(num):
#     if num == 1:
#         return "Bulbasaur"
#     elif num == 2:
#         return "Charmander"
#     elif num == 3:
#         return "Butterfree"
#     elif num == 4:
#         return "Rattata"
#     elif num == 5:
#         return "Weedle"
#     elif num == 6:
#         return "Pikachu"
#     elif num == 7:
#         return "Sandslash"
#     elif num == 8:
#         return "Jigglypuff"
#     elif num == 9:
#         return "Raichu"
#     else:
#         return "Diglett"
#
#
# # Function to check battle outcome
# def check_battle(computer, player):
#     if computer == player:
#         return "DRAW!"
#     elif (computer == 3 and player == 2) or (computer == 2 and player == 1) or (computer == 1 and player == 3):
#         return "COMPUTER"
#     else:
#         return "PLAYER"
#
#
# # Main function
# def main():
#     player_team = input("What team do you want(red or blue)?").lower()
#     computer_team = "blue" if player_team == "red" else "red"
#     player_win_track, computer_win_track = 0, 0
#
#     while True:
#         computer_choice = random.randint(1, 3)
#         player_choice = int(input("Enter 1 for Rock, 2 for Paper, 3 for Scissors "))
#         computer_pokemon = get_player(random.randint(1, 9))
#         player_pokemon = get_player(random.randint(1, 9))
#
#         print(f"{computer_team.upper()} pokemon {computer_pokemon} vs. {player_team.upper()} pokemon {player_pokemon}")
#         print(
#             f"{computer_pokemon} played {map_choice_to_string(computer_choice)}. {player_pokemon} played {map_choice_to_string(player_choice)}")
#
#         game_result = check_battle(computer_choice, player_choice)
#
#         if game_result == "DRAW!":
#             print("It's a draw! No winner")
#         elif game_result == "COMPUTER":
#             print(f"My {computer_team.upper()} team wins with {computer_pokemon}!")
#             computer_win_track += 1
#         else:
#             print(f"Your {player_team.upper()} team wins with {player_pokemon}!")
#             player_win_track += 1
#
#         if input("Play again (y/n)? ").lower() == "n":
#             print(f"{computer_team.upper()} team: {computer_win_track}\t{player_team.upper()} team: {player_win_track}")
#             print("YOU WIN!") if player_win_track > computer_win_track else print("I WIN!")
#             break
#
#
# if __name__ == '__main__':
#     main()
