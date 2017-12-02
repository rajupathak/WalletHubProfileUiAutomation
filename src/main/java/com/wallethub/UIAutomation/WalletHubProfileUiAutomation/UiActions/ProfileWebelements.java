package com.wallethub.UIAutomation.WalletHubProfileUiAutomation.UiActions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.UIAutomation.WalletHubProfileUiAutomation.TestBase.TestBase;

public class ProfileWebelements extends TestBase {
	TestBase obj = new TestBase();
	public String expectedReviewComent;
	public String actualReviewComent;
	@FindBy(xpath = "//*[contains(@id,'footer_cta')]//*[contains(@class,'af-icon-cross')]")
	WebElement crossIcon;

	@FindBy(xpath = ".//*[contains(@id,'wh-body-inner')]//*[contains(@class,'reviewinfo info')]/span")
	WebElement reviewIcon;

	@FindBy(xpath = ".//*[contains(@id,'wh-body-inner')]//*[contains(@class,'wh-rating-choices')]//a[5]")
	WebElement selectStar;

	@FindBy(xpath = ".//*[contains(@class,'dropdown-title')]")
	WebElement dropDownTitle;

	@FindBy(xpath = ".//*[contains(@class,'product')]//*[contains(@class,'drop-el')]//li")
	List<WebElement> dropDownList;

	@FindBy(xpath = ".//*[contains(@id,'overallRating')]//a[5]")
	WebElement overAllRating;

	@FindBy(xpath = ".//*[contains(@id,'review-content')]")
	WebElement reviewContent;

	@FindBy(xpath = ".//*[contains(@id,'reviewform')]//*[contains(@class,'content')]//*[contains(@class,'submit')]//input")
	WebElement submitButton;

	@FindBy(xpath = ".//*[contains(@class,'wh-profile-tab-contents')]//*[contains(@class,'reviews')]//p[1]")
	WebElement actualPost;

	public ProfileWebelements(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectFiveStart() {

		obj.waitForTheWebElement(crossIcon, driver, 30);
		obj.highLighteBackground(driver, crossIcon);
		crossIcon.click();

		obj.moveToElement(reviewIcon, driver);
		obj.waitForTheWebElement(selectStar, driver, 20);
		obj.highLighteBackground(driver, selectStar);
		selectStar.click();
		obj.getScreenShot("Selected Five Star");
	}

	public void selectDropDownValue(String dropDownValue)
			throws InterruptedException {
		obj.highLighteBackground(driver, dropDownTitle);
		dropDownTitle.click();
		
		List<WebElement> list = obj.waitForTheWebElements(dropDownList, driver,
				30);

		for (int i = 0; i < list.size(); i++) {
			String actaultest = list.get(i).getText();
			System.out.println(actaultest);
			if (actaultest.equalsIgnoreCase(dropDownValue)) {
				obj.highLighteBackground(driver, list.get(i));
				list.get(i).click();
				obj.getScreenShot("Drop Down Value");
				Thread.sleep(2000);
				break;

			}
		}
		obj.highLighteBackground(driver, overAllRating);
		overAllRating.click();
		obj.getScreenShot("Over all Rating selected");
	}

	public void enterReviewComment() throws IOException, InterruptedException {
		obj.highLighteBackground(driver, reviewContent);
		reviewContent.clear();
		reviewContent.clear();
		expectedReviewComent = obj.readTextFile();
		reviewContent.sendKeys(expectedReviewComent);
		obj.getScreenShot("Review comments");
		Thread.sleep(3000);
		obj.highLighteBackground(driver, submitButton);
		submitButton.click();
		Thread.sleep(5000);
		driver.get(TestBase.getProperties("profileURL"));
		obj.getScreenShot("Review section page");
		actualReviewComent = actualPost.getText();
		
	}

}
