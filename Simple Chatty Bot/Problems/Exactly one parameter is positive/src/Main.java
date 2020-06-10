import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();

        System.out.println(isPositive(first)
                ? !isPositive(second) && !isPositive(third)
                : !isPositive(second) || !isPositive(third)
        );
    }

    public static boolean isPositive(int numberToTest) {
        return numberToTest > 0;
    }
}
