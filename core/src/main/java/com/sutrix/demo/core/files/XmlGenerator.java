package com.sutrix.demo.core.files;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
public interface XmlGenerator {

    public static void main(String[] args)
            throws ParserConfigurationException,
                                     TransformerException {

        String outputDir = "D:\\Real Projects\\Files generate\\XML\\";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);
        Element childElement = document.createElement("child");
        childElement.setTextContent("Hi I'm Murali from Sutrix Solutions");
        rootElement.appendChild(childElement);

        // Write to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        File directory = new File(outputDir);
        if (!directory.exists()){
            directory.mkdirs();
        }
        File outputFile = new File(outputDir + "sample.xml");
        StreamResult result = new StreamResult(outputFile);
        transformer.transform(source, result);
        System.out.println("XML file created!");
    }
}