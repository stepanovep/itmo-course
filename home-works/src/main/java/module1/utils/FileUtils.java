package module1.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * Выгрузить все слова из файла
     *
     * @param fileName путь до файла
     * @return коллекция всех слов
     */
    public static List<String> readAllWordsFromTheFile(String fileName) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] wordSplit =
                        line.toLowerCase()
                                .replaceAll("\\p{Punct}", " ")
                                .trim()
                                .split("\\s");

                for (String s : wordSplit) {
                    if (s.length() > 0)
                        words.add(s.trim());
                }
            }
            return words;

        } catch (IOException e) {
            log.error("Failed to read file: {}", fileName);
            return Collections.emptyList();
        }
    }

    public static byte[] xorBytes(byte[] b, byte[] password) {
        byte[] xored = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            xored[i] = (byte)(b[i] ^ password[i % password.length]);
        }

        return xored;
    }
}
