/** 
This class is responsible for creating the WBT 
 * @ Author: Jake Hedges
 * @ Version: 1.0 - button functionality.
 * 
 * Changes to be made for version 1.1:
 * - Calendar to be added
 * - WBT/PERT/GANTT to modelled based on common data
 * 
 * */
// Things to do:
// - Add text formatter to ID box
// - Add date input
// - implement rest of buttons
// - code buttons, basically
// - properly JDoc 
// - Create testing class
// - Upload to GitHub

package randomPackage;

import java.awt.EventQueue;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class randomWindow{

	private JFrame frame;

	private JTextField txtID;
	private JTextField txtDesc;
	private JTextField startDate;
	private JTextField endDate;
	private JTextField dur;
	private JTextField txtTaskId;
	private JTextField txtDescription;
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private JTextField txtDuration;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					randomWindow window = new randomWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public randomWindow() {
		initialize();
	}

	/**
	 * Initialises the contents of the frame, to the dimensions of the user's window and the variables responsible for correct data manipulation
	 * @return opens "WBT creator"
	 */
	
	private void initialize() {	
		/**
		 * Initialises variables and formatted text variables
		 */		
		frame = new JFrame("WBT creator");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		frame.getContentPane().setBackground(new Color(153, 180, 209));
		frame.setBounds(0, 0, size.width, size.height-40);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	/**
	 * Creates JPanel and containers
	 */		
		JPanel WBTpanel = new JPanel();
		WBTpanel.setBounds(10, 10, 1330, 304);
		WBTpanel.setBackground(Color.gray);
		frame.getContentPane().add(WBTpanel);
		WBTpanel.setAutoscrolls(true);
		
		JTextPane WBTTaskTextArea = new JTextPane();
		WBTTaskTextArea.setEditable(false);
		WBTTaskTextArea.setText("ID:      Task Desc:                                                                               Start date:                                    End date:                                    Duration:            ");
		WBTTaskTextArea.setBounds(10, 359, 1330, 162);
		frame.getContentPane().add(WBTTaskTextArea);
		//JScrollPane sp = new JScrollPane(WBTTaskTextArea);
		//frame.getContentPane().add(sp);
	
	/**
	 * Creates buttons for allowable actions.
	 */
		
	/**
	 * Add button checks the file for correctness and duplicity, and then passes 
	 * @Return returns added data to the files
	 */
	btnAdd = new JButton("Add task");
	btnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		}
	});
	// checkForCorrectness();
	btnAdd.setBounds(10, 532, 114, 23);
	frame.getContentPane().add(btnAdd);
	{
}

	/**
	 * Responsible for saving an image of the created chart from the Jframe once it has been initialised
	 */
	JButton btnSave = new JButton("Save image");
	btnSave.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		}
	});
	btnSave.setBounds(10, 325, 114, 23);
	frame.getContentPane().add(btnSave);
		
	JButton btnCreateWBT = new JButton("Create chart");
	btnCreateWBT.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		}
	});
	btnCreateWBT.setBounds(1226, 325, 114, 23);
	frame.getContentPane().add(btnCreateWBT);
	
	JButton btnEdit = new JButton("Edit task");
	btnEdit.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		}
	});
	btnEdit.setBounds(10, 623, 114, 23);
	frame.getContentPane().add(btnEdit);
		
	JButton btnRemove = new JButton("Remove task");
	btnRemove.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		}
	});
	btnRemove.setBounds(138, 623, 114, 23);
	frame.getContentPane().add(btnRemove);
	
	/** 
	 * Initiates text fields and descriptions
	 */
	txtID = new JTextField();
	txtID.setBounds(10, 582, 86, 20);
	frame.getContentPane().add(txtID);
	txtID.setColumns(10);
		
	txtDesc = new JTextField();
	txtDesc.setColumns(10);
	txtDesc.setBounds(116, 582, 425, 20);
	frame.getContentPane().add(txtDesc);
		
	dur = new JTextField();
	dur.setColumns(10);
	dur.setBounds(969, 581, 32, 21);
	frame.getContentPane().add(dur);
		
	txtTaskId = new JTextField();
	txtTaskId.setText("Task ID");
	txtTaskId.setBorder(null);
	txtTaskId.setBackground(new Color(0,0,0,0));
	txtTaskId.setBounds(10, 566, 86, 20);
	frame.getContentPane().add(txtTaskId);
	txtTaskId.setColumns(10);
		
	txtDescription = new JTextField();
	txtDescription.setText("Task description");
	txtDescription.setBorder(null);
	txtDescription.setBackground(new Color(0,0,0,0));
	txtDescription.setColumns(10);
	txtDescription.setBounds(116, 566, 94, 20);
	frame.getContentPane().add(txtDescription);
		
	txtStartDate = new JTextField();
	txtStartDate.setText("Start date");
	txtStartDate.setBorder(null);
	txtStartDate.setBackground(new Color(0,0,0,0));
	txtStartDate.setColumns(10);
	txtStartDate.setBounds(551, 558, 86, 36);
	frame.getContentPane().add(txtStartDate);
		
	txtEndDate = new JTextField();
	txtEndDate.setText("End date");
	txtEndDate.setBorder(null);
	txtEndDate.setBackground(new Color(0,0,0,0));
	txtEndDate.setColumns(10);
	txtEndDate.setBounds(759, 558, 86, 36);
	frame.getContentPane().add(txtEndDate);
		
	txtDuration = new JTextField();
	txtDuration.setText("Duration");
	txtDuration.setBorder(null);
	txtDuration.setBackground(new Color(0,0,0,0));
	txtDuration.setColumns(10);
	txtDuration.setBounds(969, 558, 86, 36);
	frame.getContentPane().add(txtDuration);
		
	endDate = new JTextField();
	endDate.setColumns(10);
	endDate.setBounds(759, 581, 200, 21);
	frame.getContentPane().add(endDate);			
		
	startDate = new JTextField();
	startDate.setColumns(10);
	startDate.setBounds(551, 581, 200, 21);
	frame.getContentPane().add(startDate);
	
	/**
	 * Initiates values for combo boxes and other vital data
	 */
	String[] availableMetric = { "Minutes", "Hours", "Days", "Weeks" };
	JComboBox<?> dur_metric = new JComboBox<Object>(availableMetric);
	dur_metric.setBounds(1001, 582, 70, 20);
	frame.getContentPane().add(dur_metric);
	}
	 
	
}
