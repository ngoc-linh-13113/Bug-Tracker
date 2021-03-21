import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class AdminGUI  {

	private JFrame frame = new JFrame();
	private JTextField adNameText;
	private JTextField uidText;
	private JTextField projectNameField;
	private JTextField projectIDField;
	private JTextPane projectDescField;
	private DBConnection con;
	private String url = "jdbc:mysql://localhost:3306/bugtracker";
	private String username =  "root";
	private String password = "3737Tuonglai";

	
	public AdminGUI() {
		
		frame.setBounds(100, 100, 550, 400);
		frame.setTitle("UserGUI");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel adName = new JLabel("Name");
		adName.setBounds(10, 48, 67, 33);
		frame.getContentPane().add(adName);
		
		adNameText = new JTextField();
		adNameText.setEditable(false);
		adNameText.setBounds(124, 54, 190, 20);
		frame.getContentPane().add(adNameText);
		adNameText.setColumns(10);
		
		JLabel adID = new JLabel("ID");
		adID.setBounds(10, 92, 46, 14);
		frame.getContentPane().add(adID);
		
		uidText = new JTextField();
		uidText.setEditable(false);
		uidText.setBounds(124, 87, 148, 20);
		frame.getContentPane().add(uidText);
		uidText.setColumns(10);
		
		JLabel adminPanel = new JLabel("Admin Panel");
		adminPanel .setFont(new Font("Tahoma", Font.BOLD, 16));
		adminPanel .setBounds(221, 11, 148, 32);
		frame.getContentPane().add(adminPanel);
		
		projectNameField = new JTextField();
		projectNameField.setBounds(124, 118, 234, 20);
		frame.getContentPane().add(projectNameField);
		projectNameField.setColumns(10);
		
		//Insert Project
		JButton proInsert = new JButton("Insert");
		proInsert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(projectIDField.getText() != null && projectNameField.getText() != null && projectDescField.getText() != null ) {
				try {
					con = new DBConnection(url, username, password);
					
					Statement stm = con.getConnection().createStatement();
					String sql = "INSERT INTO project VALUES ('"+projectIDField.getText()+"','"+projectNameField.getText()+"','"+projectDescField.getText()+"')";
					stm.execute(sql);
					stm.close();
				} 
				catch (Exception n) {
					n.printStackTrace();
				}
					
			}
				else {
					System.out.println("error");
				}
		}
	});
		
		proInsert.setBounds(126, 314, 89, 23);
		frame.getContentPane().add(proInsert);
		
		JButton uSearch = new JButton("Search");
		uSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		uSearch.setBounds(282, 314, 89, 23);
		frame.getContentPane().add(uSearch);
		
		JLabel lblNewLabel = new JLabel("Project Name");
		lblNewLabel.setBounds(10, 121, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Project ID");
		lblNewLabel_1.setBounds(10, 152, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		projectIDField = new JTextField();
		projectIDField.setBounds(124, 149, 158, 20);
		frame.getContentPane().add(projectIDField);
		projectIDField.setColumns(10);
		
		projectDescField = new JTextPane();
		projectDescField.setBounds(124, 191, 245, 98);
		frame.getContentPane().add(projectDescField);
		
		JLabel lblNewLabel_2 = new JLabel("Project Descripsion");
		lblNewLabel_2.setBounds(10, 187, 115, 14);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
		
	}
	
}
