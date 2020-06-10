import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int nextNumber = scanner.nextInt();
            if (nextNumber == 0) {
                break;
            }
            System.out.println(nextNumber % 2 == 0 ? "even" : "odd");

        }
    }
}