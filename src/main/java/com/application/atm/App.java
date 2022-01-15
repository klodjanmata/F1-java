package com.application.atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App implements ActionListener {

	public static void main(String[] args) {
		JFrame frame = new JFrame("MIRESEVINI NE ATM");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel panel = new JPanel();
		frame.add(panel);
		vendosKomponentet(panel);
		frame.setVisible(true);
	}

	private static void vendosKomponentet(final JPanel panel) {
		panel.setLayout(null);
		JLabel nrKartes = new JLabel("Numri i kartes:");
		nrKartes.setBounds(10, 20, 90, 25);
		panel.add(nrKartes);
		final JTextField shkruajNumrin = new JTextField(20);
		shkruajNumrin.setBounds(100, 20, 150, 25);
		panel.add(shkruajNumrin);
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(10, 50, 80, 65);
		panel.add(pin);
		final JPasswordField shkruajPin = new JPasswordField(20);
		shkruajPin.setBounds(100, 70, 150, 25);
		panel.add(shkruajPin);
		JButton login = new JButton("Hyr");
		login.setBounds(100, 110, 70, 25);
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String gjendja = DataSaver.kerko(shkruajNumrin.getText(), shkruajPin.getText());
				JLabel mesazhi = null;
				mesazhi = new JLabel(gjendja);
				mesazhi.setBounds(100, 190, 300, 25);
				mesazhi.setVisible(true);
				panel.add(mesazhi);
				if (mesazhi.getText().startsWith("Gjendja")) {
					terhiqPara(shkruajNumrin.getText(), shkruajPin.getText());
				}
			}
		});
		panel.add(login);

		JButton clear = new JButton("Pastro");
		clear.setBounds(175, 110, 80, 25);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shkruajNumrin.setText(null);
				shkruajPin.setText(null);

			}
		});
		panel.add(clear);

		JButton signUp = new JButton("Regjistrohu");
		signUp.setBounds(100, 150, 150, 25);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame regjistrimi = new JFrame("Regjistrohu");
				regjistrimi.setSize(450, 450);
				regjistrimi.setLocation(500, 500);
				regjistrimi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				final JPanel panel = new JPanel();
				regjistrimi.add(panel);
				menuRegjistrimi(panel);
				regjistrimi.setVisible(true);

			}
		});
		panel.add(signUp);
	}

	private static void terhiqPara(final String nrKartes, final String pin) {
		JFrame terhiq = new JFrame("Terhiqni parate");
		terhiq.setSize(500, 300);
		terhiq.setLocation(500, 500);
		terhiq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel panel = new JPanel();
		terhiq.add(panel);
		terhiq.setVisible(true);
		panel.setLayout(null);
		JLabel shuma = new JLabel("Shuma qe doni te terhiqni:");
		shuma.setBounds(10, 20, 150, 25);
		panel.add(shuma);
		final JTextField shkruajShumen = new JTextField(20);
		shkruajShumen.setBounds(300, 20, 130, 25);
		panel.add(shkruajShumen);

		JButton login = new JButton("Terhiq");
		login.setBounds(50, 70, 80, 25);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gjendja = DataSaver.terhiq(shkruajShumen.getText(), nrKartes, pin);
				JLabel mesazhi = null;
				mesazhi = new JLabel(gjendja);
				mesazhi.setBounds(100, 190, 300, 25);
				mesazhi.setVisible(true);
				panel.add(mesazhi);
				;
			}
		});
		panel.add(login);

	}
	public void actionPerformed(ActionEvent arg0) {
		//  Auto-generated method stub

	}

	private static void menuRegjistrimi(final JPanel panel) {
		panel.setLayout(null);
		JLabel emri = new JLabel("Emri:");
		emri.setBounds(10, 20, 80, 25);
		panel.add(emri);
		final JTextField shkruajEmrin = new JTextField(20);
		shkruajEmrin.setBounds(100, 20, 150, 25);
		panel.add(shkruajEmrin);
		JLabel mbiemri = new JLabel("Mbiemri:");
		mbiemri.setBounds(10, 50, 80, 65);
		panel.add(mbiemri);
		final JTextField shkruajMbiemrin = new JTextField(20);
		shkruajMbiemrin.setBounds(100, 70, 150, 25);
		panel.add(shkruajMbiemrin);
		JLabel numriKartes = new JLabel("Numri i kartes:");
		numriKartes.setBounds(10, 80, 90, 105);
		panel.add(numriKartes);
		final JTextField shkruajNumrin = new JTextField(20);
		shkruajNumrin.setBounds(100, 120, 150, 25);
		panel.add(shkruajNumrin);
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(10, 110, 80, 145);
		panel.add(pin);
		final JPasswordField shkruajPin = new JPasswordField(20);
		shkruajPin.setBounds(100, 170, 150, 25);
		panel.add(shkruajPin);
		final JLabel shuma = new JLabel("Shuma:");
		shuma.setBounds(10, 140, 80, 195);
		panel.add(shuma);
		final JTextField shkruajShumen = new JTextField(20);
		shkruajShumen.setBounds(100, 220, 150, 25);
		panel.add(shkruajShumen);
		JButton regjistro = new JButton("Regjistrohu");
		regjistro.setBounds(100, 270, 150, 25);
		regjistro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				JLabel mesazhi = new JLabel();
				try{
					DataSaver.shto(shkruajEmrin.getText(), shkruajMbiemrin.getText(), shkruajNumrin.getText(),
							shkruajPin.getText(), shkruajShumen.getText());
					mesazhi = new JLabel("Regjistrimi u krye me sukses!");
					mesazhi.setBounds(10, 340, 450, 55);
				} catch (Exception exp) {
					mesazhi = new JLabel("Regjistrimi nuk mund te kryhet. Kujdes ne plotesimin e te dhenave!");
					mesazhi.setBounds(10, 320, 450, 55);
				}
				mesazhi.setVisible(true);
				panel.add(mesazhi);
				;
			}
		});
		panel.add(regjistro);

	}
}
