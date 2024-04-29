import random


def create_deck() -> list:
    card_deck = []
    color = ["s", "h", "d", "c"]
    letter = ["T", "J", "Q", "K", "A"]
    for c in color:
        for x in range(2, 10):
            value_suite = str(x) + c
            card_deck.append(value_suite)
        for el in letter:
            letter_suite = el + c
            card_deck.append(letter_suite)
    return card_deck


def shuffle(cards: list) -> list:
    shuffle_deck = []
    new_cards = cards.copy()
    for x in range(52, 0, -1):
        random_num = random.randint(0, x - 1)
        pocker = new_cards[random_num]
        shuffle_deck.append(pocker)
        new_cards.pop(random_num)
    return shuffle_deck


def deal(number_of_hands: int, number_of_cards: int, cards: list) -> list:
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
