import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
				
				//private final ArrayList<Node> names = new ArrayList<Node>(); 
				//Node row_x = new Node();
//				row_x.set_name(frame.getComponentAt(22, concurrentY).toString());
//				row_x.set_duration(Integer.parseInt(frame.getComponentAt(128, concurrentY).toString())); //add 50 to y values for each row...
//				row_x.set_children(null);
				
			}
		});
		btnSubmit.setBounds(117, 387, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JButton button2 = new JButton("Help");
		button2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame.getComponent(0), "New Node: Adds additional nodes" + "\n" + "Submit: Inserts all inputs into the program" + "\n" + "About this program: Information about the program and it's developers" + "\n" + "Restart: Resets program to its input stage" + "\n" + "Quit: Quits program");
        	}
		});
		button2.setBounds(438, 10, 79, 29);
		frame.getContentPane().add(button2);
		
		JButton btnAbout = new JButton("About this program");
		btnAbout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame.getComponent(0), "This program analyzes all inputted paths in a network and determines their duration." + "\n" + "Team members involved in program: Kristian Charboneau, Qianru Zhao, Benjamin Downes, Weinn Jiang");
        	}
		});
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
		
		node_test(2);

		node_test(3);

	}
	int y = 142;
	int counter = 4;
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add a new row");
		}
		int y = 142;
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
