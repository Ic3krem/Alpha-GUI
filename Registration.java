package main;

import javax.print.attribute.AttributeSet;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JPanel {
	
	private JTextField nameB, userB;
	private JPasswordField passB, confirmB;
	private JPanel regisForm;
	private JLabel fullN, Age, Category, userN, passW, confirmP;
	private JButton signUp;
	private JSpinner ageB;
	private JComboBox categoryB;
	private loginp parentFrame;

	public Registration(loginp parent) {
		this.parentFrame = parent;
		setBackground(new Color(0x1D, 0x29, 0x81));
		setPreferredSize(new Dimension(1200, 800));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Your Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(387, 90, 414, 64);
		
		regisForm = new JPanel();
		regisForm.setBounds(143, 178, 900, 453);
		regisForm.setBackground(Color.WHITE);
		regisForm.setLayout(null);
		
			fullN = new JLabel("Full Name");
			fullN.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			fullN.setBounds(45, 43, 98, 24);
			
			Age = new JLabel("Age");
			Age.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			Age.setBounds(45, 126, 98, 24);
			
			Category = new JLabel("Category");
			Category.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			Category.setBounds(146, 126, 98, 24);
			
			userN = new JLabel("Username");
			userN.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			userN.setBounds(451, 43, 98, 24);
			
			passW = new JLabel("Password");
			passW.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			passW.setBounds(451, 126, 98, 24);
			
			confirmP = new JLabel("Confirm Password");
			confirmP.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			confirmP.setBounds(451, 209, 154, 24);
			
			signUp = new JButton("Sign up");
			signUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        String name = nameB.getText().trim();
			        String username = userB.getText().trim();
			        String password = new String(passB.getPassword()).trim();
			        String confirm = new String(confirmB.getPassword()).trim();
			        int age = (Integer) ageB.getValue();
			        String category = (String) categoryB.getSelectedItem();

			        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
			            JOptionPane.showMessageDialog(null,
			                "Please fill in all the fields.",
			                "Missing Information",
			                JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        if (age <= 0) {
			            JOptionPane.showMessageDialog(null,
			                "Please enter a valid age.",
			                "Invalid Age",
			                JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        if (!password.equals(confirm)) {
			            JOptionPane.showMessageDialog(null,
			                "Passwords do not match.",
			                "Password Error",
			                JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        JOptionPane.showMessageDialog(null,
			            "Account created successfully!",
			            "Success",
			            JOptionPane.INFORMATION_MESSAGE);

			        parentFrame.showLogin();
			    }
			});
			signUp.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
			signUp.setBounds(45, 234, 199, 38);
			
			nameB = new JTextField();
			nameB.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
			nameB.setBounds(45, 67, 293, 38);
			nameB.setColumns(10);
			((AbstractDocument) nameB.getDocument()).setDocumentFilter(new DocumentFilter() {
	            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
	                if (string.matches("[a-zA-Z ]+")) {
	                    super.insertString(fb, offset, string, attr);
	                }
	            }

	            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
	                if (text.matches("[a-zA-Z ]+")) {
	                    super.replace(fb, offset, length, text, attrs);
	                }
	            }
	        });
			
			
			userB = new JTextField();
			userB.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
			userB.setBounds(451, 67, 293, 38);
			userB.setColumns(10);
			
			ageB = new JSpinner();
			ageB.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
			ageB.setBounds(45, 151, 66, 38);		
			
			categoryB = new JComboBox();
			categoryB.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
			categoryB.setModel(new DefaultComboBoxModel(new String[] {"Student", "Employee", "Alumni", "Outsider"}));
			categoryB.setBounds(146, 151, 192, 38);		
			
			passB = new JPasswordField();
			passB.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
			passB.setBounds(451, 151, 293, 38);
					
			confirmB = new JPasswordField();
			confirmB.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
			confirmB.setBounds(451, 234, 293, 38);
		
		add(lblNewLabel);
		add(regisForm);
			regisForm.add(fullN);
			regisForm.add(Age);
			regisForm.add(Category);
			regisForm.add(userN);
			regisForm.add(passW);
			regisForm.add(confirmP);
			regisForm.add(ageB);
			regisForm.add(categoryB);
			regisForm.add(passB);
			regisForm.add(confirmB);
			regisForm.add(nameB);
			regisForm.add(signUp);
			regisForm.add(userB);
	}
}
