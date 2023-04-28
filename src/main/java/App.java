import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    WebDriver driver;
    String BASE_URL ="https://www.instagram.com/";
    By usernameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator =new By.ByCssSelector("button[type='submit']");
    By instagramLogoLocator = new By.ByCssSelector("svg[class='_ab6-']");
    By infoLocator = By.className("g47SY");
    By postImageLocator = By.className("_aagw");
    By likeButtonLocator = new By.ByCssSelector("span._aamw");
    By postCountLocator = new By.ByCssSelector(" span._ac2a");
    By htmlTag = By.tagName("html");
    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }
    public void loginWith(String username , String password){
      waitFor(usernameLocator);
      driver.findElement(usernameLocator).sendKeys(username);
      driver.findElement(passwordLocator).sendKeys(password);
      driver.findElement(loginButtonLocator).click();
      waitFor(instagramLogoLocator);
    }
    public void navigateToProfile(String profileName){
        driver.navigate().to(BASE_URL.concat(profileName));
    }
    public void clickFirstPost(){
        driver.findElements(postImageLocator).get(0).click();
    }
    public void likeAllPost(int count){
        while (count > 0){
            waitFor(likeButtonLocator);
            driver.findElement(likeButtonLocator).click();
            driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
            count -- ;
        }
    }
    public int getPostCount(){
        String count = driver.findElement(postCountLocator).getText();
        return Integer.parseInt(count);
    }

    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver , 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
