import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import java.awt.Font;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;

public class Node_Inputs {

	private JFrame frame;

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
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c : frame.getComponents()) {
				    if (c instanceof JFormattedTextField) { 
				       ((JFormattedTextField)c).setValue("");
				       frame.repaint();
				    }
				}
				//also need to clear network path
			}
		});
		btnReset.setBounds(725, 516, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(616, 516, 97, 25);
		frame.getContentPane().add(button);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				//use a for loop to go through counter (which represents the # of rows)
				
				//iterate through each component in the frame by Row
				//counter should represent the # of rows
				ArrayList<String> names = new ArrayList<String>();		
				ArrayList<Integer> durations = new ArrayList<Integer>();
				ArrayList<String> parents = new ArrayList<String>();
				
				int activity_y_val = 42;
				for (int i = 0; i < counter; i++) {
					names.add(((JFormattedTextField)frame.getContentPane().getComponentAt(22, activity_y_val)).getText());
					if(((JFormattedTextField)frame.getContentPane().getComponentAt(22, activity_y_val)).getText().isEmpty())
						throw new java.lang.Error("an activityName is empty");
					activity_y_val+= 50;
					
				}	
				
				int duration_y_val = 42;
				for (int i = 0; i < counter; i++) {
					durations.add(Integer.parseInt(((JFormattedTextField)frame.getContentPane().getComponentAt(128, duration_y_val)).getText()));
					duration_y_val += 50;
					//throw error msg if not int or empty
					//if (((JFormattedTextField)frame.getContentPane().getComponentAt(128, duration_y_val)).getText().isEmpty() || ((JFormattedTextField)frame.getContentPane().getComponentAt(128, duration_y_val)).getText())
				}
				
				int parents_y_val = 42;
				for (int i = 0; i < counter; i++) {
					parents.add(((JFormattedTextField)frame.getContentPane().getComponentAt(248, parents_y_val)).getText());
					System.out.println(parents);
					
					parents_y_val += 50;
				
				
			}
		}});
		btnSubmit.setBounds(471, 314, 97, 25);
		frame.getContentPane().add(btnSubmit);
		JButton button2 = new JButton("Help");
		button2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame.getComponent(0), "New Node: Adds additional nodes" + "\n" + "Submit: Inserts all inputs into the program" + "\n" + "About this program: Information about the program and it's developers" + "\n" + "Restart: Resets program to its input stage" + "\n" + "Quit: Quits program");
        	}
		});
		button2.setBounds(525, 514, 79, 29);
		frame.getContentPane().add(button2);
		
		JButton btnAbout = new JButton("About this program");
		btnAbout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame.getComponent(0), "This program analyzes all inputted paths in a network and determines their duration." + "\n" + "Team members involved in program: Kristian Charboneau, Qianru Zhao, Benjamin Downes, Weinn Jiang");
	        }
		});
		btnAbout.setBounds(364, 516, 149, 25);
		frame.getContentPane().add(btnAbout);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblActivityName);
		
		JLabel label = new JLabel("Duration");
		label.setBounds(139, 13, 97, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Dependencies");
		label_1.setBounds(248, 13, 97, 16);
		frame.getContentPane().add(label_1);
		
		JFormattedTextField activityName_1 = new JFormattedTextField();
		activityName_1.setBounds(22, 42, 79, 22);
		frame.getContentPane().add(activityName_1);
		
		JFormattedTextField duration_1 = new JFormattedTextField();
		duration_1.setBounds(128, 42, 79, 22);
		frame.getContentPane().add(duration_1);
		lblNetworkAnalyzer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNetworkAnalyzer.setBounds(589, 0, 245, 76);
		frame.getContentPane().add(lblNetworkAnalyzer);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setBounds(392, 314, 67, 25);
		frame.getContentPane().add(btnAdd);
		btnAdd.setAction(action);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(248, 42, 79, 22);
		frame.getContentPane().add(formattedTextField);
	}
	int y = 42;
	int counter = 1;
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add a new row");
		}

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
			frame.repaint();
		}
		
	}
}
