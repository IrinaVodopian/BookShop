package com.bookshop.e2eTest;

import com.bookshop.pages.UserProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class UserProfilePageIT {

	WebDriver driver;
	JavascriptExecutor ex;
	UserProfilePage userProfilePage = new UserProfilePage();

	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setupTest() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, userProfilePage);
		ex=(JavascriptExecutor)driver;
	}

	@AfterEach
	void teardown() {
		driver.quit();
	}

	@Test
	void textIsPresent() {
		driver.get("http://localhost:8080/pages/userProfile.html");
		String title = userProfilePage.title.getText();
		String staticId = userProfilePage.staticUserId.getAttribute("value");
		assertThat(title).isEqualTo("USER PROFILE");
		assertThat(staticId).isEqualTo("user id");
	}

	@Test
	void assertAlertFormIsEmpty() {
		driver.get("http://localhost:8080/pages/userProfile.html");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userProfilePage.saveButton);
		ex.executeScript("arguments[0].click()", userProfilePage.saveButton);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		assertThat(text).contains("Please fill all the fields");
	}

}