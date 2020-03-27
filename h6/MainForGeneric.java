import java.util.ArrayList;

public class MainForGeneric {
    public static void main(String[] args) {

        IFilter<Integer> filter = new IFilter<Integer>(){
            public boolean filter(Integer ii){

                if(ii<5)
                    return true;
                return  false;


            }
        };


        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(5);
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(5);
        arr.add(1);

        ArrayList<Integer> arr1 = FilterApplicator.sort(arr);
        for(int i = 0;i<arr1.size();i++){
            System.out.println(arr1.get(i));
        }

        System.out.println();

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(3);
        arr2.add(7);
        arr2.add(8);
        arr2.add(2);
        ArrayList<Integer> arr3 = FilterApplicator.filter(arr2,filter);
        for(int i = 0;i<arr3.size();i++){
            System.out.println(arr3.get(i));
        }

    }
}
