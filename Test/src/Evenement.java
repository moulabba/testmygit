
public class Evenement extends Date {

	
	String texte;
	
	public Evenement (int jour, int mois, int an, String texte){
		super();
		System.out.println("etxtxtx");
		
	}
	public String toString(){
		
		return "Affichage "+ this.texte + super.toString();	
}
	
	public boolean equals(Evenement d){
		if(super.equals(d)){
		return true;	
		}else{
			return false;	
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Evenement ev=new Evenement(1, 2, 2013, "Merde");
ev.toString();
	}

}
