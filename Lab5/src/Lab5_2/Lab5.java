package Lab5_2;

import java.io.*;
import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\t00243637\\IdeaProjects\\Lab5\\src\\Lab5_1\\words_alpha.txt";

        int reps = 1000000;

        for (int size = 10; size <= 100000; size *= 10) {
            List<String> arrList = new ArrayList<>();
            List<String> linkList = new LinkedList<>();


            try {
                File file = new File(filename);
                Scanner in = new Scanner(file);

                for (int i = 0; i < size; i++) {
                    if (in.hasNextLine()) {
                        String str = in.nextLine();
                        arrList.add(str);
                        linkList.add(str);
                    }
                }
                in.close(); // Always close the scanner when done
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }

            int[] randomNos = generateRandomNos(size, reps);

            // Test ArrayList
            long startTime = System.currentTimeMillis();
            testGetForArrayList(arrList, randomNos);
            long endTime = System.currentTimeMillis();
            long durationArrayList = endTime - startTime;
            System.out.println("ArrayList size " + size + " get() duration: " + durationArrayList + " ms");

            // Test LinkedList
            startTime = System.currentTimeMillis();
            testGetForLinkedList(linkList, randomNos);
            endTime = System.currentTimeMillis();
            long durationLinkedList = endTime - startTime;
            System.out.println("LinkedList size " + size + " get() duration: " + durationLinkedList + " ms");
        }
    }

    public static void testGetForArrayList(List<String> list, int[] randomNos) {
        testGetForList(list, randomNos);
    }

    public static void testGetForLinkedList(List<String> list, int[] randomNos) {
        testGetForList(list, randomNos);
    }

    public static void testGetForList(List<String> list, int[] randomNos) {
        for (int i = 0; i < randomNos.length; i++) {
            list.get(randomNos[i]);
        }
    }

    public static int[] generateRandomNos(int listSize, int reps) {
        Random random = new Random();
        int[] randomNos = new int[reps];

        for (int i = 0; i < reps; i++) {
            randomNos[i] = random.nextInt(listSize);
        }
        return randomNos;
    }
}
///////
//Results Table
//List Type	Size	Time (get) in ms
//ArrayList	10	4
//LinkedList	10	10
//ArrayList	100	3
//LinkedList	100	15
//ArrayList	1000	1
//LinkedList	1000	291
//ArrayList	10000	0
//LinkedList	10000	6790
//ArrayList	100000	1
//LinkedList	100000	119927