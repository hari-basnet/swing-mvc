package com.swingdemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.swingdemo.db.Database;
import com.swingdemo.model.Employee;
import com.swingdemo.service.EmployeeService;
import com.swingdemo.service.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;

public class EmployeeView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JLabel companyLabel;
	private JLabel postLabel;
	private JLabel countryLabel;
	private JLabel cityLabel;
	private JLabel addressLabel;
	private JLabel dobLabel;
	private JLabel joinedAtLabel;
	private JLabel salaryLabel;
	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JTextField ageTextField;
	private JTextField companyTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField countryTextField;
	private JTextField postTextField;
	private JTextField salaryTextField;
	private JButton saveButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton otherRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser dobDateChooser;
	private JDateChooser joinedAtDateChooser;

	private Employee employee = new Employee();
	private EmployeeService employeeService = new EmployeeServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView();
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
	public EmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getFirstNameLabel());
		contentPane.add(getLastNameLabel());
		contentPane.add(getAgeLabel());
		contentPane.add(getGenderLabel());
		contentPane.add(getEmailLabel());
		contentPane.add(getPhoneLabel());
		contentPane.add(getCompanyLabel());
		contentPane.add(getPostLabel());
		contentPane.add(getCountryLabel());
		contentPane.add(getCityLabel());
		contentPane.add(getAddressLabel());
		contentPane.add(getDobLabel());
		contentPane.add(getJoinedAtLabel());
		contentPane.add(getSalaryLabel());
		contentPane.add(getLastNameTextField());
		contentPane.add(getFirstNameTextField());
		contentPane.add(getAgeTextField());
		contentPane.add(getCompanyTextField());
		contentPane.add(getEmailTextField());
		contentPane.add(getPhoneTextField());
		contentPane.add(getAddressTextField());
		contentPane.add(getCityTextField());
		contentPane.add(getCountryTextField());
		contentPane.add(getPostTextField());
		contentPane.add(getSalaryTextField());
		contentPane.add(getSaveButton());
		contentPane.add(getEditButton());
		contentPane.add(getDeleteButton());
		contentPane.add(getClearButton());
		contentPane.add(getMaleRadioButton());
		contentPane.add(getFemaleRadioButton());
		contentPane.add(getOtherRadioButton());
		contentPane.add(getDobDateChooser());
		contentPane.add(getJoinedAtDateChooser());
		listEmployees();
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(573, 12, 551, 576);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Email", "Phone Number", "Country"
				}
			));
		}
		return table;
	}
	private JLabel getFirstNameLabel() {
		if (firstNameLabel == null) {
			firstNameLabel = new JLabel("First Name");
			firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			firstNameLabel.setBounds(10, 12, 82, 26);
		}
		return firstNameLabel;
	}
	private JLabel getLastNameLabel() {
		if (lastNameLabel == null) {
			lastNameLabel = new JLabel("LastName");
			lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lastNameLabel.setBounds(10, 49, 82, 14);
		}
		return lastNameLabel;
	}
	private JLabel getAgeLabel() {
		if (ageLabel == null) {
			ageLabel = new JLabel("Age");
			ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			ageLabel.setBounds(10, 74, 46, 14);
		}
		return ageLabel;
	}
	private JLabel getGenderLabel() {
		if (genderLabel == null) {
			genderLabel = new JLabel("Gender");
			genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			genderLabel.setBounds(10, 109, 46, 14);
		}
		return genderLabel;
	}
	private JLabel getEmailLabel() {
		if (emailLabel == null) {
			emailLabel = new JLabel("Email");
			emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			emailLabel.setBounds(10, 165, 46, 14);
		}
		return emailLabel;
	}
	private JLabel getPhoneLabel() {
		if (phoneLabel == null) {
			phoneLabel = new JLabel("Phone");
			phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			phoneLabel.setBounds(10, 196, 46, 14);
		}
		return phoneLabel;
	}
	private JLabel getCompanyLabel() {
		if (companyLabel == null) {
			companyLabel = new JLabel("Company");
			companyLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			companyLabel.setBounds(10, 134, 82, 14);
		}
		return companyLabel;
	}
	private JLabel getPostLabel() {
		if (postLabel == null) {
			postLabel = new JLabel("Post");
			postLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			postLabel.setBounds(10, 326, 46, 14);
		}
		return postLabel;
	}
	private JLabel getCountryLabel() {
		if (countryLabel == null) {
			countryLabel = new JLabel("Country");
			countryLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			countryLabel.setBounds(10, 289, 46, 14);
		}
		return countryLabel;
	}
	private JLabel getCityLabel() {
		if (cityLabel == null) {
			cityLabel = new JLabel("City");
			cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cityLabel.setBounds(10, 258, 46, 14);
		}
		return cityLabel;
	}
	private JLabel getAddressLabel() {
		if (addressLabel == null) {
			addressLabel = new JLabel("Address");
			addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			addressLabel.setBounds(10, 227, 46, 14);
		}
		return addressLabel;
	}
	private JLabel getDobLabel() {
		if (dobLabel == null) {
			dobLabel = new JLabel("Date of Birth");
			dobLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			dobLabel.setBounds(10, 399, 95, 14);
		}
		return dobLabel;
	}
	private JLabel getJoinedAtLabel() {
		if (joinedAtLabel == null) {
			joinedAtLabel = new JLabel("Joined at");
			joinedAtLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			joinedAtLabel.setBounds(10, 435, 82, 14);
		}
		return joinedAtLabel;
	}
	private JLabel getSalaryLabel() {
		if (salaryLabel == null) {
			salaryLabel = new JLabel("Salary");
			salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			salaryLabel.setBounds(10, 364, 46, 14);
		}
		return salaryLabel;
	}
	private JTextField getLastNameTextField() {
		if (lastNameTextField == null) {
			lastNameTextField = new JTextField();
			lastNameTextField.setBounds(153, 47, 127, 20);
			lastNameTextField.setColumns(10);
		}
		return lastNameTextField;
	}
	private JTextField getFirstNameTextField() {
		if (firstNameTextField == null) {
			firstNameTextField = new JTextField();
			firstNameTextField.setColumns(10);
			firstNameTextField.setBounds(153, 15, 127, 20);
		}
		return firstNameTextField;
	}
	private JTextField getAgeTextField() {
		if (ageTextField == null) {
			ageTextField = new JTextField();
			ageTextField.setBounds(153, 72, 127, 20);
			ageTextField.setColumns(10);
		}
		return ageTextField;
	}
	private JTextField getCompanyTextField() {
		if (companyTextField == null) {
			companyTextField = new JTextField();
			companyTextField.setBounds(153, 132, 127, 20);
			companyTextField.setColumns(10);
		}
		return companyTextField;
	}
	private JTextField getEmailTextField() {
		if (emailTextField == null) {
			emailTextField = new JTextField();
			emailTextField.setBounds(153, 163, 127, 20);
			emailTextField.setColumns(10);
		}
		return emailTextField;
	}
	private JTextField getPhoneTextField() {
		if (phoneTextField == null) {
			phoneTextField = new JTextField();
			phoneTextField.setBounds(153, 194, 127, 20);
			phoneTextField.setColumns(10);
		}
		return phoneTextField;
	}
	private JTextField getAddressTextField() {
		if (addressTextField == null) {
			addressTextField = new JTextField();
			addressTextField.setBounds(153, 225, 127, 20);
			addressTextField.setColumns(10);
		}
		return addressTextField;
	}
	private JTextField getCityTextField() {
		if (cityTextField == null) {
			cityTextField = new JTextField();
			cityTextField.setBounds(153, 256, 127, 20);
			cityTextField.setColumns(10);
		}
		return cityTextField;
	}
	private JTextField getCountryTextField() {
		if (countryTextField == null) {
			countryTextField = new JTextField();
			countryTextField.setBounds(153, 287, 127, 20);
			countryTextField.setColumns(10);
		}
		return countryTextField;
	}
	private JTextField getPostTextField() {
		if (postTextField == null) {
			postTextField = new JTextField();
			postTextField.setBounds(153, 324, 127, 20);
			postTextField.setColumns(10);
		}
		return postTextField;
	}
	private JTextField getSalaryTextField() {
		if (salaryTextField == null) {
			salaryTextField = new JTextField();
			salaryTextField.setBounds(153, 362, 127, 20);
			salaryTextField.setColumns(10);
		}
		return salaryTextField;
	}
	private JButton getSaveButton() {
		if (saveButton == null) {
			saveButton = new JButton("Save");
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// connect to database 
					Database db = new Database();
					Connection conn = db.createConnection();
					
					validateInputs();
					
					
					employee.setFirstName(firstNameTextField.getText());
					employee.setLastName(lastNameTextField.getText());
					if(!ageTextField.getText().matches("^(0|-*[1-9]+[0-9]*)$")) {
						JOptionPane.showMessageDialog(contentPane, "Numbers required in Age field");
						return;
					}
					employee.setAge(Integer.parseInt(ageTextField.getText()));
					employee.setGender(resolveGender());
					employee.setCompany(companyTextField.getText());
					employee.setEmail(getEmailTextField().getText());
					employee.setPhoneNumber(phoneTextField.getText());
					employee.setCity(cityTextField.getText());
					employee.setCountry(countryTextField.getText());
					employee.setAddress(addressTextField.getText());
					employee.setPost(postTextField.getText());
					if(!salaryTextField.getText().matches("^(0|-*[1-9]+[0-9]*)$")) {
						JOptionPane.showMessageDialog(contentPane, "Numbers required in Salary field");
						return;
					}
					employee.setSalary(Integer.parseInt(salaryTextField.getText()));
					employee.setDob(new Date(dobDateChooser.getDate().getTime()));
					employee.setJoiningDate(new Date(joinedAtDateChooser.getDate().getTime()));
					
					if(employeeService.addEmp(employee)) {
						JOptionPane.showMessageDialog(contentPane, "Database insert successfully!");
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "Databse insert failure!");
					}
					
					listEmployees();
					clearFields();
					
					System.out.println("how is the connection ");
				}
			});
			saveButton.setBackground(new Color(0, 153, 0));
			saveButton.setOpaque(true);
			saveButton.setBounds(68, 518, 89, 23);
		}
		return saveButton;
	}
	private JButton getEditButton() {
		if (editButton == null) {
			editButton = new JButton("Edit");
			editButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(contentPane, "Please select a row to edit...");
						return;
					}
					
					int row = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(row, 0);
					
					EditEmployeeView editEmployeeView = new EditEmployeeView();
					editEmployeeView.setLocationRelativeTo(contentPane);
					editEmployeeView.setData(id);
					editEmployeeView.setVisible(true);
					
					
					dispose();
				}
			});
			editButton.setBounds(172, 518, 89, 23);
		}
		return editButton;
	}
	private JButton getDeleteButton() {
		if (deleteButton == null) {
			deleteButton = new JButton("Delete");
			deleteButton.setBounds(281, 518, 89, 23);
		}
		return deleteButton;
	}
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton("Clear All");
			clearButton.setBounds(388, 518, 89, 23);
		}
		return clearButton;
	}
	private JRadioButton getMaleRadioButton() {
		if (maleRadioButton == null) {
			maleRadioButton = new JRadioButton("Male");
			buttonGroup.add(maleRadioButton);
			maleRadioButton.setBounds(152, 99, 109, 23);
		}
		return maleRadioButton;
	}
	private JRadioButton getFemaleRadioButton() {
		if (femaleRadioButton == null) {
			femaleRadioButton = new JRadioButton("Female");
			buttonGroup.add(femaleRadioButton);
			femaleRadioButton.setBounds(281, 99, 109, 23);
		}
		return femaleRadioButton;
	}
	private JRadioButton getOtherRadioButton() {
		if (otherRadioButton == null) {
			otherRadioButton = new JRadioButton("Other");
			buttonGroup.add(otherRadioButton);
			otherRadioButton.setBounds(402, 99, 109, 23);
		}
		return otherRadioButton;
	}
	
	private String resolveGender() {
		String genderValue = "";
		
		if(maleRadioButton.isSelected()) {
			genderValue = "Male";
		}else if(femaleRadioButton.isSelected()) {
			genderValue = "Female";
		}else {
			genderValue = "Other";
		}
		
		return genderValue;
	}
	
	private void validateInputs() {
		
		if(firstNameTextField.getText().isEmpty() || 
				lastNameTextField.getText().isEmpty() ||
				ageTextField.getText().isEmpty() || 
				emailTextField.getText().isEmpty() || 
				companyTextField.getText().isEmpty() ||
				phoneTextField.getText().isEmpty() ||
				cityTextField.getText().isEmpty() ||
				addressTextField.getText().isEmpty() ||
				countryTextField.getText().isEmpty() ||
				postTextField.getText().isEmpty()
				) {
			JOptionPane.showMessageDialog(contentPane, "Fields are required");
			return;
		}
	
	}
	
	private void clearFields() {
		
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		ageTextField.setText("");
		emailTextField.setText("");
		companyTextField.setText("");
		phoneTextField.setText("");
		cityTextField.setText("");
		addressTextField.setText("");
		countryTextField.setText("");
		postTextField.setText("");
		salaryTextField.setText("");
	}
	
	private JDateChooser getDobDateChooser() {
		if (dobDateChooser == null) {
			dobDateChooser = new JDateChooser();
			dobDateChooser.setBounds(153, 399, 127, 20);
		}
		return dobDateChooser;
	}
	
	private JDateChooser getJoinedAtDateChooser() {
		if (joinedAtDateChooser == null) {
			joinedAtDateChooser = new JDateChooser();
			joinedAtDateChooser.setBounds(153, 429, 127, 20);
		}
		return joinedAtDateChooser;
	}

	private void listEmployees() {
		
		try {
		
			List<Employee> employees = employeeService.getAllEmp();
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			for(Employee emp : employees) {
				
				model.addRow(new Object[] {emp.getId(), emp.getFirstName() + " " + emp.getLastName(), emp.getEmail(), emp.getPhoneNumber(), emp.getCountry()});
				
			}
			
			}catch (Exception e1) {
				e1.printStackTrace();
			}
	}
}
