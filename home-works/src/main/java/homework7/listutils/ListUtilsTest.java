package homework7.listutils;

import homework7.iterablelist.ArrayList;
import homework7.iterablelist.LinkedList;
import homework7.iterablelist.List;
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
}
