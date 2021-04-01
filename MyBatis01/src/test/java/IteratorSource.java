import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorSource {

    public static void t1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.hasNext() ? iterator.next() : "null");
        System.out.println(iterator.hasNext() ? iterator.next() : "null");
        iterator.remove();
        list.add(1); // throws exception
        System.out.println(iterator.hasNext() ? iterator.next() : "null");

    }

    public static void t2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> iterator = list.listIterator();
        System.out.println(iterator.hasNext() ? iterator.next() : "null");
        System.out.println(iterator.hasNext() ? iterator.next() : "null");
        iterator.add(12313);
        iterator.add(123);
        list.remove(1);
        System.out.println(iterator.hasNext() ? iterator.next() : "null");
    }

    public static void main(String[] args) {
        t1();
        t2();
    }
}
