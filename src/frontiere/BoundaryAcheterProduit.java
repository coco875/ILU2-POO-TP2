package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("“Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] nomVendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
			StringBuilder question = new StringBuilder();
			question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
			for (int i = 0; i < nomVendeurs.length; i++) {
				question.append(String.valueOf(i + 1) + " - " + nomVendeurs[i] + "\n");
			}
			String vendeur = null;
			while (vendeur == null) {
				int idVendeur = Clavier.entrerEntier(question.toString());
				if (idVendeur < 1 || idVendeur > nomVendeurs.length) {
					System.out.println("Saissez un nombre valide");
				} else {
					vendeur = nomVendeurs[idVendeur - 1];
				}
			}

			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeur);
			System.out.println("Bonjour " + nomAcheteur);
			int nbProduit = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
			int nbAchete = controlAcheterProduit.trouverAcheterProduit(nbProduit, vendeur);
			if (nbAchete == 0) {
				System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit
						+ ", malheureusement il n’y en a plus !");
			} else if (nbAchete < nbProduit) {
				System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement "
						+ vendeur + " n’en a plus que " + nbAchete + ". " + nomAcheteur + " achète tout le stock de "
						+ vendeur + ".");
			} else {
				System.out.println(nomAcheteur + " achète " + nbProduit + " " + produit + " à " + vendeur + ".");
			}
		}
	}
}
