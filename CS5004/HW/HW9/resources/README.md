# Photo Album Java Application

## Description:
This is the PhotoAlbum java application built using java and java swing package.

The application is built using M-V-C architecture design.

### **Model:**

```
model
├── canvasDisplay
│   ├── Canvas.java
│   └── ICanvas.java
├── photoAlbum
│   ├── IAlbum.java
│   └── ShapeAlbum.java
├── shape
│   ├── IShape.java
│   ├── Oval.java
│   ├── Rectangle.java
│   ├── ShapeColor.java
│   ├── ShapeFactory.java
│   ├── ShapePosition.java
│   └── SuperShape.java
└── snapshot
    ├── ISnapshot.java
    └── Snapshot.java
```

**Model** controls the interactions and status of each logical components that represent a photo album consisted entirely of shapes. Shapes are of different names, types, color, position, dimensions.

The display (representing the page inside photo album) is made of a Canvas that manipulate these shapes, and export its own state.

Exported states of shapes on Canvas become static and then become Snapshots. The collection of all snapshots is in `ShapeAlbum` which orchestrates all backend businesses.



### **View:**

```
view
├── CanvasPanel.java
├── INoMoreSnapshotsDialog.java
├── IPhotoAlbumView.java
├── ISnapshotSelectionDialog.java
├── IWebView.java
├── NoMoreSnapshotsDialog.java
├── PhotoAlbumView.java
├── SnapshotSelectionDialog.java
└── WebView.java
```

**View** include the main display `PhotoAlbumView` that is a grid-layout JFrame and hosts from top-to-bottom: A banner to display currently loaded snapshot information; A display area (a JPanel) that renders the shapes from snapshot; A toolbar at the bottom with four buttons for navigating snapshots, selecting a specific snapshot, and one for quitting the program.



### **Controller:**

```
controller
├── AlbumController.java
├── FileParser.java
└── IAlbumController.java
```

**Controller** works as the main "worker" of the application when graphical view is specified by user via command-line input.

`AlbumController` works as the middleman between the **Model** and the **View**. First of all, the actions (`ActionListener` class) that buttons on the **View** side are defined within it. It binds the view to these actions, and perform these actions (all of which interact with the model instance) when user interact with the view.

`FileParser` is used for reading the user-provided file containining pre-defined commands that manipulate shapes. FileParser instance are called in **Main**  and are used to parse them into the model instance.



### **Main:**

```
src
├── META-INF
├── PhotoAlbumMain.java
├── controller
├── model
└── view
```

The source folder contains the single entrance to the program called `PhotoAlbumMain.java` that takes command-line input flags and decide whether `WebView` or `PhotoAlbumView` (Graphical) are constructed alongside with **Model** instance and a `FileParser` for provisioning the model before user starts interacting with it.



## Inside Model—Backend Structure:

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

**On Testing WebView:**

I tested the functionality of generaing a webview, by first hand-crafting a html file that should be the correct product of using `demo_input.txt` file as commands, then comparing that manual result, with the application-created one. Note that timestamps are used for creation of snapshots, so in comparisons, the expected and actual webview could never be completely identical, due to it containing a banner that displays snapshot info such as unique IDs. Excluding this, everything else works perfectly.

## Design Change for full MVC architecture

Since the last assignment, there has been some changes made to the model backend to accomodate better interoperability with the view via controllers.

- All usage of `double` type for positions, dimensions, color values are unified to be integer. This is done because all user-provided command files use integer only in specifying these field properties for shapes.
- All usage of previously-overlooked occasions of implementation instead of Interfaces are fixed to program to interfaces.
- In Model, inside `PhotoAlbum` implementation, added the functionality of tracking which snapshot is "displayed" at the moment. This is done to support the required "next" & "previous" navigation interactions from the **view** side of things. To do that we need locality, and for locality we needed a tracker.
- Respectively, methods including `getNextSnapshot()`, `getPrevSnapshot()` and `setCurrentSnapshotByID()` are added to `ShapeAlbum.java` in model to support the navigation and importing interactions.
- Further stability upgrade, such as making sure only one type of unique identifier is used for accessing, e.g. using snapshotID which is guaranteed unique by using time-generated information throughout the program where accessing or retrieving respective snapshot using ID is required.