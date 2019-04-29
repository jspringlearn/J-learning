package com.logistics.lbw.mian;

import java.sql.SQLException;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
public interface EntrePot    //这里是仓库的接口
{
    public void Print();    //打印仓库有多少商品

    public String UpGoods()throws ClassNotFoundException , SQLException;  //上货

    public String PutGoods()throws ClassNotFoundException , SQLException; ;  //下货

    public void Check();      //盘货，这里可以设置每天盘一次货物，并且打印出来
                               //并且这里可以通过打印出来的货物与入库的清单进行匹配来判断


}


