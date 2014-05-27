package com.cap.formation.jour2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestEntree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
BufferedReader in;
in=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Entrez des phrases suivies de : ");
System.out.println(" Puis une chaine vide pour finir");
	
	try {
		while (true) {
String chaine=in.readLine();
if(chaine.length()==0){
	System.exit(0);
	System.out.println ("Vous avez entré:" + chaine);
	
}
		}
	} catch(IOException e){
		System.out.println("Exception I/O " +e.getMessage());
	}
	}
	

}
