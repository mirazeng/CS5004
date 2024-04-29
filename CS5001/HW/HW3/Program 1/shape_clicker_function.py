'''
   CS5001
   Fall 2023
   Wenqing Zeng
   Homework 3: circle operation based on shape clicker function
'''


def create_screen(myTurtle, width, height, bgPic):
    '''
    Function: create_screen()
        Initializes a screen with the customized dimensions and background picture
    Parameters:
        myTurtle — turtle.Turtle — Turtle object
        width  — int — Width of the screen in pixel
        height — int — Height of the screen in pixel
        bgPic — str — The file path for the background picture
    Returns: turtle.Turtle, Turtle object, for application
    '''
    screen = myTurtle.getscreen()
    screen.setup(width, height)
    screen.bgpic(bgPic)
    return myTurtle


def draw_circle(myTurtle, x, y, penColor, radius):
    '''
    Function: draw_circle()
       Draws a circle by using turtle
    Parameters:
        myTurtle — turtle.Turtle — Turtle object
        x — int — x—coordinate for the turtle
        y — int — y—coordinate for the turtle
        penColor — str — Color of the pen
        radius — int — Radius of the circle
    Returns: turtle.Turtle, Turtle object, for application
    Ensure: pen and color status
    '''
    myTurtle.hideturtle()
    myTurtle.penup()
    myTurtle.goto(int(x), int(y))
    myTurtle.pendown()
    myTurtle.pencolor(penColor)
    myTurtle.circle(radius)
    myTurtle.penup()
    return myTurtle
