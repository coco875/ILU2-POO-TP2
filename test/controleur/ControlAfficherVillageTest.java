package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 1);
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 2);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "test");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 1);
	}

}
