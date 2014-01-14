package com.entertainment.musicpage.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.entertainment.musicpage.common.Configuration;

public class PropertiesTest {

	@Test
	public void testGetProperties() throws IOException {
		String s = Configuration.getProperties().get("drive.cope").toString();
		System.out.println(s);
		Assert.assertEquals(145, s.length());
	}
}
