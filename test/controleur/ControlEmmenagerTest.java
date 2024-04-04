package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlEmmenagerTest {
	private Village village;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		controlEmmenager = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager);
	}

	@Test
	void testIsHabitant() {
		assertFalse(controlEmmenager.isHabitant("personne"));
		Gaulois personne = new Gaulois("personne", 0);
		village.ajouterHabitant(personne);
		assertTrue(controlEmmenager.isHabitant("personne"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(controlEmmenager.isHabitant("personne"));
		Druide personne = new Druide("personne", 0, 0, 0);
		controlEmmenager.ajouterDruide("personne", 0, 0, 0);
		assertTrue(controlEmmenager.isHabitant("personne"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(controlEmmenager.isHabitant("personne"));
		Gaulois personne = new Gaulois("personne", 0);
		controlEmmenager.ajouterGaulois("personne", 0);
		assertTrue(controlEmmenager.isHabitant("personne"));
	}

}
