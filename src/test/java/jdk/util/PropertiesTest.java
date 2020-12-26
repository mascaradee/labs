package jdk.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.lang.StringTest;

public class PropertiesTest {

	private static final Logger logger = LoggerFactory.getLogger(StringTest.class);

	@Test
	public void testCharSet() throws IOException{
		Properties p = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("src\\main\\webapp\\WEB-INF\\classes\\bundle\\TestBundle_ko.properties"));
        Properties prop = new Properties();
        prop.load(reader);
        reader.close();
        logger.debug("{}", prop);

        Assert.assertEquals("{WELCOME=환영합니다., COUNTRY=한국, TITLE=JSTL 공부중}", prop.toString());

	}
}
