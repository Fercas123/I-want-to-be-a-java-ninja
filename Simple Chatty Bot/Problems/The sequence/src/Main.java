import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elements = scanner.nextInt();
        int c = 0;
        int max = 0;
        while (c < elements) {
            int element = scanner.nextInt();
            if (element % 4 == 0 && element > max) {
                max = element;
            }
            c++;
        }
        System.out.println(max);

    }
}