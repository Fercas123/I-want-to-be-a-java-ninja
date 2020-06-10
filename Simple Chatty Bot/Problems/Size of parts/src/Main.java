import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfParts = scanner.nextInt();
        int toShip = 0;
        int rejected = 0;
        int correct = 0;

        for (int i = 0; i < numberOfParts; i++) {
            int status = scanner.nextInt();
            if (status == 1) {
                correct++;
            } else if (status == 0) {
                toShip++;
            } else {
                rejected++;
            }
        }
        System.out.println(toShip + " " + correct + " " + rejected);
    }
}