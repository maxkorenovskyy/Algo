import java.util.List;

public class SelectionSorter {
    static int numberOfComparison;
    static int numberOfExchange;
    static long timeOfWork;

    public static List<NewYearTree> selectionSortByPrice(List<NewYearTree> newYearTrees) {
        long startTime = System.nanoTime();
        for (int i = 0; i < newYearTrees.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < newYearTrees.size(); j++) {
                numberOfComparison += 1;
                if (newYearTrees.get(j).getPrice() > newYearTrees.get(maxIndex).getPrice()) {
                    maxIndex = j;
                }
            }
            NewYearTree tmp = newYearTrees.get(i);
            newYearTrees.set(i, newYearTrees.get(maxIndex));
            newYearTrees.set(maxIndex, tmp);
            numberOfExchange += 1;
        }

        timeOfWork = System.nanoTime() - startTime;

        return newYearTrees;
    }
}