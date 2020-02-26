public class Main {

    public static void main(String[] args) {


        Car car = new Car();
        car.setCompact(true);
        if(ParkingLot.isEmpty())
            ParkingLot.park();

        ParkingLot.unPark(20);
    }
}

