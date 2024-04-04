package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] trouverVendeurProduit(String produit) {
		Etal[] etalsVendeurProduit = village.trouverVendeurProduit(produit);
		String[] NomVendeurProduit = new String[etalsVendeurProduit.length];
		for (int i = 0; i < etalsVendeurProduit.length; i++) {
			NomVendeurProduit[i] = etalsVendeurProduit[i].getVendeur().getNom();
		}
		return NomVendeurProduit;
	}

	public int trouverAcheterProduit(int nbProduit, String vendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		return etal.acheterProduit(nbProduit);
	}
}
