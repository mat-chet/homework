import java.util.*;

public class Array_Linked {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Random random =new Random();

        long l1 = System.currentTimeMillis();

        for (int i = 0;i< 1000_000;i++) {
            array.add(random.nextInt());
        }

        long l2 = System.currentTimeMillis();
        System.out.println("add ArrayList " + ((double)(l2-l1))/1000);

        for (int i = 0;i< 1000_000;i++) {
            array.remove(array.size()-1);
        }
        l1 = System.currentTimeMillis();

        System.out.println("Del ArrayList " + ((double)(l1-l2))/1000);
        List<Integer> linked = new LinkedList<>();

        array.sort(Integer::compareTo);



        long l3 = System.currentTimeMillis();

        for (int i = 0;i< 1000_000;i++) {
            linked.add(random.nextInt());
        }

        long l4 = System.currentTimeMillis();
        System.out.println("Add LinkedList : " + ((double)(l4-l3))/1000);

        for (int i = 0;i< 1000_000;i++) {
            //linked.remove((linked.size()-1)/2);
            linked.remove(linked.size()-1);
        }


        l3 = System.currentTimeMillis();
        System.out.println("Del LinkedList : " + ((double)(l3-l4))/1000);








        //2


        for (int i = 0;i< 1000_000;i++) {
            linked.add(random.nextInt());
        }

        for (int i = 0;i< 1000_000;i++) {
            linked.remove(linked.size()-1);
        }


    }
}
