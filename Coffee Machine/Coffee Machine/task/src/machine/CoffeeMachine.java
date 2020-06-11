package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int canMake = 0;

        while (water >= 200 && milk >= 50 && beans >= 15) {
            canMake++;
            water -= 200;
            milk -= 50;
            beans -= 15;
        }

        if (canMake < cups) {
            System.out.println("No, I can make only " + canMake + " cup(s) of coffee");
        } else if (canMake == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + (canMake - cups) + " more than that)");
        }
    }
}
