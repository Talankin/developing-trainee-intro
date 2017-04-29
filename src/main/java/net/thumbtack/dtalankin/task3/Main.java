/**
 *  IntelliJ IDEA 15.0.3
 */

package net.thumbtack.dtalankin.task3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        File inputFile = new File("src/main/java/net/thumbtack/dtalankin/task3/input.txt").getCanonicalFile();
        File outputFile = new File("src/main/java/net/thumbtack/dtalankin/task3/output.txt").getCanonicalFile();
        Scanner scanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile);
        String pattern = "[' ']{1}";
        Set<List<Integer>> set = new HashSet<>();
        while (scanner.hasNextLine()) {
            List<String> stringList = Arrays.asList(scanner.nextLine().split(pattern));
            List<Integer> intList = stringList.stream()
                    .map(Integer::parseInt).collect(Collectors.toList());
            intList.sort(Integer::compareTo);

            if (set.add(intList)) {
                printWriter.println(stringList);
            }
        }
        printWriter.close();
    }
}
