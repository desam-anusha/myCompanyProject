package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Locators;
import utilities.Properties;
import utilities.BaseDriver;


public class LoginPage extends BaseDriver{
	
	public LoginPage(WebDriver driver){
		BaseDriver.driver = driver;
		PageFactory.initElements(BaseDriver.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.USER_NAME_FIELD)
	WebElement emailBox;
	@FindBy(how = How.XPATH, using = Locators.PASSWORD_FIELD)
	WebElement passWordBox;
	@FindBy(how = How.XPATH, using = Locators.LOGIN_BUTTON)
	WebElement loginButton1;
	@FindBy(how = How.XPATH, using = Locators.SEARCH_DROPDOWN)
	WebElement searchDropdown;
	@FindBy(how = How.XPATH, using = Locators.SEARCH_LOCATION)
	WebElement searchLocation;
	@FindBy(how = How.XPATH, using = Locators.LOGIN_NAME)
	WebElement loginName;
	@FindBy (how = How.XPATH, using = Locators.LOGIN_PASSWORD)
	WebElement loginPassword;
	
	
	
	public boolean validate_loginPage1(ExtentReports logger) {
		if( loginName.isEnabled()) {
			System.out.println("Actual result: EMDM Company Home page loaded succesfully\n");
			logger.log(LogStatus.PASS, "Actual result: EMDM Company Home Page Loaded\\n");
			return true;
		}
		else {
			System.out.println("EMDM Company Home Page not loaded\n");
			logger.log(LogStatus.FAIL, "EMDM Company Page Home Page not loaded\n");
			return false;
		}
	}
	
	public void login_page(ExtentReports logger) {
		try {
			
				new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(loginName));
				if(loginName.isEnabled()) {
					loginName.click();
					loginName.sendKeys(Properties.LOGIN_NAME);
				new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(loginPassword));
				if(loginName.isEnabled()) {
					loginPassword.click();
					loginPassword.sendKeys(Properties.LOGIN_PASSWORD);
				
				new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(loginButton1));
				if(loginButton1.isEnabled()) {
					loginButton1.click();
				} else {
				System.out.println("Can not login to EMDM Page");
				logger.log(LogStatus.FAIL,"Can not login to EMDM Page|");
			}
			}
			}
				
				}catch(Exception ex) {
					System.out.println(ex);
				}
	}
			

	public void user_Login(String userName, String userPassword){
		
		try {
			
			//System.out.println("Driver" + driver);
			//System.out.println("EmailBox:" + emailBox);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(emailBox));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(passWordBox));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(loginButton1));
			
			if (emailBox.isEnabled()) {
				emailBox.sendKeys(userName);
			}else {
				System.out.println("User name box is not Enabled");
			}
			if (passWordBox.isEnabled()) {
				passWordBox.sendKeys(userPassword);
			}else {
				System.out.println("Password box is not Enabled");
			}
			if (loginButton1.isEnabled()) {
				loginButton1.click();
			}else {
				System.out.println("Login button is not Enabled");
			}
			
			
			try {
				driver.findElement(By.xpath("//div[@class=\'alert alert-danger\']//span[@_ngcontent-c3]"));
				System.out.println("	SignIn Unsuccessfull. Please check credentials");
				throw new RuntimeException();
				
			}
			catch(NoSuchElementException ex) {
				System.out.println("	Login Successfully");
			}
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}


		
		
	}


