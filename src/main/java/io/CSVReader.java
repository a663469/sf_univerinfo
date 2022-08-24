package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("data/students.csv"));
        String[] headers = scanner.nextLine().split(";");
//        System.out.format(leftAlignFormat, headers);
        while (scanner.hasNextLine()) {
            String[] position = scanner.nextLine().split(";", -1);
            for(String word : position) {
                System.out.printf(word + " ");
            }
            System.out.println();
        }
    }
}
