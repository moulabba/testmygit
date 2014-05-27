package com.cap.formation.jour4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Jeu {
	private Partie partie;
	private int random;
	private HashMap<Integer, Partie> hashM;
	static Scanner sc = new Scanner(System.in);

	public Jeu() {
		this.partie = new Partie();
		this.hashM = new HashMap<Integer, Partie>();
	}

	public String demander(String message) {
		return null;
	}

	public int demanderValeur() {

		if (!(this.partie.getTentative() >= 1)) {
			System.out.println();
			System.out.println();
			System.out
					.println("L'ordinateur choisit un nombre mystère entre 1 et 100");
			System.out.println("Quel est ce nombre ?");
		}
		int r = sc.nextInt();
		return r;
	}

	public void setHighScore(int highS) {
		try {
			File fichier = new File("score.txt");
			FileWriter out = new FileWriter(fichier);
			String text = highS + "";
			out.write(text);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getHighScore() throws Exception {
		String str = loadFile(new File("score.txt"));
		try {
			int score = new Integer(str);

			return score;
		} catch (Exception e) {
			return 0;
			// score n'existe pas
		}

	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public String jouer() throws Exception {
		if (this.partie.getNumero() == this.partie.getValeur()) {

			if (this.partie.getTentative() < this.getHighScore()) {
				this.setHighScore(this.partie.getTentative());
			}

			return "Bravo, vous avez trouvé le nombre !"
					+ " le meilleur score est: " + this.getHighScore();
		} else {
			if (this.partie.getNumero() < this.partie.getValeur()) {

				return "Le nombre est plus petit, quel est-il ?";
			} else {
				return "Le nombre est plus grand, quel est-il ?";
			}
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

	public void ecrireDansFichier() throws Exception {
		java.util.Iterator itValue = this.hashM.values().iterator();
		while (itValue.hasNext()) {
			Partie partie = (Partie) itValue.next();
			String contentFile = loadFile(new File("score.txt"));
			try {
				File fichier = new File("partie.txt");
				FileWriter out = new FileWriter(fichier);
				String text = contentFile + "/n" + partie.toString() + "/n";
				out.write(text);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void afficherHistoriqueDesPartie() throws Exception {
		String str = loadFile(new File("partie.txt"));
		try {
			System.out.println(str);
		} catch (Exception e) {
			throw new Exception("Erreur historique des parties.");
		}
	}

}
