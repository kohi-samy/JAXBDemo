package com.kvks.demo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBDemo {

    public static void main(String[] args) throws IOException, JAXBException {

        Path workingDir = Paths.get("").toAbsolutePath();
        String strWorkingDir = workingDir.toString();

        String xmlFP = strWorkingDir + "\\Subjects.xml";

        String xml = getFileContent(xmlFP);

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
            System.out.println("Stream : " + e.getStream());
            System.out.println("Name : " + e.getName());
            System.out.println("--------------------------");
        }
    }

    static String getFileContent(String filePath) {

        StringBuilder stringBuilder = new StringBuilder();

        try{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String scurrentLine;
        while((scurrentLine = br.readLine()) != null){
            stringBuilder.append(scurrentLine).append("\n");
        }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
