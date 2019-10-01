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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Marks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
					Marks frame = new Marks();
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
	public Marks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setForeground(new Color(128, 0, 0));
		lblResult.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblResult.setBounds(27, 11, 90, 76);
		contentPane.add(lblResult);
		
		JLabel lblMark = new JLabel("Mark");
		lblMark.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblMark.setBounds(57, 195, 72, 17);
		contentPane.add(lblMark);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblEmail.setBounds(57, 135, 72, 17);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(139, 132, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 192, 139, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = JDBC.dbconnect();
				try {
			
					String insert_data="Select mark from m_detail where Emailid = ?";
   					pst=(OraclePreparedStatement) conn.prepareStatement(insert_data);
   					pst.setString(1, textField.getText());
                    rs = (OracleResultSet) pst.executeQuery();
                    if(rs.next()) {
                    	String mark = rs.getString("mark");
                    	textField_1.setText(mark);
    					
                    }else {
                    	JOptionPane.showMessageDialog(null, "Wrong Email..");
                    }
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnSearch.setToolTipText("Search with Emailid");
		btnSearch.setBounds(309, 129, 99, 33);
		contentPane.add(btnSearch);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton.setBounds(40, 355, 89, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Correct Ans");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Correctans frame = new Correctans();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(309, 355, 161, 33);
		contentPane.add(btnNewButton_1);
	}
}
