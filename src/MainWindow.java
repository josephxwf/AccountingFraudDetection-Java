import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
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
		//frame.getContentPane().add(scroll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 45, 134, 227);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JTextArea textResult = new JTextArea();
		textResult.setBounds(234, 45, 210, 227);
		frame.getContentPane().add(textResult);
		
		
		JButton btnReadFile = new JButton("read file");
		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenFile of = new OpenFile();
				try {
					
					of.PickMe();
					
				}catch(Exception er){
					
					er.printStackTrace();
				}
				textArea.setText(of.sb.toString());
				textResult.setText(of.sb2.toString());
				
			}
		});
		btnReadFile.setBounds(146, 98, 88, 29);
		frame.getContentPane().add(btnReadFile);
		
		JLabel lblInputData = new JLabel("Input Data");
		lblInputData.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblInputData.setBounds(30, 25, 67, 14);
		frame.getContentPane().add(lblInputData);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblResult.setBounds(319, 24, 47, 14);
		frame.getContentPane().add(lblResult);
		
		JLabel lblNewLabel = new JLabel("Accounting Fraud Detection");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(124, 6, 183, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(Benford's law)");
		lblNewLabel_1.setBounds(159, 23, 97, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
	
		
		
		
		
		
	
		
		
		
		
	}
}
