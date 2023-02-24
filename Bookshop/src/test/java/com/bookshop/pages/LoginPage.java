package com.bookshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

	@FindBy(id = "login")
	public WebElement loginInput;

	@FindBy(id = "password")
	public WebElement passwordInput;

	@FindBy(id = "login-button")
	public WebElement loginButton;

	@FindBy(id = "logout-button")
	public WebElement logoutButton;

	@FindBy(id = "register-button")
	public WebElement registerButton;

	public void login(String login, String password){
		loginInput.sendKeys(login);
		passwordInput.sendKeys(password);
	}
}
