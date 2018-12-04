import java.io.File;
import java.util.Scanner;

public class  Career3 {
    private static int[][] experiencePyramid;

    public static void main(String[] args) {
        readDataFromFile();

        int maxTotalExperience = findMaxTotalExperience(experiencePyramid);
        System.out.println(maxTotalExperience);
    }

    private static int findMaxTotalExperience(int[][] works) {
        for (int i = works.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                works[i][j] += Math.max(works[i + 1][j], works[i + 1][j + 1]);
            }
        }
        return works[0][0];
    }

    private static void readDataFromFile() {
        try {
            Scanner scanner = new Scanner(new File("career.in"));
            short numberOfLevels = scanner.nextShort();
            experiencePyramid = new int[numberOfLevels][numberOfLevels];
            for (int i = 0; i < numberOfLevels; i++) {
                for (int j = 0; j <= i; j++) {
                    experiencePyramid[i][j] = scanner.nextShort();
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}