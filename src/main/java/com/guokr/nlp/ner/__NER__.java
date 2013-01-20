package com.guokr.nlp.ner;

import java.lang.reflect.Method;

public enum __NER__ {

    INSTANCE;

    private Class  clz = __PKG__.INSTANCE.load("com.guokr.nlp.ner.NerWrapper");
    private Object ner = __PKG__.INSTANCE.create("com.guokr.nlp.ner.NerWrapper");

    public String recognize(String text) {
        String result = null;
        try {
            text = com.guokr.nlp.seg.__SEG__.INSTANCE.segment(text);
            Class[] argTypes = new Class[] { String.class };
            Method mtd = this.clz.getDeclaredMethod("recognize", argTypes);
            String[] args = new String[]{ text };
            result = mtd.invoke(this.ner, args).toString();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

}

