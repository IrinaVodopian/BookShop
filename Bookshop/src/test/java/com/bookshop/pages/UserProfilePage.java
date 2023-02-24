package com.bookshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class UserProfilePage {

	@FindBy(id = "title")
	public WebElement title;

	@FindBy(id = "staticUserId")
	public WebElement staticUserId;

	@FindBy(id = "createUser")
	public WebElement saveButton;

}
