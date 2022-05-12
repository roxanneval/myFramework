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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;





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
//					String pdriverDir = "C:\\\\Selenium\\"
					

			// String pdriverDirFireFox = getDataConfigProperties("driverDirFireFox");
			// String pdriverDirEdge = getDataConfigProperties("driverdirEdge");

			// Check of Parameter passed as "chrome"
				if (browser.equalsIgnoreCase("chrome")) {
					
				WebDriverManager.chromedriver().setup();
				// Set path to chromedriver.exe
				//System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
				// Create instance of Chrome
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("firefox")) {
				// Set path to geckodriver.exe
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver", pdriverDir + "geckodriver.exe");
				// Create an instance of firefox
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("edge")) {
				// Set path to geckodriver.exe
				WebDriverManager.edgedriver().setup();
				//System.setProperty("webdriver.edge.driver", pdriverDir + "MicrosoftWebDriver.exe");
				// Create an instance of edge
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
		}
	}
			//Create method to read the config
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
			// Method: Wait for Element, Wait for Click,
			// ...Wait for Element
			public void waitForElement(int elementWait, By pLocator) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
			}

			// ...Wait for Click
			public void waitforClick(int elementWait, By pLocator) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.elementToBeClickable(pLocator));
			}
			// ...Wait to dissappear
			public void waitToDisappear(int elementWait, By pLocator) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(pLocator));

			}
			// ...Wait for URL
			public void waitForUrl(int elementWait, String urlContains) {
				WebDriverWait wait = new WebDriverWait(driver, elementWait);
				wait.until(ExpectedConditions.urlContains(urlContains));
			}

			// Method: Get Current URL
			public String getUrl() {
				String getCurrentURL = driver.getCurrentUrl();
				return getCurrentURL;
			}
			// Method: Get Title
			public String getTitle() {
				String getTitle  = driver.getTitle();
				return getTitle;
			}
			// Method: Get inner HTML
			public String getInnerHTML(By pLocator) {
				String elementText = getElement(pLocator).getAttribute("innerHTML");
				System.out.println(elementText);
				return elementText;
				
			}
			// Method: Get text on an Element
			public String getElementText(By pLocator) {
				String elementText = getElement(pLocator).getText();
				return elementText;
			}

			// Method: Click on an Element
			public void clickElement(By pLocator) {
				waitforClick(100, pLocator);
				getElement(pLocator).click();
			}
			// Method: Check Element exists

			// Method: Get Element
			public WebElement getElement(By pLococator) {
				waitforClick(30, pLococator);
				return driver.findElement(pLococator);
			}

			// Method: Cleanup i.e close the Driver
			public void cleanUp() {
				driver.quit();
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
				;
			}

			// Method: Select from DropDown
			public void selectDropdown(By pLocator, String pValue) {
				// Create an instance of the dropdown object
				waitForElement(200, pLocator);
				Select sDropdown = new Select(getElement(pLocator));
				// populate the Dropdown
				sDropdown.selectByVisibleText(pValue);
			}

			// Method: Get text on Method - pass

			// Method Switch Window
			public void switchToNewTab() {
				Set<String> handles = driver.getWindowHandles();
				Iterator<String> it = handles.iterator();
				String parentWindowID = it.next();
				String childWindowID = it.next();
				driver.switchTo().window(childWindowID);
			}

			public void switchToParent() {
				Set<String> handles = driver.getWindowHandles();
				Iterator<String> it = handles.iterator();
				String parentWindowID = it.next();
				String childWindowID = it.next();
				driver.switchTo().window(parentWindowID);
			}

			public void closeChildBrowser() {
				Set<String> handles = driver.getWindowHandles();
				Iterator<String> it = handles.iterator();
				String parentWindowID = it.next();
				String childWindowID = it.next();
				driver.switchTo().window(childWindowID);
				driver.close();
				driver.switchTo().window(parentWindowID);
			}
			
			public void quitBrowser() {
				Set<String> handles = driver.getWindowHandles();
				Iterator<String> it = handles.iterator();
				String parentWindowID = it.next();
				String childWindowID = it.next();
				driver.quit();
			}

		}
			
			
			
			
			
			
		