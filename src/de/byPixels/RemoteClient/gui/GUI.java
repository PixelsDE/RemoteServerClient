package de.byPixels.RemoteClient.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import de.byPixels.RemoteClient.client.Connect;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtUsername;
	private JPasswordField txtPassword;


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 163, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIp = new JTextField();
		txtIp.setText("Adress");
		txtIp.setBounds(10, 11, 122, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setText("Port");
		txtPort.setColumns(10);
		txtPort.setBounds(10, 42, 122, 20);
		contentPane.add(txtPort);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setColumns(10);
		txtUsername.setBounds(10, 73, 122, 20);
		contentPane.add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 105, 122, 20);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connect connect = new Connect(txtIp.getText(), Integer.parseInt(txtPort.getText()), txtUsername.getText(), txtPassword.getText());
			}
		});
		btnNewButton.setBounds(20, 136, 89, 23);
		contentPane.add(btnNewButton);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
