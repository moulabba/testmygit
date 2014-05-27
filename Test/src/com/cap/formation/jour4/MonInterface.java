package com.cap.formation.jour4;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonInterface extends Frame {

           Button b1;
             Button b2, b3, b4, b5, b6,b7;
             public int c1=0;
             private int c2=0, c3=0, c4=0, c5=0, c6=0;
       public MonInterface() {
       
             
             setTitle("Exercice AWT");
             
             setSize(400,200);
             GridLayout grid=new GridLayout(3, 3);
             grid.setHgap(5);
             grid.setVgap(5);
             setLayout(grid);
             b1=new Button("1");
             b1.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                           c1=c1+1;
                           b1.setLabel("clic:"+c1 );
                           
                    }
             });
             add(b1);
             
             b2=new Button(" 2");
             b3=new Button(" 3");
             b4=new Button("4");
             b5=new Button("5");
             b6=new Button(" 6");
                    b2.addActionListener(new ActionListener() {
                                        
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                               c2=c2+1;
                                               b2.setLabel("clic:"+c2 );
                                               
                                        }
                                  });
                    b3.addActionListener(new ActionListener() {
                           
                           @Override
                           public void actionPerformed(ActionEvent e) {
                                  c3=c3+1;
                                  b3.setLabel("clic:"+c3 );
                                  
                           }
                    });
                    b4.addActionListener(new ActionListener() {
                           
                           @Override
                           public void actionPerformed(ActionEvent e) {
                                  c4=c4+1;
                                  b4.setLabel("clic:"+c4 );
                                  
                           }
                    });
                    b5.addActionListener(new ActionListener() {
                           
                           @Override
                           public void actionPerformed(ActionEvent e) {
                                  c5=c5+1;
                                  b5.setLabel("clic:"+c5);
                                  
                           }
                    });
                    b6.addActionListener(new ActionListener() {
                           
                           @Override
                           public void actionPerformed(ActionEvent e) {
                                  c6=c6+1;
                                  b6.setLabel("clic:"+c6 );
                                  
                           }
                    });
       
             add(b2);            
             add(b3);            
             add(b4);            
             add(b5);            
             add(b6);
             b7=new Button("Reset");
             b7.addActionListener(new ActionListener() {
                                  
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                        b1.setLabel("1");
                                        b2.setLabel("2");
                                        b3.setLabel("3");
                                        b4.setLabel("4");
                                        b5.setLabel("5");
                                        b6.setLabel("6");
                                        c1=0;
                                        c2=0;
                                        c3=0;
                                        c4=0;
                                        c5=0;
                                        c6=0;
                                  }
                           });
             add(b7);
             MenuBar mb = new MenuBar();
             
             setMenuBar(mb);
             
             Menu m = new Menu("menu ");
             
             mb.add(m);
             
             
             
             Menu a = new Menu("Options");
             
             mb.add(a);
             
             
       
             Menu  b= new Menu("Help");
             
             mb.add(b);
             m.add(new MenuItem("Ouvrir"));
             
             
       
             Menu m2 = new Menu("Enregistrer");
       
             
             
             CheckboxMenuItem cbm1 = new CheckboxMenuItem("Message");
             
             m2.add(cbm1);
       
             cbm1.setState(true);
       
             CheckboxMenuItem cbm2 = new CheckboxMenuItem("Mail");
       
             m2.add(cbm2);
             
             m.add(m2);
             
             m.add(new MenuItem("Quitter"));
             
             setBackground(Color.DARK_GRAY);
             
             show(); // affiche la fenetre*/
       
             
             
             }
             
             public static void main(String[] args) {
             
            	 MonInterface f=new MonInterface();
             f.addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowClosing(java.awt.event.WindowEvent evt) {
                       
                       System.exit(0);
               } 
       } );
             }

}




