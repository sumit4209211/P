public class ParkingLotManager {

    private final ParkingLot parkingLot;
    String[] vehicleTypes = { "TwoWheeler", "Car", "Bus" };

    public ParkingLotManager(int numberOfSlots) {
        parkingLot = new ParkingLot();
    }
}
