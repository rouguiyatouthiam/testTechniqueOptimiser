package com.test.technique.selenium.testCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.technique.selenium.page.Test_exercice_1;
import com.test.technique.selenium.page.Test_exercice_2;
import com.test.technique.selenium.utils.BrowserControl;



public class ExerciceTestCase {
	
	
	private BrowserControl bc;
	private StopWatch globalTime;
	private	Test_exercice_1 test_exercice_1;
	private Test_exercice_2 test_exercice_2;
	private String NomProduit2DeLaListe,NomProduitPageProduit;

	@Parameters({ "navigateur"})
	@BeforeTest
	public void setup( String navigateur) throws IOException
	{
	
		globalTime = new StopWatch();
		globalTime.start();
		bc = new BrowserControl(navigateur);;
		bc.launchURL(bc.getUrl());
		bc.implicitTimetWait(10);
	}
	
	
	@Test(description = "Ce test permet de verifier si on est à la page d'acueil")
	public void accueil()
	{
		Assert.assertEquals(bc.getUrl(),bc.currentURL());
		System.out.println("urls conformes");
	}
	
	
	@Parameters({"motRcherche"})
	@Test(description = "Ce test traite l'exercice 1",dependsOnMethods = "accueil")
	public void exercice_1(String motRechercher)
	{
		test_exercice_1 =new Test_exercice_1(this.bc);
		System.out.println("*******DEBUT EXERCICE 1************");
		
	    test_exercice_1.clickAccepterCookies();
	    System.out.println("Accepter cookies ok");
		test_exercice_1.clickBarreRecherche();
		System.out.println("cliquer icone rechercher depuis menu en haut ok");
		test_exercice_1.setMotRechercher(motRechercher);
		System.out.println("Saisit du mot à rechercher " + motRechercher +  " ok");
		test_exercice_1.clickBoutonRecherche();
		System.out.println("clique sur l'icone  rechercher ok");
		bc.waitSomeTime(2000);
		test_exercice_1.btnCloseSearchPage();
		System.out.println("clique sur l'icone  close recherche et retour à la page d'accueil ok");
		test_exercice_1.clickBarreRechercheBis();
		System.out.println("clique sur l'icone  rechercher depuis menu en haut ok");
		bc.waitSomeTime(20000);
		//System.out.println(test_exercice_1.getReccentSearch());
		Assert.assertEquals(test_exercice_1.getReccentSearch(),motRechercher);
		System.out.println("la rescente recherche affichée " + test_exercice_1.getReccentSearch() + " correspond au notre dernière recherche "  + motRechercher);
		test_exercice_1.clickReccentSearch();
		System.out.println("clique sur l'icone  rechercher ok");
		
		  for (String produit :test_exercice_1.getlistResultat()) {
		  
		  assertTrue(produit.contains(motRechercher));
		  
		  System.out.println("le produit "  +produit + " contient " + motRechercher); }
		  
		  bc.waitSomeTime(3000);
		  
		  NomProduit2DeLaListe =test_exercice_1.getProdui2tNameListProduct();
		  test_exercice_1.clickProduitDeuxListe();
		  System.out.println("clique sur le produit 2 de la liste des produits affichés ok");
		  NomProduitPageProduit=test_exercice_1.getProdui2tNamepageProduct();
		  Assert.assertEquals(NomProduitPageProduit,NomProduit2DeLaListe);
		  System.out.println("nom produit page produit = nom produit de la  liste produit ");
		 
		  System.out.println("*******FIN EXERCICE 1************");
	}
	
	
	
	  @Parameters({"quantite","nomProduit"})
	  @Test(description = "Ce test traite l'exercie 2", dependsOnMethods =  "accueil") 
	  public void exercice_2(String quantite,String nomProduit) 
	  {
	  test_exercice_2 = new Test_exercice_2(this.bc); 
	  System.out.println("*******DEBUT EXERCICE 2************");
	  
	  test_exercice_2. clickbtnMenuMakup();  
	  test_exercice_2. clickbtnMenuMakupLipstick(); 
	  bc.waitSomeTime(3000);
	  //scroller vers le ba  pour voir les produits
		/*
		 * JavascriptExecutor Js1 = (JavascriptExecutor) this.bc.getDriver();
		 * Js1.executeScript("window.scrollBy(250,0)");
		 */
	  
	  test_exercice_2.clickAddPanier(nomProduit);
	  
	  test_exercice_2. clickAjouterAuPanier();
	  bc.implicitTimetWait(30);
	//  bc.waitSomeTime(10000);
	  test_exercice_2. clickbtnbtnAfficherPanier(); 
	//scroll
	JavascriptExecutor jse =(JavascriptExecutor) bc.getDriver();
	jse.executeScript("window.scrollBy(0,250)");
	  
	  Assert.assertEquals(test_exercice_2. getProduitName(),nomProduit);
	  System.out.println("le produit affiché dans le panier est" +nomProduit);
	  Assert.assertEquals(test_exercice_2.getQuantitetProduiPanier(),quantite);
	  System.out.println("quantité produit =1");
	  
	  
	  Assert.assertEquals(test_exercice_2.getPrixUnitaireProduiPanier(),
	  test_exercice_2.getTotalPanier());
	  System.out.println("prix unitaire et prix total  conformes");
	  
	  System.out.println("*******FIN EXERCICE 2 OK************");
	  
	  }
	 
	
	 @AfterTest
	  public void browserClose() {
		
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
		  
	  }


}
