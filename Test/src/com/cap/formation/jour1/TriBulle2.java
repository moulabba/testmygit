package com.cap.formation.jour1;

import java.util.Arrays;

public class TriBulle2 <T> implements Comparable<T>{

	private T[] tableau;
	
	public TriBulle2(T[] tableau ){
			tableau=this.tableau;
	}
	public void trier(){
	Arrays.sort(this.tableau);
	}
	public void afficher(){
		System.out.println(Arrays.toString(this.tableau));
	}
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		if(this.equals(o)){
			return 1;
		}
		return 0;
	}
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		String tab[] = {"hhh", "a", "g", "f", "t", "b", "gye", "ab"};

		Character[] tab2 = {'h', 'a', 'g', 'f', 't', 'b', 'y', 'a'};

		Integer[] tab3 = { 34, 5, 1, 65, 100, 35, 11, 1, 5, 14, 0};

		TriBulle2<String> tabTri = new TriBulle2<String>(tab);

		tabTri.trier();

		tabTri.afficher();

//		TriBulle2<Character> tabTri2 = new TriBulle2<Character>(tab2);
//
//		tabTri2.trier();
//
//		tabTri2.afficher();
//
//		TriBulle2<Integer> tabTri3 = new TriBulle2<Integer>(tab3);
//
//		tabTri3.trier();
//
//		tabTri3.afficher();

		}
}

