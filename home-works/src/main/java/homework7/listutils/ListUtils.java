package homework7.listutils;

import homework7.iterablelist.LinkedList;
import homework7.iterablelist.List;

import java.util.function.Predicate;

/**
 * @author Egor Stepanov
 * @since 26-10-2017.
 */
public class ListUtils {

    public static <T> T find(Predicate<T> predicate, Iterable<T> list) {
        for (T element: list) {
            if (predicate.test(element)) {
                return element;
            }
        }
        return null;
    }

    public static <T> List<T> filter(Predicate<T> predicate, List<T> list) {
        List<T> filteredList = new LinkedList<>();
        for (T element: list) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    public static <T> List<T> transform(Transformer<T> transformer, List<T> list) {
        List<T> transformedList = new LinkedList<>();
        for (T element: list) {
            transformedList.add(transformer.transform(element));
        }

        return transformedList;
    }

    public interface Transformer<T> {
        T transform(T obj);
    }
}
