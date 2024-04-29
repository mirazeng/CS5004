'''
Wenqing Zeng
CS 5001, Fall 2023
Homework 5

This is a program to remix music
'''
import copy

import music as m

PUNC = [".", "?", "!", ":", ","]


def remove_punc(string: str):
    """
     Function: remove_punc()
        Remove punctuation marks from a given string
     Parameters:
        string - str -  input string
     Returns - str - A new string with specified punctuation marks removed
   """
    result = ""
    for char in string:
        if char in PUNC:
            pass
        else:
            result += char
    return result


def substitute(song: list, old_word: str, new_word: str) -> bool:
    """
    Function: substitute()
        Replaces 'old_word' with 'new_word' in each string
    Parameters:
        song - list - A list of strings represents a song
        old_word - str - word to be replaced
        new_word - str - word to replace with
    Returns - bool - True if substitutions were made, False otherwise.
    """
    s = song.copy()
    flag = False
    for line in s:
        if old_word in line:
            flag = True
    if flag:
        result = []
        for line in s:
            temp = ""
            words = line.split(" ")
            for i in range(len(words)):
                words[i] = remove_punc(words[i])
                if words[i] == old_word:
                    words[i] = new_word
            temp = " ".join(words)
            result.append(temp)
        song.clear()
        for i in result:
            song.append(i)
    return flag


def reverse_it(song: list) -> list:
    """
    Function: reverse_it()
        Reverses the order of words in each string
    Parameters:
        song - list - A list of strings, each representing a line of a song
    Returns - list - modified list with reversed order of words
    """
    s = song.copy()
    result = []

    # start from the last one and go to the first one
    for i in range(len(s)):
        temp = ""
        cur = s[i]  # cur is the currently selected line
        words = cur.split(" ")
        words = words[::-1]
        for j in range(len(words)):
            words[j] = remove_punc(words[j])
        temp = " ".join(words)
        result.append(temp)

    song.clear()
    for i in result:
        song.append(i)

    return song


def load_song(selection: int) -> list:
    """
      Function: load_song()
        Load a song based on the user's selection playlist
      Parameters:
        selection - int - user's choice of a song
      Returns - list - A list of selected song and its title
              - empty list - if the index is out of range
      """
    index = int(selection) - 1
    if index < 0 or index > len(m.PLAYLIST):
        return []
    else:
        song = m.SONGS[index]
        title = m.PLAYLIST[index]
        return [song, title]


def main():
    # print welcome message
    print(f"Welcome to ReMix-Master. You can remix the greatest hits!"
          f"\nTurn up the 808's and drop the beat! Here's your remix: "
          f"\nold macdonald had a farm - ee-i-ee-i-o."
          f"\nand on that farm he had a cow - ee-i-ee-i-o."
          f"\nwith a moo moo here and a moo moo there"
          f"\nhere a moo - there a moo - everywhere a moo moo"
          f"\nold macdonald had a farm - ee-i-ee-i-o.")

    # initiate flag and tracker
    run = True
    current_selection = 0

    # make a deepcopy on original list
    # ensure each remix not to change the original
    pl = copy.deepcopy(m.PLAYLIST)
    songs = copy.deepcopy(m.SONGS)

    while run:
        # prepare a menu for user interaction
        print(f"\n"
              f"Remix-Master: \n"
              f"L: Load a different song \n"
              f"T: Title of current song \n"
              f"S: Substitute a word \n"
              f"P: Playback your song \n"
              f"R: Reverse it! \n"
              f"X: Reset to original song \n"
              f"Q: Quit?")

        # acquire user selection
        user_choice = input("Your choice: ")
        user_choice = user_choice.upper()

        # when user choose load song
        if user_choice == "L":
            print("Choose the number for "
                  "the song you want to load")
            # Print current playlist
            for i in range(len(pl)):
                print(f"{i + 1}. {pl[i]}")
            user_input = input("Your choice: ")
            user_input = int(user_input)
            result = load_song(user_input)
            if len(result) <= 0:
                print("Sorry, please try again.")
            else:
                # update current_selection
                current_selection = int(user_input)

        # when user choose to know about the title
        elif user_choice == "T":
            if 1 <= current_selection <= len(pl):
                print(f"The current song title is: "
                      f"{pl[current_selection - 1]}")
            else:
                print("Sorry, wrong current song. "
                      "please use L to load an available song.")

        # when user choose to substitute word
        elif user_choice == "S":
            old = input("What word do you want to "
                        "replace in the existing song? ")
            new = input("What new word do you want to use for the song? ")
            # returned stores boolean value
            returned = substitute(songs[current_selection - 1], old, new)
            if returned:
                # this means substitution was successful
                pass
            else:
                # give feedback when user input is not in the string
                print(f"Sorry. I didn't find {old} in the existing song")

        # when user plays the song
        elif user_choice == "P":
            for i in songs[current_selection - 1]:
                print(i)

        # when user reverses each line of string
        elif user_choice == "R":
            songs[current_selection - 1] = (
                reverse_it(songs[current_selection - 1]))

        # when user resets the remixed song
        elif user_choice == "X":
            # clear out remixed element
            pl.clear()
            songs.clear()
            # getting the original element, deepcopy again
            pl = copy.deepcopy(m.PLAYLIST)
            songs = copy.deepcopy(m.SONGS)

        # exit the remixer/program
        elif user_choice == "Q":
            print("Bravo! Your Grammy Award is being shipped to you now!")
            # ensure program is finished
            run = False


if __name__ == "__main__":
    main()
