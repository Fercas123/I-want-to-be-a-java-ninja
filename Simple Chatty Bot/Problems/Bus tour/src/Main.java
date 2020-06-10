import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heigth = scanner.nextInt();
        int bridges = scanner.nextInt();
        boolean crashed = false;
        for (int i = 0; i < bridges; i++) {
            int bridgeHeigth = scanner.nextInt();
            if (bridgeHeigth <= heigth) {
                System.out.println("Will crash on bridge " + (i + 1));
                crashed = true;
                break;
            }
        }
        if (!crashed) {
            System.out.println("Will not crash");
        }

    }
}
