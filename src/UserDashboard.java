import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class UserDashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard frame = new UserDashboard();
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
	public UserDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Salary Raise RQ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MailSender sendMail = new MailSender();
				sendMail.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 68, 129, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leave Premision");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 122, 129, 23);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(203, 33, 195, 180);
		contentPane.add(table);
		
		JButton btnNewButton_2 = new JButton("Permisions");
		btnNewButton_2.setBounds(10, 176, 129, 23);
		contentPane.add(btnNewButton_2);
	}
}
