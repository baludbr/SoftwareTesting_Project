import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class Login {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.edgedriver().setup();
            WebDriver driver=new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://lms.kluniversity.in/login/index.php");
            driver.manage().window().maximize();
            driver.findElement(By.id("username")).sendKeys("2100031888");
            driver.findElement(By.id("password")).sendKeys("password");
            driver.findElement(By.id("password")).submit();
            Thread.sleep(3000);
            driver.findElement(By.className("usertext")).click();
            Thread.sleep(3000);
            List<WebElement> menubars = driver.findElements(By.xpath("//a/span"));
            for(WebElement option : menubars) {
                if(option.getText().equalsIgnoreCase("Log out")){
                    option.click();
                    break;
                }
            }
        }

}
