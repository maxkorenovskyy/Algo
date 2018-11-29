import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    static long timeOfWork = 0;
    static int numberOfComparison = 0;
    static int numberOfExchange = 0;
    private static long startTime = System.nanoTime();

    public static List<NewYearTree> mergeSort(List<NewYearTree> newYearTrees) {
        if (newYearTrees.size() <= 1) {
            return newYearTrees;
        }
        List<NewYearTree> left = new ArrayList<>();
        List<NewYearTree> right = new ArrayList<>();
        int middle = newYearTrees.size() / 2;

        for (int i = 0; i < newYearTrees.size(); i++) {
            if (i < middle) {
                left.add(newYearTrees.get(i));
            } else {
                right.add(newYearTrees.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<NewYearTree> merge(List<NewYearTree> left, List<NewYearTree> right) {
        List<NewYearTree> mergedList = new ArrayList<>();

        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                numberOfComparison += 1;
                if (left.get(0).getHeight() < right.get(0).getHeight()) {
                    mergedList.add(left.get(0));
                    left.remove(0);
                    numberOfExchange += 1;
                } else {
                    mergedList.add(right.get(0));
                    right.remove(0);
                    numberOfExchange += 1;
                }
            } else if (left.size() > 0) {
                mergedList.add(left.get(0));
                left.remove(0);
                numberOfExchange += 1;
            } else if (right.size() > 0) {
                mergedList.add(right.get(0));
                right.remove(0);
                numberOfExchange += 1;
            }
        }

        timeOfWork = System.nanoTime() - startTime;
        return mergedList;
    }
}