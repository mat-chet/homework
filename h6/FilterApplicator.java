import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FilterApplicator {


    public static <T,K extends List<T>> K filter(K list, IFilter<T> filt) {

        for(int i = list.size() - 1;i >= 0; i--){
            if(!filt.filter(list.get(i)))
                list.remove(i);
        }
        return list;
    }



    public static <T extends Comparable,K extends List<T>> K sort(K arr){
        arr.sort(T::compareTo);
        return arr;
    }
}
