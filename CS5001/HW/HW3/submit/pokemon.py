'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 3: Pokémon Rock Paper Scissor game
'''

import random


def rps_to_string(selection):
    '''
    Function: rps_to_string()
        Converts Rock-Paper-Scissors to string
    Parameters:
        selection — int — Numerical representation of the choice
    Returns: str, Returns the string equivalent of given selections
    '''
    if selection == 1:
        return "ROCK"
    elif selection == 2:
        return "PAPER"
    elif selection == 3:
        return "SCISSORS"


def get_player(num):
    '''
     Function: get_player()
         Maps a numerical identifier to a specific Pokémon name
     Parameters:
         num — int — The numerical identifier for the Pokémon
     Returns: str — Returns the name of the Pokémon
            Defaults to "Diglett" if the identifier is not in the range 1-9
     Ensure: input num is an integer
     '''
    if num == 1:
        return "Bulbasaur"
    elif num == 2:
        return "Charmander"
    elif num == 3:
        return "Butterfree"
    elif num == 4:
        return "Rattata"
    elif num == 5:
        return "Weedle"
    elif num == 6:
        return "Pikachu"
    elif num == 7:
        return "Sandslash"
    elif num == 8:
        return "Jigglypuff"
    elif num == 9:
        return "Raichu"
    else:
        return "Diglett"


def check_battle(computer, player):
    '''
     Function: check_battle()
         Determines the winner between the computer and a player
     Parameters:
         computer — int — Numerical representation of the computer's choice
         player — int — Numerical representation of the player's choice
     Returns: str, Returns game results
     '''
    if computer == player:
        return "DRAW!"
    elif computer == 3 and player == 2:
        return "COMPUTER"
    elif computer == 2 and player == 3:
        return "PLAYER"
    elif computer == 2 and player == 1:
        return "COMPUTER"
    elif computer == 1 and player == 2:
        return "PLAYER"
    elif computer == 3 and player == 1:
        return "PLAYER"
    elif computer == 1 and player == 3:
        return "COMPUTER"


def get_computer_team(player_team):
    '''
    Function: get_computer_team()
        Determines the computer's team based on the player's team selection
    Parameters:
        player_team — str — The team chosen by the player ("red" or "blue")
    Returns: str — Returns the computer's team ("red" or "blue")
    Ensure: player_team is passed in as string.
    '''
    if player_team == "red":
        computer_team = "blue"
    elif player_team == "blue":
        computer_team = "red"
    return computer_team


def get_player_rps():
    '''
    Function: get_player_rps()
        Prompt the user to play either rock, paper or scissors
    Parameters:
        None
    Returns: int — Returns an integer corresponding to the user's choice
    Ensure: player_rps is cast into integer and returned
    '''
    question = "Enter 1 for Rock, 2 for Paper, 3 for Scissors "
    player_rps = input(question)
    return int(player_rps)


def game_loop(player_team, computer_team, player_win, computer_win):
    '''
    Function: start_game_loop()
        Executes the main game loop where the battles take place
    Parameters:
        player_team — str — Player's team ("red" or "blue")
        computer_team — str — Computer's team ("red" or "blue")
        player_win_track — int — Number of wins by the player
        computer_win_track — int — Number of wins by the computer
    Returns: None
    Ensure: The four parameters are defined before function is called
    '''
    while True:
        # Both teams play random Pokémon
        computer_pokemon = get_player(random.randint(1, 9))
        player_pokemon = get_player(random.randint(1, 9))

        # computer plays random, and ask for player's choice
        computer_rps = random.randint(1, 3)
        player_rps = get_player_rps()

        # Print team information for red and blue team
        print(f"{computer_team.upper()} pokemon {computer_pokemon}"
              f" vs. {player_team.upper()} pokemon {player_pokemon}")
        print(f"{computer_pokemon} played {rps_to_string(computer_rps)}. "
              f"{player_pokemon} played {rps_to_string(player_rps)}")

        # Call check_battle() and obtain game result
        game_result = check_battle(computer_rps, player_rps)
        if game_result == "DRAW!":
            print("It's a draw! No winner")
        elif game_result == "COMPUTER":
            print(f"My {computer_team.upper()} "
                  f"team wins with {computer_pokemon}!")
            # Increment team winning tracker unless draw
            computer_win += 1
        else:
            print(f"My {player_team.upper()} "
                  f"team wins with {player_pokemon}!")
            # Increment team winning tracker unless draw
            player_win += 1

        print("\n")  # For formatting

        # Ask player if they want to play again
        repeat_game = input("Play again (y/n)? ")

        # If yes, go directly into a round
        if repeat_game.lower() == "y":
            pass
        # If no, print out overall score based on tracker
        # and the respective winner ("I" is computer and "YOU" player)
        elif repeat_game.lower() == "n":
            print("Tournament has ended!")
            if player_win > computer_win:
                print(
                    f"{computer_team.upper()} team: {computer_win}"
                    f"  {player_team.upper()} team: {player_win}"
                    f"\nYOU WIN!")
            else:
                print(
                    f"{computer_team.upper()} team: {computer_win}"
                    f"  {player_team.upper()} team: {player_win}"
                    f"\nI WIN!")

            # Game Ended. Break the while loop.
            break


def main():
    # Ask player to choose a team
    player_team = input("What team do you want(red or blue)?").lower()

    # Call helper function to get computer's team
    computer_team = get_computer_team(player_team)

    # Keep track of player and computer's win
    player_win_track = 0
    computer_win_track = 0

    # Enter main loop for player to keep playing
    game_loop(player_team, computer_team, player_win_track, computer_win_track)


if __name__ == '__main__':
    main()
