package com.guokr.nlp.ner;

import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.security.CodeSource;
import java.net.URL;

import org.xeustechnologies.jcl.AbstractClassLoader;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

import com.guokr.util.DowngradeClassLoader;

public enum __PKG__ {

    INSTANCE;

    private ProtectionDomain domain = JarClassLoader.class.getProtectionDomain();
    private CodeSource source = domain.getCodeSource();
    private URL location = source.getLocation();
    private String path = (location != null ? location.getPath() : null);
    private AbstractClassLoader loader = (path != null
                                             ? new JarClassLoader(new String[] { path })
                                             : new DowngradeClassLoader(getClass().getClassLoader()));
    private JclObjectFactory factory = JclObjectFactory.getInstance();

    private Object protocol = loader.safeLoadClass("com.guokr.util.ClasspathProtocol").getEnumConstants()[0];
    private Class localSettings = loader.safeLoadClass("com.guokr.util.Settings");
    private Class localIOUtils = loader.safeLoadClass("edu.stanford.nlp.io.IOUtils");

    public Class load(String clazzName) {
        return loader.safeLoadClass(clazzName);
    }

    public Object create(String clazzName) {
        try {
            return path != null
                 ? factory.create((JarClassLoader)loader, clazzName, new Object[]{null}, new Class[]{Object.class})
                 : Class.forName(clazzName).newInstance();
        } catch (java.lang.ClassNotFoundException e) {
            return null;
        } catch (java.lang.InstantiationException e) {
            return null;
        } catch (java.lang.IllegalAccessException e) {
            return null;
        }
    }

}

