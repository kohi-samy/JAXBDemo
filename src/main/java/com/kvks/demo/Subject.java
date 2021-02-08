package com.kvks.demo;

import javax.xml.bind.annotation.XmlElement;

public class Subject {

    private String stream;
    private String name;

    @XmlElement
    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




