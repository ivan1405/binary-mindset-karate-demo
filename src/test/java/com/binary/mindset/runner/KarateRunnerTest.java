package com.binary.mindset.runner;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CucumberOptions(features = "classpath:features")
public class KarateRunnerTest {

    @Test
    public void testRunner() {
        String karateOutputPath = "target/cucumber-html-reports";
        KarateStats karateStats = CucumberRunner.parallel(getClass(), 1, karateOutputPath);
        generateReport(karateOutputPath);
        Assert.assertEquals("Some scenarios did not pass the tests", 0, karateStats.getFailCount());
    }

    private static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        final List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(jsonFile -> jsonPaths.add(jsonFile.getAbsolutePath()));
        Configuration configuration = new Configuration(new File("target"), "Tasklist Management API");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
        reportBuilder.generateReports();
    }
}
