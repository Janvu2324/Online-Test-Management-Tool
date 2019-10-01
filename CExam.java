import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CExam extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	
	Connection conn = null;
	OraclePreparedStatement pst = null;
	OracleResultSet rs = null;
	int count=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CExam frame = new CExam();
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
	public CExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question paper");
		lblNewLabel.setBackground(new Color(255, 182, 193));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 5, 683, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterYourEmail = new JLabel("Enter your Email");
		lblEnterYourEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblEnterYourEmail.setBounds(30, 50, 182, 23);
		contentPane.add(lblEnterYourEmail);
		
		textField = new JTextField();
		textField.setBounds(261, 53, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblchooseTheCorrect = new JLabel("*Choose the correct alternative for the following:");
		lblchooseTheCorrect.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblchooseTheCorrect.setBounds(30, 100, 368, 20);
		contentPane.add(lblchooseTheCorrect);
		
		JLabel lblNewLabel_1 = new JLabel("1. The default executetable generation on UNIX for a C program is_____.");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 142, 466, 25);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("a.exe");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(41, 174, 123, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("a");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(183, 174, 123, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("a.out");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(328, 174, 142, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("out.a");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(472, 174, 132, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("2. Linker generates _____ file.");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 226, 393, 29);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Object");
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(41, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Executable");
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBounds(183, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Assembly");
		buttonGroup_1.add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.setBounds(328, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("None of this");
		buttonGroup_1.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_7.setBounds(472, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_7);
		
		JLabel lblIsDesign = new JLabel("3. The return type of malloc function is void.");
		lblIsDesign.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblIsDesign.setBounds(30, 311, 306, 22);
		contentPane.add(lblIsDesign);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("True");
		buttonGroup_2.add(rdbtnNewRadioButton_8);
		rdbtnNewRadioButton_8.setBounds(41, 340, 109, 23);
		contentPane.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("False");
		buttonGroup_2.add(rdbtnNewRadioButton_9);
		rdbtnNewRadioButton_9.setBounds(197, 340, 109, 23);
		contentPane.add(rdbtnNewRadioButton_9);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = JDBC.dbconnect();
				rdbtnNewRadioButton.setActionCommand("a.exe");
				rdbtnNewRadioButton_1.setActionCommand("a");
				rdbtnNewRadioButton_2.setActionCommand("a.out");
				rdbtnNewRadioButton_3.setActionCommand("out.a");
				rdbtnNewRadioButton_4.setActionCommand("Object code");
				rdbtnNewRadioButton_5.setActionCommand("Executable code");
				rdbtnNewRadioButton_6.setActionCommand("Assembly code");
				rdbtnNewRadioButton_7.setActionCommand("Java");
				rdbtnNewRadioButton_8.setActionCommand("True");
				rdbtnNewRadioButton_9.setActionCommand("False");
				try {
					if(textField.getText().equals("") ) {
						JOptionPane.showMessageDialog(null,"Email  not entered..");
					}else {
						String sql="Select * from uss_detail where Emailid = ?";
						pst=(OraclePreparedStatement)conn.prepareStatement(sql);
						pst.setString(1, textField.getText());
						rs = (OracleResultSet)pst.executeQuery();
						
						if(rs.next()) {
							String a1=buttonGroup.getSelection().getActionCommand();
							String a2=buttonGroup_1.getSelection().getActionCommand();
							String a3=buttonGroup_2.getSelection().getActionCommand();
							
							String sql1="select * from cans_detail";
							pst=(OraclePreparedStatement) conn.prepareStatement(sql1);
		
							rs = (OracleResultSet) pst.executeQuery();
							
							if(rs.next()) {
								String add1=rs.getString("ans1");
								String add2=rs.getString("ans2");
								String add3=rs.getString("ans3");
								
								if(a1.equals(add1)) {
									count++;
								}
								if(a2.equals(add2)) {
									count++;
								}
								if(a3.equals(add3)) {
									count++;
								}else {
									count=0;
								}
								
								String obj="INSERT INTO m_detail(Emailid,mark) VALUES(?,?)";
			   					pst=(OraclePreparedStatement) conn.prepareStatement(obj);
			   					pst.setString(1, textField.getText());
			   					pst.setString(2, String.valueOf(count));
			   					
			   					pst.execute();
			   					Marks mark = new Marks();
			   					mark.setVisible(true);
							}
						  }else {
							  JOptionPane.showMessageDialog(null,textField.getText()+"Email not Exist");
						  }
				        
				}}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(509, 358, 109, 34);
		contentPane.add(btnNewButton);
		
		
	}
}
