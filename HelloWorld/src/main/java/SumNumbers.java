import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumNumbers {

    public static void main(String[] args) {

        int sum = 0;
        File file = new File("/Users/fernandacastillo/IdeaProjects/HelloWorld/dataset_91033.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sum += Integer.parseInt(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        System.out.print(sum);
    }
}