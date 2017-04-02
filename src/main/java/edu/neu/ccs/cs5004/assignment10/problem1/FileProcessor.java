package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by Jeremy on 4/2/17.
 */
public interface FileProcessor {
    File process(File input);

    static Text getFileContent(String fileName) {
        StringBuilder res = new StringBuilder();
        try (BufferedReader inputFile = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                if (res.length() != 0) {
                    res.append("\n");
                }
                res.append(line);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
            ioe.printStackTrace();
        }
        return new Text(res.toString());
    }
}
