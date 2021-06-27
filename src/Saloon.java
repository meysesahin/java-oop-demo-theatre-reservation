public class Saloon extends Object{
    private String name;
    private Seat[][] seats;

    public Saloon(String name, Seat[][] seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public void reserveSeat(char row, int number) {
        Seat seat = seats[row - 'A'][number - 1];
        if (seat.isReserved()) {
            System.out.println("Bu koltuk rezerve edilemez.");
        } else {
            seat.setReserved(true);
            System.out.println("Bu koltuk " + seat.calculatePrice() + " TL karşılığında rezerve  edilmiştir.");
        }
    }

    public void cancelSeats(char row, int number) {
        Seat seat = seats[row - 'A'][number - 1];
        if (!seat.isReserved()) {
            System.out.println("Bu koltuk rezerve değildir.");
        } else if (seat instanceof CancelableSeat) {
            ((CancelableSeat) seat).cancel();
        } else {
            System.out.println("Bu koltuktaki rezervasyon iptal edilemez.");
        }
    }

    @Override
    public String toString() {
        String s = "Salon " + name + "\n";
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                s += seats[i][j].toString();
            }
            s += "\n";
        }
        return s;
    }
}
