import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
 
public class GradeAnalyzer {

    private static String DEFAULT_INPUT_FILE = "scores.txt";
    private static String DEFAULT_OUTPUT_FILE = "report.txt";

    public static void main(String[] args) {
        String inputFile = DEFAULT_INPUT_FILE;
        String outputFile = DEFAULT_OUTPUT_FILE;

        // Process input arguments.
        if (args.length > 0) {
            inputFile = args[0];
        }
        if (args.length > 1) {
            outputFile = args[1];
        }

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }

        // Step 3: write and print report
        writeReport(scores, average, high, low, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        int score = Integer.parseInt(line);
                        scores.add(score);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Cannot convert '" + line + "' to an integer.");
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    } 

    public static void printAndWrite(Writer writer, String string) throws IOException {
        writer.write(string);
        System.out.print(string);
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        for (int score : scores) {
            if (score >= 90) {
                countA++;
            }
            else if (score >= 80) {
                countB++;
            }
            else if (score >= 70) {
                countC++;
            }
            else if (score >= 60) {
                countD++;
            }
            else {
                countF++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            printAndWrite(writer, String.format("=== Grade Analysis Report ===%n"));
            printAndWrite(writer, String.format("Total scores processed: %3d%n%n", scores.size()));

            if (scores.isEmpty()) {
                return;
            }

            printAndWrite(writer, String.format("Average score: %6.2f%n", avg));
            printAndWrite(writer, String.format("Highest score: %3d%n", high));
            printAndWrite(writer, String.format("Lowest score:  %3d%n%n", low));
            printAndWrite(writer, String.format("Grade distribution:%n"));
            printAndWrite(writer, String.format("  A (90-100):   %2d%n", countA));
            printAndWrite(writer, String.format("  B (80-89):    %2d%n", countB));
            printAndWrite(writer, String.format("  C (70-79):    %2d%n", countC));
            printAndWrite(writer, String.format("  D (60-69):    %2d%n", countD));
            printAndWrite(writer, String.format("  F (below 60): %2d%n", countF));
        }
        catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}
