package module1.utils;

import module1.collections.LinkedList;
import module1.collections.List;

import java.util.function.Predicate;

/**
 * @author Egor Stepanov
 * @since  26-10-2017.
 */
public final class ListUtils {

    private ListUtils() {
    }

    /**
     * Найти первый элемент в списке удовлетворяющий условию
     * Вернёт null, если такого элемента нет
     */
    public static <T> T find(Predicate<T> predicate, Iterable<T> list) {
        for (T element: list) {
            if (predicate.test(element)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Возвращает новый List, отфильтрованный по условию predicate
     */
    public static <T> List<T> filter(Predicate<T> predicate, List<T> list) {
        List<T> filteredList = new LinkedList<>();
        for (T element: list) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    /**
     * Возвращает новый List, каждый элемент которого получен
     * преобразованием transformer к элементам входного списка
     */
    public static <T> List<T> transform(Transformer<T> transformer, List<T> list) {
        List<T> transformedList = new LinkedList<>();
        for (T element: list) {
            transformedList.add(transformer.transform(element));
        }

        return transformedList;
    }

    /**
     * Обобщенный метод contains()
     * Возвращает элемент или null
     */
    public static <T> T get(T obj, List<T> list) {
        for (T element: list) {
            if (obj.equals(element)) {
                return element;
            }
        }
        return null;
    }

    public interface Transformer<T> {
        T transform(T obj);
    }
}