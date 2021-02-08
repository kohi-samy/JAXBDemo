package com.kvks.demo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Subjects")
public class Subjects {

    private List<Subject> subject;

    @XmlElement(name="Subject")
    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subjectList) {
        this.subject = subjectList;
    }
}

