package com.cap.formation.jour2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author smoulabb
 *
 */
public class LectureFichier {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static HashMap<Integer, String[]> LectureFichier(String fileName) throws IOException{
		HashMap<Integer, String[]> _map = new HashMap<Integer, String[]>();
		BufferedReader  in = new BufferedReader(new FileReader(fileName)); 
		String line; 
		String[] temp={""}; 
		int comp=0;
		
		while ((line=in.readLine()) != null){  
		       	temp=line.split("\\t");         
		       	for (int i=0; i<temp.length; i++){ 
		       		 	
		       	}
		       //System.out.println(temp[0]+ " " + temp[1]);
		       	_map.put(comp++, temp);
		}  
		in.close(); 
			return _map;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, String[]> _map = new HashMap<Integer, String[]>();
		_map=LectureFichier("src/insertion.conf");
		
		for(int i=0;i<_map.size();i++){
			String[] temp= {""};
			temp=_map.get(i);
			System.out.println(temp[0]+ " OK " + temp[1]);
		}
		
	}

}

