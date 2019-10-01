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
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class CorrectansofC extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
					CorrectansofC frame = new CorrectansofC();
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
	public CorrectansofC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 454);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCorrectAns = new JLabel("Correct Ans");
		lblCorrectAns.setForeground(new Color(128, 0, 0));
		lblCorrectAns.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblCorrectAns.setBounds(36, 33, 183, 30);
		contentPane.add(lblCorrectAns);
		
		JLabel lblNewLabel = new JLabel("Que 1.");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBounds(66, 120, 91, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.controlHighlight);
		textField.setBorder(new TitledBorder(null, "1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(167, 95, 209, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Que 2.");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(66, 163, 91, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Que 3.");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_2.setBounds(66, 214, 91, 21);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.controlHighlight);
		textField_1.setBorder(new TitledBorder(null, "2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_1.setBounds(167, 154, 209, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.controlHighlight);
		textField_2.setBorder(new TitledBorder(null, "3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_2.setBounds(167, 207, 209, 46);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnExit.setBounds(10, 358, 97, 30);
		contentPane.add(btnExit);
		
		JButton btnShow = new JButton("Show");
		btnShow.setForeground(Color.RED);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = JDBC.dbconnect();
				try {
					String sql1="select * from cans_detail ";
				     pst=(OraclePreparedStatement) conn.prepareStatement(sql1);
                    rs = (OracleResultSet) pst.executeQuery();
                    if(rs.next()) {
                     	textField.setText(rs.getString("ans1"));
                     	textField_1.setText(rs.getString("ans2"));
                     	textField_2.setText(rs.getString("ans3"));
    					
                    }else {
                    	JOptionPane.showMessageDialog(null,"Wrong Id..","Error",JOptionPane.ERROR_MESSAGE);
                    }
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnShow.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnShow.setBounds(317, 293, 89, 23);
		contentPane.add(btnShow);
	}

}
