package com.guokr.nlp.ner;

import java.util.Properties;

import edu.stanford.nlp.ie.crf.CRFClassifier;

import com.guokr.util.Reflector;

public class NerWrapper {

    private static Class clzSettings = Reflector.classFor("com.guokr.util.Settings");
    private static Object defaults   = Reflector.callStaticly(clzSettings, "load", new Class[]{String.class}, new Object[]{"classpath:ner/defaults.using.prop"});

    private CRFClassifier classifier;

    public NerWrapper(Object settings) {
        Properties props = (Properties) Reflector.newInstance
            (clzSettings, new Class[]{Properties.class, Properties.class},
              new Object[]{settings, defaults});

        String model = props.getProperty("model");
        try {
            classifier = CRFClassifier.getClassifier(model, props);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace(System.err);
        }
    }

    public NerWrapper() {
        new NerWrapper((Object)null);
    }


    public String recognize(String text) {
        return classifier.classifyToString(text).trim();
    }

}

