package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Validator {
    public static void fileExists(String filename) throws Exception {
        Scanner scanner = new Scanner(new File(filename));
        if(scanner.hasNextLine()){
            System.out.println("OK!");
        }
        else
            throw new Exception("File not found!");
    }
    
    public static void fileExists2(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if(file.exists()){
            System.out.println("");
        }
        else
            throw new FileNotFoundException("sfdasdf");
    }
}

