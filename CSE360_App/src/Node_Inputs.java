import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Node_Inputs {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(310, 215, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(198, 215, 97, 25);
		frame.getContentPane().add(button);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(279, 144, 97, 25);
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
		
		node_test(2);
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
			
			System.out.println("Add node 'a', duration 2, no parents\n");
			network.add_node("a", 2, parents);
			
			
			System.out.println("Add duplicate node 'a':");
			int errorCode = network.add_node("a", 3, parents);
			System.out.println("Network.add('a') error code: " + errorCode + "\n");
			
			
			network.printMap();
			network.printPathMap();
			network.printPaths();
			System.out.println("-------------------------------------------------");
			
			System.out.println("Add node 'b', duration 3, parents: 'a'\n");
			parents.add("a");
			errorCode = network.add_node("b", 3, parents);
			System.out.println("Network.add('b') error code: " + errorCode + "\n");
			
			network.printMap();
			network.printPathMap();
			network.printPaths();	
			System.out.println("-------------------------------------------------");
			
			
			network.printInfo();
		}
		
	}
}

