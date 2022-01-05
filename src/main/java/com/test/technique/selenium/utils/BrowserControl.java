package com.test.technique.selenium.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserControl {
	
	private WebDriver driver;
	private String driverType; 
	private String driverPath;
	private GetPropertyValues myvalues;
	private WebDriverWait t;
	
	/** Cette méthode permet de renvoyer le driver utilisé.
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/** Cette méthode permet de définir le driver à utiliser : Chrome, IE ou Firefox.
	 * 
	 * @return
	 */
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * C'est le controleur de la classe. Elle permet d'initialiser le driver sur lequel toutes les autres actions seront 
	 * effectuées à celui passé en paramètres lors de l'instanciation d'un objet de type BrowserControl. 
	 * @param driver
	 */
	public BrowserControl(String navigateur) throws IOException
	{
		
		
		myvalues = new GetPropertyValues();
		this.driverType = myvalues.getDriverType(navigateur);
		this.driverPath = myvalues.getDriverPath(navigateur);
		System.setProperty(this.driverType, this.driverPath);
		
		if(navigateur.equals("chrome"))
		{
			this.driver = new ChromeDriver();
		}
		
		if(navigateur.equals("ie"))
		{
			this.driver = new InternetExplorerDriver();
		}
		if(navigateur.equals("firefox"))
		{
			this.driver = new FirefoxDriver();
		}
	
	}
	
	/**
	 * Cette métode permet de recuperer l'url du site se trouvant dans le fichier proporties.
	 */
	public String  getUrl()
	{
		return this.driverType = myvalues.getUrlSite();
	}
	
	/**
	 * Cette métode permet de fermer le navigateur de test. Elle est souvent utilisé à la fin des tests.
	 */
	public void closeBrowser()
	{
		this.driver.close();
	}
	
	/**
	 * Cette méthode permet d'accéder à une application à partir de l'url fourni en paramètre.
	 * @param appUrl
	 */
	public void launchURL(String appUrl)
	{
		this.driver.get(appUrl);
		
		this.driver.manage().window().maximize();
	}
	
	
	/**
	 * Cette méthode permet de recuper l'url de la pge courante.
	 * retourne une chaine
	 */
	public String currentURL()
	{
		String urlCourrant=this.driver.getCurrentUrl();
		return urlCourrant;
	}
	
	
	
	/**
	 * Cette méthode permet de faire une attente implicite.
	 * @param time
	 */
	public void implicitTimetWait(long time)
	{
		this.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
	
	/**
	 * Cette méthode permet de faire une attente explicit que l'élément soit visible et cliquable.
	 * @param time
	 */
	public void explicitTimet(long time,WebElement element)
	{
		t = new WebDriverWait(this.getDriver(), time); 
		t.until(ExpectedConditions.visibilityOf(element));  
 		t.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * Cette méthode permet de faire l'action click sur un element non interceptable .
	 * @param time
	 */
		public void clickAction(WebElement element)
		{
			Actions builder = new Actions(this.getDriver());
	 		builder.moveToElement(element).click(element);
	 		builder.perform();
		}
		

			
	
	/**
	 * Cette méthode permet de faire une pause de X millisecondes.
	 * @param time
	 */
	public void waitSomeTime(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
