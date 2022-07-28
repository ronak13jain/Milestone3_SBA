package mindtree.ProjectMilestone;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class Selenium {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//step 1
        driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='/hovers']")).click();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[1]"))).build().perform();
		String name =driver.findElement(By.xpath("(//div[@class='figure'])[1] //h5")).getText();
		System.out.println(name);
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 2
		driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 3
		driver.findElement(By.xpath("//div[@id='content'] //a[@href='/inputs']")).click();
		driver.findElement(By.xpath("//div[@class='example'] //input [@type='number']")).sendKeys("6754");
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 4
		driver.findElement(By.xpath("//a[contains(@href,'dropdown')]")).click();
		Select sel1=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		sel1.selectByVisibleText("Option 2");
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 5
		driver.findElement(By.xpath("//li //a[@href='/upload']")).click();
		//driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).click();
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 6
		driver.findElement(By.xpath("//a[contains(@href,'tables')]")).click();
		String email =driver.findElement(By.xpath("//table[@id='table1'] //tr[4] //td[3]")).getText();
		System.out.println(email);
		String website =driver.findElement(By.xpath("//table[@id='table1'] //tr[4] //td[5]")).getText();
		System.out.println(website);
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 7
		driver.findElement(By.xpath("//a[@href='/key_presses']")).click();
		driver.findElement(By.id("target")).sendKeys(Keys.DIVIDE);
		String key =driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(key);
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 8
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//div [@class='example'] //a[@href='/windows/new']")).click();
		Set<String> Str2=driver.getWindowHandles();
		Iterator <String> iterator1=Str2.iterator();
		String p_screen=iterator1.next();
		String n_screen=iterator1.next();
		driver.switchTo().window(n_screen);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement webele=driver.findElement(By.tagName("h3"));
		String Text=webele.getText();
		System.out.println(Text);
		driver.get("http://the-internet.herokuapp.com/");
		
		//step 9
		driver.findElement(By.xpath("//a[contains(@href,'context')]")).click();
		action.moveToElement(driver.findElement(By.xpath(("//div[@class='large-12 columns'] //div[@id='hot-spot']")))).contextClick().build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		
		
	}

}
