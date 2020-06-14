package machine;

import java.util.Scanner;

enum NextStep {
    askAction("Write action (buy, fill, take, remaining, exit):", 0),
    buyEspresso(null, 1),
    buyLatte(null, 2),
    buyCappuccino(null, 3),
    buy("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:", 4),
    fillWater("Write how many ml of water do you want to add:", 5),
    fillMilk("Write how many ml of milk do you want to add:", 6),
    fillCoffee("Write how many grams of coffee beans do you want to add:", 7),
    fillCups("Write how many disposable cups of coffee do you want to add:", 8),
    fill(null, 9),
    remaining(null, 10),
    take(null, 11),
    back(null, 12),
    exit(null, 13);

    String question;
    int step;

    NextStep(String question, int step) {
        this.question = question;
        this.step = step;
    }
}

enum MachineStatus {
    money(550),
    water(400),
    milk(540),
    coffee(120),
    disposableCups(9),
    step(0);

    int amount;

    MachineStatus(int amount) {
        this.amount = amount;
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (MachineStatus.step.amount != 13) {
            String input = scanner.next();
            UseCoffeeMachine(input);
        }
    }

    private static void TakeTheMoney() {
        System.out.println("I gave you $" + MachineStatus.money.amount);
        MachineStatus.money.amount = 0;
    }

    private static void PrintStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(MachineStatus.water.amount + " of water");
        System.out.println(MachineStatus.milk.amount + " of milk");
        System.out.println(MachineStatus.coffee.amount + " of coffee beans");
        System.out.println(MachineStatus.disposableCups.amount + " of disposable cups");
        System.out.println(MachineStatus.money.amount > 0 ? "$" + MachineStatus.money.amount + " of money" : "0 of money");
    }

    static void UseCoffeeMachine(String input) { //2

        NextStep nextStep = getNextStep(input);

        switch (nextStep) {
            case askAction:
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 10;
                break;
            case remaining:
                PrintStatus();
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case buy:
                System.out.println(NextStep.buy.question);
                MachineStatus.step.amount = 15;
                break;
            case buyCappuccino:
                makeCappuccino();
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case buyLatte:
                makeLatte();
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case buyEspresso:
                makeEspresso();
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case fill:
                System.out.println(NextStep.fillWater.question);
                MachineStatus.step.amount = 5;
                break;
            case fillWater:
                MachineStatus.water.amount += Integer.parseInt(input);
                System.out.println(NextStep.fillMilk.question);
                MachineStatus.step.amount = 6;
                break;
            case fillMilk:
                MachineStatus.milk.amount += Integer.parseInt(input);
                System.out.println(NextStep.fillCoffee.question);
                MachineStatus.step.amount = 7;
                break;
            case fillCoffee:
                MachineStatus.coffee.amount += Integer.parseInt(input);
                System.out.println(NextStep.fillCups.question);
                MachineStatus.step.amount = 8;
                break;
            case fillCups:
                MachineStatus.disposableCups.amount += Integer.parseInt(input);
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case take:
                TakeTheMoney();
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case back:
                System.out.println(NextStep.askAction.question);
                MachineStatus.step.amount = 0;
                break;
            case exit:
            default:
                MachineStatus.step.amount = 13;
                break;
        }
    }

    private static NextStep getNextStep(String input) { //2
        switch (MachineStatus.step.amount) {
            case 15:
                return getCoffeeType(input);
            case 5:
                return NextStep.fillWater;
            case 6:
                return NextStep.fillMilk;
            case 7:
                return NextStep.fillCoffee;
            case 8:
                return NextStep.fillCups;
            default:
                return NextStep.valueOf(input);
        }
    }

    private static NextStep getCoffeeType(String input) {
        switch (input) {
            case "1":
                return NextStep.buyEspresso;
            case "2":
                return NextStep.buyLatte;
            case "3":
                return NextStep.buyCappuccino;
            default:
                return NextStep.valueOf(input);
        }
    }

    private static void makeCappuccino() {
        if (MachineStatus.water.amount >= 200 && MachineStatus.coffee.amount >= 12 && MachineStatus.milk.amount >= 100) {
            MachineStatus.water.amount -= 200;
            MachineStatus.milk.amount -= 100;
            MachineStatus.coffee.amount -= 12;
            MachineStatus.money.amount += 6;
            System.out.println("I have enough resources, making you a coffee!");
            MachineStatus.disposableCups.amount--;
        } else {
            String missingItem = MachineStatus.water.amount < 200 ? "water" : MachineStatus.coffee.amount < 12 ? "coffee" : "milk";
            System.out.println("Sorry, not enough " + missingItem + "!");
        }
    }

    private static void makeLatte() {
        if (MachineStatus.water.amount >= 350 && MachineStatus.coffee.amount >= 20 && MachineStatus.milk.amount >= 75) {
            MachineStatus.water.amount -= 350;
            MachineStatus.milk.amount -= 75;
            MachineStatus.coffee.amount -= 20;
            MachineStatus.money.amount += 7;
            System.out.println("I have enough resources, making you a coffee!");
            MachineStatus.disposableCups.amount--;
        } else {
            String missingItem = MachineStatus.water.amount < 250 ? "water" : MachineStatus.coffee.amount < 20 ? "coffee" : "milk";
            System.out.println("Sorry, not enough " + missingItem + "!");
        }
    }

    private static void makeEspresso() {

        if (MachineStatus.water.amount >= 250 && MachineStatus.coffee.amount >= 16) {
            MachineStatus.water.amount -= 250;
            MachineStatus.coffee.amount -= 16;
            MachineStatus.money.amount += 4;
            System.out.println("I have enough resources, making you a coffee!");
            MachineStatus.disposableCups.amount--;
        } else {
            String missingItem = MachineStatus.water.amount < 250 ? "water" : "coffee";
            System.out.println("Sorry, not enough " + missingItem + "!");
        }
    }
}
