package jiekou;

public class CommandTest {

        public static void  main(String []arg)
        {
              ProcessArray pa=new ProcessArray();
            int [] target={3,-4,6,4};
//            pa.process(target,new PrintCommand());
//            System.out.println("---------------");
//            pa.process(target,new AddCommand());
            pa.process(target,new Command()
            {
                public void process(int[] target)
                {
                    int sum=0;
                    for(int tmp:target)
                    {
                        sum+=tmp;
                    }
                    System.out.println("数组元素的总和 = "+sum);
                }

            });


        }

}
