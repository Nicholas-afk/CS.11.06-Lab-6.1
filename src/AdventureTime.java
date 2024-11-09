import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");

        System.out.println(challengeOneAnswer);
        System.out.println(challengeTwoAnswer);
        System.out.println(challengeThreeAnswer);
        System.out.println(challengeFourAnswer);

        writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer, challengeTwoAnswer, challengeThreeAnswer, challengeFourAnswer);
    }

    /**
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] data = readFile(fileName);
        int increaseCount = 0;

        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[i - 1]) {
                increaseCount++;
            }
        }
        return increaseCount;
    }

    /**
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] data = readFile(fileName);
        int increaseCount = 0;

        for (int i = 3; i < data.length; i++) {
            int previousSum = data[i - 3] + data[i - 2] + data[i - 1];
            int currentSum = data[i - 2] + data[i - 1] + data[i];

            if (currentSum > previousSum) {
                increaseCount++;
            }
        }
        return increaseCount;
    }

    /**
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int horizontalPosition = 0;
        int depth = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String command = parts[0];
                int value = Integer.parseInt(parts[1]);

                switch (command) {
                    case "forward":
                        horizontalPosition += value;
                        break;
                    case "down":
                        depth += value;
                        break;
                    case "up":
                        depth -= value;
                        break;
                }
            }
        }
        return horizontalPosition * depth;
    }

    /**
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String command = parts[0];
                int value = Integer.parseInt(parts[1]);

                switch (command) {
                    case "forward":
                        horizontalPosition += value;
                        depth += aim * value;
                        break;
                    case "down":
                        aim += value;
                        break;
                    case "up":
                        aim -= value;
                        break;
                }
            }
        }
        return horizontalPosition * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
}
