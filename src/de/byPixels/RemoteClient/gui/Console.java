package de.byPixels.RemoteClient.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.byPixels.RemoteClient.utils.Utils;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Console extends JFrame {

	private JPanel contentPane;
	private JTextField txtCommand;
	public DefaultListModel model = new DefaultListModel<>();
	public JList list = new JList();

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public Console() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 414, 181);
		contentPane.add(scrollPane);

		
		txtCommand = new JTextField();
		txtCommand.setText("command");
		txtCommand.setBounds(10, 230, 326, 20);
		contentPane.add(txtCommand);
		txtCommand.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Utils.getClient().isAuth()) {
				Utils.getClient().sendData(txtCommand.getText());
				model.addElement(txtCommand.getText());
				list.setModel(model);
				txtCommand.setText("");
			}
			}
		});
		btnNewButton.setBounds(345, 229, 89, 23);
		contentPane.add(btnNewButton);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
	}
}
