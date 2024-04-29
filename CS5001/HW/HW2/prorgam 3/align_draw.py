import turtle

# Import file as alias
import align_draw_function as df

# Get constance
SIDELENGTH = 80
RADIUS = 40
TURTLE_DIRECTION = 90
SCREEN_WIDTH = 635
SCREEN_HEIGHT = 970
BACKGROUND = 'shape_window.png'


def main():
    # Initiation of turtle t
    t = turtle.Turtle()

    # Create a screen with given dimensions and background picture
    t = df.create_screen(t, SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND)

    # Preparing turtle t with given measures before drawing
    t = df.prep(t, -(SIDELENGTH / 2), SIDELENGTH / 2, "red", "")
    # Drawing the original square
    t = df.draw_square(t, SIDELENGTH, TURTLE_DIRECTION)

    # Preparing turtle t with given measures before drawing
    t = df.prep(t, 0, -(SIDELENGTH / 2), "blue", "")
    # Drawing the original circle
    t = df.draw_circle(t, RADIUS)

    # Ask for user input of new coordinates for shapes
    x, y, x1, y1 = df.ask_pos()

    # Erasing screen
    t.clear()

    # Preparing turtle t with new measures before drawing
    t = df.prep(t, x - SIDELENGTH / 2, y + SIDELENGTH / 2, "red", "red")
    # Drawing the new square
    t = df.draw_square(t, SIDELENGTH, TURTLE_DIRECTION)

    # Preparing turtle t with new measures before drawing
    t = df.prep(t, x1, y1 - RADIUS, "blue", "blue")
    # Drawing the new circle
    t = df.draw_circle(t, RADIUS)

    t.hideturtle()


if __name__ == "__main__":
    main()
