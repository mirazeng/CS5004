import hw4data as da


def decode(data: list) -> list:
    new_list = []
    for x in range(0, len(data), 2):
        character = data[x]
        repetition = data[x + 1]
        for i in range(repetition):
            new_list.append(character)
    return new_list
