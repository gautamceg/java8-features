package com.example.core.tryWithResource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResourceEx {

    public static void main(String[] args) {
        String fileName = "someFile.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
             Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine())
                writer.write(scanner.nextLine());
        }
        catch(IOException e) {
            // handle the exception
            e.printStackTrace();
        }
    }
}
