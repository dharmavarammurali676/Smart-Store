package com.sutrix.demo.core.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public interface HtmlGenerator {
    public static void main(String[] args) {

        String Path = "D:\\Real Projects\\Files generate\\HTML\\";

        File file = new File( Path+ "sample.html");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<!DOCTYPE html>");
            writer.newLine();
            writer.write("<html>");
            writer.newLine();
            writer.write("<head>");
            writer.newLine();
            writer.write("<title>Example HTML File</title>");
            writer.newLine();
            writer.write("</head>");
            writer.newLine();
            writer.write("<body>");
            writer.newLine();
            writer.write("<h1>Hi I am a Java Developer</h1>");
            writer.newLine();
            writer.write("</body>");
            writer.newLine();
            writer.write("</html>");
            writer.close();
            System.out.println("HTML file created!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}