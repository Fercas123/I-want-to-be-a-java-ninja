import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int ticketsToBuy = scanner.nextInt();
        int emptySeatsFound = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) {
                    emptySeatsFound++;
                    if (emptySeatsFound == ticketsToBuy) {
                        System.out.println(i + 1);
                        return;
                    }
                } else {
                    emptySeatsFound = 0;
                }
            }
            emptySeatsFound = 0;
            if (i == n - 1) {
                System.out.println(emptySeatsFound);
                return;
            }
        }
    }
}