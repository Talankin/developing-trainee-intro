/**
 *  IntelliJ IDEA 15.0.3
 */

package net.thumbtack.dtalankin.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        File inputFile = new File("src/main/java/net/thumbtack/dtalankin/task1/input.txt");
        File outputFile = new File("src/main/java/net/thumbtack/dtalankin/task1/output.txt");
        int n = 17;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            n = Integer.parseInt(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintStream printStream = new PrintStream(outputFile)){
            for (int i = 16; i < n; i++) {
                if (isSequence(Integer.toHexString(i))) {
                    printStream.println(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isSequence(String str) {
        Boolean isSortingAsc = true;
        Boolean isSortingDesc = true;
        for (int i = 1; i < str.length(); i++) {
            int a = Character.getNumericValue(str.charAt(i-1));
            int b = Character.getNumericValue(str.charAt(i));
            if (b <= a) {
                isSortingAsc = false;
            }
            if (a <= b) {
                isSortingDesc = false;
            }
        }
        return isSortingAsc || isSortingDesc;
    }

}
