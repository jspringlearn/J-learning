package zut.com.sofware.ben;

import static org.junit.Assert.*;

import org.junit.Test;

public class GroupTest {

	@Test
	public void test() {
		Group group=new Group();
		group.setGroupName("郑州市");
		System.out.println(group);
	}

}
