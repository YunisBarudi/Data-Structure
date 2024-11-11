package Lab5_3;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class BinarySearch {
    public static void main(String[] args) {
        try {

            List<String> dictionaryWords = new ArrayList<>(readDictionary("C:\\Users\\t00243637\\IdeaProjects\\Data-Structure\\Lab5\\src\\Lab5_3\\words_alpha.txt"));
            Collections.sort(dictionaryWords);

            Set<String> documentWords = readWords("C:\\Users\\t00243637\\IdeaProjects\\Data-Structure\\Lab5\\src\\Lab5_3\\mussolini.txt");

            int numberMisspelledWords = 0;
            for (String word : documentWords) {

                if (Collections.binarySearch(dictionaryWords, word) < 0) {

                    numberMisspelledWords++;
                    System.out.println(word);

                }
            }

            System.out.println("Number of misspelled words in 'My autobiography by Benito Mussolini': " + numberMisspelledWords);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static Set<String> readDictionary(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    public static Set<String> readWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
}
