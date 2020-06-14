import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String content = scanner.nextLine();
        final String[] strArray = content.split(" ");
        final int length = strArray.length;
        final int moves = scanner.nextInt();
        int pointer = moves % length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (pointer == length) {
                pointer = 0;
            }
            newArray[pointer] = Integer.parseInt(strArray[i]);
            pointer++;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}
