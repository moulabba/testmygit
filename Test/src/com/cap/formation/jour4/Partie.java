package com.cap.formation.jour4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Partie {
	private int Valeur;
	private int tentative;
	private int numero;
	public static int compteur;

	public Partie(int valeur, int tentative) {
		this.Valeur = valeur;
		this.tentative = tentative;
		compteur++;
	}

	public Partie() {
	}

	public int getValeur() {
		return Valeur;
	}

	public void setValeur(int valeur) {
		Valeur = valeur;
	}

	public int getTentative() {
		return tentative;
	}

	public void setTentative(int tentative) {
		this.tentative = tentative;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static void setCompteur(int compteur) {
		Partie.compteur = compteur;
	}

	public String toString() {
		// System.out.println();
		return "Partie N°: " + this.compteur + "tentative N°: "
				+ this.getTentative() + " Nombre d'or: " + this.getNumero();

	}

	public void incrementCompteur() {
		this.compteur++;
		try {
			File fichier = new File("nombrePartie.txt");
			FileWriter out = new FileWriter(fichier);
			String text = this.compteur + "";
			out.write(text);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCompteur() throws Exception {
		String str2 = loadFile(new File("nombrePartie.txt"));
		try {
			this.compteur = new Integer(str2);
			return this.compteur;
		} catch (Exception e) {
			return 0;
		}
	}

	public static String loadFile(File f) throws Exception {
		try {
			BufferedInputStream in;
			in = new BufferedInputStream(new FileInputStream(f));
			StringWriter out = new StringWriter();
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			out.flush();
			out.close();
			in.close();
			return out.toString();
		} catch (IOException ie) {
			throw new Exception("le fichier est introuvable");
		}
	}

}
