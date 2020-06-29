import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        char[] reverseArr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            reverseArr[i] = input.charAt(input.length() - 1 - i);
        }
        System.out.println(input.equals(String.valueOf(reverseArr)) ? "yes" : "no");
    }
}