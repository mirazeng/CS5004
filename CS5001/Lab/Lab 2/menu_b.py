def menu(sample_question):
    print(sample_question)
    user_selection = input("Your answer: ")
    return user_selection

def main():
    question_1 = ('How fo you like to keep active?\n'
                'A: Running\nB: Birdwatching\nC: Swimming\n'
                'D: Does laying on a couch count?')
    answer_1 = menu(question_1)
    print('You selected: ', answer_1.upper())

    

main()
