package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("test", 1, 1);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager);
	}

	@Test
	void testIsHabitant() {
		assertFalse(controlEmmenager.isHabitant("personne"));
		Gaulois personne = new Gaulois("personne", 1);
		village.ajouterHabitant(personne);
		assertTrue(controlEmmenager.isHabitant("personne"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(controlEmmenager.isHabitant("personne"));
		controlEmmenager.ajouterDruide("personne", 1, 0, 0);
		assertTrue(controlEmmenager.isHabitant("personne"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(controlEmmenager.isHabitant("personne"));
		controlEmmenager.ajouterGaulois("personne", 1);
		assertTrue(controlEmmenager.isHabitant("personne"));
	}

}
