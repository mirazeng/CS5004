user_selection = input("Please select the shape you want to know\n"
                       "T for Triangle, S for square, C for Circle")


# present the choices to user
# and ask them to choose the shape
# store in a variable
def compute_sqaure(length):
    s_area = length * length
    return s_area


def compute_triangle(base, height):
    t_area = (base * height) / 2
    return t_area


def compute_circle(radius):
    c_area = compute_circle(radius)
    return c_area


def main():
    if user_selection == S:
        compute_sqaure()
    elif user_selection == T:
        compute_triangle()
    else:
        comupte_circle()


if __name__ == "__main__":
    main()
