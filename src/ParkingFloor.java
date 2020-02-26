import java.util.HashMap;

public class ParkingFloor {
    private String name;
    private HashMap<String, HandicappedSpot> handicappedSpots;
    private HashMap<String, CompactSpot> compactSpots;
    private HashMap<String, LargeSpot> largeSpots;
    private HashMap<String, MotorBikeSpot> motorbikeSpots;
    private HashMap<String, ElectricSpot> electricSpots;
    private HashMap<String, CustomerInfoPortal> infoPortals;
    private ParkingDisplayBoard displayBoard;
    private int freeLargeSpotCount;
    ParkingSpotType parkingSpotType;
    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (parkingSpotType) {
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot);
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), (CompactSpot) spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), (LargeSpot) spot);
                break;
            case MOTORBIKE:
                motorbikeSpots.put(spot.getNumber(), (MotorBikeSpot) spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        switch (spot.getType()) {
            case HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            case COMPACT:
                updateDisplayBoardForCompact(spot);
                break;
            case LARGE:
                updateDisplayBoardForLarge(spot);
                break;
            case MOTORBIKE:
                updateDisplayBoardForMotorbike(spot);
                break;
            case ELECTRIC:
                updateDisplayBoardForElectric(spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    private void updateDisplayBoardForElectric(ParkingSpot spot) {
    }

    private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
    }

    private void updateDisplayBoardForLarge(ParkingSpot spot) {
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    public void freeSpot(ParkingSpot spot) {
        spot.removeVehicle();
        switch (spot.getType()) {
            case HANDICAPPED:
                int freeHandicappedSpotCount = 0;
                freeHandicappedSpotCount++;
                break;
            case COMPACT:
                int freeCompactSpotCount = 0;
                freeCompactSpotCount++;
                break;
            case LARGE:
                freeLargeSpotCount++;
                break;
            case MOTORBIKE:
                int freeMotorbikeSpotCount = 0;
                freeMotorbikeSpotCount++;
                break;
            case ELECTRIC:
                int freeElectricSpotCount = 0;
                freeElectricSpotCount++;
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public boolean isFull() {
        return true;
    }
}
