package GlueCode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition
{
WebDriver driver;

@Given("User opens chrome browser")
public void user_opens_chrome_browser() {
    
	
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();    // driver=111222
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	driver.manage().window().maximize() ;	

}
@Then("User opens URL{string}")
public void user_opens_url_https_opensource_demo_orangehrmlive_com_web_index_php_auth_login(String TestURL) {
    
	
	driver.get(TestURL);
}
@Given("User entres Username as {string} and Password as {string}")
public void user_entres_username_as_and_password_as(String UserName1, String PassWord1) {
    
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName1);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PassWord1);
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	
	
	
}
@When("User creates Skills record")
public void user_creates_skills_record(io.cucumber.datatable.DataTable dataTable) throws Exception {
    
	List<List<String>> Skillsdata=dataTable.cells();
	
	System.out.println("Number of rows:"+Skillsdata.size());
	
	for(int i=0;i<Skillsdata.size();i++) {
		
	//System.out.println(Skillsdata.get(i).get(0));
	
	String SkillName=Skillsdata.get(i).get(0);
	
	String SkillDescription=Skillsdata.get(i).get(1);
	
	System.out.println("_______________________");
	
	driver.findElement(By.xpath("//span[text()='Admin']")).click();
	driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
	driver.findElement(By.xpath("//a[text()='Skills']")).click();
	driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(SkillName);
	driver.findElement(By.xpath("//textarea[ @placeholder='Type description here']")).sendKeys(SkillDescription);
	driver.findElement(By.xpath("//button[text()=' Save ']")).click();

}
}
@Then("User close browser")
public void user_close_browser() {
    driver.close();
}
}
