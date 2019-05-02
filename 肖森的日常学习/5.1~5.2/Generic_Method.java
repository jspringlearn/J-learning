package fanxing_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generic_Method {
    static <T> void test(Collection<? extends T>from, Collection<T> to)
    {
        for(T ele:from)
        {
            to.add(ele);
        }
    }
    public static void main(String[] arg){
        List<Object> ao=new ArrayList<>();
        List<String> as=new ArrayList<>();
        test(as,ao);
    }
}
