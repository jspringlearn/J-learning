package fanxing_;

import java.util.List;

public class Canvas
{
    //通配符的上限
    public void drawall(List<? extends Shape> shapes ){
        for(Shape s: shapes)
        s.draw(this);
    }
}
