import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String date = scanner.nextLine();
        String[] dateElements = date.split("-");
        System.out.println(dateElements[1] + "/" + dateElements[2] + "/" + dateElements[0]);
    }
}