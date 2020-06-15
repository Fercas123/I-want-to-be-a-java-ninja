import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input < 15) {
            String[][] array = new String[input][input];
            int end = input - 1;
            int middle = end / 2;
            for (int i = 0; i < input; i++) {
                for (int j = 0; j < input; j++) {
                    if (j == i || j == middle || i == middle || j == end) {
                        array[i][j] = "*";
                    } else {
                        array[i][j] = ".";
                    }
                    System.out.print(array[i][j] + " ");

                }
                end--;
                System.out.println();
            }
        }
    }
}