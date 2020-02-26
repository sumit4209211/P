public class ParkingAttendant extends Account {

    public boolean processTicket(String ticketNumber) {
        return false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
