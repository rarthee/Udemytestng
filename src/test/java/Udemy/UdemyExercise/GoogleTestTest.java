package Udemy.UdemyExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTestTest {
	WebDriver driver;
  @Test
  public void setupTest() {
    
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Sahana Rangarajan\\Documents\\Arthee\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://google.com");
    driver.manage().window().maximize();
  }
}
