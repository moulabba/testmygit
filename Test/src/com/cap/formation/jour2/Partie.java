package com.cap.formation.jour2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Partie {

    private int valeur;
    private int tentative;
    private int numero;
    public static int compteur;
    
    
    public Partie(){
          this.tentative= 0;
          this.valeur = 0;
          this.numero = 0;
    }
    
    public Partie(int numberRandom){
          this.tentative=0;
          this.valeur = 0;
          this.numero = numberRandom;
    }
    
    public static String loadFile(File f) throws jeuxException {
             try {
                 BufferedInputStream in;
                 in = new BufferedInputStream(new FileInputStream(f));
                 StringWriter out = new StringWriter();
                 int b;
                 while ((b=in.read()) != -1)
                      out.write(b);
                            out.flush();
                            out.close();
                            in.close();      
                       return out.toString();
              }
              catch (IOException ie)
              {
                throw new jeuxException("le fichier est introuvable");
              }    
    }
    
    public int getValeur() {
          return valeur;
    }

    public void setValeur(int valeur) {
          this.valeur = valeur;
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
    
    public int getCompteur() throws jeuxException{
          String str2 = loadFile(new File("nombrePartie.txt"));
          try {
                this.compteur = new Integer(str2);
                return this.compteur;
          } catch (Exception e) {
                return 0;
          }     
    }
    
    public void incrementCompteur(){
          this.compteur++;  
          try {
                File fichier = new File("nombrePartie.txt");
                FileWriter out = new FileWriter(fichier);
                String text = this.compteur+"";
                out.write(text);
                out.close();            
          } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }
    }
    
    public String toString(){
          //System.out.println();
          return "Nombre de partie: " + this.compteur+" Nombre de tentative: " + this.getTentative()+" Nombre d'or: "+this.getNumero();
    }
    
    public void affiche() throws jeuxException{
          //System.out.println();
          System.out.print( "Nombre de partie: " + getCompteur());
          System.out.print( " Nombre de tentative: " + this.getTentative());
          System.out.println( " Nombre d'or: "+this.getNumero());
    }
    
}
