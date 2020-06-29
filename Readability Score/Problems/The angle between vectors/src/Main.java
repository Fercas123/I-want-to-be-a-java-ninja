import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double den = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2)) * (Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2)));
        double cos = (x1 * x2 + y1 * y2) / den;
        System.out.println((int) (Math.toDegrees(Math.acos(cos))));

    }
}