package main;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserBodystats extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField textField, results;
    private JTable table;
    private JSpinner spinnerAge, spinnerHeight, spinnerWeight;
    private JButton computeBMI, updateBMI;
    private JLabel lblNewLabel, nameLabel,  bmiLabel, ageLabel, heightLabel, weightLabel;

    public UserBodystats() {
        setSize(800, 800);
        setLayout(null);
        setBackground(Color.WHITE);

	        lblNewLabel = new JLabel("Body Status");
	        lblNewLabel.setForeground(new Color(0, 64, 128));
	        lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 40));
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setBounds(281, 50, 237, 64);        
	
	        nameLabel = new JLabel("Name");
	        nameLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
	        nameLabel.setBounds(67, 155, 72, 38);        
	
	        bmiLabel = new JLabel("BMI");
	        bmiLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
	        bmiLabel.setBounds(67, 264, 49, 38);
	        
	        ageLabel = new JLabel("Age");
	        ageLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
	        ageLabel.setBounds(444, 155, 46, 38);        
	
	        heightLabel = new JLabel("Height");
	        heightLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
	        heightLabel.setBounds(444, 264, 82, 38);        
	
	        weightLabel = new JLabel("Weight");
	        weightLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
	        weightLabel.setBounds(600, 263, 86, 38);
	        
	        textField = new JTextField();
	        textField.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
	        textField.setBounds(67, 190, 330, 53);
	        textField.setColumns(10);        
	
	        spinnerAge = new JSpinner();
	        spinnerAge.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
	        spinnerAge.setBounds(444, 190, 286, 53);        
	
	        spinnerHeight = new JSpinner(new SpinnerNumberModel(170.0, 0.0, 300.0, 0.1));
	        spinnerHeight.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
	        spinnerHeight.setBounds(444, 300, 130, 53);
	
	        spinnerWeight = new JSpinner(new SpinnerNumberModel(70.0, 0.0, 300.0, 0.1));
	        spinnerWeight.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
	        spinnerWeight.setBounds(600, 300, 130, 53);        
	
	        computeBMI = new JButton("Compute BMI");
	        computeBMI.setForeground(Color.WHITE);
	        computeBMI.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
	        computeBMI.setBackground(new Color(42, 158, 222));
	        computeBMI.setBounds(67, 300, 150, 53);
	        computeBMI.addActionListener(e -> {
	            try {
	                double heightCm = (Double) spinnerHeight.getValue();
	                double weightKg = (Double) spinnerWeight.getValue();
	                double heightM = heightCm / 100.0;
	
	                if (heightM <= 0 || weightKg <= 0) {
	                    results.setText("Please enter valid height and weight.");
	                    return;
	                }
	
	                double bmi = weightKg / (heightM * heightM);
	                String classification;
	
	                if (bmi < 18.5) {
	                    classification = "Underweight";
	                } else if (bmi < 24.9) {
	                    classification = "Normal";
	                } else if (bmi < 29.9) {
	                    classification = "Overweight";
	                } else {
	                    classification = "Obese";
	                }
	
	                results.setText(String.format("BMI: %.2f (%s)", bmi, classification));
	            } catch (Exception ex) {
	                results.setText("Error computing BMI.");
	                ex.printStackTrace();
	            }
	        });       
	
	        updateBMI = new JButton("Update BMI");
	        updateBMI.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
	        updateBMI.setForeground(Color.WHITE);
	        updateBMI.setBackground(new Color(233, 0, 32));
	        updateBMI.setBounds(247, 300, 150, 53);
	        updateBMI.addActionListener(e -> {
	            try {
	                double heightCm = (Double) spinnerHeight.getValue();
	                double weightKg = (Double) spinnerWeight.getValue();
	                double heightM = heightCm / 100.0;
	
	                if (heightM <= 0 || weightKg <= 0) {
	                    results.setText("Please enter valid height and weight.");
	                    return;
	                }
	
	                double bmi = weightKg / (heightM * heightM);
	                String classification;
	
	                if (bmi < 18.5) {
	                    classification = "Underweight";
	                } else if (bmi < 24.9) {
	                    classification = "Normal";
	                } else if (bmi < 29.9) {
	                    classification = "Overweight";
	                } else {
	                    classification = "Obese";
	                }
	
	                results.setText(String.format("BMI: %.2f (%s)", bmi, classification));
	                
	                int nextId = tableModel.getRowCount() + 1;
	                String recordId = String.format("%03d", nextId);
	                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	                tableModel.addRow(new Object[]{recordId, date, String.format("%.2f", bmi), classification});
	            } catch (Exception ex) {
	                results.setText("Error updating BMI.");
	                ex.printStackTrace();
	            }
	        });
	        
	        results = new JTextField();
	        results.setForeground(new Color(240, 233, 0));
	        results.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
	        results.setBackground(new Color(255, 255, 255));
	        results.setBounds(67, 364, 330, 53);
	        results.setColumns(10);
	        results.setEditable(false);
		
	        String[] columnNames = {"Record ID", "Date Recorded", "BMI", "Classification"};
	        tableModel = new DefaultTableModel(columnNames, 0);
	        table = new JTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(67, 428, 663, 285);
        
                
                
	add(lblNewLabel);
        add(nameLabel);
        add(Name);
        add(ageLabel);
        add(spinnerAge);
        add(bmiLabel);
        add(heightLabel);
        add(spinnerHeight);
        add(weightLabel);
        add(spinnerWeight);
        add(computeBMI);
        add(updateBMI);
        add(results);
        add(scrollPane);
    }
}
