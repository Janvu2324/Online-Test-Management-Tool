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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JavaExam extends JFrame {

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
					JavaExam frame = new JavaExam();
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
	public JavaExam() {
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
		lblEnterYourEmail.setBounds(30, 50, 120, 14);
		contentPane.add(lblEnterYourEmail);
		
		textField = new JTextField();
		textField.setBounds(164, 50, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblchooseTheCorrect = new JLabel("*Choose the correct alternative for the following:");
		lblchooseTheCorrect.setBounds(30, 100, 356, 14);
		contentPane.add(lblchooseTheCorrect);
		
		JLabel lblNewLabel_1 = new JLabel("1. Which of the following is advantage of using JDBC connection pool?");
		lblNewLabel_1.setBounds(30, 142, 456, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Using more memory");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(41, 174, 123, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Using less memory");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(183, 174, 143, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Better performance");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(328, 174, 142, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Slow performance");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(472, 174, 132, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("2. Which of the following is not valid design pattern?");
		lblNewLabel_2.setBounds(30, 226, 343, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Singleton");
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(41, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Factory");
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBounds(183, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Command");
		buttonGroup_1.add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.setBounds(328, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Java");
		buttonGroup_1.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_7.setBounds(472, 262, 109, 23);
		contentPane.add(rdbtnNewRadioButton_7);
		
		JLabel lblIsDesign = new JLabel("3. Is design pattern a logical concept.");
		lblIsDesign.setBounds(30, 311, 296, 14);
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setActionCommand("Using more memory");
				rdbtnNewRadioButton_1.setActionCommand("Using less memory");
				rdbtnNewRadioButton_2.setActionCommand("Better performance");
				rdbtnNewRadioButton_3.setActionCommand("Slow performance");
				rdbtnNewRadioButton_4.setActionCommand("Singleton");
				rdbtnNewRadioButton_5.setActionCommand("Factory");
				rdbtnNewRadioButton_6.setActionCommand("Command");
				rdbtnNewRadioButton_7.setActionCommand("Java");
				rdbtnNewRadioButton_8.setActionCommand("True");
				rdbtnNewRadioButton_9.setActionCommand("False");
				try {
						String sql="Select Emailid from users_detail where Emailid = ?";
						pst=(OraclePreparedStatement)conn.prepareStatement(sql);
						pst.setString(1, textField.getText());
						rs = (OracleResultSet)pst.executeQuery();
						
						if(rs.next()) {
							String a1=buttonGroup.getSelection().getActionCommand();
							String a2=buttonGroup_1.getSelection().getActionCommand();
							String a3=buttonGroup_2.getSelection().getActionCommand();
							
							String sql1="select * from answers_detail where id=1";
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
								String obj="INSERT INTO marks_detail VALUES(?,?)";
			   					pst=(OraclePreparedStatement) conn.prepareStatement(obj);
			   					pst.setString(1, textField.getText());
			   					pst.setString(2, String.valueOf(count));
			   					pst.execute();
			   					dispose();
			   					 
			   					Marks mark = new Marks();
			   					mark.setVisible(true);
							}
						  }
				        
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(509, 358, 95, 34);
		contentPane.add(btnNewButton);
		
		
	}
}
