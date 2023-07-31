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

public class StaticTableSubjectTopper {
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
	 * use this method to click on tabs
	 * 
	 * @param webElement
	 */
	public void clickSubjectTopperTab(WebElement webElement) {
		webElement.click();
	}

	/**
	 * use this method to print the row 
	 */
	 public void printRow(List<WebElement> webElement) {
		
		// TODO : Print the data 
		for(WebElement element: webElement)
		{
			System.out.println(" | " + element.getText());
		}

		// To add next line
		System.out.println("\n");
	}

	/**
	 * use this method to print the total rows
	 */
	public void printTotalRows(List<WebElement> webElement) {
		int rowCount = 0;
		// TODO : Calculate the number of rows
		rowCount = webElement.size();
		System.out.println("Row count is: " + rowCount);
	}

	
	

	/**
	 * Use this method to print the subject info
	 * 
	 * @param webElement : List of table header columns
	 * @param headerName : Name of the table column
	 * @param value      : to be search under column header
	 */
	public void printStudentInfo(List<WebElement> webElement, String headerName, String value) {
		int columnCounter = 0;
		int rowCounter = 0;
		List<WebElement> theads ;

		// TODO : Locate all the table headers
		theads = driver.findElements(By.tagName("th"));

		// TODO : Iterate through each header to find out the matching header
		for(WebElement thead: theads)
		{
			columnCounter++;
			if(thead.getText().equals(headerName))
			break;
		}

		// TODO : Use the column header index to locate all the row data of the column
		List<WebElement> subjects =driver.findElements(By.xpath("//tbody//td[2]"));

		// TODO : Iterate through each row data of the column to find out the matching
		// row data and print its info
		for(WebElement sub:subjects)
		{
			rowCounter++;
			if(sub.getText().equals(value))
			{
				List<WebElement> studentInfo = driver.findElements(By.xpath("//tr"));
				System.out.println("Student record for subject : "+value);
				for(WebElement info:studentInfo)
				System.out.println(" | "+info.getText());
			}
		}
	}

	/**
	 * use this method to calculate average of "Highest Marks"
	 */
	public void avgHighestMarks(List<WebElement> webElement) {
		int avg = 0;
		int totalRow = 0;
		int totalMarks = 0;

		// TODO: Calculate the avg
		totalRow = webElement.size();
		for(WebElement element : webElement)
		{
			String value = element.getText();
			totalMarks = totalMarks + Integer.parseInt(value);
		}
		avg = totalMarks/totalRow;

		
		System.out.println("Average marks are : " + avg);
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

		// TODO: Step - 3 Click on "Static Table - Subject Topper"
		WebElement tab = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/div/div/button[2]/span[1]"));
		this.clickSubjectTopperTab(tab);

		// Step - 4 : List/Print the names of all columns
		
		
		


		// TODO: Locate the <th>under <thead> and assign it to columnName
		List<WebElement> columnsName = driver.findElements(By.xpath("//th"));
		System.out.println("Column headers are : ");
		// TODO: Call the method printRow() to print the column names as column headers are first row
		this.printRow(columnsName);

		// Step - 5 : List/Print the data in the second row
		List<WebElement> secondRowData = driver.findElements(By.xpath("//tr[2]/td"));


		// Locate the all <td> under second <tr> of <tbody> and assign it to
		// secondRowData

		System.out.println("Second row is : ");

		// Call the method printRow() to print the row
		this.printRow(secondRowData);
		// Step - 6 : Print the Student Name,Roll Number and the Mark of topper in
		// "Java"
		List<WebElement> headers = driver.findElements(By.xpath("//tbody//tr"));

		// TODO: Find all header columns

		// TODO: Call the method printStudentInfo() to print the topper student data
		this.printStudentInfo(headers,"Subject","Java");
		// Step - 7 : Find the number of rows
		List<WebElement> totalRows = driver.findElements(By.xpath("//table//tbody//child::tr"));


		// TODO: Locate all the <tr> under <tbody> and assign it to totalRows

		// TODO: Call the method printTotalRows() to the print the row count
		this.printTotalRows(totalRows);
		// Step - 8 : Find the average of all the "Highest Marks"
		List<WebElement> avgHighestMarks = driver.findElements(By.xpath("//tbody//tr/td[3]"));

		// TODO: Locate the column Highest Marks and assign it to avgHighestMarks.

		// TODO: Call the method avgHighestMarks()
		this.avgHighestMarks(avgHighestMarks);
		// Call the method closeBrowser
		this.closeBrowser();
	}
}
