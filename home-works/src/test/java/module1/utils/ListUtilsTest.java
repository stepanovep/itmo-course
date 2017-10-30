package module1.utils;

import module1.collections.ArrayList;
import module1.collections.LinkedList;
import module1.collections.List;
import org.junit.Test;
import org.testng.Assert;

/**
 * @author Egor Stepanov
 * @since 26-10-2017.
 */
public class ListUtilsTest {

    @Test
    public void filterTest() {
        List<String> list = new ArrayList<>(10);
        list.add("ABCD");
        list.add("1234");
        list.add("F4");

        List<String> filteredList = ListUtils.filter((str) -> str.length() < 4, list);
        Assert.assertEquals(filteredList.size(), 1);
        Assert.assertEquals(filteredList.get(0), "F4");

        Integer i1 = 125;
        Integer i2 = 125;
    }

    @Test
    public void findTest() {
        List<String> list = new LinkedList<>();
        list.add("ABCD");
        list.add("1234");
        list.add("F4");

        Assert.assertEquals(ListUtils.find(str -> str.contains("A"), list), "ABCD");
    }

    @Test
    public void transformTest() {
        List<String> list = new ArrayList<>(10);
        list.add("ABCD");
        list.add("1234");
        list.add("F4");

        List<String> transformedList = ListUtils.transform(str -> str.substring(0, 2), list);

        Assert.assertEquals(transformedList.get(0), "AB");
        Assert.assertEquals(transformedList.get(1), "12");
        Assert.assertEquals(transformedList.get(2), "F4");
    }

    @Test
    public void intersectListTest() {
        List<String> list1 = new ArrayList<>(10);
        list1.add("123");
        list1.add("345");

        List<String> list2 = new ArrayList<>(10);
        list2.add("345");
        list2.add("456");

        List<String> intersectList = ListUtils.intersect(list1, list2);

        Assert.assertEquals(intersectList.size(), 1);
        Assert.assertEquals(intersectList.get(0), "345");
    }

    @Test
    public void differenceListTest() {
        List<String> list1 = new ArrayList<>(10);
        list1.add("123");
        list1.add("345");

        List<String> list2 = new ArrayList<>(10);
        list2.add("345");
        list2.add("456");

        List<String> differenceList = ListUtils.difference(list1, list2);

        Assert.assertEquals(differenceList.size(), 1);
        Assert.assertEquals(differenceList.get(0), "123");
    }
}
