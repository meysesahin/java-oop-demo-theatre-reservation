import java.util.Scanner;

public class TheatreBooking {
    public static void main(String[] args) {
        Seat[][] seats = new Seat[4][5];
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j<5; j++){
                if (i < 2) {
                    seats[i][j] = new PremiumSeat(2, (char) ('A' + i), j + 1, 10);
                } else {
                    seats[i][j] = new StandardSeat((char) ('A' + i), j + 1, 10);
                }
            }
        }
        Saloon saloonA = new Saloon("A", seats);
        System.out.println(saloonA);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Yapmak istediğiniz aksiyonu yazınız (R: Rezervasyon, C: İptal): ");
            String action = scanner.next();

            if(action.equals("R")) {
                reserveSeat(saloonA);
            } else if (action.equals("C")){
                cancelSeat(saloonA);
            } else {
                System.out.println("Program kapatılıyor." + saloonA);
                break;
            }
            System.out.println(saloonA);
        }

    }

    private static void reserveSeat(Saloon saloon){
        System.out.print("Rezerve etmek istediğiniz koltuk numarasını girin: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char row = input.charAt(0);
        int number = input.charAt(1) - '0';
        saloon.reserveSeat(row, number);
    }

    private static void cancelSeat(Saloon saloon){
        System.out.print("İptal etmek istediğiniz koltuk numarasını girin: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char row = input.charAt(0);
        int number = input.charAt(1) - '0';
        saloon.cancelSeats(row, number);
    }

}