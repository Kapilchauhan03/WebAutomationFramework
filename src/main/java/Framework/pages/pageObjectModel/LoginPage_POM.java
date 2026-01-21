package Framework.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage_POM {

        // This POM contains Page locator & page action

        WebDriver driver;
        public LoginPage_POM(WebDriver driver){
            this.driver = driver;
        }
        // private here we want encapsulation here & they can be use by getter setter

        private By username = By.id("login-username");
        private By password = By.id("login-password");
        private By signButton = By.id("js-login-btn");
        private By error_message = By.id("js-notification-box-msg");

        // page Action

        public String loginVWOInvalidCreds(String user, String pwd){
            driver.get("https://app.vwo.com");
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(signButton).click();

            try{
                Thread.sleep(3000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            WebElement error_msg = driver.findElement(error_message);
            String error_msg_text = error_msg.getText();
            return error_msg_text;

        }
    }


