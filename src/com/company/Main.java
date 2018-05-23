package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static final String file = "poesy.txt";

    public static void main(String[] args) {
        countOfStrings(file);
        countOfWords(file);
        countOfSymbols(file);
    }

    private static void countOfStrings(String file) {
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("In file \"%s\" there are %d strings.\n", file, count);
    }

    private static void countOfWords(String file) {
        int count = 0;
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] tmpArray = line.split(" ");
                count += tmpArray.length;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("In file \"%s\" there are %d words.\n", file, count);
    }

    private static void countOfSymbols(String file) {
        int count = 0;
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                count += line.length();
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("In file \"%s\" there are %d symbols.\n", file, count);
    }
}