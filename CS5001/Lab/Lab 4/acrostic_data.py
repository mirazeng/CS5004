POEM = "Intensive technologies croon.\n\nLocal bandits lesson.\n" \
       "Old notebooks emote.\nVideos intersect.\n" \
       "Early notebooks choreograph.\n\nAsynchronous modems search.\n" \
       "Local desktops deliver.\nInteractive videos skill.\n" \
       "Grain tablets clap.\nNew technologies cry.\n\n" \
       "Commercial kits chant.\nSublingual tablets exalt.\n"

DREAM = "If tax payers tell their tale.\n" \
        "Of heated victories against the tax man.\n" \
        "A meeting with others who file late.\n\n" \
        "There were many reasons to file early...\n" \
        "Remembering what H&R Block said: 'Leave it to us!'\n" \
        "Ford cars with ejection seats - is that a valid deduction?\n\n" \
        "Peas and carrots, please - you barely ate dinner.\n" \
        "Floors covered with peas - you couldn't eat them after all.\n" \
        "Flux capacitors were science fiction - go back in time!\n\n" \
        "Flow with this - the deadline is looming.\n" \
        "Trails of paper litter your office.\n Follow the bouncing ball.\n" \
        "Follow the rabbit.\n\n Full of ideas; you're distracted again.\n" \
        "Scoops of ice cream await, finish the task!\n" \
        "Alas, you'll need an extension.\n" \
        "Rise up, go to bed - it's January and only a bad tax dream."


# index for the list
def acrostic():
    # split sentences from original data
    poem = POEM.split("\n")
    new_list = []
    first_letter = []

    # start a loop to read first letters in each row
    # try to indentify the correct group for element to loop
    for el in poem:
        # slicing sentence into each word
        eachWord = list(el.split())
        if len(eachWord) < 1:
            continue
        else:
            new_list.append(eachWord[0])
    for n in new_list:
        word_mean = n.split(",")
        first_letter.append(word_mean)
        # for x in list(word_mean):
        #     first_letter.append(x)
        #     print(first_letter)

        #     for fl in targetLetter:
        #         firstLetter = fl.split()
        # getting each first word from slicing sentence
        # for n in range(eachWord):
        #     firstWord =


print(acrostic())

# def main():
#     acrostic([POEM, 0], [DREAM, 3])
#     for each in acrostic:
#         acrostic(each)
# main()
