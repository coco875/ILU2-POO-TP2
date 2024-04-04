package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche() {
		assertEquals(controlAfficherMarche.donnerInfosMarche().length, 0);
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertEquals(controlAfficherMarche.donnerInfosMarche().length, 1);
	}

}
