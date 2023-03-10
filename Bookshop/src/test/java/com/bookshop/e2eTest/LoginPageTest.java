package com.bookshop.e2eTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.bookshop.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class LoginPageTest {

	WebDriver driver;
	JavascriptExecutor ex;

	LoginPage loginPage = new LoginPage();

	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setupTest() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, loginPage);
		ex=(JavascriptExecutor)driver;
	}

	@AfterEach
	void teardown() {
		driver.quit();
	}

	@Test
	void loginPositive() {
		driver.get("http://localhost:8080/pages/login.html");
		loginPage.login("login1","password1");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginPage.loginButton);
		ex.executeScript("arguments[0].click()", loginPage.loginButton);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		assertThat(text).contains("Logged in");
	}

	@Test
	void assertAlertLoginEmpty() {
		driver.get("http://localhost:8080/pages/login.html");
		loginPage.login("login1","");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginPage.loginButton);
		ex.executeScript("arguments[0].click()", loginPage.loginButton);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		assertThat(text).contains("Please fill all the fields");
	}

}