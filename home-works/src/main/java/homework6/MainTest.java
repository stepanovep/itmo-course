package homework6;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public class MainTest {

    private static final int N = 8;

    @Test
    public void arrayListTest() {

        Queue<Integer> queue = new ArrayList<>(10);
        for (int i = 0; i <= N; i++) {
            queue.add(i);
        }
        Assert.assertEquals(queue.poll().intValue(), 0);
        Assert.assertEquals(queue.poll().intValue(), 1);


        Stack<Integer> stack = new ArrayList<>(10);
        for (int i = 0; i <= N; i++) {
            stack.push(i);
        }
        Assert.assertEquals(stack.pop().intValue(), N);
        Assert.assertEquals(stack.pop().intValue(), N-1);


        List<Integer> list = new ArrayList<>(5);
        for (int i = 0; i <= N; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(list.size(), N+1);
        Assert.assertEquals(list.get(N).intValue(), N);
        Assert.assertEquals(list.remove(0).intValue(), 0);
        Assert.assertEquals(list.size(), N);
    }

    @Test
    public void linkedListTest() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            queue.add(i);
        }
        Assert.assertEquals(queue.poll().intValue(), 0);
        Assert.assertEquals(queue.poll().intValue(), 1);


        Stack<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            stack.push(i);
        }
        Assert.assertEquals(stack.pop().intValue(), N);
        Assert.assertEquals(stack.pop().intValue(), N-1);


        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(list.size(), N+1);
        Assert.assertEquals(list.get(N).intValue(), N);
        for (int i = 0; i <= N; i++) {
            Assert.assertEquals(list.remove(0).intValue(), i);
        }
        Assert.assertEquals(list.size(), 0);
    }

}
