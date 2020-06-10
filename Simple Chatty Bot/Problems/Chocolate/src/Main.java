import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nn = scanner.nextInt();
        int mm = scanner.nextInt();
        int kk = scanner.nextInt();

        boolean canCutChoco = nn * mm > kk && (kk % nn == 0 || kk % mm == 0);
        System.out.println(canCutChoco ? "YES" : "NO");
    }
}