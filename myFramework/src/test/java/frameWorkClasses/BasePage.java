package frameWorkClasses;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	String browser = getDataConfigProperties("browser");
	String URL = getDataConfigProperties("URL");
	String pdriverDir = getDataConfigProperties("pdriverDir");

	

		// Declare the Web Driver
			public static WebDriver driver;

		// Constructor
			public BasePage() {
				if (driver == null) {
			// Set Parameter numbers
//			String browser = getDataConfigProperties("browser");
//			String URL = getDataConfigProperties("systemUnderTest");
//			String pdriverDir = getDataConfigProperties("driverdir");
//					String browser = "chrome";
//					String URL = "https://www.takealot.com/";
//					String pdriverDir = "C:\\\\Selenium\\";
					

			// String pdriverDirFireFox = getDataConfigProperties("driverDirFireFox");
			// String pdriverDirEdge = getDataConfigProperties("driverdirEdge");

			// Check of Parameter passed as "chrome"
				if (browser.equalsIgnoreCase("chrome")) {
				// Set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
				// Create instance of Chrome
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("firefox")) {
				// Set path to geckodriver.exe
				System.setProperty("webdriver.gecko.driver", pdriverDir + "geckodriver.exe");
				// Create an instance of firefox
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("edge")) {
				// Set path to geckodriver.exe
				System.setProperty("webdriver.edge.driver", pdriverDir + "MicrosoftWebDriver.exe");
				// Create an instance of edge
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
		}
	}
			
			public String getDataConfigProperties (String propertyName) {
				//Properties Set
				//System.out.printIn("in config")
				Properties p = new Properties();
				InputStream is = null;
				try {
					is = new FileInputStream("config.properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					p.load(is);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return p.getProperty(propertyName);
			}

			// Switch Window
				public void SwitchToNewTab() {
					Set<String> handles =driver.getWindowHandles();
					
					Iterator<String> it = handles.iterator();
					String parentWindowID = it.next();
					String childWindowId = it.next();
					driver.switchTo().window(childWindowId);
			}
		
		

		// Wait for URL
			public void waitForUrl(int elementWait, String urlContains) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.urlContains(urlContains));
	        }

		// Method: Wait for Element, Wait for Click
			public void waitForElement(int elementWait, By pLocator) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
			}

		// Wait for click
			public void waitforClick(int elementWait, By pLocator) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.elementToBeClickable(pLocator));
			}

		// Method: Get Text on Element
			public String getElementText(By pLocator) {
				String elementText = getElement(pLocator).getText();
				return elementText;
			}

	    // Method: Get Text on Element
			public String getProductText(By pLocator) {
				String elementText = getElement(pLocator).getText();
				System.out.println(elementText);
				return elementText;
			}


		// Method: Click Element
			public void clickElement(By pLocator) {
				waitforClick(30, pLocator);
				getElement(pLocator).click();
			}

		// Method:Get Element
			public WebElement getElement(By pLocator) {
				waitforClick(30, pLocator);
				return driver.findElement(pLocator);
			}

		// Method: Enter text on field
			public void enterText(By pLocator, String enterText) {
				waitforClick(30, pLocator);
				driver.findElement(pLocator).sendKeys(enterText);
			}

	// Method: Clear text from field
		public void clearText(By pLocator) {
			waitforClick(30, pLocator);
			driver.findElement(pLocator).clear();
		}
	
	// Method: Select from dropdown
	// Method: Get text from Method - Pass
	// Method: Check Element exists
	// check if our Driver has been started, if not then start
	// Methods: Cleanup i.e close the Driver

}
