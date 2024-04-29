# def add_friend(file_name, additional_msg=""):
#     with open(file_name, mode="w") as outfile:
#         outfile.write("Keith is Fantastic!\n")
#         outfile.write("At least HE think so!\n")
#         outfile.write("LOL\n")
#         outfile.write(additional_msg)


def friend_list(file_name):
    with open(file_name, mode="r") as infile:
        for each in infile:
            return each.split()

def check_friend(name):
    mega_list = []
    with open("facebook.txt", mode="r") as infile:
        for each in infile:
            mega_list.append(each.split())
            for element in mega_list :
                if element:
                    


    # for name in mega_list:
    #     # if name ==

    # if name == "Happy":



def main():

    # add_friend("Northeastern.txt")
    # add_friend("Tuesday.txt")
    # add_friend(additional_msg="Ba-da-ba-ba-baaah. Lovin' it!", file_name="Sunday.txt")
    check_friend("Happy")
    print("done")


if __name__ == "__main__":
    main()
