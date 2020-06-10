import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean asc = true;
        boolean desc = true;
        int lastNumber = 0;

        while (true) {
            int nextNumber = scanner.nextInt();
            boolean isDesc = nextNumber <= lastNumber && desc;
            boolean isAsc = nextNumber >= lastNumber && asc;
            if (nextNumber == 0) {
                System.out.println(true);
                break;
            } else if (lastNumber == 0) {
                lastNumber = nextNumber;
            } else if (isAsc || isDesc) {
                asc = isAsc;
                desc = isDesc;
                lastNumber = nextNumber;
            } else {
                System.out.println(false);
                break;
            }
        }
    }
}