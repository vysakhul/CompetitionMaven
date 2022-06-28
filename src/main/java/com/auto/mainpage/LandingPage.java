package com.auto.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	@FindBy(id="name")
	private WebElement name;
	@FindBy(id="phone")
	private WebElement phone;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(name="submit")
	private WebElement subBtn;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void setName(String n)
	{
		name.sendKeys(n);
	}
	
	public void setPhone(String n)
	{
		phone.sendKeys(n);
	}
	
	public void setEmail(String n)
	{
		email.sendKeys(n);
	}
	
	public void setPass(String n)
	{
		password.sendKeys(n);
	}
	
	public void setAddress(String n)
	{
		address.sendKeys(n);
	}
	
	public void btnClick()
	{
		subBtn.click();
	}
	
}
