import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.Font;

public class fileLoader {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fileLoader window = new fileLoader();
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
	public fileLoader() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JFileChooser fc = new JFileChooser();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnSearch) {
			        int returnVal = fc.showOpenDialog(btnSearch);
				
				}
			}
		});
		btnSearch.setBounds(170, 137, 97, 25);
		panel.add(btnSearch);
		
		JLabel lblLoadFile = new JLabel("Load File");
		lblLoadFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoadFile.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLoadFile.setBounds(149, 13, 137, 42);
		panel.add(lblLoadFile);
		
		
	}
}
