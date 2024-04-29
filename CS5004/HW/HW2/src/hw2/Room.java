package hw2;

/**
 * Wenqing Zeng - HW2
 * This class represents a Room class.
 */
public class Room {
  private final RoomType roomType;
  private final double roomPrice;
  private int numOfGuests;
  private int maxOccupancy;

  private static final int SINGLE_MAX_OCCUPANCY = 1;
  private static final int DOUBLE_MAX_OCCUPANCY = 2;
  private static final int FAMILY_MAX_OCCUPANCY = 4;

  /**
   * Instantiates a new Room.
   * Room price must be positive number and zero,
   * Room type is defined by user,
   * And room occupancy is determined by type.
   *
   * @param roomType the room type
   * @param roomPrice the room price
   * @throws IllegalArgumentException the，illegal argument exception
   *
   */
  public Room(RoomType roomType, double roomPrice) throws IllegalArgumentException {
    if (roomPrice < 0) {
      throw new IllegalArgumentException("Room price can not be a negative number.");
    }
    this.roomType = roomType;
    this.roomPrice = roomPrice;

    // Set room to empty by default.
    this.numOfGuests = 0;

    // Set room max occupancy respectively.
    switch (this.roomType) {
      case SINGLE:
        this.maxOccupancy = SINGLE_MAX_OCCUPANCY;
        break;
      case DOUBLE:
        this.maxOccupancy = DOUBLE_MAX_OCCUPANCY;
        break;
      case FAMILY:
        this.maxOccupancy = FAMILY_MAX_OCCUPANCY;
        break;
    }
  }

  /**
   * Function to detect whether room is available.
   * If nobody is booked in, then yes, so compare with 0
   *
   *
   * @return the boolean showing whether room is available
   */
  public boolean isAvailable() {
    return this.numOfGuests == 0;
  }

  /**
   * Book room after checking whether it will over occupy,
   * Or if room is already booked.
   *
   * @param guests the guests
   */
  public void bookRoom(int guests) {
    if ((0 < guests) && (guests <= this.maxOccupancy) && this.isAvailable()) {
      this.numOfGuests = guests;
    }
  }

  /**
   * Gets number of guests.
   *
   * @return the number of guests
   */
  public int getNumberOfGuests() {
    return this.numOfGuests;
  }

  /**
   * Gets room type.
   *
   * @return the room type
   */
  public RoomType getRoomType() {
    return this.roomType;
  }
}

//  /**
//   * Gets room price
//   * saved for future reference.
//   *
//   * @return the room price
//   */
//  public double getRoomPrice() {
//    return this.roomPrice;
//  }
//}
