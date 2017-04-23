/**
 *  IntelliJ IDEA 15.0.3
 */

package net.thumbtack.dtalankin.task1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        File inputFile = new File("src/main/java/net/thumbtack/dtalankin/task1/input.txt").getCanonicalFile();
        File outputFile = new File("src/main/java/net/thumbtack/dtalankin/task1/output.txt").getCanonicalFile();
        Scanner scanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile);
        int n = scanner.nextInt();

        for (int i = 16; i < n; i++) {
            if (isSequence(Integer.toHexString(i))) {
                printWriter.println(i);
            }
        }
        printWriter.close();
    }

    private boolean isSequence(String str) {
        Boolean isSortingAsc = true;
        Boolean isSortingDesc = true;
        char[] charArray = str.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            int a = Character.getNumericValue(charArray[i-1]);
            int b = Character.getNumericValue(charArray[i]);
            if (!(b > a)) {
                isSortingAsc = false;
            }
            if (!(a > b)) {
                isSortingDesc = false;
            }
        }
        return isSortingAsc || isSortingDesc;
    }

}
