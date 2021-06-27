public class Seat {
    private char row;
    private int number;
    private double price;
    private boolean isReserved;
    private static final double KDV_RATIO = 0.2;

    public Seat(char row, int number, double price) {
        this.row = row;
        this.number = number;
        this.price = price;
        this.isReserved = false;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void reserve(){
        this.isReserved = true;
    }

    public double calculatePrice(){
        double result = this.price;
        result += result * KDV_RATIO;
        return result;
    }

    @Override
    public String toString() {
        return "[" + row + number + ": " + (isReserved ? "x" : "o") + "]";
    }
}
