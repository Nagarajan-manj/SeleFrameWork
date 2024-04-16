package com.qa.base;

import com.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;


    public TestBase() throws IOException {
 //       Properties pro;
//        File fi=new File("Users/Nagarajan/SeleFrameWork/src/main/java/com" +
//                "/qa/config.properties");
        try {
            File src = new File("./Configuration/config.properties");
            FileInputStream fis = new FileInputStream(src);
            //   FileInputStream fis =new FileInputStream(System.getProperty("user.dir"));
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

        public static void initialization()
        {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));


        }
}
