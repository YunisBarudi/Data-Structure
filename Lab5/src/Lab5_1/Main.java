package Lab5_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "C:\\Users\\t00243637\\IdeaProjects\\Lab5_2.Lab5\\src\\Lab5_1\\words_alpha.txt";

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};
        List<String> words = readWordsFromFile(FILE_NAME);

        System.out.printf("%-10s %-20s %-20s\n", "Size", "ArrayList Time (ms)", "LinkedList Time (ms)");

        for (int size : sizes) {
            if (size > words.size()) {
                System.out.println("Not enough words in the file for size: " + size);
                continue;
            }

            List<String> arrayList = new ArrayList<>(words.subList(0, size));
            List<String> linkedList = new LinkedList<>(words.subList(0, size));

            long arrayListTime = measureSetTime(arrayList, size);
            long linkedListTime = measureSetTime(linkedList, size);

            System.out.printf("%-10d %-20d %-20d\n", size, arrayListTime, linkedListTime);
        }
    }

    private static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return words;
    }

    private static long measureSetTime(List<String> list, int size) {
        int reps = 1000000;
        long startTime = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            list.set(i % size, "new_word" + (i % size));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }
}