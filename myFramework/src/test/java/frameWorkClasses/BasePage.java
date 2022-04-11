package frameWorkClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Declare the Web Driver
	public static WebDriver driver;
	
	//Constructor
	public BasePage() {
		if(driver == null) {
		//Set Parameter numbers
//		String browser = getDataConfigProperties("browser");
//		String URL = getDataConfigProperties("systemUnderTest");
//		String pdriverDir = getDataConfigProperties("driverdir");
		String browser = "chrome" ;
		String URL = "https://www.takealot.com/";
		String pdriverDir = "C:\\Selenium\\selenium-java-4.1.2\\" ;
			
		//String pdriverDirFireFox = getDataConfigProperties("driverDirFireFox");
		//String pdriverDirEdge = getDataConfigProperties("driverdirEdge");
		
		//Check of Parameter passed as "chrome"
		if(browser.equalsIgnoreCase("chrome")) {
		//Set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
		//Create instance of Chrome
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		}
	}
	//check if our Driver has been started, if not then start
	
	//Set the Browser URL
	public void waitForUrl(int elementWait, String pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(pLocator));
	}
	
	//Method: Wait for Element, Wait for Click
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
		}
	
	//Wait for click
	public void waitforClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
		}
	
	//Method: Get Text on Element
	public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
		return elementText;
		}
	
	//Method: Check Element exists
	
	//Method:Get Element
	public WebElement getElement(By pLococator) {
		waitforClick(30, pLococator);
		return driver.findElement(pLococator);
		}
	
	//Methods: Cleanup i.e close the Driver
	
	//Method: Enter text on field
	
	//Method: Clear text from field
	
	//Method: Select from dropdown
	
	//Method: Get text from Method - Pass

	

}
