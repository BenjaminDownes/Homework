package Network_Analyzer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;

public class Node_Inputs {
	int y = 134;
	private JFrame frame;
	private JTable table;
	private final Action action = new SwingAction();
	private final JLabel lblNetworkAnalyzer = new JLabel("Network Analyzer");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Node_Inputs window = new Node_Inputs();
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
	public Node_Inputs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(669, 516, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(570, 516, 97, 25);
		frame.getContentPane().add(button);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//this will analyze the inputed data and show the correct output
			}
		});
		btnSubmit.setBounds(531, 341, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblActivityName);
		
		JLabel label = new JLabel("Duration");
		label.setBounds(139, 13, 97, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Dependencies");
		label_1.setBounds(248, 13, 97, 16);
		frame.getContentPane().add(label_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setAction(action);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFormattedTextField activityName_x = new JFormattedTextField();
				activityName_x.setBounds(22, y+50, 79, 22);
				frame.getContentPane().add(activityName_x);
				int counter = 4;
				activityName_x.setName("activityName_" + counter);
				
				JFormattedTextField duration_x = new JFormattedTextField();
				duration_x.setBounds(128, y+50, 79, 22);
				frame.getContentPane().add(duration_x);
				duration_x.setName("duration_" + counter);
				
				JFormattedTextField dependencies_x = new JFormattedTextField();
				dependencies_x.setBounds(248, y+50, 79, 22);
				frame.getContentPane().add(dependencies_x);
				dependencies_x.setName("dependencies_" + counter);
				y+=50;
				counter++; //keeps track of current row index
			}
		});
		btnAdd.setBounds(22, 341, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JFormattedTextField activityName_1 = new JFormattedTextField();
		activityName_1.setBounds(22, 42, 79, 22);
		frame.getContentPane().add(activityName_1);
		
		JFormattedTextField duration_1 = new JFormattedTextField();
		duration_1.setBounds(128, 42, 79, 22);
		frame.getContentPane().add(duration_1);
		
		JFormattedTextField activityName_2 = new JFormattedTextField();
		activityName_2.setBounds(22, 84, 79, 22);
		frame.getContentPane().add(activityName_2);
		
		JFormattedTextField duration_2 = new JFormattedTextField();
		duration_2.setBounds(128, 84, 79, 22);
		frame.getContentPane().add(duration_2);
		
		JFormattedTextField dependencies_2 = new JFormattedTextField();
		dependencies_2.setBounds(248, 84, 79, 22);
		frame.getContentPane().add(dependencies_2);
		
		JFormattedTextField activityName = new JFormattedTextField();
		activityName.setBounds(22, 134, 79, 22);
		frame.getContentPane().add(activityName);
		
		JFormattedTextField duration_3 = new JFormattedTextField();
		duration_3.setBounds(128, 134, 79, 22);
		frame.getContentPane().add(duration_3);
		
		JFormattedTextField dependencies_3 = new JFormattedTextField();
		dependencies_3.setBounds(248, 134, 79, 22);
		frame.getContentPane().add(dependencies_3);
		lblNetworkAnalyzer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNetworkAnalyzer.setBounds(401, -12, 245, 76);
		frame.getContentPane().add(lblNetworkAnalyzer);
	}


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add a new row");
		}
		int y = 134;
		int counter = 4;
		public void actionPerformed(ActionEvent e) {
			
			JFormattedTextField activityName_x = new JFormattedTextField();
			activityName_x.setBounds(22, y+50, 79, 22);
			frame.getContentPane().add(activityName_x);
			activityName_x.setName("activityName_" + counter);
			
			JFormattedTextField duration_x = new JFormattedTextField();
			duration_x.setBounds(128, y+50, 79, 22);
			frame.getContentPane().add(duration_x);
			duration_x.setName("duration_" + counter);
			
			JFormattedTextField dependencies_x = new JFormattedTextField();
			dependencies_x.setBounds(248, y+50, 79, 22);
			frame.getContentPane().add(dependencies_x);
			dependencies_x.setName("dependencies_" + counter);
			y+=50;
			counter++; //keeps track of current row index
			
		}
	}
}

