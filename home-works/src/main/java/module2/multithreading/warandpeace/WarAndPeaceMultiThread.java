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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author Egor Stepanov
 * @since  27-11-2017.
 */
public class WarAndPeaceMultiThread {

    private static final Logger log = LoggerFactory.getLogger(WarAndPeaceMultiThread.class);

    private static final String FILE_NAME = "war_and_peace.txt";

    private static final String[] commonWords = new String[] {
            "a", "in", "on", "to", "from", "the", "of", "that", "and", "with", "not", "at",
            "it", "his", "her", "was", "him", "he", "as", "i", "is", "had", "s", "were", "by",
            "for", "be", "but", "this", "they", "you", "said", "all", "what", "who", "she",
            "which", "there", "have", "them", "an", "did", "so", "their", "or", "been",
            "no", "now", "if", "when", "would", "me", "my", "are", "out", "t", "could", "up",
            "we", "will", "more"
    };
    private static final Set<String> COMMON_SET = new HashSet<>(Arrays.asList(commonWords));

    public static void main(String[] args) {
        new WarAndPeaceMultiThread().start();
    }

    private void start() {
        long startTime = System.currentTimeMillis();

        int cpus = Runtime.getRuntime().availableProcessors();
        List<String> words = FileUtils.readAllWordsFromTheFile(FILE_NAME);

        int part = words.size() / cpus;

        ExecutorService pool = Executors.newFixedThreadPool(cpus);
        List<Future<Map<String, Integer>>> futs = new ArrayList<>();

        for (int i = 0; i < cpus; i++) {
            Future<Map<String, Integer>> fut = pool.submit(
                    new Counter(words.subList(i *part, Integer.min((i +1)*part, words.size())))
            );

            futs.add(fut);
        }

        List<Map<String, Integer>> threadMaps = new ArrayList<>();
        for (Future<Map<String, Integer>> future: futs) {
            try {
                threadMaps.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException();
            }
        }

        pool.shutdown();

        Map<String, Integer> wordsFreq = mergeMaps(threadMaps);

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

    private Map<String, Integer> mergeMaps(Iterable<Map<String, Integer>> maps) {
        Map<String, Integer> res = new HashMap<>();
        for (Map<String, Integer> map: maps) {
            map.forEach((k, v) -> res.merge(k, v, Integer::sum));
        }
        return res;
    }

    private class Counter implements Callable<Map<String, Integer>> {
        private final List<String> words;
        private final Map<String, Integer> map = new HashMap<>();

        private Counter(List<String> words) {
            this.words = words;
        }

        @Override
        public Map<String, Integer> call() {
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
                        log.info("thread={}, i={}, word: {}", Thread.currentThread().getName(), i, word);
                    }
            }
            return map;
        }
    }
}
