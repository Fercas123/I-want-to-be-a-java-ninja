import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length - 1; i++) {
            int next = scanner.nextInt();
            arr[i + 1] = next;
        }
        arr[0] = scanner.nextInt();

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
