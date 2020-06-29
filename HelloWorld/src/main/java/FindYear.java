import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindYear {

    public static void main(String[] args) {
        int year = 0;
        long population = 0L;
        long increase = 0L;
        File file = new File("/Users/fernandacastillo/IdeaProjects/HelloWorld/dataset_91069.txt");
        try (Scanner scanner = new Scanner(file)) {
            // discard headers
            scanner.nextLine();
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] splitData = data.split("\\s+");
                long nextPopulation = Long.parseLong(splitData[1].replace(",", ""));
                if (population == 0) {
                    population = nextPopulation;
                }
                if (nextPopulation - population > increase) {
                    year = Integer.parseInt(splitData[0]);
                }
                increase = Math.max((nextPopulation - population), increase);
                population = nextPopulation;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        System.out.print(year);
    }
}