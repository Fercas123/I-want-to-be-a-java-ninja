import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextItem = scanner.next();
            if ("0".equals(nextItem)) {
                return;
            }
            try {
                System.out.println(Integer.parseInt(nextItem) * 10);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + nextItem);
            }
        }

    }
}