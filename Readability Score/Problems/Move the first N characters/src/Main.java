import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String input = scanner.next();
        final int move = scanner.nextInt();
        if (input.length() < move) {
            System.out.println(input);
        } else {
            System.out.println((input.substring(move) + (input.substring(0, move))));
        }
    }
}