package Lab5_3;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheck {

   public static void main(String[] args) {
      String dictionaryFile = "C:\\Users\\YunisBarudi\\IdeaProjects\\Data-Structure\\Lab5\\src\\Lab5_3\\words_alpha.txt";
      String bookFile = "C:\\Users\\YunisBarudi\\IdeaProjects\\Data-Structure\\Lab5\\src\\Lab5_3\\mussolini.txt";

      testDictionary("HashSet", new HashSet<>(), dictionaryFile, bookFile);
      //testDictionary("LinkedHashSet", new LinkedHashSet<>(), dictionaryFile, bookFile);
      //testDictionary("TreeSet", new TreeSet<>(), dictionaryFile, bookFile);
      //testDictionary("LinkedList", new LinkedList<>(), dictionaryFile, bookFile);
      //testDictionary("ArrayList", new ArrayList<>(), dictionaryFile, bookFile);
   }

   private static void testDictionary(String name, Collection<String> dictionaryWords, String dictionaryFile, String bookFile) {
      try {
         long startTime = System.nanoTime();
         loadDictionary(dictionaryWords, dictionaryFile);
         long loadTime = System.nanoTime() - startTime;

         Set<String> book = readWords(bookFile);

         startTime = System.nanoTime();
         List<String> misspelledWords = getMisspelledWords(book, dictionaryWords);
         long containsTime = System.nanoTime() - startTime;

         double loadTimeMs = loadTime / 1_000_000.0;
         double containsTimeMs = containsTime / 1_000_000.0;

         System.out.printf("%s: Load Time = %.2f ms, Contains Time = %.2f ms, Misspelled Words Count = %d%n",
                 name, loadTimeMs, containsTimeMs, misspelledWords.size());

         System.out.println("Misspelled Words: " + misspelledWords);

         double percentageOfContaints = calculatePercentageOfContains(loadTimeMs, containsTimeMs);
         System.out.println("Percentage of Contains: " + String.format("%.2f", percentageOfContaints));

      } catch (FileNotFoundException e) {
         System.err.println("File not found: " + e.getMessage());
      }
   }

   private static void loadDictionary(Collection<String> dictionaryWords, String filename) throws FileNotFoundException {
      Scanner in = new Scanner(new File(filename));
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext()) {
         dictionaryWords.add(in.next().toLowerCase());
      }
   }

   private static Set<String> readWords(String filename) throws FileNotFoundException {
      Set<String> words = new HashSet<>();
      Scanner in = new Scanner(new File(filename));
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext()) {
         words.add(in.next().toLowerCase());
      }
      return words;
   }

   private static List<String> getMisspelledWords(Set<String> book, Collection<String> dictionaryWords) {
      List<String> misspelled = new ArrayList<>();
      for (String word : book) {
         if (!dictionaryWords.contains(word)) {
            misspelled.add(word);
         }
      }
      return misspelled;
   }

   public static double calculatePercentageOfContains(double loadTimeMs, double containsTimeMs) {
      double totalTime = loadTimeMs + containsTimeMs;
      if (totalTime == 0) {
         return 0;
      }
      return (containsTimeMs / totalTime) * 100;
   }
}