stan-cn-seg
===========

stan-cn-* package family is packages based on Stanford NLP packages for the
convenience of Chinese users. This package provide a Chinese naming entity
recognizor.

stan-cn-* package family is including:

* stan-cn-com: Common code base
* stan-cn-seg: Chinese segmentation and related data model
* stan-cn-ner: Naming entity recognization and related data model
* stan-cn-tag: POS tagging and related data model

Comments, reviews, bug reports and patches are welcomed.


The API
--------

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

License
--------

GPLv2, just same as the license of Stanford CoreNLP package

