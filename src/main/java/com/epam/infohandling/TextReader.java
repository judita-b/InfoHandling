package com.epam.infohandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    public String readText(String fileName) {
        String lines = null;
        String line;
        String temp;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader buffer = new BufferedReader(fileReader);) {

            while ((line = buffer.readLine()) != null) {
                if (lines == null) {
                    lines = line;
                } else {
                    temp = lines;
                    lines = temp+"\n"+line;
                }
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return lines;
    }
}
