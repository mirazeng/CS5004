package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** A JUnit test class for class Room. Three Room constructed: oom01, room02, room03 */
public class TestRoom {
  private Room room01;
  private Room room02;
  private Room room03;

  /** Sets up parameters for Room objects. */
  @BeforeEach
  void setUp() {
    room01 = new Room(RoomType.SINGLE, 100.0);
    room02 = new Room(RoomType.DOUBLE, 200.0);
    room03 = new Room(RoomType.FAMILY, 300.0);
  }

  /** Test good constructor
   *  in class Room, price have a getter but did not be used efficiently
   *  So no test for the getter of price but saved for future reference.
   */
  @Test
  void testGoodConstructor() {
    Assertions.assertEquals(RoomType.SINGLE, room01.getRoomType());
    //Assertions.assertEquals(100.0, room01.getRoomPrice());
    Assertions.assertEquals(0, room01.getNumberOfGuests());
    Assertions.assertEquals(RoomType.DOUBLE, room02.getRoomType());
    //Assertions.assertEquals(200.0, room02.getRoomPrice());
    Assertions.assertEquals(0, room02.getNumberOfGuests());
    Assertions.assertEquals(RoomType.FAMILY, room03.getRoomType());
    //Assertions.assertEquals(300.0, room03.getRoomPrice());
    Assertions.assertEquals(0, room03.getNumberOfGuests());
  }

  /** Test bad constructor. */
  @Test
  void testBadConstructor() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> new Room(RoomType.SINGLE, -100.0));

    Assertions.assertThrows(
        IllegalArgumentException.class, () -> new Room(RoomType.DOUBLE, -200.0));

    Assertions.assertThrows(
        IllegalArgumentException.class, () -> new Room(RoomType.FAMILY, -300.0));
  }

  /** Test is available by implementing book room. */
  @Test
  void testIsAvailable() {
    Assertions.assertTrue(room01.isAvailable());
    room01.bookRoom(1);
    Assertions.assertFalse(room01.isAvailable());

    Assertions.assertTrue(room02.isAvailable());
    room02.bookRoom(2);
    Assertions.assertFalse(room02.isAvailable());

    Assertions.assertTrue(room03.isAvailable());
    room03.bookRoom(4);
    Assertions.assertFalse(room03.isAvailable());
  }

  /** Test book room when room is not booked and already occupied. */
  @Test
  void testBookRoom() {
    room01.bookRoom(1);
    Assertions.assertEquals(1, room01.getNumberOfGuests());
    room02.bookRoom(2);
    Assertions.assertEquals(2, room02.getNumberOfGuests());
    room03.bookRoom(4);
    Assertions.assertEquals(4, room03.getNumberOfGuests());
  }

  /** Test get number of guests by implementing bookroom method and getter. */
  @Test
  void testGetNumberOfGuests() {
    room01.bookRoom(1);
    Assertions.assertEquals(1, room01.getNumberOfGuests());
    room02.bookRoom(2);
    Assertions.assertEquals(2, room02.getNumberOfGuests());
    room03.bookRoom(4);
    Assertions.assertEquals(4, room03.getNumberOfGuests());
  }

  /**
   * Test room not full in real life situation, customers can check in when even they don't have
   * enough people for the room. for example: upgrade from single to double, or double to family for
   * more space.
   */
  @Test
  void testRoomNotFull() {
    room02.bookRoom(1);
    Assertions.assertEquals(1, room02.getNumberOfGuests());
    room03.bookRoom(3);
    Assertions.assertEquals(3, room03.getNumberOfGuests());
  }

  /**
   * Test room full when guests who booked are over the maximum number of guests for a type of room.
   */
  @Test
  void testRoomFull() {
    room01.bookRoom(2);
    Assertions.assertEquals(0, room01.getNumberOfGuests());
    room02.bookRoom(3);
    Assertions.assertEquals(0, room02.getNumberOfGuests());
    room03.bookRoom(5);
    Assertions.assertEquals(0, room03.getNumberOfGuests());
  }
}
