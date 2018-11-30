import java.util.Arrays;

public class Main {
    public static void main(String[] arg) {
        int cowsNum = 5;
        int aggressiveCowsNum = 3;
        int[] positions = {1, 2, 8, 4, 9};

        Arrays.sort(positions);

        int[] distances = new int[cowsNum - 1];

        for (int i = 0; i < cowsNum - 1; i++) {
            distances[i] = positions[i + 1] - positions[i];
        }

        System.out.println(distanceBinarySearch(distances, 0, (positions[cowsNum - 1] - positions[0]) / (aggressiveCowsNum - 1), aggressiveCowsNum - 1));
    }

    private static int distanceBinarySearch(int[] distances, int startIndex, int endIndex, int counter) {
        if (endIndex - startIndex < 0) {
            return 0;
        } else {
            int midIndex = (endIndex + startIndex) / 2;
            int tempCounter = count(distances, midIndex);
            if (tempCounter < counter) {
                return distanceBinarySearch(distances, startIndex, midIndex - 1, counter);
            } else if (tempCounter == counter) {
                if (count(distances, midIndex + 1) == counter) {
                    return distanceBinarySearch(distances, midIndex + 1, endIndex, counter);
                } else {
                    return midIndex;
                }
            } else {
                return distanceBinarySearch(distances, midIndex + 1, endIndex, counter);
            }
        }
    }

    private static int count(int[] distances, int compareValue) {
        int counter = 0;
        int sum = 0;
        for (int distance : distances) {
            sum += distance;
            if (sum >= compareValue) {
                counter++;
                sum = 0;
            }
        }
        return counter;
    }
}