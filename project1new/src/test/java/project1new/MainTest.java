package project1new;

import static org.junit.Assert.*;

import org.junit.Test;

import daos.UserModel;

public class MainTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test1() {
		
		UserModel um = new UserModel();
		String test = null;
		test = um.getId();
		assertEquals(null, test);
	}
}
