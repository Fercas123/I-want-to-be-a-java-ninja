import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int tens = (input / 10) % 10;
        System.out.println(tens);
    }
}