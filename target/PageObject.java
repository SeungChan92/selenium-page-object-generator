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
		Tool.goToPage("/fax/sendView");
	}

	@FindBy(id = "sendMainDtoSubject")
	private WebElement input_sendMainDtoSubject;
	@FindBy(id = "textReceiverInput")
	private WebElement input_textReceiverInput;
	@FindBy(id = "textReceiverName")
	private WebElement input_textReceiverName;
	@FindBy(id = "coverSendName")
	private WebElement input_coverSendName;
	@FindBy(id = "coverSendNumber")
	private WebElement input_coverSendNumber;

	public Page type_sendMainDtoSubject(String sendMainDtoSubject) {

		this.input_sendMainDtoSubject.sendKeys(sendMainDtoSubject);

		return this;
	}
	public Page type_textReceiverInput(String textReceiverInput) {

		this.input_textReceiverInput.sendKeys(textReceiverInput);

		return this;
	}
	public Page type_textReceiverName(String textReceiverName) {

		this.input_textReceiverName.sendKeys(textReceiverName);

		return this;
	}
	public Page type_coverSendName(String coverSendName) {

		this.input_coverSendName.sendKeys(coverSendName);

		return this;
	}
	public Page type_coverSendNumber(String coverSendNumber) {

		this.input_coverSendNumber.sendKeys(coverSendNumber);

		return this;
	}
}
