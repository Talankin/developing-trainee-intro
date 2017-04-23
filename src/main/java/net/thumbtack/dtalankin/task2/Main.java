/**
 *  IntelliJ IDEA 15.0.3
 */

package net.thumbtack.dtalankin.task2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        File inputFile = new File("src/main/java/net/thumbtack/dtalankin/task2/input.txt").getCanonicalFile();
        File outputFile = new File("src/main/java/net/thumbtack/dtalankin/task2/output.txt").getCanonicalFile();
        Scanner scanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile);
        String pattern = "[' ']{1,}";
        List<String> firstLineArray = Arrays.asList(scanner.nextLine().split(pattern));
        List<String> secondLineArray = Arrays.asList(scanner.nextLine().split(pattern));
        String outputWord = "отсутствует";
        int maxSize = 0;

        for (String s : firstLineArray) {
            if (secondLineArray.contains(s) && s.length() > maxSize) {
                maxSize = s.length();
                outputWord = s;
            }
        }

        printWriter.print(outputWord);
        printWriter.close();
    }

}
