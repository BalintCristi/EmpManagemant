import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GUI implements  ActionListener {
	private static JTextField userText;
	private static JFrame frame;
	private static JLabel label;
	private static JLabel passLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel Lsucces;
	

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		frame = new JFrame();
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("User");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
		userText = new JTextField(20);
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(10, 50, 80, 25);
		panel.add(passLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10, 80, 80,25);
		button.addActionListener(new GUI());
		panel.add(button);
		
		Lsucces = new JLabel("");
		Lsucces.setBounds(10, 110, 300, 25);
		panel.add(Lsucces);
		
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","goremXD2013.");
			Statement stmt = con.createStatement();
			String sql = "SELECT username, password FROM employee.login where username = " + '"' + userText.getText() + '"'  +" and  password = " + '"' + passwordText.getText().toString()+ '"';
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				frame.dispose();
				Dashbord dash = new Dashbord();
				dash.setVisible(true);
			}
		} catch(Exception f){System.out.println(f);}
		
		
		
		
		/*String user = userText.getText();
		String pass = passwordText.getText();
		
		
		if(user.equals("a") && pass.equals("b"))
		{
			
			frame.dispose();
			Dashbord dash = new Dashbord();
			dash.setVisible(true);
		}*/
		
	}
	
	

}
