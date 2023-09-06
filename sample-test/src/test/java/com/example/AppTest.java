package com.example;

// Generated by Selenium IDE
import org.junit.Test;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

  private static String SELENIUM_HUB_LOCATION = "http://selenium-selenium-hub.apps.ocp.khary.net";
  private static String TEST_NAME="Screenshot My Session";
  private WebDriver chromeDriver;
  private WebDriver edgeDriver;
  private WebDriver firefoxDriver;
  JavascriptExecutor js;


  private void setupChrome(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeDriver = commonSetup(chromeOptions);
  }

  private void setupEdge(){
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeDriver = commonSetup(edgeOptions);
  }

  private void setupFirefox(){
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setCapability("se:name", TEST_NAME);
    try {
        firefoxDriver = new RemoteWebDriver(new URL(SELENIUM_HUB_LOCATION), firefoxOptions);
    } catch (MalformedURLException mue) {
        mue.printStackTrace();
    }
  }

  private WebDriver commonSetup(ChromiumOptions<?> options) {
    WebDriver driver=null;

    // Important, set these
    options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

    // Showing a test name instead of the session id in the Grid UI
    options.setCapability("se:name", TEST_NAME);

    try {
        driver = new RemoteWebDriver(new URL(SELENIUM_HUB_LOCATION), options);
    } catch (MalformedURLException mue) {
        mue.printStackTrace();
    }

      return driver;
  }

  @Test
  public void testEdge() throws IOException, InterruptedException  {
    setupEdge();
    commonTest(edgeDriver);
    takeScreenShot(edgeDriver, "sessionListEdge.png");
    edgeDriver.quit();
  }

  @Test
  public void testChrome() throws IOException, InterruptedException  {
    setupChrome();
    commonTest(chromeDriver);
    takeScreenShot(chromeDriver, "sessionListChrome.png");
    chromeDriver.quit();
  }

  @Test
  public void testFirefox() throws IOException, InterruptedException  {
    setupFirefox();
    commonTest(firefoxDriver);
    takeScreenShot(firefoxDriver, "sessionListFirefox.png");
    firefoxDriver.quit();
  }

  private void commonTest(WebDriver driver) throws IOException, InterruptedException{
    driver.get(SELENIUM_HUB_LOCATION);
    driver.manage().window().setSize(new Dimension(1200, 800));
    driver.findElement(By.cssSelector("#root > div > div.MuiDrawer-root.MuiDrawer-docked.css-1pv7n5u > div > ul > div > a:nth-child(2) > div.MuiListItemText-root.css-1tsvksn > span")).click();
    assertTrue("No Exceptions", true);
  }

  private void takeScreenShot(WebDriver driver, String fname) throws IOException{
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String imageFileDir = System.getProperty("selenium.screenshot.dir");
	    if (imageFileDir == null)
        imageFileDir="target";
    	FileUtils.copyFile(scrFile, new File(imageFileDir, fname));
	}

}
