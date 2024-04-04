package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		assertFalse(controlAcheterProduit.verifierIdentite(""));
		assertTrue(controlAcheterProduit.verifierIdentite("personne"));
	}
	
	@Test
	void testTrouverVendeurProduit() {
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertEquals(controlAcheterProduit.trouverVendeurProduit("testing").length, 1);
		assertEquals(controlAcheterProduit.trouverVendeurProduit("nothing").length, 0);
	}
	
	@Test
	void testTrouverAcheterProduit() {
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertEquals(controlAcheterProduit.trouverAcheterProduit(5,"testing"), 5);
		assertEquals(controlAcheterProduit.trouverAcheterProduit(0,"nothing"), 0);
	}

}
