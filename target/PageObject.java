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
		Tool.goToPage("/fax/popup/document");
	}


	@FindBy(id = "funFaxSend")
	private WebElement a_funFaxSend;


	public Page click_funFaxSend() {

		this.a_funFaxSend.click();

		return this;
	}
}
