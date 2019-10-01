import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	
	Connection conn = null;
	OraclePreparedStatement pst = null;
	OracleResultSet rs = null;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(195, 23, 153, 69);
		lblLogin.setForeground(new Color(139, 0, 0));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 47));
		contentPane.add(lblLogin);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setBounds(78, 130, 127, 44);
		lblEmailId.setForeground(new Color(139, 0, 0));
		lblEmailId.setBackground(new Color(255, 182, 193));
		lblEmailId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailId.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		contentPane.add(lblEmailId);
		
		textField = new JTextField();
		textField.setBounds(250, 138, 235, 27);
		textField.setBackground(new Color(220, 220, 220));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(78, 199, 127, 69);
		lblPassword.setForeground(new Color(139, 0, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(250, 226, 235, 27);
		pass.setBackground(new Color(220, 220, 220));
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(149, 325, 114, 34);
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = JDBC.dbconnect();
				try {
					if(textField.getText().equals("") || pass.getText().equals("") ) {
						JOptionPane.showMessageDialog(null,"Email and Password not entered..");
					}
					else {
						String queary="INSERT INTO log_detail VALUES (?,?)";
						pst=(OraclePreparedStatement) conn.prepareStatement(queary);
						pst.setString(1, textField.getText());
						pst.setString(2, pass.getText());
						rs = (OracleResultSet) pst.executeQuery();
						
						if(rs.next()) {
							
							JOptionPane.showMessageDialog(null,"Log in successfully");
							Control con = new Control();
							con.setVisible(true);
						   }
						else
						{	
							String quea="Select * from login_detail where Emailid=? and Password=?";
							pst=(OraclePreparedStatement) conn.prepareStatement(quea);
							pst.setString(1, textField.getText());
							pst.setString(2, pass.getText());
							rs = (OracleResultSet) pst.executeQuery();
							JOptionPane.showMessageDialog(null,"Wrong Email and Password..Enter correct one....");
						}
						pst.close();
						rs.close();
						conn.close();
					    }
					
				    }
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGNIN");
		btnNewButton_1.setBounds(292, 325, 127, 34);
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				Register reg = new Register();
				reg.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		contentPane.add(btnNewButton_1);
	}
}
