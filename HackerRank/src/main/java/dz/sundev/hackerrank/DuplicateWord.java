package dz.sundev.hackerrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateWord {
    public static void main(String[] args) throws IOException {
        /*Pattern pattern = Pattern.compile("(\\b(\\w+?)\\s)(\\2(\\s|$))+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("-------------------");
            System.out.println(matcher.group());
        }*/

        String text;

        try (Stream<String> lines = Files.lines(Paths.get("duplicate_word.txt"))) {
            text = lines
                    .skip(1) // ignore number of lines
                    .collect(Collectors.joining("\n"));
        }

        System.out.println(text.replaceAll("(?i)\\b(\\w+?)\\s(\\1(\\s|$))+", "$1$3"));
    }
}
