package com.cap.formation.jour2;

import java.util.Scanner;

public class MagicNumber {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int x, r, life, games, win, lost, continuer, newgame;

		x = (int) (Math.random() * 100) + 1;
		life = 10;
		games = 0;
		win = 0;
		lost = 0;
		continuer = 1;
		newgame = 0;

		while (continuer == 1) {
			System.out.println();
			System.out.println();
			System.out
					.println("L'ordinateur choisit un nombre mystère entre 1 et 100");
			System.out.println("Quel est ce nombre ?");
			System.out.println("(Encore " + life + " chances).");
			while (life >= 1 && newgame == 0) {
				r = sc.nextInt();
				if (r == x) {
					System.out
							.println("Bravo, vous avez trouvé le nombre mystère !");
					newgame = 1;
				} else {
					life = (life - 1);
					if (r > x) {
						System.out.println();
						System.out
								.println("Le nombre est plus petit, quel est-il ?");
						System.out.println("(Encore " + life + " chances).");
						if (life == 0) {
							System.out.println("Désolé, vous avez perdu !");
							System.out.println("Le nombre mystère était " + x);
						}
						System.out.println();
						System.out.println();
					} else {
						System.out.println();
						System.out
								.println("Le nombre est plus grand, quel est-il ?");
						System.out.println("(Encore " + life + " chances).");
						if (life == 0) {
							System.out.println("Désolé, vous avez perdu !");
							System.out.println("Le nombre mystère était " + x);
						}
						System.out.println();
						System.out.println();
					}
				}
			}
			games = (games + 1);
			if (life > 1) {
				win = (win + 1);
			} else {
				lost = (lost + 1);
			}
			System.out.println(games + "parties jouées");
			System.out.println(win + "parties gagnées");
			System.out.println(lost + "parties perdues");
			System.out.println();
			System.out.println();
			life = 10;
			newgame = 0;
			System.out.println("Continuer ? (Oui : 1, Non : 0)");
			continuer = sc.nextInt();
		}

	}
}
