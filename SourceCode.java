import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MassFiles extends JFrame {

	private JPanel contentPane;
	private JTextField txtfieldinside;
	private JLabel lblWhatsInsideThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MassFiles frame = new MassFiles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Able for the JFile to be called from anywhere....
	JFileChooser chooser = new JFileChooser();
	
	
	/**
	 * Create the frame.
	 */
	public MassFiles() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MassFiles.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-warning@2x.png")));
		setResizable(false);
		setTitle("Mass File");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtfieldinside = new JTextField();
		txtfieldinside.setBounds(12, 12, 114, 19);
		contentPane.add(txtfieldinside);
		txtfieldinside.setColumns(10);
		
		lblWhatsInsideThe = new JLabel("Whats inside the TxT file?");
		lblWhatsInsideThe.setBounds(144, 14, 239, 15);
		contentPane.add(lblWhatsInsideThe);
		
		JSpinner spiner = new JSpinner();
		spiner.setBounds(22, 43, 93, 20);
		contentPane.add(spiner);
		
		JLabel lblHowManyFiles = new JLabel("How many files?");
		lblHowManyFiles.setBounds(144, 45, 126, 15);
		contentPane.add(lblHowManyFiles);
		
		
		JButton btn = new JButton("Directory");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				} else {
				  System.out.println("No Selection ");
				}
				btn.setText(chooser.getSelectedFile().toString());
				
			}
		});
		
		btn.setBounds(12, 115, 371, 25);
		contentPane.add(btn);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x = 0;
					int y = (int) spiner.getValue();
					while(x < y) {
						x = x+1;
						System.out.print(x);
					//Make a txt file on the desktop called TestFile.txt
					@SuppressWarnings("unused")
					
					File file = new File(chooser.getSelectedFile().toString() + "/" + x + ".txt");
					//Waits for the file to be created...
					try {
					    Thread.sleep(100);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
					//Writes into the TestFile.txt, "Tests worked!".
					try( PrintWriter out = new PrintWriter(chooser.getSelectedFile().toString() + "/" + x + ".txt") ){
						out.println(txtfieldinside.getText());
						
					}
					}
				} catch (IOException e1){
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnStart.setBounds(12, 152, 117, 25);
		contentPane.add(btnStart);
	
		
	}
}
