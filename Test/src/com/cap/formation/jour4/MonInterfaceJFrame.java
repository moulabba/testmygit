package com.cap.formation.jour4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MonInterfaceJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Jeu jeu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterfaceJFrame frame = new MonInterfaceJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MonInterfaceJFrame() {
		getContentPane().setFont(
				new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 143);
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		textField = new JTextField();
		getContentPane().add(textField, "2, 2, center, default");
		textField.setColumns(10);
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.GREEN);
		getContentPane().add(lblNewLabel, "2, 8, center, default");

		final JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setForeground(SystemColor.textHighlight);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		getContentPane().add(lblNewLabel_1, "2, 10, left, default");

		JButton btnNewButton = new JButton("Tester");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int valeur = Integer.parseInt(textField.getText());
					jeu.getPartie().setValeur(valeur);
					jeu.getPartie().setNumero(jeu.getRandom());
					jeu.getPartie().setTentative(
					jeu.getPartie().getTentative() + 1);
					lblNewLabel.setForeground(Color.BLACK);
					lblNewLabel.setText(jeu.jouer());
				 lblNewLabel_1.setText("Tentative N° : "+jeu.getPartie().getTentative()+" ");
				} catch (Exception e) {
					lblNewLabel
							.setText("Veuillez saisir un nombre entre 1 et 100 !!!");
				}

			}
		});
		getContentPane().add(btnNewButton, "2, 4, fill, default");

		JButton btnNewButton_1 = new JButton("New");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jeu = new Jeu();
				int x = (int) (Math.random() * 100) + 1;
				jeu.setRandom(x);
				lblNewLabel.setText("");
				textField.setText("");
			}
		});
		getContentPane().add(btnNewButton_1, "2, 6");

		// Jeu
		this.jeu = new Jeu();
		int x = (int) (Math.random() * 100) + 1;
		this.jeu.setRandom(x);

	}

}
