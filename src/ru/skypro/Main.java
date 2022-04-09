package ru.skypro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
            List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6, 7, 8, 10, 10, 11, 12));

            printOddNumbers(nums);
            System.out.println();

            printEvenNumbers(nums);
            System.out.println();

            List<String> words = new ArrayList<>(List.of("park", "park", "sea", "beach", "town", "town", "town"));

            uniqueWords(words);
            System.out.println();

            duplicateWords(words);
            System.out.println();
        }

        public static void printOddNumbers(List<Integer> nums) {
            if (nums.isEmpty()) {
                System.out.println("Список пуст.");
            } else {
                List<Integer> selectedNums = new ArrayList<>();
                for (int i = 0; i < nums.size(); i++) {
                    if (nums.get(i).intValue() % 2 != 0) {
                        selectedNums.add(nums.get(i));
                    }
                }
                if (selectedNums.isEmpty()) {
                    System.out.println("Массив отсутствует");
                } else {
                    printArrayInteger(selectedNums);
                }
            }
        }

        public static void printEvenNumbers(List<Integer> nums) {
            if (nums.isEmpty()) {
                System.out.println("Список пуст.");
            } else {
                List<Integer> selectedNums = new ArrayList<>();
                for (Integer num : nums) {
                    if (num.intValue() % 2 == 0 && !selectedNums.contains(num)) {
                        selectedNums.add(num);
                    }
                }
                if (selectedNums.isEmpty()) {
                    System.out.println("Массив отсутствует");
                } else {
                    Collections.sort(selectedNums);
                    printArrayInteger(selectedNums);
                }
            }
        }

    public static void uniqueWords(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("Список пуст.");
        }
        if (words.size() == 1) {
            System.out.println(words.get(0));
        }
        if (words.size() == 2) {
            if (!words.get(0).equals(words.get(1))) {
                System.out.println(words.get(0) + " " + words.get(1));
            } else {
                System.out.println("Уникальные слова отсутствуют");
            }
        }
        if (words.size() > 2) {
            List<String> uniqueWords = new ArrayList<>();
            List<String> oddList = new ArrayList<>();
            for (int i = 0; i <= words.size() - 1; i++) {
                boolean uniqueWord = true;
                for (int j = i + 1; j < words.size(); j++) {
                    if (words.get(i).equals(words.get(j))) {
                        uniqueWord = false;
                    }
                }
                if (!oddList.contains(words.get(i)) && !uniqueWord) {
                    oddList.add(words.get(i));
                }
                if (!oddList.contains(words.get(i)) && uniqueWord) {
                    uniqueWords.add(words.get(i));
                }
            }
            if (uniqueWords.isEmpty()) {
                System.out.println("Уникальные слова отсутствуют");
            } else {
                printArrayString(uniqueWords);
            }
        }
    }

        public static void duplicateWords(List<String> words) {
            if (words.isEmpty()) {
                System.out.println("Список пуст.");
            }
            if (words.size() == 1) {
                System.out.println("Список состоит из одного слова.");
            }
            if (words.size() > 1) {
                List<String> oddWords = new ArrayList<>();
                for (int i = 0; i <= words.size() - 1; i++) {
                    boolean uniqueWord = true;
                    for (int j = i + 1; j < words.size(); j++) {
                        if (words.get(i).equals(words.get(j))) {
                            uniqueWord = false;
                        }
                    }
                    if (!oddWords.contains(words.get(i)) && !uniqueWord) {
                        oddWords.add(words.get(i));
                    }
                }
                if (oddWords.isEmpty()) {
                    System.out.println("Повторящиеся слова не найдены");
                } else {
                    int counter;
                    for (String oddWord : oddWords) {
                        counter = 0;
                        for (String word : words) {
                            if (oddWord.equals(word)) {
                                counter++;
                            }
                        }
                        System.out.println("Слово " + oddWord + ", повторяется " + counter + " раза.");
                    }
                }
            }
        }

        public static void printArrayInteger(List<Integer> nums) {
            if (!nums.isEmpty()) {
                for (Integer num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }

        public static void printArrayString(List<String> words) {
            if (!words.isEmpty()) {
                for (String word : words) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }