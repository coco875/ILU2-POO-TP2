package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("personne"));
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("personne"));
	}

}
