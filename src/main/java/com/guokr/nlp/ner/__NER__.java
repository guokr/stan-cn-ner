package com.guokr.nlp.ner;

import com.guokr.nlp.seg.__SEG__;

public enum __NER__ {

	INSTANCE;

	private NerWrapper ner = new NerWrapper();

	public String recognize(String text) {
		String result = null;
		try {
			text = __SEG__.INSTANCE.segment(text);
			result = ner.recognize(text);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return result;
	}

}
