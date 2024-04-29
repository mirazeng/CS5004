def menu(sample_question):
    print(sample_question)
    user_selection = input("Your answer: ")
    return user_selection

def main():
    question = ('How fo you like to keep active?\n'
                'A: Running\nB: Birdwatching\nC: Swimming\n'
                'D: Does laying on a couch count?')
    answer = menu(question)
    print('You selected: ', answer.upper())

    

main()
