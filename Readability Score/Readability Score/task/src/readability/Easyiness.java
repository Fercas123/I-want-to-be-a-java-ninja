package readability;

import java.util.Scanner;

public class Easyiness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        if (content.matches(".*[.]")){
            content = content.substring(0, content.length() - 1);
        }
        String[] sentences = content.split("[.!?][\\u25A0\\u00A0\\s*]?");
        int words = 0;
        for (String sentence : sentences) {
            words += sentence.split("[\\u25A0\\u00A0\\s*]+").length;
        }
        if ((float) words / sentences.length <= 10) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }
}
