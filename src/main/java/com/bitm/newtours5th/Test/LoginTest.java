package com.bitm.newtours5th.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.newtours5th.DTO.LoginDTO;
import com.bitm.newtours5th.DataProvider.LoginDataProvider;
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

	@Test(priority = 2,dataProvider="loginData",dataProviderClass=LoginDataProvider.class)
	public void logintest(List<LoginDTO> logindata) throws InterruptedException {

		for(LoginDTO login: logindata){
	
			driver.findElement(By.xpath(XpathUtils.Login.INPUT_USER_NAME)).sendKeys(login.getUserName());
			driver.findElement(By.xpath(XpathUtils.Login.INPUT_PASSWORD)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(XpathUtils.Login.BTN_SIGNIN)).submit();

			System.out.println("Logged in Successfully!");
		}
	}
	}

