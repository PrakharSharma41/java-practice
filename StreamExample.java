import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public void check(){
        Stream<Integer>st=Stream.of(1,2,3,4).filter(x->x<=3);
        List<Integer>ls=st.collect(Collectors.toList());
        System.out.println(ls);
    }
    public void flatMap(){
        List<List<Integer>>ls=Arrays.asList(
            Arrays.asList(1,2,3,4),Arrays.asList(5,6,7,8)
        );
        Stream<Integer>temp=ls.stream().flatMap((List<Integer>l)->l.stream().map(x->x%2));
        // System.out.println(temp.reduce(0, (Integer i1,Integer i2)->i1+i2)); // this closes temp stream
        // Optional<Integer>itr=temp.min((Integer i1,Integer i2)->i1-i2);

        System.out.println(temp.collect(Collectors.toList()));
    }
}
