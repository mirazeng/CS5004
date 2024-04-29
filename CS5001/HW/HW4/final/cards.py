'''
    Wenqing Zeng
    CS 5001, Fall 2023
    Homework 4 Program 2

    This is a program about poker cards
'''

import random


def create_deck() -> list:
    '''
    Function: create_deck():
        Create a deck of playing cards
    Parameters:
        None
    Returns: list, A list of strings, each representing a card in the deck
    '''

    # Initialize the empty deck
    card_deck = []

    # Define the suits and face cards
    color = ["s", "h", "d", "c"]
    letter = ["T", "J", "Q", "K", "A"]

    # Generate cards for each suit
    for c in color:
        # Generate numeric cards from 2 to 9 for each suit
        for x in range(2, 10):
            value_suite = str(x) + c
            card_deck.append(value_suite)

        # Generate face cards for each suit
        for el in letter:
            value_suite = el + c
            card_deck.append(value_suite)

    return card_deck


def shuffle(cards: list) -> list:
    '''
    Function: shuffle()
        Take an unshuffled deck and shuffle cards within
    Parameters:
        cards — list — the list representing unshuffled deck
    Returns: list, the shuffled deck
    Ensure: Do not modify original deck, get a copy
    '''

    # Create an empty list to store the shuffled deck
    shuffle_deck = []

    # Create a copy of the original deck to shuffle
    new_cards = cards.copy()

    # Check how many times to shuffle
    num_of_shuffle = len(new_cards)

    # Loop to shuffle, starting with total number of cards
    for x in range(num_of_shuffle, 0, -1):
        # Generate a random index within the remaining cards
        random_num = random.randint(0, len(new_cards) - 1)

        # Pick a card from the original deck based on the random index
        poker = new_cards[random_num]

        # Add the picked card to the shuffled deck
        shuffle_deck.append(poker)

        # Remove the picked card from the original deck
        new_cards.pop(random_num)

    # Return the shuffled deck
    return shuffle_deck


def deal(number_of_hands: int, number_of_cards: int, cards: list) -> list:
    '''
    Function: deal()
        Deal to x players y number of cards as a hand, from cards
    Parameters:
        number_of_hands — int — number of players
        number_of_cards — int — cards of each player received
        cards — list — the deck of card to deal from
    Returns: list, which contains all player's hands
    Ensure: Modify the cards deck since we deal some cards from it
    '''
    deck = cards
    deal_deck = []
    # Outer Loop: Give Hand to each player,
    # repeat actions a total of (number_of_hands) times
    for h in range(0, number_of_hands):
        # Create a temporary container to contain the actual Hand
        hand = []
        # Inner Loop: Add to Hand a single card, randomly drawn,
        # repeat a total of (number_of_cards) times
        for i in range(0, number_of_cards):
            # Get random index in the range of (zero, length of cards)
            random_num = random.randint(0, len(deck) - 1)
            # Use that index to get a card from cards
            poker = deck[random_num]

            # Append that card to hand
            hand.append(poker)

            # Remove that same card from cards
            deck.pop(random_num)
        deal_deck.append(hand)

    return deal_deck