package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		assertEquals(controlPrendreEtal.prendreEtal("personne", "testing", 10), 0);
		Gaulois personne2 = new Gaulois("personne2", 1);
		village.ajouterHabitant(personne2);
		assertEquals(controlPrendreEtal.prendreEtal("personne2", "testing", 10), -1);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controlPrendreEtal.verifierIdentite("personne"));
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		assertTrue(controlPrendreEtal.verifierIdentite("personne"));
	}

}
