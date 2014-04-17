package com.guokr.nlp.ner;

import com.guokr.protocol.Protocols;
import com.guokr.util.Settings;

import edu.stanford.nlp.ie.crf.CRFClassifier;

public class NerWrapper {

	static Protocols protocols = Protocols.INSTANCE;
	static Settings defaults = Settings.load("xcf:///ner/defaults.using.prop");

	private CRFClassifier<?> classifier;

	public NerWrapper(Settings settings) {
		Settings props = new Settings(settings, defaults);
		String model = props.getProperty("model");
		try {
			classifier = CRFClassifier.getClassifier(model, props);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace(System.err);
		}
	}

	public NerWrapper() {
		this(null);
	}

	public String recognize(String text) {
		return classifier.classifyToString(text).trim();
	}

}
