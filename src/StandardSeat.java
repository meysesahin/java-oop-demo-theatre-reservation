public class StandardSeat extends Seat implements CancelableSeat {
    public StandardSeat(char row, int number, double price) {
        super(row, number, price);
    }

    @Override
    public void cancel() {
        super.setReserved(false);
        System.out.println("Bu koltuktaki rezervasyon iptal edilmiştir.");
    }
}
