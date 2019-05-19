package jiekou;

public class AddCommand implements Command {
    public void process (int [] target)
    {
        int sum=0;
        for(int t:target)
        {
            sum+=t;
        }
        System.out.println("数组元素的总和 = "+sum);
    }
}
