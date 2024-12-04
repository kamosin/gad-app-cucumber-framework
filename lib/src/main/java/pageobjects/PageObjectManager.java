package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.articles.ArticlesPage;
import pageobjects.articles.NewArticleModal;
import pageobjects.flashposts.FlashpostsPage;
import pageobjects.surveys.SurveysPage;

public class PageObjectManager {

    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
        return new LandingPage(driver);
    }

    public RegistrationPage getRegistrationPage(){
        return new RegistrationPage(driver);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    public MyAccountPage getMyAccountPage(){
        return new MyAccountPage(driver);
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver);
    }

    public ArticlesPage getArticlesPage(){
        return new ArticlesPage(driver);
    }

    public NewArticleModal getNewArticleModal(){
        return new NewArticleModal(driver);
    }

    public FlashpostsPage getFlashpostsPage(){
        return new FlashpostsPage(driver);
    }

    public SurveysPage getSurveysPage(){
        return new SurveysPage(driver);
    }
}
