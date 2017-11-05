package module1.collections.map;

import module1.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WarAndPeace {

    private static final Logger log = LoggerFactory.getLogger(WarAndPeace.class);
    private static final String PATH_TO_THE_BOOK = "war_and_peace.txt";

    public static String getLongestWord() {
        List<String> words = FileUtils.readAllWordsFromTheFile(PATH_TO_THE_BOOK);
        return words.get(0);
    }

    public static void main(String[] args) {
        System.out.println(getLongestWord());
    }
}
