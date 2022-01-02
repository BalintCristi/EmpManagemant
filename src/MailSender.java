import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.swing.JTextArea;
import java.sql.*;


public class MailSender extends JFrame {

	private JPanel contentPane;
	private JTextField IdAngajat;
	private JTextField SumaAngajat;
	private JTextField txtToEmail;
	private JTextField txtFromEmail;
	private JTextField txtSubjectSent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailSender frame = new MailSender();
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
	public MailSender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suma");
		lblNewLabel.setBounds(10, 47, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("to");
		lblNewLabel_1.setBounds(10, 83, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setBounds(10, 108, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject");
		lblNewLabel_3.setBounds(10, 141, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Id angajat");
		lblNewLabel_4.setBounds(10, 22, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Message");
		lblNewLabel_5.setBounds(10, 176, 69, 14);
		contentPane.add(lblNewLabel_5);
		
		IdAngajat = new JTextField();
		IdAngajat.setBounds(89, 19, 133, 20);
		contentPane.add(IdAngajat);
		IdAngajat.setColumns(10);
		
		SumaAngajat = new JTextField();
		SumaAngajat.setBounds(89, 44, 133, 20);
		contentPane.add(SumaAngajat);
		SumaAngajat.setColumns(10);
		
		txtToEmail = new JTextField();
		txtToEmail.setBounds(89, 80, 174, 20);
		contentPane.add(txtToEmail);
		txtToEmail.setColumns(10);
		
		txtFromEmail = new JTextField();
		txtFromEmail.setBounds(89, 105, 174, 20);
		contentPane.add(txtFromEmail);
		txtFromEmail.setColumns(10);
		
		txtSubjectSent = new JTextField();
		txtSubjectSent.setBounds(89, 138, 133, 20);
		contentPane.add(txtSubjectSent);
		txtSubjectSent.setColumns(10);
		
		JTextArea textZona = new JTextArea();
		textZona.setBounds(89, 176, 242, 74);
		contentPane.add(textZona);
		
		JButton btnNewButton = new JButton("Send email");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ToEmail = txtToEmail.getText();
				String FromEmail = txtFromEmail.getText();
				String FromEmailPass = "cristi2013";
				String SubjSend = txtSubjectSent.getText();
				
				 Properties properties = new Properties();
			        properties.put("mail.smtp.auth","true");
			        properties.put("mail.smtp.starttls.enable","true");
			        properties.put("mail.smtp.host","smtp.gmail.com");
			        properties.put("mail.smtp.port","587");
			        
			        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication(){
			                return new PasswordAuthentication(FromEmail, FromEmailPass);
			            }
			        });
			        
			        try{
			            MimeMessage message = new MimeMessage(session);
			            message.setFrom(new InternetAddress(FromEmail));
			            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
			            message.setSubject(SubjSend);
			            message.setText(textZona.getText());
			            Transport.send(message);
			        }catch(Exception ex){
			            System.out.println(""+ex);
			        }
			        
			        try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","goremXD2013.");
						Statement stmt = con.createStatement();
						String sql = "INSERT INTO employee.requestsr (EmpId , Amount) " + "VALUES (" +  IdAngajat.getText().toString() + ","   + SumaAngajat.getText().toString()  + ")";
						stmt.executeUpdate(sql);
					
					} catch(Exception f){System.out.println(f);}
			    }                                  
			
		});
		btnNewButton.setBounds(304, 79, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
