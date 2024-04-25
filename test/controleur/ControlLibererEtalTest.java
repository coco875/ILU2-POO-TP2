package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		assertFalse(controlLibererEtal.isVendeur("personne"));
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertTrue(controlLibererEtal.isVendeur("personne"));
	}

	@Test
	void testLibererEtal() {
		assertFalse(controlLibererEtal.isVendeur("personne"));
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		village.installerVendeur(personne, "testing", 10);
		assertTrue(controlLibererEtal.isVendeur("personne"));
		String[] donneesEtal = controlLibererEtal.libererEtal("personne");
		assertEquals(donneesEtal[0], "true");
		assertEquals(donneesEtal[1], "personne");
		assertEquals(donneesEtal[2], "testing");
		assertEquals(donneesEtal[3], "10");
		assertEquals(donneesEtal[4], "0");
		assertFalse(controlLibererEtal.isVendeur("personne"));
	}

}
