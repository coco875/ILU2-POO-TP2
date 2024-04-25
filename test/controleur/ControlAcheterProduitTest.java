package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlAcheterProduit controlAcheterProduit;
	
	@BeforeEach
	void setUp() {
		village = new Village("test", 1, 1);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit);
	}
	
	@Test
	void testVerifierIdentite() {
		assertFalse(controlAcheterProduit.verifierIdentite("personne"));
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		assertTrue(controlAcheterProduit.verifierIdentite("personne"));
	}
	
	@Test
	void testTrouverVendeurProduit() {
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertEquals(controlAcheterProduit.trouverVendeurProduit("testing").length, 1);
		assertEquals(controlAcheterProduit.trouverVendeurProduit("nothing").length, 0);
	}
	
	@Test
	void testTrouverAcheterProduit() {
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertEquals(controlAcheterProduit.trouverAcheterProduit(5,"personne"), 5);
		assertEquals(controlAcheterProduit.trouverAcheterProduit(0,"nothing"), 0);
	}

}
