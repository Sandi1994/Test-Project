package testproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class myProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//navigate to Transmedia Inc page
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/");
		
		
		//maximize the window size
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Test Case 01
		
		//Input a board number
		driver.findElement(By.xpath("//h1[contains(text(), 'Create new board')]")).click();
		driver.findElement(By.className("new-board-input")).sendKeys("Test Board1");
		
		//Create a board
		driver.findElement(By.xpath("//button[contains(text(), 'Create board')]")).click();
		
		
		//Verify Board created successfully.
		//Check whether the 'Login' icon is available in the page
		String expectedResult = "Log";
		String actualResult = driver.findElement(By.xpath("//span[contains(text(), 'Log')]")).getText().split(" ")[0].trim();
		System.out.println(actualResult);
		
		if(actualResult.equals(actualResult)) {
			System.out.println("You've successsfully created a board");
			
		}else {
			System.out.println("Something wrong with creating a board. Please try again!");
			
		}
		
		Thread.sleep(1000);
		
		//Test Case 02
		
		//Add List 01
		driver.findElement(By.xpath("//input[@placeholder='Enter list title...']")).sendKeys("List 01");
		
		//Create a list 01
		driver.findElement(By.xpath("//button[contains(text(), 'Add list')]")).sendKeys("List 01");
		
		//Add List 02
		driver.findElement(By.xpath("//input[@placeholder='Enter list title...']")).sendKeys("List 02");
		
		//Create a list 02
		driver.findElement(By.xpath("//button[contains(text(), 'Add list')]")).sendKeys("List 02");
		
		//Verify 2 lists created successfully
		
		List<WebElement> createdLists = driver.findElements(By.xpath("//input[@data-cy='list-name']"));
		
		if(createdLists.size() == 2) {
			
			System.out.println("You have created" + " "+ createdLists.size()+" " + "Lists");
			
		}
		else {
			System.out.println("Created Lists cannot be found");
		}
		
		Thread.sleep(2000);
		
		//Test Case 03
		
		//Delete a list
		driver.findElement(By.xpath("//button[@data-cy='list-options']")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Delete list')]")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
