package com.ea.SpringBasic.resourceTests;

import com.ea.SpringBasic.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataProviderTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata2.csv")
    private Resource resource;

    @Value("${screenshot.path}")
    private Path path ;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test(dataProvider = "getData")
    public void resourceTest(String url , String fileName) throws IOException {
        FileCopyUtils.copy(resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(fileName))
        );
    }


    @DataProvider
    private Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(s->s.split(","))
                .toArray(Object[][]::new);
    }


}
