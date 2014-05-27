package com.cap.formation.jour2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;

public class Jeu {

	private int highScore;
	private int ramdomNumber;
	private Partie partie;
	private HashMap<Integer, Partie> hashM;

	public Jeu() throws jeuxException {
		this.highScore = this.getHighScore();
		this.ramdomNumber = (int) Math.round(Math.random() * 100);
		partie = new Partie(this.ramdomNumber);
		this.hashM = new HashMap<Integer, Partie>();
	}

	public void demandeInfo(String str) {
		System.out.println(str);
	}

	public int demandeValeur() throws jeuxException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		if (this.getPartie().getTentative() == 0) {
			demandeInfo("Saisissez un nombre entre 1 et 100");
		} else {
			if (this.getPartie().getNumero() < this.getPartie().getValeur()) {
				demandeInfo("Pas encore! vous etes au dessus (>).");
			} else {
				demandeInfo("Pas encore! vous etes en dessous (<).");
			}
		}
		String saisie = "";
		int value = -1;
		try {
			saisie = in.readLine();
			if (saisie.length() == 0) {
				return demandeValeur();
			} else {
				value = new Integer(saisie);
			}
		} catch (Exception e) {
			demandeInfo("la saisie est incorecte: ");
			return demandeValeur();
		}
		if (value < 0) {
			demandeInfo("la saisie est incorecte (nombre négatif nom permis) ");
			return demandeValeur();
		}
		return value;
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

	public int getHighScore() throws jeuxException {
		String str = loadFile(new File("score.txt"));
		try {
			int score = new Integer(str);
			return score;
		} catch (Exception e) {
			return 0;
			// score n'existe pas
		}
	}

	public int getRamdomNumber() {
		return ramdomNumber;
	}

	public void setRamdomNumber(int ramdomNumber) {
		this.ramdomNumber = ramdomNumber;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public static String loadFile(File f) throws jeuxException {
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
			throw new jeuxException("le fichier est introuvable");
		}
	}

	public void ecrireDansFichier() throws jeuxException {
		java.util.Iterator itValue = this.hashM.values().iterator();
		while (itValue.hasNext()) {
			Partie partie = (Partie) itValue.next();
			String contentFile = loadFile(new File("partie.txt"));
			try {
				File fichier = new File("partie.txt");
				FileWriter out = new FileWriter(fichier);
				String text = contentFile + " " + partie.toString() + " ";
				out.write(text);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void afficherHistoriqueDesPartie() throws jeuxException {
		String str = loadFile(new File("partie.txt"));
		try {
			System.out.println(str);
		} catch (Exception e) {
			throw new jeuxException("Erreur historique des parties.");
		}
	}

	public void jouer() throws jeuxException {
		this.getPartie().affiche();
		this.getPartie().setValeur(demandeValeur());
		this.getPartie().setTentative(this.getPartie().getTentative() + 1);
		while (this.getPartie().getValeur() != this.getRamdomNumber()) {
			if (this.getPartie().getValeur() > 100) {
				demandeInfo("La veleur saisie est suppérieur à 100.");
			}
			if (this.getPartie().getValeur() < 0) {
				demandeInfo("La veleur saisie est incorrecte.");
			}
			this.getPartie().setValeur(demandeValeur());
			this.getPartie().setTentative(this.getPartie().getTentative() + 1);
		}
		if (this.getPartie().getValeur() == this.getRamdomNumber()) {
			demandeInfo("Vous avez gagner!!!!");
			demandeInfo("Le nombre magique est " + this.getPartie().getValeur());
			if (this.getPartie().getTentative() < this.getHighScore()) {
				this.setHighScore(this.getPartie().getTentative());
				demandeInfo("Vous avez le meilleur socre :-)");
			} else if (this.getPartie().getTentative() == this.getHighScore()) {
				demandeInfo("Vous etes a égalité avec le meilleur socre");
			} else {
				demandeInfo("Le meilleur socre est: " + this.getHighScore()
						+ " tentative(s).");
			}
			this.getPartie().affiche();
			this.hashM.put(this.getPartie().getCompteur(), this.getPartie());
			this.getPartie().incrementCompteur();
			demandeInfo("Voulez vous rejouer ? (O/N)");
			BufferedReader in;
			in = new BufferedReader(new InputStreamReader(System.in));
			try {
				while (true) {
					String chaine = in.readLine();
					if (chaine.toUpperCase().equals("O")) {
						int rdomNumber = (int) Math.round(Math.random() * 100);
						this.getPartie().setNumero(rdomNumber);
						this.setRamdomNumber(rdomNumber);
						this.setPartie(new Partie(rdomNumber));
						jouer();
					} else {
						ecrireDansFichier();
						demandeInfo("Voulez vous afficher l'historique des parties (O/N).");
						String ch = in.readLine();
						if (ch.toUpperCase().equals("O")) {
							afficherHistoriqueDesPartie();
						} else {
							demandeInfo("Au revoir :-)");
						}
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new jeuxException("Exception I/O:" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws jeuxException {
		Jeu jeux = new Jeu();
		jeux.jouer();
	}
}
