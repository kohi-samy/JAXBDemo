package com.kvks.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBDemo {

    public static void main(String[] args) throws IOException, JAXBException {

        String xml = "<Subjects>\n" +
                "    <Subject>\n" +
                "        <Stream>STEM</Stream>\n" +
                "        <name>Mathematics</name>\n" +
                "    </Subject>\n" +
                "    <Subject>\n" +
                "        <Stream>STEM</Stream>\n" +
                "        <name>Science</name>\n" +
                "    </Subject>\n" +
                "    <Subject>\n" +
                "        <Stream>STEM</Stream>\n" +
                "        <name>Technology</name>\n" +
                "    </Subject>\n" +
                "    <Subject>\n" +
                "        <Stream>Art</Stream>\n" +
                "        <name>Music</name>\n" +
                "    </Subject>\n" +
                "    <Subject>\n" +
                "        <Stream>Art</Stream>\n" +
                "        <name>Dance</name>\n" +
                "    </Subject>\n" +
                "</Subjects>";


        //initialize a java.io.Reader object with xml content
        StringReader reader = new StringReader(xml);
        //initialize jaxb classes
        JAXBContext context = JAXBContext.newInstance(Subjects.class);
        Unmarshaller um = context.createUnmarshaller();
        //convert into relevant object
        Subjects subjectData = (Subjects) um.unmarshal(reader);
        List<Subject> lstSubject = subjectData.getSubject();
        //iterate over object
        for (Subject e : lstSubject) {
            System.out.println("Name : " + e.getName());
            System.out.println("Stream : " + e.getStream());
            System.out.println("--------------------------");
        }
    }


}
