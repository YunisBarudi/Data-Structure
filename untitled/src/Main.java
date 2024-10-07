
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List<String> names= new LinkedList<String>();
        System.out.println("Exercise 1.1");
        names.add("Kay");
        names.add("Jay");
        names.add("May");
        names.add("Fay");
        System.out.println(names);
        System.out.println("Exercise 1.2");
        ListIterator<String> iterator = names.listIterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.add("Ray");
        System.out.println(names);
        System.out.println("Exercise 1.3");
        iterator = names.listIterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        System.out.println(names);
        System.out.println("Exercise 1.4");
        iterator = names.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println("Exercise 1.5");
        names.add("Kay");
        iterator = names.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Exercise 2");

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Kay");
        hashSet.add("Jay");
        hashSet.add("May");
        hashSet.add("Fay");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Kay");
        treeSet.add("Jay");
        treeSet.add("May");
        treeSet.add("Fay");
        Iterator<String> hashIterator = hashSet.iterator();
        Iterator<String> treeIterator = treeSet.iterator();
        System.out.println("Tree Iterator");
        while (treeIterator.hasNext()) {
            System.out.println(treeIterator.next());
        }
        System.out.println("Hash Iterator");
        while (hashIterator.hasNext()) {
            System.out.println(hashIterator.next());
        }
        System.out.println("Exercise 3");
        TreeSet<String> treeSet2 = new TreeSet<>();
        String fileName = "C:\\Users\\t00243637\\Desktop\\hamlet.txt";

        try {
              Scanner in = new Scanner(new File(fileName));
              int lineNumber = 1;
              while (in.hasNextLine()) {
                        Scanner lineParser = new Scanner(in.nextLine());
                        lineParser.useDelimiter("[^A-Za-z0-9]+");
                        while (lineParser.hasNext()) {
                            String word = lineParser.next();
                            treeSet2.add(word);
                        }
                        lineNumber++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
        Iterator<String> iterator2 = treeSet2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println("Exercise 4");

        Map<String, Set<Integer>> wordMap = new HashMap<>();

         try {
                    Scanner in = new Scanner(new File(fileName));
                    int lineNumber = 1;
                    while (in.hasNextLine()) {
                        Scanner lineParser = new Scanner(in.nextLine());
                        lineParser.useDelimiter("[^A-Za-z0-9]+");
                        while (lineParser.hasNext()) {
                            String word = lineParser.next().toLowerCase();
                            Set<Integer> lines = wordMap.getOrDefault(word, new HashSet<>());
                            lines.add(lineNumber);
                            wordMap.put(word, lines);
                        }
                        lineNumber++;
                    }
                    in.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                for (Map.Entry<String, Set<Integer>> entry : wordMap.entrySet()) {
                    System.out.println("Word: " + entry.getKey() + ", Lines: " + entry.getValue());
                }


                Scanner userInput = new Scanner(System.in);
                System.out.println("Enter a word: ");
                String word = userInput.next().toLowerCase();
                Set<Integer> lineNumbers = wordMap.get(word.toLowerCase());
                if (lineNumbers != null) {
                    System.out.println("The word '" + word + "' appears on lines: " + lineNumbers);
                } else {
                    System.out.println("The word '" + word + "' was not found in the text.");
                }
            }
        }




