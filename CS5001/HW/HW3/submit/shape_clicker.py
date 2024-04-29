'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 3: circle operation based on shape clicker
'''
import turtle

import PositionService as ps

# Get constance
SCREEN_WIDTH = 635
SCREEN_HEIGHT = 970
RADIUS = 80
BACKGROUND = 'shape_window.png'

# Initiation of turtle t
t = turtle.Turtle()


def create_screen(width, height, bgPic):
    '''
    Function: create_screen()
        Initializes a screen with the customized dimensions and background picture
    Parameters:
        width  — int — Width of the screen in pixel
        height — int — Height of the screen in pixel
        bgPic — str — The file path for the background picture
    Returns: turtle.Turtle, Turtle object, for application
    '''
    screen = t.getscreen()
    screen.setup(width, height)
    screen.bgpic(bgPic)
    return t


def draw_circle(x, y, penColor, radius):
    '''
    Function: draw_circle()
       Draws a circle by using turtle
    Parameters:
        x — int — x—coordinate for the turtle
        y — int — y—coordinate for the turtle
        penColor — str — Color of the pen
        radius — int — Radius of the circle
    Returns: turtle.Turtle, Turtle object, for application
    Ensure: pen and color status
    '''
    t.hideturtle()
    t.penup()
    t.goto(int(x), int(y) - RADIUS)
    t.pendown()
    t.pencolor(penColor)
    t.circle(radius)
    t.penup()
    return t


def click_circle(x, y):
    '''
    Function: click_circle()
        Receive mouse clicks and decides either clear screen or draw circle.
    Parameters:
        x — int — x-coordinate of the mouse click
        y — int — y-coordinate of the mouse click
    Returns: None
    Ensure: Updates the screen state based on whether a circle is clicked
    '''

    print("clicking at ({}, {})".format(x, y))

    if ps.is_visible() is False:
        ps.set_visible(True)
        ps.set_position(x, y)
        draw_circle(x, y, "green", RADIUS)
    else:  # (screen has a circle)
        x_pos = ps.get_position_x() - RADIUS <= x <= ps.get_position_x() + RADIUS
        y_pos = ps.get_position_y() - RADIUS <= y <= ps.get_position_y() + RADIUS
        if x_pos and y_pos:
            t.clear()
            ps.set_visible(False)
        else:
            pass


def main():
    # Tell main to use global turtle
    global t

    # Initiation of a screen
    screen = turtle.Screen()

    # Create a screen with given dimensions and background picture
    create_screen(SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND)

    # Draw the predetermined circle
    draw_circle(0, 0, "green", RADIUS)

    # Update screen status to PositionService
    ps.set_visible(True)

    # Start registering mouse clicks and do operations
    screen.onclick(click_circle, 1, None)

    # Freeze screen for better view
    turtle.done()


if __name__ == "__main__":
    main()
