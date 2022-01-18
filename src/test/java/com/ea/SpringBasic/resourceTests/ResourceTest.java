package com.ea.SpringBasic.resourceTests;

import com.ea.SpringBasic.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {


    @Value("classpath:data/testdata.csv")
    private Resource resource;

    //When file not part of project , use absolute file path
    @Value("file:C:\\Spring boot\\Section 2\\SpringBasic_Section2\\SpringBasic\\src\\test\\resources\\data\\testdata.csv")
    private Resource resource2;

    // this also works , it will read the file content
    //https://www.w3.org/TR/PNG/iso_8859-1.txt
    @Value("https://www.google.com")
    private Resource resource3;

    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
    private Resource resource4;

    @Value("${screenshot.path}/downloadedFile.txt")
    private Path path ;


    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    public void resourceTest2() throws IOException {
        Files.readAllLines(resource.getFile().toPath())
                .forEach(System.out::println);
    }

    //reads content
    @Test
    public void resourceTest3() throws IOException {
        System.out.println(
               new String(resource3.getInputStream().readAllBytes())
        );

    }

    // saves content in file
    @Test
    public void resourceTest4() throws IOException {
        FileCopyUtils.copy(resource4.getInputStream(),Files.newOutputStream(path));
    }

}
