import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class Table {

    WebDriver driver = new ChromeDriver();
    String website = "C:\\Users\\Owner\\eclipse-workspace\\TableTest\\TableTest(HTML, CSS)\\TableTest.html";

    @BeforeTest
    public void SetUp() {
        driver.get(website);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void Tables() {
        // Test 1: Print row only if "Pass" column value is "Yes"
        System.out.println("Test 1: Rows where Pass = Yes");

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        
        for (int i = 1; i < rows.size(); i++) { // Start at index 1 to skip the header row
           
        	WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String passStatus = columns.get(3).getText(); // "Pass" column is the 4th (index 3)
            
            if (passStatus.equals("Yes")) {
                System.out.println(row.getText());
            }
            
        }

        // Test 2: Print any column randomly
        System.out.println("\nTest 2: Random Column");
        Random random = new Random();
        int randomColumnIndex = random.nextInt(4) + 1; // Random index for columns (1 to 4)

        List<WebElement> columnData = driver.findElements(By.xpath("//table//tr/td[" + randomColumnIndex + "]"));
        
        for (int i = 0; i < columnData.size(); i++) {
            System.out.println(columnData.get(i).getText());
        }
        
    }
    
}
