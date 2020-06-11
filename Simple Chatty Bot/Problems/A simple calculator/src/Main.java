import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long firstNo = scanner.nextLong();
        String operation = scanner.next();
        Long secondNo = scanner.nextLong();
        switch (operation) {
            case "+":
                System.out.println(firstNo + secondNo);
                break;
            case "-":
                System.out.println(firstNo - secondNo);
                break;
            case "/":
                if (secondNo == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(firstNo / secondNo);
                break;
            case "*":
                System.out.println(firstNo * secondNo);
                break;
            default:
                System.out.println("Unknown operator");

        }
    }
}
