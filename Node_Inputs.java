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

public class Node_Inputs {
	int y = 134;
	private JFrame frame;
	private JTable table;
	private final Action action = new SwingAction();

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
			}
		});
		button.setBounds(570, 516, 97, 25);
		frame.getContentPane().add(button);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(365, 284, 97, 25);
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
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				y += 50; //bring three boxes downward 50 y pixels
				JFormattedTextField formattedTextField_9 = new JFormattedTextField();
				formattedTextField_9.setBounds(22, y, 79, 22);
				frame.getContentPane().add(formattedTextField_9);
				
				JFormattedTextField formattedTextField_10 = new JFormattedTextField();
				formattedTextField_10.setBounds(128, y, 79, 22);
				frame.getContentPane().add(formattedTextField_10);
				
				JFormattedTextField formattedTextField_11 = new JFormattedTextField();
				formattedTextField_11.setBounds(248, y, 79, 22);
				frame.getContentPane().add(formattedTextField_11);
			}
		});
		btnAdd.setAction(action);
		btnAdd.setBounds(12, 196, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(22, 42, 79, 22);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(128, 42, 79, 22);
		frame.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(22, 84, 79, 22);
		frame.getContentPane().add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(128, 84, 79, 22);
		frame.getContentPane().add(formattedTextField_4);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(248, 84, 79, 22);
		frame.getContentPane().add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setBounds(22, 134, 79, 22);
		frame.getContentPane().add(formattedTextField_5);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setBounds(128, 134, 79, 22);
		frame.getContentPane().add(formattedTextField_6);
		
		JFormattedTextField formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setBounds(248, 134, 79, 22);
		frame.getContentPane().add(formattedTextField_7);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}


		public void actionPerformed(ActionEvent e) {
			y += 50; //bring three boxes downward 50 y pixels
			JFormattedTextField formattedTextField_9 = new JFormattedTextField();
			formattedTextField_9.setBounds(22, y, 79, 22);
			frame.getContentPane().add(formattedTextField_9);
			
			JFormattedTextField formattedTextField_10 = new JFormattedTextField();
			formattedTextField_10.setBounds(128, y, 79, 22);
			frame.getContentPane().add(formattedTextField_10);
			
			JFormattedTextField formattedTextField_11 = new JFormattedTextField();
			formattedTextField_11.setBounds(248, y, 79, 22);
			frame.getContentPane().add(formattedTextField_11);
		}
	}
}
