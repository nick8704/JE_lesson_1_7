package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static final String file = "poesy.txt";
    static int amountOfStrings = 0;
    static int amountOfWords = 0;
    static int amountOfSymbols = 0;

    public static void main(String[] args) {
        fileCount(file);
        System.out.printf("In file \"%s\" there are %d strings, %d words and %d symbols.", file, amountOfStrings, amountOfWords, amountOfSymbols);
    }

    private static void fileCount(String file) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                amountOfStrings++;
                amountOfSymbols += line.length();
                String[] tmpArray = line.split(" ");
                for (int i = 0; i < tmpArray.length; i++) {
                    if (tmpArray[i].matches("[a-zA-Zа-яА-Я.,;]+")) {
                        amountOfWords++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}