package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        int totalSentences = 0;
        double words = 0;
        double characters = 0;
        double syllables = 0;
        double polysyllables = 0;
        try (Scanner wordScanner = new Scanner(file)) {
            System.out.println("The text is:");
            while (wordScanner.hasNext()) {
                String content = wordScanner.nextLine();
                if (content.matches(".*[.]")) {
                    characters += 1;
                }
                String[] sentences = content.split("[.!?][\\u25A0\\u00A0\\s*]?");
                syllables += content.split("[aeiouyAEIOUY]{1,3}").length;
                totalSentences += sentences.length;
                for (String sentence : sentences) {
                    String[] arrayOfWords = sentence.split("[\\u25A0\\u00A0\\s*]+");
                    words += arrayOfWords.length;
                    for (String word : arrayOfWords) {
                        characters += word.length();
                        if (word.matches(".*[e][,.!?]?")) {
                            syllables--;
                        }
                        if (word.split("[aeiouyAEIOUY]{1,3}").length > 3) {
                            polysyllables++;
                        }
                    }
                }
                characters += sentences.length - 1;
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + totalSentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        double ari = 4.71 * characters / words + 0.5 * words / totalSentences - 21.43;
        double fk = 0.39 * (words / totalSentences) + 11.8 * (syllables / words) - 15.59;
        double smog = 1.043 * Math.sqrt(polysyllables * 30 / totalSentences) + 3.1291;
        double cl = 0.0588 * ((characters / words) * 100) - 0.296 * (totalSentences / words * 100) - 15.8;

        switch (word) {
            case "ARI":
                System.out.println("Automated Readability Index: " + ari + " (about " + getAge(ari) + " year olds).");
                break;
            case "FK":
                System.out.println("Flesch–Kincaid readability tests: " + fk + " (about " + getAge(fk) + " year olds).");
                break;
            case "SMOG":
                System.out.println("Simple Measure of Gobbledygook: " + smog + " (about " + getAge(smog) + " year olds).");
                break;
            case "CL":
                System.out.println("Coleman–Liau index: " + cl + " (about " + getAge(cl) + " year olds).");
                break;
            default:
                System.out.println("Automated Readability Index: " + ari + " (about " + getAge(ari) + " year olds).");
                System.out.println("Flesch–Kincaid readability tests: " + fk + " (about " + getAge(fk) + " year olds).");
                System.out.println("Simple Measure of Gobbledygook: " + smog + " (about " + getAge(smog) + " year olds).");
                System.out.println("Coleman–Liau index: " + cl + " (about " + getAge(cl) + " year olds).");
        }
    }

    private static String getAge(double score) {
        switch ((int) Math.ceil(score)) {
            case 1:
            case 2:
                return score + 4 + "-" + score + 5;
            case 3:
                return score + 4 + "-" + score + 6;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return score + 5 + "-" + score + 6;
            case 13:
                return score + 5 + "-" + score + 11;
            default:
                return "24+";
        }
    }
}
