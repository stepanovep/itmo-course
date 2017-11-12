package module1.utils;

import module1.collections.list.ArrayList;
import module1.collections.list.LinkedList;
import module1.collections.list.List;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author Egor Stepanov
 * @since  26-10-2017.
 */
@SuppressWarnings("WeakerAccess")
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
     * Определить, находится ли заданный элемент в списке
     */
    public static <T> boolean contains(T obj, List<T> list) {
        for (T element: list) {
            if (obj.equals(element)) {
                return true;
            }
        }
        return false;
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

    /**
     * Преобразовать массив элементов в список
     */
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>(array.length);
        for (T element: array) {
            list.add(element);
        }

        return list;
    }

    /**
     * Вернуть пересечение двух списков
     */
    public static <T> List<T> intersect(List<T> list1, List<T> list2) {
        List<T> intersectList;
        intersectList = list1.emptyList();

        for (T element: list1) {
            if (ListUtils.contains(element, list2)) {
                intersectList.add(element);
            }
        }

        return intersectList;
    }

    /**
     * Вернуть разность двух списков
     */
    public static <T> List<T> difference(List<T> list1, List<T> list2) {
        List<T> differenceList;
        differenceList = list1.emptyList();

        for (T element: list1) {
            if (!ListUtils.contains(element, list2)) {
                differenceList.add(element);
            }
        }

        return differenceList;
    }

    /**
     * Вернуть "общий" Iterable для группы коллекций
     */
    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> Iterable<T> view(Iterable<T> ... its) {
        Iterator<T>[] iterators = new Iterator[its.length];
        for (int i = 0; i < its.length; i++) {
            iterators[i] = its[i].iterator();
        }

        return () -> new Iterator<T>() {
            private final int iteratorsCount = its.length;
            private int itIndex = 0;

            @Override
            public boolean hasNext() {
                if (itIndex == iteratorsCount) {
                    return false;
                }
                if (iterators[itIndex].hasNext()) {
                    return true;
                }
                itIndex++;
                return hasNext();
            }

            @Override
            public T next() {
                return iterators[itIndex].next();
            }
        };
    }

    /**
     * Вернуть фильтрованный Iterable для группы коллекций
     */
    public static <T> Iterable<T> filterView(Iterable<T> iterable, Predicate<T> predicate) {
        Iterator<T> iterator = iterable.iterator();

        return () -> new Iterator<T>() {
            T next = null;

            @Override
            public boolean hasNext() {
                while(iterator.hasNext()) {
                    next = iterator.next();
                    if (predicate.test(next)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                return next;
            }
        };
    }

    /**
     * Вернуть общий Iterable для группы коллекций,
     * элементы которых преобразованы transformer'ом
     */
    public static <T> Iterable<T> transformView(Iterable<T> iterable, Transformer<T> transformer) {
        Iterator<T> iterator = iterable.iterator();

        return () -> new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return transformer.transform(iterator.next());
            }
        };
    }
}
