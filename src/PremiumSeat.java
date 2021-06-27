public class PremiumSeat extends Seat{
    private int multiplier;

    public PremiumSeat(int multiplier, char row, int number, double price) {
        super(row, number, price);
        this.multiplier = multiplier;
    }

    @Override
    public double calculatePrice(){
        return super.calculatePrice() * this.multiplier;
    }
}
