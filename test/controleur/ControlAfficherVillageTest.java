package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlAfficherVillageTest {
	private Village village;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 0);
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 1);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "test");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 0);
		village.installerVendeur(new Gaulois("personne", 0), "testing", 10);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 1);
	}

}
