package ethocaTestShoppingCart;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class TestNGShoppingCart {

    static WebDriver driver;
    
    public static final String cWomenXpath = "//*[@id='block_top_menu']/ul/li[1]/a";
    public static final String cSummerDressXpath= "//*[@id='block_top_menu']/ul/li/ul/li/ul/li[3]/a";
    public static final String cEyeIconXPath= "//*[@id='center_column']/ul/li[3]/div/div[1]/div/div[1]/a/i";
    public static  String testEmail = "TestKalees1@gmail.com";
    public static  String zipCode = "08052";
    /**
     * This function will execute before each Test tag in testng.xml
     * @param browser
     * @throws Exception
     */
    @Parameters("browser")
    @BeforeTest

    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'chrome'
        if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
        	
        	String path = System.getProperty("user.dir");   // return project folder path
        	String driverpath = path + "\\driverfolder\\chromedriver.exe";   // return driver folder path 
        	System.setProperty("webdriver.chrome.driver",driverpath );
           // System.setProperty("webdriver.chrome.driver","C:\\Users\\Velu\\Downloads\\chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        }
             else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
	public void testShoppingCartWithCreateAccount() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		System.out.print("success Step1");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// Step 2 a
		WebElement elementWomen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cWomenXpath)));
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(elementWomen).build().perform();
		
		// Step 2b
		WebElement elementSummer = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cSummerDressXpath)));
		elementSummer.click();
		System.out.print("\n" + "success Step2");
		
		// Step 3
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement elementEyeIcon = driver.findElement(By.xpath(cEyeIconXPath));
		// Scroll the browser to the EyeIcon Y position
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + elementEyeIcon.getLocation().y + ")");
		elementEyeIcon.click();
		System.out.print("\n" + "success Step3");
		
		// Step 4
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().frame("fancybox-frame1552284920942");
		String iFrameText = "fancybox-iframe";
		driver.switchTo().frame(driver.findElement(By.className(iFrameText)));
		WebElement elementSelect = driver.findElement(By.xpath("//*[@id='uniform-group_1']"));
		System.out.print("success6");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + elementSelect.getLocation().y + ")");
		// *[@id="attributes"]/fieldset[1]/div
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByIndex(1);
		WebElement elementAddtoCart = driver.findElement(By.xpath("//*[@id='add_to_cart']/button"));
		elementAddtoCart.click();
		System.out.print("\n" + "success Step4");
		
		// Step 5
		WebElement elementConShop = driver
				.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
		elementConShop.click();
		System.out.print("\n" + "success Step5");
		
		// Step 6
		WebElement elementCartOpen = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		mouseOver.moveToElement(elementCartOpen).build().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elementcheckout = driver.findElement(By.xpath("//*[@id='button_order_cart']"));
		elementcheckout.click();
		System.out.print("\n" + "success Step6");
		
		// Step 7
		WebElement elementProceedcheckout = driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span"));
		elementProceedcheckout.click();
		System.out.print("\n" + "success Step7");
		
		// Step 8
		WebElement elementEmailbox = driver.findElement(By.xpath("//*[@id='email_create']"));
		elementEmailbox.sendKeys(testEmail);

		WebElement elementCreateAccount = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		elementCreateAccount.click();
		System.out.print("\n" + "success Step8");
		
		// User Details
		// Step 9
		WebElement elementRadioGender = driver.findElement(By.xpath("//*[@id='id_gender1']"));
		elementRadioGender.click();
		WebElement elementFirstName = driver.findElement(By.xpath("//*[@id='customer_firstname']"));
		elementFirstName.sendKeys("Kaleeswaran");
		WebElement elementLastName = driver.findElement(By.xpath("//*[@id='customer_lastname']"));
		elementLastName.sendKeys("Karuppasami");
		WebElement elementPassword = driver.findElement(By.xpath("//*[@id='passwd']"));
		elementPassword.sendKeys("Test_1@#");

		// WebElement elementAddFirstName=
		// driver.findElement(By.xpath("//*[@id='firstname']"));
		// elementAddFirstName.sendKeys("Kaleeswaran");

		// WebElement elementAddtLastName=
		// driver.findElement(By.xpath("//*[@id='lastname']"));
		// elementAddtLastName.sendKeys("Karuppasami");

		WebElement elementAddress = driver.findElement(By.xpath("//*[@id='address1']"));
		elementAddress.sendKeys("2131 Broad st");
		
		WebElement elementCity = driver.findElement(By.xpath("//*[@id='city']"));
		elementCity.sendKeys("Regina");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("New Jersey");

		WebElement elementPost = driver.findElement(By.xpath("//*[@id='postcode']"));
		elementPost.sendKeys(zipCode);

		WebElement elementMobilePhone = driver.findElement(By.xpath("//*[@id='phone_mobile']"));
		elementMobilePhone.sendKeys("3065519397");

		WebElement elementRegister = driver.findElement(By.xpath("//*[@id='submitAccount']"));
		elementRegister.click();
		System.out.print("\n" + "success Step9");
		
		// Step 10
		WebElement elementProCheckout2 = driver.findElement(By.xpath("//*[@id='center_column']/form/p/button"));
		elementProCheckout2.click();
		System.out.print("\n" + "success Step10");
		
		// Step 11
		WebElement elementAgreeTerms = driver.findElement(By.xpath("//*[@id='cgv']"));
		elementAgreeTerms.click();
		WebElement elementProCheckout3 = driver.findElement(By.xpath("//*[@id='form']/p/button"));
		elementProCheckout3.click();
		System.out.print("\n" + "success Step11");
		
		// Step 12
		WebElement elementPayment = driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a"));
		elementPayment.click();

		WebElement elementConfirmOrder = driver.findElement(By.xpath("//*[@id='cart_navigation']/button"));
		elementConfirmOrder.click();
		System.out.print("\n" + "success Step12");
		System.out.print("\n" + "\n" + "Automation Complated Successfully");
		endSession();
		System.out.print("\n" + "\n" + "Id for Ref");

		// *[@id="center_column"]/p[1]
		// *[@id="cart_navigation"]/button
		// *[@id="HOOK_PAYMENT"]/div[2]/div/p/a

		// *[@id="form"]/p/button

		// *[@id="cgv"]
		// *[@id="center_column"]/form/p/button
		// *[@id="submitAccount"]
		// *[@id="newsletter"]
		// *[@id="customer_firstname"]
		// *[@id="id_gender1"]
		// *[@id="SubmitCreate"]
		// *[@id="email_create"]
		// *[@id="center_column"]/p[2]/a[1]/span
		// *[@id="button_order_cart"]

		// *[@id="header"]/div[3]/div/div/div[3]/div/a
		// *[@id="layer_cart"]/div[1]/div[2]/div[4]/span/span
		// *[@id="add_to_cart"]/button
		// *[@id="uniform-group_1"]

    }
    
    public static WebElement getElement(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
 
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
 
			@Override
			public WebElement apply(WebDriver arg0) {
				return arg0.findElement(locator);
			}
 
		});
 
		return element;
	}
	public static void endSession() {
		driver.close();
		driver.quit();
	}

    }
