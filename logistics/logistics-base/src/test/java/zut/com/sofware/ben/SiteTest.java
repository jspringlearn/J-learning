package zut.com.sofware.ben;

import static org.junit.Assert.*;

import org.junit.Test;

public class SiteTest {

	@Test
	public void test() {
		Site site =new Site();
		site.setName("河南省郑州市新郑市龙湖镇");
		site.setInfo("是个热闹的地方");
		System.out.println(site);
		
	}

}
