import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt(); //  7
        int counter = 0;

        while (counter < length) {
            for (int i = 1; i <= length; i++) {
                if (counter != length) {
                    System.out.print(i + " ");
                    counter++;
                    for (int j = 1; j < i; j++) {
                        if (counter != length) {
                            System.out.print(i + " ");
                            counter++;
                        } else {
                            break;
                        }

                    }
                } else {
                    break;
                }
            }

        }

    }
}