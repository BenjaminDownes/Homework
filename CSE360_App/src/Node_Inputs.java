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
		
		JFormattedTextField dependencies_1 = new JFormattedTextField();
		dependencies_1.setBounds(248, 42, 79, 22);
		frame.getContentPane().add(dependencies_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnReset) {
				activityName_1.setText("");
				duration_1.setText("");
				dependencies_1.setText("");
			}
			//	for (Component c : frame.getComponents()) {
			//	    if (c instanceof JFormattedTextField) { 
			//	       ((JFormattedTextField)c).setValue("");
			//	       frame.repaint();
			//	    }
			//	}
				//also need to clear network path
			}
		});
		btnReset.setBounds(725, 516, 97, 25);
		frame.getContentPane().add(btnReset);
		
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

	
	public void node_test(int tCase) {
		if(tCase == 1) {
			System.out.println("Test case 1");
			Node node = new Node();
			node.set_name("a");
			node.set_duration(2);
			System.out.println(node.toString());
			System.out.println("Name = " + node.get_name());
			
			Node node2 = new Node("B", 3);
			Node node3 = new Node("C", 5);
			
			ArrayList<Node> children = new ArrayList<>();
			children.add(node2);
			children.add(node3);
			
			node.set_children(children);
			
			System.out.println(node.get_children());
			System.out.print(node.get_children().get(0).get_name() + ", ");
			System.out.println(node.get_children().get(1).get_name());
			
			Node node4 = new Node("D", 3);
			node.add_child(node4);
			System.out.println(node.get_children());
			
			node.remove_child(node3);
			System.out.println(node.get_children());
		}
		else if(tCase == 2) {
			Network network = new Network();
			
			ArrayList<String> parents = new ArrayList<String>(); //Store list of parents
			int errorCode;
			String name;
			
			System.out.println("Add node 'a', duration 2, no parents\n");
			name = ("a");
			network.add_node(name, 2, parents);
			
			
//			System.out.println("Add duplicate node 'a':");
//			int errorCode = network.add_node("a", 3, parents);
//			System.out.println("Network.add('a') error code: " + errorCode + "\n");
			
			
			network.printDataStructures();
//			network.printInfo();
			System.out.println("-------------------------------------------------");
			
			System.out.println("Add node 'b', duration 3, parents: 'a'\n");
			parents = new ArrayList<String>();
			parents.add("a");
			errorCode = network.add_node("b", 3, parents);
			System.out.println("Network.add('b') error code: " + errorCode + "\n");
			
			network.printDataStructures();
//			network.printInfo();
			System.out.println("-------------------------------------------------");
			
			System.out.println("Add node 'c', duration 4, parents: 'a'\n");
			parents = new ArrayList<String>();
			parents.add("a");
			errorCode = network.add_node("c", 4, parents);
			System.out.println("Network.add('c') error code: " + errorCode + "\n");
			
			network.printDataStructures();
//			network.printInfo();
			System.out.println("-------------------------------------------------");
			
//			System.out.println("Add node 'c', duration 4, parents: 'a'\n");
//			errorCode = network.add_node("c", 4, parents);
//			System.out.println("Network.add('c') error code: " + errorCode + "\n");
//			
//			network.printMap();
//			network.printPathMap();
//			network.printPaths();
////			network.printInfo();
//			System.out.println("-------------------------------------------------");
			
			

			System.out.println("Add node 'd', duration 5, parents: 'b, c'\n");
			parents = new ArrayList<String>();
			parents.add("b");
			parents.add("c");
			errorCode = network.add_node("d", 5, parents);
			System.out.println("Network.add('d') error code: " + errorCode + "\n");
			
			network.printDataStructures();
//			network.printInfo();
			System.out.println("-------------------------------------------------");

			
			network.build_network();
			network.printInfo();
		}
		else if (tCase == 3) {
			randomNetworkGenerator networkGenerator = new randomNetworkGenerator();
			Network network = new Network();
			network = networkGenerator.generate_network(5);
			network.build_network();
			network.printDataStructures();
			network.printInfo();
			System.out.println(network.get_paths().toString());
		}
//		else if (tCase == 4) { //test cases based on project rubric
//			ArrayList<String> parents = new ArrayList<String>();
//
//			System.out.println("Results are correct for single, linear path (4 nodes in order)");
//			Network n1 = new Network();
//			n1.add_nodes("A", 2, parents);
//			parents.add()(n1.get_node("A"));
//			n1.add_node("B", 4, parents);
//			parents.clear();
//			parents.add(n1.get_node("B"));
//			n1.add_node("C", 6, parents);
//			parents.clear();
//			parents.add(n1.get_node("C"));
//			n1.add_node("D", 5, parents);
//			parents.clear();
//			n1.printInfo();
//
//			System.out.println("Results are correct for 2 paths (4 nodes in order)");
//			Network n2 = new Network();
//			n2.add_node("A", 2, parents);
//			parents.add(n2.get_node("A"));
//			n2.add_node("B", 4, parents);
//			n2.add_node("C", 6, parents);
//			parents.clear();
//			parents.add(n2.get_node("B"));
//			parents.add(n2.get_node("C"));
//			n2.add_node("D", 5, parents);
//			parents.clear();
//			n2.printInfo();
//
//			System.out.println("Results are correct for 4 paths (nodes inserted in order)");
//			Network n3 = new Network();
//			n3.add_node("A", 2, parents);
//			parents.add(n1.get_node("A"));
//			n3.add_node("B", 4, parents);
//			n3.add_node("C", 6, parents);
//			n3.add_node("D", 3, parents);
//			n3.add_node("E", 10, parents);
//			parents.clear();
//			parents.add(n3.get_node("B"));
//			parents.add(n3.get_node("C"));
//			parents.add(n3.get_node("D"));
//			parents.add(n3.get_node("E"));
//			n3.add_node("F", 5, parents);
//			parents.clear();
//			n3.printInfo();
//		}
//		
	}


}
