import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	
	Connection conn = null;
	OraclePreparedStatement pst = null;
	OracleResultSet rs = null;
	OracleResultSet rs1 =null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(new Color(128, 0, 0));
		lblRegistration.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblRegistration.setBounds(159, 38, 155, 39);
		contentPane.add(lblRegistration);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(128, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblName.setBounds(96, 108, 89, 23);
		contentPane.add(lblName);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setForeground(new Color(128, 0, 0));
		lblEmailId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailId.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblEmailId.setBounds(96, 168, 89, 24);
		contentPane.add(lblEmailId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(128, 0, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblPassword.setBounds(96, 227, 89, 27);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Phone no");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBounds(96, 288, 89, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = JDBC.dbconnect();
				try {
					String insert_data="select Emailid from uss_detail where Emailid=?";
					pst=(OraclePreparedStatement) conn.prepareStatement(insert_data);
					pst.setString(1, textField_1.getText());
					rs = (OracleResultSet) pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,textField_1.getText()+"Email Exist..");
					}
					else if(textField.getText().equals("") || textField_1.getText().equals("") || passwordField.getText().equals("") || textField_3.getText().equals("") ) {
						JOptionPane.showMessageDialog(null,"Fill must not empty");
					}
					else {
						if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", textField_1.getText()))) {
							JOptionPane.showMessageDialog(null,"Plearse Enter Valid Email id..","Error",JOptionPane.ERROR_MESSAGE);
						}
	                   else
					   {
	                	
	                	String data="INSERT INTO uss_detail VALUES(?,?,?,?)";
	   					pst=(OraclePreparedStatement) conn.prepareStatement(data);
	   					pst.setString(1, textField.getText());
	   					pst.setString(2, textField_1.getText());
	   					pst.setString(3,passwordField.getText());
	   					pst.setString(4,textField_3.getText());
	   					pst.execute();
	   				    JOptionPane.showMessageDialog(null,"Data Entered successfully..");
	   					}
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
		btnNewButton.setBounds(97, 375, 128, 27);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(223, 112, 155, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(223, 165, 155, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(223, 285, 155, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnLogin.setForeground(new Color(128, 0, 0));
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnLogin.setBounds(261, 375, 117, 27);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(223, 227, 155, 20);
		contentPane.add(passwordField);
	}

}
