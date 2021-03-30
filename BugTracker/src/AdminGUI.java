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
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;

public class AdminGUI {

	private JFrame frame = new JFrame();
	private DBConnection con;
	private String url = "jdbc:mysql://localhost:3306/bugtracker";
	private String username = "root";
	private String password = "3737Tuonglai";
	private JTextField name_Field;
	private JTextField id_Field;
	private JTextField proName_Field;
	private JTextField proId_Field;
	private JTextPane proDesc_Field;
	private JTextField userNameField;
	private JTextField userIDField;
	private JPasswordField userRePassField;
	private JPasswordField userPassField;
	private JTextField staffNameField;
	private JTextField staffIDField;
	private JPasswordField staffPassField;
	private JPasswordField staffRePassField;
	private LoginUI ui = new LoginUI();

	public AdminGUI() {

		frame.setBounds(100, 100, 550, 500);
		frame.setTitle("UserGUI");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 534, 450);
		frame.getContentPane().add(tabbedPane);

		JPanel adPro = new JPanel();
		tabbedPane.addTab("Project", null, adPro, null);
		adPro.setLayout(null);
		frame.setVisible(true);
		//
		JLabel adName = new JLabel("Name");
		adName.setBounds(10, 62, 67, 33);
		adPro.add(adName);

		name_Field = new JTextField();
		name_Field.setEditable(false);
		name_Field.setColumns(10);
		name_Field.setBounds(131, 68, 190, 20);
		adPro.add(name_Field);

		JLabel adID = new JLabel("ID");
		adID.setBounds(10, 102, 46, 14);
		adPro.add(adID);

		id_Field = new JTextField();
		id_Field.setEditable(false);
		id_Field.setColumns(10);
		id_Field.setBounds(131, 99, 148, 20);
		adPro.add(id_Field);

		proName_Field = new JTextField();
		proName_Field.setColumns(10);
		proName_Field.setBounds(131, 126, 243, 20);
		adPro.add(proName_Field);

		proDesc_Field = new JTextPane();
		proDesc_Field.setBounds(131, 190, 282, 98);
		adPro.add(proDesc_Field);

		JLabel adminPanel = new JLabel("Admin Panel - Project");
		adminPanel.setFont(new Font("Tahoma", Font.BOLD, 16));
		adminPanel.setBounds(181, 11, 201, 32);
		adPro.add(adminPanel);

		JButton proInsert = new JButton("Insert");
		proInsert.setBounds(210, 316, 89, 23);
		adPro.add(proInsert);
		proInsert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (proId_Field.getText() != null && proName_Field.getText() != null
						&& proDesc_Field.getText() != null) {
					try {
						con = new DBConnection(url, username, password);

						Statement stm = con.getConnection().createStatement();
						String sql = "INSERT INTO project VALUES ('" + proId_Field.getText() + "','"
								+ proName_Field.getText() + "','" + proDesc_Field.getText() + "')";
						stm.execute(sql);
						stm.close();
					} catch (Exception n) {
						n.printStackTrace();
					}

				} else {
					System.out.println("error");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Project Name");
		lblNewLabel.setBounds(10, 129, 89, 14);
		adPro.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Project ID");
		lblNewLabel_1.setBounds(9, 160, 67, 14);
		adPro.add(lblNewLabel_1);

		proId_Field = new JTextField();
		proId_Field.setColumns(10);
		proId_Field.setBounds(131, 159, 158, 20);
		adPro.add(proId_Field);

		JLabel lblNewLabel_2 = new JLabel("Project Descripsion");
		lblNewLabel_2.setBounds(8, 190, 113, 14);
		adPro.add(lblNewLabel_2);
		// Tab
		JPanel adUser = new JPanel();
		tabbedPane.addTab("User&Staff", null, adUser, null);
		adUser.setLayout(null);

		JLabel adUserLabel = new JLabel("Admin - User&Staff");
		adUserLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		adUserLabel.setBounds(186, 11, 179, 24);
		adUser.add(adUserLabel);

		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setBounds(10, 42, 76, 24);
		adUser.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("User ID");
		lblNewLabel_3_1.setBounds(10, 77, 60, 24);
		adUser.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("User Password");
		lblNewLabel_3_2.setBounds(10, 112, 106, 24);
		adUser.add(lblNewLabel_3_2);

		userNameField = new JTextField();
		userNameField.setBounds(127, 44, 238, 20);
		adUser.add(userNameField);
		userNameField.setColumns(10);

		userIDField = new JTextField();
		userIDField.setBounds(127, 79, 191, 20);
		adUser.add(userIDField);
		userIDField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Repeat Password");
		lblNewLabel_4.setBounds(10, 150, 106, 14);
		adUser.add(lblNewLabel_4);

		userRePassField = new JPasswordField();
		userRePassField.setBounds(127, 147, 156, 20);
		adUser.add(userRePassField);

		userPassField = new JPasswordField();
		userPassField.setBounds(127, 114, 156, 20);
		adUser.add(userPassField);

		JButton userInsert = new JButton("Insert");
		userInsert.setBounds(202, 188, 89, 23);
		adUser.add(userInsert);

		JLabel lblNewLabel_3_3 = new JLabel("Staff Name");
		lblNewLabel_3_3.setBounds(10, 220, 76, 24);
		adUser.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_1_1 = new JLabel("Staff ID");
		lblNewLabel_3_1_1.setBounds(10, 255, 60, 24);
		adUser.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_2_1 = new JLabel("Staff Password");
		lblNewLabel_3_2_1.setBounds(10, 290, 106, 24);
		adUser.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_4_1 = new JLabel("Repeat Password");
		lblNewLabel_4_1.setBounds(10, 328, 106, 14);
		adUser.add(lblNewLabel_4_1);

		staffNameField = new JTextField();
		staffNameField.setColumns(10);
		staffNameField.setBounds(127, 222, 238, 20);
		adUser.add(staffNameField);

		staffIDField = new JTextField();
		staffIDField.setColumns(10);
		staffIDField.setBounds(127, 257, 191, 20);
		adUser.add(staffIDField);

		staffPassField = new JPasswordField();
		staffPassField.setBounds(127, 292, 156, 20);
		adUser.add(staffPassField);

		staffRePassField = new JPasswordField();
		staffRePassField.setBounds(127, 325, 156, 20);
		adUser.add(staffRePassField);

		JButton staffInsert = new JButton("Insert");
		staffInsert.setBounds(204, 376, 87, 23);
		adUser.add(staffInsert);

		JPanel adAssign = new JPanel();
		tabbedPane.addTab("Assign" + "", null, adAssign, null);
		adAssign.setLayout(null);

		JLabel lblAdminAssign = new JLabel("Admin - Assign");
		lblAdminAssign.setBounds(197, 11, 133, 20);
		lblAdminAssign.setFont(new Font("Tahoma", Font.BOLD, 16));
		adAssign.add(lblAdminAssign);

		JPanel adSearch = new JPanel();
		tabbedPane.addTab("Search", null, adSearch, null);
		
		EnterIDAndName();

	}

	private void EnterIDAndName() {
		name_Field.setText(ui.getName());
		id_Field.setText(ui.getID());
	}

}
