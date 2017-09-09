package com.bitm.newtours5th.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.newtours5th.Utils.DriverManager;
import com.bitm.newtours5th.Utils.UrlTextUtils;
import com.bitm.newtours5th.Utils.XpathUtils;

public class LoginTest {

	private WebDriver driver = null;

	@Test(priority = 1)
	public void checkloginpagetitle() {
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.BASE_URL);

		Assert.assertEquals(driver.getTitle(), UrlTextUtils.LOGIN_PAGE_TITLE);
		System.out.println("Checked- Login Page Title Successfully !!!!!");
	}

	@Test(priority = 2)
	public void logintest() {

		driver.findElement(By.xpath(XpathUtils.Login.INPUT_USER_NAME)).sendKeys("demo");
		driver.findElement(By.xpath(XpathUtils.Login.INPUT_PASSWORD)).sendKeys("demo");
		driver.findElement(By.xpath(XpathUtils.Login.BTN_SIGNIN)).submit();
		
		System.out.println("Logged in Successfully!");
	}
}
