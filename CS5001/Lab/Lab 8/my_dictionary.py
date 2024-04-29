"""
Translator
"""

ENGLISH = ['hello', 'friend', 'hey', 'awful', 'wow', 'reward', 'song', 'money',

           'board', 'cocktail', 'bathroom', 'friends', 'cheat', 'flag', 'boy',

           'girl', 'my', 'take', 'sink', 'telescope', 'clean', 'you']

PIRATE = ['ahoy', 'matey', 'avast', 'bilge-sucking', 'blimey', 'booty', 'chanty',

          'dubloon', 'plank', 'grogg', 'head', 'hearties', 'hornswaggle',

          'jack', 'lad', 'lass', 'me', 'plunder', 'scuttle', 'spyglass', 'swob',

          'ye']


def build_translation(english: list, pirate: list):
    dict = {}

    for index, value in enumerate(english):
        # put word group into one list under one key
        dict[value] = pirate[index]
        print(dict)

    # creating as an empty container
    temp = []

    sentence = input("Enter a sentence: ")

    # the word is currently a string
    # I need a list to iterate
    # make sure it is lower case
    word = sentence.lower()
    temp.append(word.split())

    pirate_box = []
    for element in temp[0]:
        # find the index in the list of english
        pirate_word = dict[element]
        pirate_box.append(pirate_word)
        str = "".join(pirate_word)
        # for trans_word in pirate_box:
        #     str = "".join(trans_word)
        print(str)


        # making the associative directory to locate words in

    #
    #
    # if word in translate:
    #     print(f"Translated word is: {translate[word]}")
    # else:
    #     print(f"Cannot translate {word}")


def main():
    build_translation(ENGLISH, PIRATE)


if __name__ == "__main__":
    main()
