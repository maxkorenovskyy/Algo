import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<NewYearTree> getDataFromFile() {
        List<NewYearTree> newYearTrees = new ArrayList<>();
        try (FileReader fileReader = new FileReader("trees.txt")) {
            Scanner scan = new Scanner(fileReader);

            while (scan.hasNextLine()) {
                String readString = scan.nextLine();
                String[] treesInfo = readString.split(",");

                String name = treesInfo[0];
                double height = Double.parseDouble(treesInfo[1]);
                int price = Integer.parseInt(treesInfo[2]);
                String material = treesInfo[3];

                newYearTrees.add(new NewYearTree(name, height, price, material));
            }
            fileReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newYearTrees;
    }

    private static void printList(List<NewYearTree> list) {
        for (NewYearTree newYearTree : list) {
            System.out.println(newYearTree.toString());
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        List<NewYearTree> newYearTrees;

        newYearTrees = getDataFromFile();

        System.out.println("Initial list of new year trees:");
        printList(newYearTrees);

        newYearTrees = SelectionSorter.selectionSortByPrice(newYearTrees);

        System.out.println("\nSelection Sort descending by price:");
        printList(newYearTrees);

        System.out.println("Number of exchanges:" + SelectionSorter.numberOfExchange);
        System.out.println("Number of comparison operations:" + SelectionSorter.numberOfComparison);
        System.out.println("Work time:" + SelectionSorter.timeOfWork + " nanoseconds\n");

        MergeSort.mergeSort(newYearTrees);

        System.out.println("\n\nMerge Sort ascending by height:");
        printList(newYearTrees);

        System.out.println("Number of exchanges:" + MergeSort.numberOfExchange);
        System.out.println("Number of comparison operations:" + MergeSort.numberOfComparison);
        System.out.println("Work time:" + MergeSort.timeOfWork + " nanoseconds");
    }
}