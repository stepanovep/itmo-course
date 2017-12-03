package module2.multithreading.warandpeace;

import module1.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Egor Stepanov
 * @since  27-11-2017.
 */
public class WarAndPeaceMultiThread {

    private static final Logger log = LoggerFactory.getLogger(WarAndPeaceMultiThread.class);

    private Map<String, Integer> wordMap;
    private static final String FILE_NAME = "war_and_peace.txt";

    private static final String[] commonWords = new String[] {
            "a", "in", "on", "to", "from", "the", "of", "that", "and", "with", "not", "at",
            "it", "his", "her", "was", "him", "he", "as", "i", "is", "had", "s", "were", "by",
            "for", "be"};
    private static final Set<String> COMMON_SET = new HashSet<>(Arrays.asList(commonWords));

    public static void main(String[] args) {
        new WarAndPeaceMultiThread().start();
    }

    private void start() {
        int cpus = Runtime.getRuntime().availableProcessors();
        long startTime = System.currentTimeMillis();

        List<String> words = FileUtils.readAllWordsFromTheFile(FILE_NAME);

        int part = words.size() / cpus;

        List<Counter> threads = new ArrayList<>();

        for (int i = 0; i < cpus; i++) {
            List<String> list = words.subList(i*part, Integer.min((i+1)*part, words.size()));
            threads.add(new Counter(list));
        }

        for (Counter thread: threads) {
            thread.start();
        }

        for (Counter thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Interrupted Exception error: {}", e);
                throw new RuntimeException();
            }
        }

        Map<String, Integer> wordsFreq = mergeMaps(threads);

        Map<String, Integer> top10Words = wordsFreq.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().contains(" "))
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        log.info("Top 10 words: {}", top10Words);
        log.info("Elapsed time = {} ms, {} cpus",
                System.currentTimeMillis() - startTime, cpus);
    }

    private Map<String, Integer> mergeMaps(List<Counter> threads) {
        Map<String, Integer> res = new HashMap<>();
        for (Counter thread: threads) {
            Map<String, Integer> threadMap = thread.getMap();
            threadMap.forEach((k, v) -> res.merge(k, v, Integer::sum));
        }
        return res;
    }

    private class Counter extends Thread {
        private final List<String> words;

        private final Map<String, Integer> map = new HashMap<>();

        private Counter(List<String> words) {
            this.words = words;
        }

        @Override
        public void run() {
                for (int i = 0; i < words.size(); i++) {
                    if (COMMON_SET.contains(words.get(i))) {
                        continue;
                    }

                    String word = words.get(i);
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }

                    if (i % 1000 == 0) {
                        log.info("thread={}, i={}, word: {}", this.getName(), i, word);
                    }
            }
        }

        public Map<String, Integer> getMap() {
            return map;
        }
    }
}
