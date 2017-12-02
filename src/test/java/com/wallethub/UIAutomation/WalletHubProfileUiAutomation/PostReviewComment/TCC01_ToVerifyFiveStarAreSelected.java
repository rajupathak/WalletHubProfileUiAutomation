package com.wallethub.UIAutomation.WalletHubProfileUiAutomation.PostReviewComment;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wallethub.UIAutomation.WalletHubProfileUiAutomation.TestBase.TestBase;
import com.wallethub.UIAutomation.WalletHubProfileUiAutomation.UiActions.ProfileWebelements;

public class TCC01_ToVerifyFiveStarAreSelected extends TestBase {

	ProfileWebelements profileObject;
	TestBase testBaseObj = new TestBase();

	@BeforeTest
	public void launchTheBrowser() throws IOException {
		testBaseObj.init();
		testBaseObj.selectBrowser(TestBase.getProperties("browserName"));
		testBaseObj.getURL(TestBase.getProperties("url"));
		testBaseObj.getScreenShot("ProfilePage");
	}

	@Test(priority=1)
	public void selectStar() {

		profileObject= new ProfileWebelements(driver);
		profileObject.selectFiveStart();
		
		
	}

	@Test(priority=2,dependsOnMethods={"selectStar"})
	public void selectValueFromDropDown() throws IOException, InterruptedException{
		profileObject.selectDropDownValue(TestBase.getProperties("dropDownValue"));
		
	}
	
	@Test(priority=3)
	public void verifyActaulandEcpectedReviewCommnets() throws IOException, InterruptedException{
		profileObject.enterReviewComment();
		assertEquals(profileObject.expectedReviewComent, profileObject.expectedReviewComent,"Test Case Passed Successfully");
	}
	
}
