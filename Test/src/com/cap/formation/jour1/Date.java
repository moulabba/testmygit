package com.cap.formation.jour1;

public class Date {

	private int jour, mois, an;
	static Date jourDeLAn=new Date(01,01,2014);
	
	public Date(){
		System.out.println("Ton par défaut: 14/04/2014");
	}
	private static Date Date(int i, int j, int k) {

		System.out.println("Date static: " + i+ "\\" + j+"\\"+ k);
		return null;
	}
	public Date (int jour,int mois, int an){
		System.out.println("Ma date: " + jour+ "\\" + mois+"\\"+ an);
	}
	
	public void afficher(){
		if(verifDate()){
			if(this.getJour()==jourDeLAn.jour && this.getMois()==jourDeLAn.mois && this.getAn()==jourDeLAn.an){
				System.out.println("Bonne Annee");
			}else{
				System.out.println("Affichage " + this.getJour()+ "\\" + this.getMois()+"\\"+ this.getAn());	
			}		
		}else{
			System.out.println("Date incorrect");
		}
	
		
	}
	
	public String toString(){
		
	
				return "Affichage " + this.getJour()+ "\\" + this.getMois()+"\\"+ this.getAn();	
	}
	
	public boolean equals(Date d){
		if(d== this){
		return true;	
		}else{
			return false;	
		}
		
	}
	private boolean verifDate(){
		
		if(this.getJour()>=1 && this.getJour()<30 && this.getMois()<12 && this.getMois()>=1){
			return true;
		}
		else{
			
			return false;
		}
		
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date1= new Date(3333,22,210);
		
		date1.afficher();
	}







	public int getJour() {
		return jour;
	}







	public void setJour(int jour) {
		this.jour = jour;
	}







	public int getMois() {
		return mois;
	}







	public void setMois(int mois) {
		this.mois = mois;
	}







	public int getAn() {
		return an;
	}







	public void setAn(int an) {
		this.an = an;
	}

}
