package Lab5_3;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheck {

   public static void main(String[] args) {
      try {

         Set<String> dictionaryWords = new HashSet<>(readDictionary("C:\\Users\\t00243637\\IdeaProjects\\Lab5\\src\\Lab5_3\\words"));

         Set<String> documentWords = readWords("C:\\Users\\t00243637\\IdeaProjects\\Lab5\\src\\Lab5_3\\war-and-peace.txt");
         Set<String> aliceWords = readWords("C:\\Users\\t00243637\\IdeaProjects\\Lab5\\src\\Lab5_3\\alice30.txt");



         int numberMisspeltWordsDocument = 0;
         for (String word : documentWords) {
            if (!dictionaryWords.contains(word)) {
               numberMisspeltWordsDocument++;
               System.out.println(word);
            }
         }
         System.out.println("Number of misspelled words in War and Peace: " + numberMisspeltWordsDocument);
         int numberMisspelledWordsDocument2 = 0;
         for (String word : aliceWords) {
            if (!dictionaryWords.contains(word)) {
               numberMisspelledWordsDocument2++;
               System.out.println(word);
            }
         }
         System.out.println("Number of misspelled words in Alice30: " + numberMisspelledWordsDocument2);
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