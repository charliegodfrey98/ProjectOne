package com.bae.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

//loads the front end in [src/main/resources/static] and hosts it on a random port
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//resets db between tests -> means that only ONE penguin rendered to page at start of test
@Sql(scripts = { "classpath:Loadout-schema.sql",
		"classpath:Loadout-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // uses h2db
public class SeleniumCreateTest {

	@LocalServerPort // fetches the random port
	private int port;

	private RemoteWebDriver driver;

	private WebDriverWait wait;

	@BeforeEach
	void setup() {
		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true); // turns off the chrome window (great when tests
		// are FINISHED)
		this.driver = new ChromeDriver(options);

		this.driver.manage().window().maximize(); // maximizes window

		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // will wait two seconds for EVERY ELEMENT

		System.setProperty("webdriver.chrome.driver", "C:\\Shared\\chromedriver.exe"); // loads chromedriver from folder

		this.wait = new WebDriverWait(driver, 5); // set up explicit wait -> up to 5 seconds ONLY WHEN USED
	}

	@Test
	void createTest() {
		this.driver.get("http://localhost:" + port);

		WebElement createButton = this.driver.findElement(By.xpath("/html/body/header/nav/button"));

		createButton.click();

		WebElement nameBar = this.driver.findElement(By.xpath("//*[@id=\"createloadoutname\"]"));

		nameBar.sendKeys("Test");

		WebElement submitButton = this.driver
				.findElement(By.xpath("//*[@id=\"createLoadoutForm\"]/div/div[2]/button[2]"));

		submitButton.submit();

	}

	// @AfterEach
	// void tearDown() {
	// this.driver.close();
	// }

}
