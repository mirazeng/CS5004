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


def draw_square(myTurtle, sideLength, turtleAngle):
    '''
    Function: draw_square()
        Draws a square by using turtle
    Parameters:
        myTurtle — turtle.Turtle — Turtle object
        sideLength — int — Length of each side of the square
        turtleDirection — int — Angle to turn the turtle
    Returns: turtle.Turtle, Turtle object, for application
    Ensure: pen and color status
    '''
    myTurtle.pendown()
    myTurtle.begin_fill()
    myTurtle.forward(sideLength)  # side 1
    myTurtle.right(turtleAngle)
    myTurtle.forward(sideLength)  # side 2
    myTurtle.right(turtleAngle)
    myTurtle.forward(sideLength)  # side 3
    myTurtle.right(turtleAngle)
    myTurtle.forward(sideLength)  # side 4
    myTurtle.right(turtleAngle)
    myTurtle.end_fill()
    myTurtle.penup()
    return myTurtle


def draw_circle(myTurtle, radius):
    '''
    Function: draw_circle()
       Draws a circle by using turtle
    Parameters:
        myTurtle — turtle.Turtle — Turtle object
        radius — int — Radius of the circle
    Returns: turtle.Turtle, Turtle object, for application
    Ensure: pen and color status
    '''
    myTurtle.pendown()
    myTurtle.begin_fill()
    myTurtle.circle(radius)
    myTurtle.end_fill()
    myTurtle.penup()
    return myTurtle


def ask_pos():
    '''
    Function: ask_pos()
        Ask users to input x, y coordinates for new square and circle
    Parameters: Null
    Returns: int, user input x,y coordinates for new square and circle
    Ensure: casting String input into integer at the end, so no need for another casting when getting return value
    '''
    inquiry_x = "Please enter a coordination x for Square: "
    inquiry_y = "Please enter a coordination y for Square: "
    inquiry_x1 = "Please enter a coordination x for Circle: "
    inquiry_y1 = "Please enter a coordination y for Circle: "
    x_coor = input(inquiry_x)
    y_coor = input(inquiry_y)
    x1_coor = input(inquiry_x1)
    y1_coor = input(inquiry_y1)
    return int(x_coor), int(y_coor), int(x1_coor), int(y1_coor)


def prep(myTurtle, x, y, penColor, fillColor):
    '''
    Function: prep()
        assign tasks to turtle before drawing shapes with position and color, as a preparation
    Parameters:
        myTurtle — turtle.Turtle — Turtle object
        x — int — x—coordinate for the turtle
        y — int — y—coordinate for the turtle
        penColor — str — Color of the pen
        fillColor — str — Fill color for the shape
    Returns: turtle.Turtle, Turtle object, for application
    Ensure: pen and color status
    '''
    myTurtle.penup()
    myTurtle.goto(int(x), int(y))
    myTurtle.color(penColor, fillColor)
    return myTurtle
