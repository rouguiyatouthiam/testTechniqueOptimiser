package com.test.technique.selenium.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.technique.selenium.utils.BrowserControl;

public class Test_exercice_2 

{
	         BrowserControl bc;
	         String productNamePanier,quantite,prix_unitaire,total,strProductName;
	         
	         
	         @FindBy(id=("makeup"))
				private WebElement  btn_MenuMakup;
	         
	         @FindBy(xpath=("//a[@data-linkname='Lipstick']"))
			 private WebElement  btn_MenuMakupLipstick;
	         
	       
	         //
	         @FindBy(xpath="//div[@data-position-mobile]/article/div[2]/div[1]/p/a/span[2]")
	 	     private   List<WebElement>list_lipstickt;
	         
			
	         @FindBy(xpath=("//button[@data-id='151107'][2]"))
			 private WebElement  btn_AjouterProduitAuPanier;
	
			
			@FindBy(xpath=("//button[@data-test='btnAddtocart_StickBar']"))
			private WebElement  btn_AjouterAuPanier;
			
			
			@FindBy(xpath=("//a[@data-test='btnReviewBag']"))
			private WebElement  btn_AfficherPanier;
	
			//*[@id="151107"]/span[1]
			@FindBy(xpath=( "//a[@data-test='secProductName_1'][1]/span[1]"))
			private WebElement  productName;
			
		
			
			@FindBy(xpath=( "//select[@id='prd1']/option[1]" ))
			private WebElement  quantite_panier;
			
			@FindBy(xpath=("//div[@data-test='lblPrice_orderSummary']" ))
			private WebElement  prixUnitaire_panier;
			
			@FindBy(xpath=("//td[@data-test='lblTotalPrice_CartOverview']" ))
			private WebElement  total_panier;
	
	   /**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
			public Test_exercice_2(BrowserControl bc)
			{
				this.bc = bc;
				PageFactory.initElements(bc.getDriver(), this);
			}
			
			
			/**
			 * Cette fonction permet de cliquer sur le menu Makup
			 *
			 */
		 	public void clickbtnMenuMakup()
		 	{
		 		
		 		bc.explicitTimet(10, btn_MenuMakup);
		 		this.btn_MenuMakup.click();
		 	}
		 	
		 	
		 	
			/**
			 *Cette fonction permet de cliquer sur lipstick depuis le menu Makup
			 *
			 */
		 	public void clickbtnMenuMakupLipstick()
		 	{
				
		 		this.btn_MenuMakupLipstick.click();
		 	}
			
		 	
		 	
		 	
			/**
			 * Cette fonction permet de cliquer sur le bouton ajouter au panier depuis la page hub des lipstick
			 *
			 */
		 	public void clickBtnAjouterProduitAuPanier()
		 	{
		 		this.btn_AjouterProduitAuPanier.click();
		 	}
			
		 	
		 	/**
			 * Cette fonction permet d ajouter le produit  au panier depuis le popup
		 	 * @throws Exception 
			 *
			 */
		 	public void clickAjouterAuPanier() 
		 	{
		 		//scroller jusqu'à voir l'élément ajouter au panier du produit Rouge allure
		 		//((JavascriptExecutor) this.bc.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btn_AjouterAuPanier);;
		 		
		 		this.btn_AjouterAuPanier.click();
		 	}
			
		 	
			/**
			 * Cette fonction permet de ferer le popup panier
			 *
			 */
		 	public void clickbtnbtnAfficherPanier()
		 	{
		 		bc.explicitTimet(10, btn_AfficherPanier);
		 		this.btn_AfficherPanier.click();
		 	}
		 	
		 	
		
		 	
		 	/**
			 * Cette fonction permet de recuperer le nom du produit depuis la page hub lipstick
			 *
			 */
			
			  public String getProduitName() 
			  { 
				  return productNamePanier =   this.productName.getText().toUpperCase();
				  
			  }
			  
			 
			  
			  /**
				 * Cette fonction permet de recuperer la quantité du produit dans la page panier
				 *
				 */
				
				  public String getQuantitetProduiPanier() 
				  { 
					 
					   quantite =   this.quantite_panier.getAttribute("value");
					 
					  return quantite;
					  
				  }
				  
				  /**
					 * Cette fonction permet de recuperer le prix unitaire du produit dans le  panier
					 *
					 */
					
					  public String getPrixUnitaireProduiPanier() 
					  { 
						   prix_unitaire =   this.prixUnitaire_panier.getText().replaceAll("[^0-9 . ]", "");
						  return prix_unitaire;
						  
					  }
					  
					  
					  /**
						 * Cette fonction permet de recuperer le montant total du panier
						 *
						 */
						
						  public String getTotalPanier() 
						  { 
							  //return total =   this.total_panier.getText();
							 total =   this.total_panier.getText().replaceAll("[^0-9 .]", "");
							return total.replaceAll("\\s+","");
							  
						  }
						   
						  
						  	/**
							 * Cette fonction permet de parcourir la liste des lipstick et de cliquer sur rouge allure
						 	 * @return 
							 *
							 */
								 	public  void  clickAddPanier(String nomProduit)
								 	
								 	 {	
								 		System.out.println("nom produit en param" +nomProduit );
								 		 for (WebElement ele:list_lipstickt)
								 		 { 
								 			 
										     strProductName = ele.getText().toUpperCase();
										     System.out.println("nom produit liste" +strProductName);
										     
										     if(strProductName.equals(nomProduit))
										     { 
										    	 this.clickBtnAjouterProduitAuPanier();
										    	 
										    	 break;
										     }
										     	 
										     
								 	    }
								 	   
								 	    	
										
								}
}
