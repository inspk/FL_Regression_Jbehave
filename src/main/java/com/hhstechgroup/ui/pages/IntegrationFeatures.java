package com.hhstechgroup.ui.pages;


import org.openqa.selenium.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class IntegrationFeatures  extends AbstractPage{
    public IntegrationFeatures(WebDriver driver) {
        super(driver);
    }


    public String getRandomStringFromFile(String filename) {
        System.out.println("file not fount ");
        try {
            List<String> values = Files.readAllLines(Paths.get("integration", filename ,".csv"));
            return values.get((int) (Math.random() * values.size()));
        } catch (IOException e) {
            throw new RuntimeException("Not possible to read String in file");
        }
        finally {
            System.out.println("file not found");
        }
    }

    public void getTest(){

    }
//        public static List<String> getListOfNpiFromFile() {
//            try {
//                return Files.readAllLines(Paths.get("integration/Npi.csv"));
//            } catch (IOException e) {
//                throw new RuntimeException("Unable to load npi file");
//            }
//        }





//    public static class ReadFileFromClasspath
//    {
//        public static void main(String[] args) throws Exception
//        {
//            //To avoid referring non-static method inside main() static method
//            ReadFileFromClasspath instance = new ReadFileFromClasspath();
//
//            File file = instance.getFile("integration/WyNPI.csv");
//
//            //validate file path
//            System.out.println(file.getPath());
//
//            //Read file
//            List<String> lines = Files.readAllLines(file.toPath());
//
//            System.out.println(lines);
//        }
//
//        private File getFile(String fileName) throws IOException
//        {
//            ClassLoader classLoader = getClass().getClassLoader();
//            URL resource = classLoader.getResource(fileName);
//
//            if (resource == null) {
//                throw new IllegalArgumentException("file is not found!");
//            } else {
//                return new File(resource.getFile());
//            }
//        }
//    }

}
