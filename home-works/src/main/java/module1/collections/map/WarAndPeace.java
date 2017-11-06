package module1.collections.map;

import module1.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WarAndPeace {

    private static final Logger log = LoggerFactory.getLogger(WarAndPeace.class);
    private static final String FILE_NAME = "war_and_peace.txt";

    private static final int MAX_WORD_LENGTH = 19;
    private static final String[] commonWords = new String[] {
            "a", "in", "on", "to", "from", "the", "of", "that", "and", "with", "not", "at",
            "it", "his", "her", "was", "him", "he", "as", "i", "is", "had", "s", "were", "by",
            "for", "be"};
    private static final Set<String> COMMON_SET = new HashSet<>(Arrays.asList(commonWords));

    /**
     * Получить из файла самое длинное слово
     */
    public static String getLongestWord() {
        List<String> words = FileUtils.readAllWordsFromTheFile(FILE_NAME);
        String maxWord = "";
        for (String word: words) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }

        return maxWord;
    }

    /**
     * Сгруппировать слова по длине
     */
    private static void groupWordsByLentgh() {
        List<String> words = FileUtils.readAllWordsFromTheFile(FILE_NAME);
        Set<String>[] groups = new Set[MAX_WORD_LENGTH];
        for (int i = 0; i < MAX_WORD_LENGTH; i++) {
            groups[i] = new HashSet<>();
        }

        for (String word: words) {
            if (!COMMON_SET.contains(word))
                groups[word.length()].add(word);
        }

        for (int i = 0; i < MAX_WORD_LENGTH; i++) {
            log.info("{}: {}", i, groups[i].size());
        }
    }

    /**
     * Вычислить частоту встречаемости слов и фраз
     */
    private static Map<String, Integer> frequency() {
        List<String> words = FileUtils.readAllWordsFromTheFile(FILE_NAME);
        Map<String, Integer> freq = new HashMap<>();
        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i <= words.size()-k; i++) {
                if (COMMON_SET.contains(words.get(i))) {
                    continue;
                }
                StringBuilder phraseBuilder = new StringBuilder(words.get(i));
                for (int j = 1; j < k; j++) {
                    phraseBuilder.append(' ');
                    phraseBuilder.append(words.get(i+j));
                }

                String phrase = phraseBuilder.toString();
                if (freq.containsKey(phrase)) {
                    freq.put(phrase, freq.get(phrase) + 1);
                } else {
                    freq.put(phrase, 1);
                }

                if (i % 1000 == 0) {
                    log.info("k={}, i={}, phrase: {}", k, i, phrase);
                }
            }
        }

        return freq;
    }

    /**
     * Вывести самые частые слова и фразы
     */
    private static void showMostUsedWordsAndPhrases() {
        Map<String, Integer> freq = frequency();

        Map<String, Integer> top10Words = freq.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().contains(" "))
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Integer> top10Phrases = freq.entrySet()
                .stream()
                .filter(entry -> entry.getKey().contains(" "))
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Integer> top10PhrasesWith3Words = freq.entrySet()
                .stream()
                .filter(entry -> entry.getKey().split(" ").length == 3)
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        log.info("Most used words: {}", top10Words);
        log.info("Most used phrases[2 words]: {}", top10Phrases);
        log.info("Most used phrases[3 words]: {}", top10PhrasesWith3Words);
    }

    /**
     * Показать частоту встречаемости букв
     */
    private static void showCharsFrequency() {
        List<String> words = FileUtils.readAllWordsFromTheFile(FILE_NAME);
        Map<Character, Integer> freqs = new HashMap<>();

        int allCharsCount = 0;
        for (String word: words) {
            for (Character c: word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    if (freqs.containsKey(c)) {
                        freqs.put(c, freqs.get(c) + 1);
                    } else {
                        freqs.put(c, 1);
                    }
                    allCharsCount++;
                }
            }
        }

        for (Map.Entry<Character, Integer> entry: freqs.entrySet()) {
            log.info("{}: count={} ({}%)", entry.getKey(), entry.getValue(),
                    new DecimalFormat("#.##").format(((double)entry.getValue() / allCharsCount) * 100));
        }
    }

    public static void main(String[] args) {
        showCharsFrequency();
    }
}
