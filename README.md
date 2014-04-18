stan-cn-ner
============

stan-cn-* family are wrappers based on Stanford CoreNLP for the convenience of
Chinese users. This package provide a Chinese naming entity recognizor.

stan-cn-* family are including:

* stan-cn-com: Common code base
* stan-cn-seg: Chinese segmentation and related data model
* stan-cn-ner: Naming entity recognization and related data model
* stan-cn-tag: POS tagging and related data model

Comments, reviews, bug reports and patches are welcomed.

Current version
----------------

Current version is 0.0.4 and based on Stanford CoreNLP 3.2.0 with minor fixes.

including below dependency:

* maven:
```xml
    <dependency>
        <groupId>com.guokr</groupId>
        <artifactId>stan-cn-ner</artifactId>
        <version>0.0.4</version>
    </dependency>
```
* leiningen:
```clojure
    [com.guokr/stan-cn-ner "0.0.4"]
```
* sbt:
```scala
    libraryDependencies += "com.guokr" % "stan-cn-ner" % "0.0.4"
```

Simplified API
---------------

We use a very simple API to reduce the complexity.

```java
    new NerWrapper(settings).recognize(text);
```

Or if you want to use the default language models, just use

```java
    __NER__.INSTANCE.recognize(text);
```

Preparation for release
------------------------

Before release this package to maven central, please execute below commands:

* mvn clean source:jar javadoc:jar package
* export MAVEN_OPTS=-Xmx2048m
* mvn release:clean
* mvn release:prepare
* mvn release:perform

Authors
--------

* Mingli Yuan ( https://github.com/mountain )
* Rui Wang ( https://github.com/isnowfy )
* Wanjian Wu ( https://github.com/jseagull )

License
--------

GPLv2, just same as the license of Stanford CoreNLP package
