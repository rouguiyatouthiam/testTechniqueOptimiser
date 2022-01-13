package com.test.technique.selenium.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.technique.selenium.utils.BrowserControl;

public class Test_exercice_1 
{
	   BrowserControl bc;
	   String productName;
	   String Produit2NameListProduct,Produit2NamepageProduct;
	   ArrayList<String> listResultat = new ArrayList<String>();

	   
	   @FindBy(xpath="//*[@id=\"onetrust-accept-btn-handler\"]")
		private WebElement  btn_validerCookies;
	   
	
	   @FindBy(xpath="//button[@data-test='btnSearch_Header_Disabled']")
	   private WebElement  barre_de_recherche;
	   public String strBarreDeRecherche="//button[@data-test='btnSearch_Header_Disabled']";
	   public boolean isstrBarreDeRecherche ;
	   
	   
	   @FindBy(id="searchInput")
	   private WebElement  zone_recherche;
	   public String strZoneRecherche="searchInput";
	   public boolean isZoneRecherche ;
	   
	   
	   
	   @FindBy(xpath="//button[@data-test='btnSubmitSearch']")
	   private WebElement  btn_rechercher;
	   
	   
	    @FindBy(xpath="//div[@class='product-list-inline']/div[2]/a/h4/span")
	    private   List<WebElement>list_product;
	   
	    
	    @FindBy(xpath="//div[@class='product-list-inline'][2]/div[2]/a")
		private WebElement  produit_2_listProduit;
	    
	    
	    @FindBy(xpath="//div[@class='product-list-inline'][2]/div[2]/a/h4/span")
		private WebElement  Product2NameListProduct;
	    
	    @FindBy(xpath="//span[@data-test='lblProductTitle']")
		private WebElement  Product2NamePageProduct;
	    
	    
	    @FindBy(xpath="//*[@data-test='btnCloseSerach']/span")
	  	private WebElement  btnClose;
	    public String strClose="//*[@data-test='btnCloseSerach']/span";
	    public boolean isBtnClose ;
	    
	    @FindBy(xpath = "//button[@data-test='lblRecentSearchData']")
	  	private WebElement  lRecentSearch;
	    String strRecentSearch="//button[@data-test='lblRecentSearchData']";
	    public boolean isRecentSearch ;
	    
	    public String strLogoHP="//img[@data-test='lnkLogo']";
	    public boolean isLogoHP ;
	    
	    /**
		 * Constructeur: Initialisation des éléments
		 * @param driver
		 */
		public Test_exercice_1(BrowserControl bc)
		{
			this.bc = bc;
			PageFactory.initElements(bc.getDriver(), this);
		}
		
		/**
		 * Cette fonction permet de valider les cookies
		 *
		 */
	 	public void clickAccepterCookies()
	 	{
	 		this.btn_validerCookies.click();
	 	}
		
		/**
		 * Cette fonction permet de cliquer sur la barre de recherche depuis HP
		 *
		 */
	 	public void clickBarreRecherche()
	 	{
	 		this.barre_de_recherche.click();
	 	}
	 	
	 	
	 	/**
		 * Cette fonction permet de cliquer sur la barre de recherche depuis HP
		 *
		 */
	 	public void clickBarreRechercheBis()
	 	{
			
	 		this.bc.clickAction(barre_de_recherche);
	 	}
	 	
	 	/**
		 * Cette fonction permet de saisir la valeur à rechercher
		 *
		 */
	 	public void setMotRechercher(String motRecherche)
	 	{
	 		this.zone_recherche.clear();
	 		this.zone_recherche.sendKeys(motRecherche);
	 	}
	 	
	 	/**
		 * Cette fonction permet de cliquer sur le bouton rechercher après avoir saisit le mot
		 *
		 */
	 	public void clickBoutonRecherche()
	 	{
	 		this.btn_rechercher.click();
	 	}
	 	
	 	/**
		 * Cette fonction permet de parcourir la liste des resultats et de renvoyer le nom de chaque produit affiché
	 	 * @return 
		 *
		 */
			 	public  ArrayList<String> getlistResultat()
			 	{
			 		 for (WebElement ele:list_product) { 
					     productName = ele.getText().toUpperCase();
					     listResultat.add(productName);
					     
			 	}
					return listResultat;
			}
			 	
