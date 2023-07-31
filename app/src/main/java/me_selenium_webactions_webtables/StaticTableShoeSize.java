package me_selenium_webactions_webtables;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableShoeSize {
	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	/**
	 * use this method to open the url of an application
	 */
	public void openURL(String browserURL) {

		System.out.println("maximize the window..");
		driver.manage().window().maximize();

		System.out.println("opening website --->" + browserURL);
		driver.get(browserURL);
	}

	/**
	 * use this method to select the shoe size
	 */
	public void selectShoeSize(WebElement webElement) {
		// Click on the radio button
		webElement.click();
	}

	public void printHeelToToeValue(WebElement webElement) {
		String value = null;
		// get the Heel To Toe value
		value = webElement.getText();
		System.out.println("Heel To Toe value is : " + value);
	}

	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws MalformedURLException {
		

		// Step - 1 : Call the method startBrowser
		WebDriver driver = this.startBrowser();

		// Step - 2 : Call the method openURL
		this.openURL("https://web-locators-static-site-qa.vercel.app/Web%20Table");

		// Step - 3 : Select your shoe size(By Clicking on the radio button in the
		// specific row)
		
		 WebElement shoeSize = driver.findElement(By.name("2"));
		// TODO: Locate the radio button of shoe size which you want to select and assign it
		// to shoeSize
		
		// TODO: Call the method selectShoeSize
		this.selectShoeSize(shoeSize);
		// Step - 3 : Select your shoe size(By Clicking on the radio button in the
		// specific row)
		
		WebElement heelToToe = driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));

		// TODO: Locate the heelToToe cell of your selected shoe size

		// TODO: Call the method printHeelToToeValue
		this.printHeelToToeValue(heelToToe);
		// Call the method closeBrowser
		this.closeBrowser();
	}
}
