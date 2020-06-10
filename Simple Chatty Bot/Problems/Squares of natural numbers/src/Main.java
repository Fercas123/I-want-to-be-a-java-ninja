import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = 1;
        while (c <= n) {
            if (c * c <= n) {
                System.out.println(c * c);
            }
            c++;
        }
    }
}
