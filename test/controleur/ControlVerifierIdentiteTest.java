package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlVerifierIdentiteTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controlVerifierIdentite.verifierIdentite("personne"));
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		assertTrue(controlVerifierIdentite.verifierIdentite("personne"));
	}

}
