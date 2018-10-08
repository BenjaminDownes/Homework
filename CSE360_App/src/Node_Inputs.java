
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
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;
import java.awt.List;

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
				       ((JFormattedTextField)c).setText("");
				    }
				}
				//also clear network path
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
		button.setBounds(570, 516, 97, 25);
		frame.getContentPane().add(button);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				int concurrentY = 42;
				private final List<Node> names = new ArrayList<Node>(); 
				Node row_x = new Node();
				row_x.set_name(frame.getComponentAt(22, concurrentY).toString());
				row_x.set_duration(Integer.parseInt(frame.getComponentAt(128, concurrentY).toString())); //add 50 to y values for each row...
				row_x.set_children(null);
				
			}
		});
		btnSubmit.setBounds(117, 387, 97, 25);
		frame.getContentPane().add(btnSubmit);
<<<<<<< Updated upstream
=======
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setBounds(29, 16, 125, 16);
		frame.getContentPane().add(lblActivityName);
		
		JLabel label = new JLabel("Duration");
		label.setBounds(180, 16, 97, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Dependencies");
		label_1.setBounds(308, 16, 97, 16);
		frame.getContentPane().add(label_1);
		

>>>>>>> Stashed changes
		JButton button2 = new JButton("Help");
		button2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame.getComponent(0), "New Node: Adds additional nodes" + "\n" + "Submit: Inserts all inputs into the program" + "\n" + "About this program: Information about the program and it's developers" + "\n" + "Restart: Resets program to its input stage" + "\n" + "Quit: Quits program");
        	}
		});
		button2.setBounds(438, 10, 79, 29);
		frame.getContentPane().add(button2);
<<<<<<< Updated upstream
=======


		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(438, 10, 79, 29);
		frame.getContentPane().add(btnHelp);

>>>>>>> Stashed changes
		
		JButton btnAbout = new JButton("About this program");
		btnAbout.setBounds(29, 307, 171, 29);
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
		
		JFormattedTextField activityName_2 = new JFormattedTextField();
		activityName_2.setBounds(22, 92, 79, 22);
		frame.getContentPane().add(activityName_2);
		
		JFormattedTextField duration_2 = new JFormattedTextField();
		duration_2.setBounds(128, 92, 79, 22);
		frame.getContentPane().add(duration_2);
		
		JFormattedTextField dependencies_2 = new JFormattedTextField();
		dependencies_2.setBounds(248, 92, 79, 22);
		frame.getContentPane().add(dependencies_2);
		
		JFormattedTextField activityName = new JFormattedTextField();
		activityName.setBounds(22, 142, 79, 22);
		frame.getContentPane().add(activityName);
		
		JFormattedTextField duration_3 = new JFormattedTextField();
		duration_3.setBounds(128, 142, 79, 22);
		frame.getContentPane().add(duration_3);
		
		JFormattedTextField dependencies_3 = new JFormattedTextField();
		dependencies_3.setBounds(248, 142, 79, 22);
		frame.getContentPane().add(dependencies_3);
		lblNetworkAnalyzer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNetworkAnalyzer.setBounds(589, 0, 245, 76);
		frame.getContentPane().add(lblNetworkAnalyzer);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(12, 387, 67, 25);
		frame.getContentPane().add(btnAdd);
		btnAdd.setAction(action);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(248, 42, 79, 22);
		frame.getContentPane().add(formattedTextField);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add a new row");
		}
<<<<<<< Updated upstream
		int y = 142;
		int counter = 4;
=======
		else if (tCase == 3) {
			randomNetworkGenerator networkGenerator = new randomNetworkGenerator();
			Network network = new Network();
			network = networkGenerator.generate_network(20);
			network.printInfo();
			System.out.println(network.get_paths().toString());
		}
		else if (tCase == 4) { //test cases based on project rubric
			ArrayList<String> parents = new ArrayList<String>();

			System.out.println("Results are correct for single, linear path (4 nodes in order)");
			Network n1 = new Network();
			n1.add_nodes("A", 2, parents);
			parents.add()(n1.get_node("A"));
			n1.add_node("B", 4, parents);
			parents.clear();
			parents.add(n1.get_node("B"));
			n1.add_node("C", 6, parents);
			parents.clear();
			parents.add(n1.get_node("C"));
			n1.add_node("D", 5, parents);
			parents.clear();
			n1.printInfo();
>>>>>>> Stashed changes

		public void actionPerformed(ActionEvent e) {
			
			JFormattedTextField activityName_x = new JFormattedTextField();
			activityName_x.setBounds(22, y+50, 79, 22);
			frame.getContentPane().add(activityName_x);;
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

