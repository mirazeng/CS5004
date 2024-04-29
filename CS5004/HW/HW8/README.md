# Photo Album Backend (Model)

## Description:
This is my project that behaves as a model for a photo album. Inside the photo album, user can create/move/scale (up and down)/change color of various shapes (As an example, I have implemented Oval and Rectangle). Whenever user wish to record the current state (the overall looks, positions, colors of each shape right now inside the album), user can decide to take a snapshot that records all these information. And later, user can view all these snapshots by putting them back onto the display.

Note that un-"snapped" changes will not be saved.

## Structure:

The project is divided into several packages:

#### `photoAlbum`

In photoAlbum package, the `ShapeAlbum` class resides. `ShapeAlbum` class manages and hosts the main display (`Canvas`) and a collection of snapshots (`Snapshot`). This class orchestrates the display canvas and has methods for taking, retrieving, and importing snapshots to the display. It can also print a textual representation of all the snapshots.

#### `canvasDisplay`

This package has the `Canvas` class that hosts a collection of shapes (`IShape`). The functionalities of adding, removing, moving, scaling, changing color on shapes are inside `Canvas` class. This class also has a method that imports a given `Snapshot` instance at any time by overwriting the current shapes on display. The uniqueness of each shape's name is also enforced inside `Canvas`.

#### `snapshot`

In `snapshot` package is the `Snapshot` class. Each instance of `Snapshot` has a list of `IShape`, a unique snapshotID and timeStamp that comes from the local datetime. The datetime is unique because the creation of `Snapshot` instance receives this datetime information from `ShapeAlbum` who reads the current time and passes it. Each snapshot also has a description that is up to user's choice. Additionally, `Snapshot` class has a getter method for retrieving the "snapshotted" list of `IShape` shapes.

#### `shape`

In this package is where the factory construction of shapes is done. Each shape adheres to the `IShape` interface, and extends an abstract `SuperShape` class.

Shapes all have these information:
- `name`, stored in `SuperShape`
- `type`, stored in `SuperShape`
- `position`, stored as `ShapePosition` instance inside `SuperShape`
- `color`, stored as `Color` instance inside `SuperShape`

Then, also unique properties that concrete shapes may have, that are different from each other.

For example, `Rectangle` class has `width` and `height`; while `Oval` class has `radiusX` and `radiusY`. However, whatever the naming/usage, these are abstracted to become `dimensionX` and `dimensionY` in factory creation. All future new shapes must also adhere to this convention (as stated by `IShape` interface). The reason behind this design decision is that, while the types of shapes may be many, at the end of the day, to draw them, we really always just need their dimension on X-Y coordinate system.

`Color` class instances all have three double values to represent R, G, B values.

#### Notes on interfaces:

All publicly available behaviors and responsibilities of `Canvas`, `ShapeAlbum`, `Snapshot` and Shapes are reflected in their respective interfaces `ICanvas`, `IAlbum`, `ISnapshot`, and `IShape`, for interface programming and next assignment.

## Testing

For each class, unit testing are done and checked, including all edge cases and (thrown) exceptions. The tests are located in the `test` directory and are separate from the `src` directory.

## Takeaway

In the future, should the amount of shape instances, or the number of snapshot instances become very large, I will update the storing of them from using List structure to using HashMap to optimize the application.

As of right now, for matching operations such as finding a specific shape using name, I am using iteration on the list that contains shapes.