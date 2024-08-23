package projectauto;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//SAMPLE TESTS REGARDING THE ASSIGNMENT AND SELECTORS TO INTERACT WITH WEB ELEMENTS.

public class ProjectAuto
{
	WebDriver driver;
	// Sets up the WebDriver before running any tests and  set the path to your EdgeDriver executable.
	 @BeforeClass
	    public void setUp() {
		// Set the driver path
		 System.setProperty("webdriver.edge.driver", "C://EdgeDriver.exe");
		//InitiLaize the edge WebDriver 
	        WebDriver driver = new EdgeDriver();
	       driver.manage().window().maximize();
	    }
	
	
	@Test
	public void task1() 
	{
      //TEST1

		//Navigate to the HomePage
		driver.get("file:///C:/Users/Lenovo/AppData/Local/Temp/ad211f29-abf7-4c4f-92e4-22b9da75bc36_AutomationChallenge_2022.zip.c36/QE-index.html");
		//Assert that both the email address and password inputs are present as well as the login button and Enter in an email address and password combination into the respective fields
		driver.findElement(By.id("inputEmail")).sendKeys("test@example.com");
		driver.findElement(By.id("inputpassword")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();	
      
	  //TEST2
		
		//Navigate to the HomePage
		driver.get("file:///C:/Users/Lenovo/AppData/Local/Temp/d18db6aa-42c3-419d-8b4d-6ec6eb4f6835_AutomationChallenge_2022.zip.835/QE-guide.html");
		//In the test 2 div, assert that there are three values in the ListGroup
		List<WebElement> listitems = driver.findElements(By.xpath("//*[@id=\"test-2-div\"]/ul"));
	    Assert.assertEquals(listitems.size(), 3);
	    
        //Assert that the second list item's value is set to "List Item 2"
	    WebElement secondListItem = listitems.get(1);
        Assert.assertEquals(secondListItem.getText().trim(), "List Item 2");
        
        //Assert that the second list item's badge value is 6
        WebElement secondListItemBadge = secondListItem.findElement(By.xpath("//*[@id=\"test-2-div\"]/ul/li[2]/span"));
        Assert.assertEquals(secondListItemBadge.getText().trim(), "6");
        
      //TEST3 
        
        //Navigate to the HomePage
        driver.get("file:///C:/Users/Lenovo/AppData/Local/Temp/d18db6aa-42c3-419d-8b4d-6ec6eb4f6835_AutomationChallenge_2022.zip.835/QE-guide.html");
        
        //In the test 3 DIV, assert that "Option 1" is the default selected value

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"test-3-div\"]/div/div/a[1]"));
        WebElement selectedOption = dropdown.findElement(By.xpath("//*[@id=\"test-3-div\"]/div/div/a[3]"));
        Assert.assertEquals(selectedOption.getText().trim(), "Option 1");

        // Select "Option 3" from the select list
        dropdown.findElement(By.xpath("//*[@id=\"test-3-div\"]/div/div/a[3]")).click();
      
     //TEST4
        
         //Navigate to the HomePage
        driver.get("file:///C:/Users/Lenovo/AppData/Local/Temp/d18db6aa-42c3-419d-8b4d-6ec6eb4f6835_AutomationChallenge_2022.zip.835/QE-guide.html");
        
        //In the test 4 DIV, assert that the first button is enabled and that the second button is disabled
        WebElement firstButton = driver.findElement(By.xpath("//*[@id=\"test-4-div\"]/button[1]"));
        WebElement SecondButton = driver.findElement(By.xpath("//*[@id=\"test-4-div\"]/button[2]"));
        Assert.assertTrue(firstButton.isEnabled());
        Assert.assertFalse(SecondButton.isEnabled());
        
     //TEST5
        
        //Navigate to the HomePage
        driver.get("file:///C:/Users/Lenovo/AppData/Local/Temp/d18db6aa-42c3-419d-8b4d-6ec6eb4f6835_AutomationChallenge_2022.zip.835/QE-guide.html");
        
        //In the test 5 DIV, wait for a button to be displayed (note: the delay is random) and then click it
        WebElement ElemButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id=\"test5-button\"])")));
        ElemButton.click();		
        
        //Once you've clicked the button, assert that a success message is displayed
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"test5-alert\"]")); 
        Assert.assertTrue(successMessage.isDisplayed()); 
        
        // Assert that the button is now disabled 
        Assert.assertFalse(ElemButton.isEnabled());
        
     //TEST6
        
         //Navigate to the HomePage
        driver.get("file:///C:/Users/Lenovo/AppData/Local/Temp/d18db6aa-42c3-419d-8b4d-6ec6eb4f6835_AutomationChallenge_2022.zip.835/QE-guide.html");
        
        //Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
        String cellValue = getCellValue(2, 2);

        // Assert that the value of the cell is VentoSanzap
        Assert.assertEquals(cellValue, "Ventosanzap");
    }

    // Method to find the value of any cell in the grid
    public String getCellValue(int row, int col) {
        WebElement cell = driver.findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table/tbody"));
        return cell.getText().trim();
    }
    
    // Cleans up by closing the browser after tests are complete.
    @AfterClass
    public void close() {
    	driver.quit();
}
	
}
	
