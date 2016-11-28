package page.//PATH.TO.PAGE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import infra.Config;
import infra.Tool;

public class Page extends page.Page {

	public Page(WebDriver driver) {
		super(driver);
	}

	public static void goToPage() {
		Tool.goToPage("/");
	}

	@FindBy(id = "userId")
	private WebElement input_userId;
	@FindBy(id = "userPwd")
	private WebElement input_userPwd;

	public Page type_userId(String userId) {

		this.input_userId.sendKeys(userId);

		return this;
	}
	public Page type_userPwd(String userPwd) {

		this.input_userPwd.sendKeys(userPwd);

		return this;
	}
}
