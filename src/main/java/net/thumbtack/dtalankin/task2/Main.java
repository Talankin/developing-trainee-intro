/**
 *  IntelliJ IDEA 15.0.3
 */

package net.thumbtack.dtalankin.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        File inputFile = new File("src/main/java/net/thumbtack/dtalankin/task2/input.txt");
        File outputFile = new File("src/main/java/net/thumbtack/dtalankin/task2/output.txt");
        String pattern = "[' ']{1,}";
        String outputWord = "отсутствует";
        int maxSize = 0;
        List<String> firstLineArray = new ArrayList<>();
        List<String> secondLineArray = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            firstLineArray = Arrays.asList(bufferedReader.readLine().split(pattern));
            secondLineArray = Arrays.asList(bufferedReader.readLine().split(pattern));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String s : firstLineArray) {
            if (secondLineArray.contains(s) && s.length() > maxSize) {
                maxSize = s.length();
                outputWord = s;
            }
        }

        try (PrintStream printStream = new PrintStream(outputFile)){
            printStream.print(outputWord);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
