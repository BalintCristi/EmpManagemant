import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashbord extends  javax.swing.JFrame {
	
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmpId;
	private JTextField textDept;
	private JTextField textSalariu;
	private JTextField textPhoneNum;
	private JTextField textEmail;
	private JTable table;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashbord frame = new Dashbord();
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
	public Dashbord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(-2, -2, 810, 677);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(16, 94, 89, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EmpId");
		lblNewLabel_1.setBounds(15, 128, 90, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Departament");
		lblNewLabel_2.setBounds(15, 158, 90, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Salariu");
		lblNewLabel_3.setBounds(16, 183, 89, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Numar Telefon");
		lblNewLabel_4.setBounds(16, 208, 89, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(16, 233, 89, 14);
		panel.add(lblNewLabel_5);
		
		textName = new JTextField();
		textName.setBounds(103, 96, 95, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		textEmpId = new JTextField();
		textEmpId.setBounds(103, 130, 95, 20);
		panel.add(textEmpId);
		textEmpId.setColumns(10);
		
		textDept = new JTextField();
		textDept.setBounds(104, 155, 94, 20);
		panel.add(textDept);
		textDept.setColumns(10);
		
		textSalariu = new JTextField();
		textSalariu.setBounds(105, 184, 93, 20);
		panel.add(textSalariu);
		textSalariu.setColumns(10);
		
		textPhoneNum = new JTextField();
		textPhoneNum.setBounds(105, 206, 93, 20);
		panel.add(textPhoneNum);
		textPhoneNum.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(105, 230, 93, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 24, 524, 642);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textName.setText(model.getValueAt(i, 0).toString());
				textEmpId.setText(model.getValueAt(i, 1).toString());
				textDept.setText(model.getValueAt(i, 2).toString());
				textSalariu.setText(model.getValueAt(i, 3).toString());
				textPhoneNum.setText(model.getValueAt(i, 4).toString());
				textEmail.setText(model.getValueAt(i, 5).toString());
				
				
				
			}
		});
		table.setBackground(SystemColor.text);
		model = new DefaultTableModel();
		Object[] column = {"Name","IdEmployee","Departament","Salary","Phone Number","Email"};
		Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals("") || textEmpId.getText().equals("") || textDept.getText().equals("") || textSalariu.getText().equals("") || textPhoneNum.getText().equals("")
						|| textEmail.getText().equals("") )
				{
				 JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else
				{
					row[0] = textName.getText();
					row[1] = textEmpId.getText();
					row[2] = textDept.getText();
					row[3] = textSalariu.getText();
					row[4] = textPhoneNum.getText();
					row[5] = textEmail.getText();
					model.addRow(row);
					
					textName.setText("");
					textEmpId.setText("");
					textDept.setText("");
					textSalariu.setText("");
					textPhoneNum.setText("");
					textEmail.setText("");
				}
				
			}
		});
		btnNewButton.setBounds(16, 275, 224, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update/Delete Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(textName.getText(), i, 0);
				model.setValueAt(textEmpId.getText(), i, 1);
				model.setValueAt(textDept.getText(), i, 2);
				model.setValueAt(textSalariu.getText(), i, 3);
				model.setValueAt(textPhoneNum.getText(), i, 4);
				model.setValueAt(textEmail.getText(), i, 5);
			}
		});
		btnNewButton_1.setBounds(16, 309, 224, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>= 0)
				{
					model.removeRow(i);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Select a row");
				}
			}
		});
		btnNewButton_2.setBounds(16, 343, 224, 23);
		panel.add(btnNewButton_2);
		
		
		
	}
}
