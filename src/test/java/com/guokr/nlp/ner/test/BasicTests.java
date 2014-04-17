package com.guokr.nlp.ner.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.guokr.nlp.ner.__NER__;

@RunWith(JUnit4.class)
public class BasicTests {

	@Test
	public void testNer() throws Exception {
		String nerText = __NER__.INSTANCE.recognize("这是个测试");
		assertEquals("这/O 是/O 个/O 测试/O", nerText);
	}

}
