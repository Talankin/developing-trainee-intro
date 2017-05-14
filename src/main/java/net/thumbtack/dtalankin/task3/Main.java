/**
 *  IntelliJ IDEA 15.0.3
 */

package net.thumbtack.dtalankin.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        File inputFile = new File("src/main/java/net/thumbtack/dtalankin/task3/input.txt");
        File outputFile = new File("src/main/java/net/thumbtack/dtalankin/task3/output.txt");
        String pattern = "[' ']{1}";
        Map<Set<Integer>, String> map = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> stringList = Arrays.asList(line.split(pattern));
                List<Integer> intList = stringList.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                Set<Integer> set = new HashSet<>(intList);
                map.put(set, line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintStream printStream = new PrintStream(outputFile)){
            for (String value : map.values()) {
                printStream.println(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