			 	/**
				 * Cette fonction permet de cliquer sur leproduit 2 de la liste
				 *
				 */
			 	public void clickProduitDeuxListe()
			 	{
			 		this.produit_2_listProduit.click();
			 	}
			 	
			 	
			 	/**
				 * Cette fonction recuperer le nom du produit 2 de la liste
				 *
				 */
			 	public String  getProdui2tNameListProduct()
			 	{
			 	 return Produit2NameListProduct=	this.Product2NameListProduct.getText().toUpperCase();
			 	}
			 	
			 	
			 	/**
				 * Cette fonction recuperer le nom du produit 2 depuit sa page détails
				 *
				 */
			 	public String  getProdui2tNamepageProduct()
			 	{
			 	 return Produit2NamepageProduct=	this.Product2NamePageProduct.getText();
			 	}
			 	
			 	
			 	/**
				 * Cette fonction permet de fermer la page de recherche
				 *
				 */
			 	
			 	
			 	public void clickBtnCloseSearchPage()
			 	{
			 		   bc.clickAction(btnClose);;
			 		   //this.bc.clickAction(btnClose);

			 	
			 	}
			 	
			 	
			 	/**
				 * Cette fonction me permet de recuper la valeur du reccent search
				 *
				 */
			 	
			 	
			 	public String getReccentSearch()
				{

			 			
					/*  Actions builder = new Actions(bc.getDriver());
					  builder.moveToElement(lRecentSearch);
					  builder.perform();*/
					  
					  bc.explicitTimet(60, lRecentSearch);
					  return this.lRecentSearch.getText().toUpperCase();
					 
					 
					
					 /* WebDriverWait wait = new WebDriverWait(bc.getDriver(), 120);
					  wait.until(ExpectedConditions.elementToBeClickable(lRecentSearch)); return
					  this.lRecentSearch.getText().toUpperCase();*/
					  
					  
						/*
						 * WebElement navigationPageButton = (new WebDriverWait(bc.getDriver(), 10))
						 * .until(ExpectedConditions.presenceOfElementLocated(By.xpath(strLRecentSearch)
						 * )); return lRecentSearch.getText().toUpperCase();
						 */
			 		}
			 	
			 	
			 	
				/**
				 * Cette fonction me permet de cliquer la valeur du reccent search
				 *
				 */
			 	
			 	
			 	public void clickReccentSearch()
				{

			 		 this.lRecentSearch.click();
			 	
			 	}
			 	
			 	
			 	/**
				 * Cette fonction me permet de verifier si le bouton close est visible
				 *
				 */
			 	
			 	public boolean isBtnClose()
			    {
			 		isBtnClose=false;
					WebElement close = bc.getElementByXPath(strClose);
						
						
						if(null != close)
						{
							isBtnClose=true;
							
							System.out.println("le bouton close est visble");
						}
						else
						{
							System.out.println(" bouton close n'est pas visible ");
						}
						
					
					return isBtnClose;
				}
		
			 	
			 	/**
				 * Cette fonction me permet de verifier si le bouton close est visible
				 *
				 */
			 	
			 	public boolean isLogoHP()
			    {
			 		isLogoHP=false;
					WebElement logoHP = bc.getElementByXPath(strLogoHP);
						
						
						if(null != logoHP)
						{
							isLogoHP=true;
							
							System.out.println("retour HP OK");
						}
						else
						{
							System.out.println(" retour HP KO ");
						}
						
					
					return isLogoHP;
				}
		
			 	
			 	
			 	
			 	/**
				 * Cette fonction me permet de verifier si le LABEL rescent search est visible
				 *
				 */
			 	
			 	public boolean isRecentSearch()
			    {
			 		isRecentSearch=false;
					WebElement recentSearch = bc.getElementByXPath(strRecentSearch);
						
						
						if(null != recentSearch)
						{
							isRecentSearch=true;
							
							System.out.println("RecentSearch OK");
						}
						else
						{
							System.out.println(" isRecentSearch KO ");
						}
						
					
					return isRecentSearch;
				}
		
			 	
			 	/**
			 	 * Cette fonction me permet de verifier si la zone de recherche  est visible
				 * 
				 *
				 */
			 	
			 	public boolean isZoneRecherche()
			    {
			 		isZoneRecherche=false;
					WebElement zoneRecherche = bc.getElementByID(strZoneRecherche);
						
						
						if(null != zoneRecherche)
						{
							isZoneRecherche=true;
							
							System.out.println("Accès Page Recherche OK");
						}
						else
						{
							System.out.println(" Accès page recherche KO ");
						}
						
					
					return isZoneRecherche;
				}
		
			 	
			 	/**
			 	 * Cette fonction me permet de verifier si le bouton rechercher est visible depuis la homepage
				 * 
				 *
				 */
			 	
			 	public boolean isBarreDeRechercheHP()
			    {
			    	isstrBarreDeRecherche=false;
					WebElement barreRecherche = bc.getElementByXPath(strBarreDeRecherche);
						
						
						if(null != barreRecherche)
						{
							isstrBarreDeRecherche=true;
							
							System.out.println("Affichge barre de recherche depuis HP OK");
						}
						else
						{
							System.out.println(" Affichge barre de recherche depuis HP OK KO ");
						}
						
					
					return isstrBarreDeRecherche;
				}
		
			 	
}
