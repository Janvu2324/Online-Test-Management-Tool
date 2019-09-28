import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Control extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control frame = new Control();
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
	
	Connection conn = null;
	OraclePreparedStatement pst = null;
	OracleResultSet rs = null;
	
	public Control() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExamSystem = new JLabel(" Exam System");
		lblExamSystem.setForeground(new Color(0, 0, 128));
		lblExamSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamSystem.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblExamSystem.setBounds(104, 37, 286, 44);
		contentPane.add(lblExamSystem);
		
		JLabel lblEnterExamName = new JLabel("Exam Name");
		lblEnterExamName.setForeground(new Color(128, 0, 0));
		lblEnterExamName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterExamName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblEnterExamName.setBounds(48, 113, 182, 35);
		contentPane.add(lblEnterExamName);
		
		JList list = new JList();
		list.setBounds(292, 207, 98, -15);
		contentPane.add(list);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		btnHome.setForeground(new Color(102, 51, 51));
		btnHome.setBounds(64, 356, 98, 35);
		contentPane.add(btnHome);
		
		JButton C = new JButton("Start Exam");
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cque login = new Cque();
				login.setVisible(true);
			}
		});
		C.setForeground(new Color(255, 51, 153));
		C.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		C.setBackground(Color.BLACK);
		C.setBounds(261, 283, 132, 35);
		contentPane.add(C);
		
		JButton button = new JButton("Start Exam");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaExam login = new JavaExam();
				login.setVisible(true);
			}
		});
		button.setForeground(new Color(255, 51, 153));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBackground(Color.BLACK);
		button.setBounds(261, 221, 132, 35);
		contentPane.add(button);
		
		JLabel lblJava = new JLabel("JAVA:");
		lblJava.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblJava.setBounds(200, 226, 62, 23);
		contentPane.add(lblJava);
		
		JLabel lblC = new JLabel("C:");
		lblC.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblC.setBounds(221, 288, 30, 23);
		contentPane.add(lblC);
		
	}
}
