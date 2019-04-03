package talkbot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import org.apache.logging.log4j.LogManager;



public class TBCLog {
	
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(TalkBoxConfigurationGUI.class);
	public static void runLog()
	{
		JFrame simFrame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		JTabbedPane tabbedPane = new JTabbedPane();
		simFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simFrame.setVisible(true);
		simFrame.setMinimumSize(new Dimension(800,600));
		JButton clear = new JButton("Clear");
		JTextArea text = new JTextArea(10,10);
		JScrollPane scroll = new JScrollPane (text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		File fname = new File("logs" + File.separator + "Mylogs.log");
		
		tabbedPane.addTab("Simulator Logs", panel1);
		tabbedPane.addTab("Configurator Logs", panel2);

		
		ActionListener clearListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == clear)
				{
					FileWriter fwOb;
					try {
						fwOb = new FileWriter("logs" + File.separator + "Mylogs.log", false);
						 PrintWriter pwOb = new PrintWriter(fwOb, false);
						    pwOb.flush();
						    pwOb.close();
						    fwOb.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					try {
				          BufferedReader input = new BufferedReader(new InputStreamReader(
				              new FileInputStream(fname)));
				          text.read(input, "READING FILE :-)");
				        } catch (Exception b) {
				          b.printStackTrace();
				        }
					
					logger.info("Clear");
				}
			}
		};
		clear.addActionListener(clearListener);
		//clear.setSize(new Dimension(50, 50));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    JLabel header = new JLabel("Simulator Logs");
		
		
		
		try {
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(fname)));
	          text.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
		panel1.setLayout(new BorderLayout());
		panel1.add(scroll,BorderLayout.CENTER);
		panel2.setLayout(new BorderLayout());
		//panel2.add(scroll,BorderLayout.CENTER);
		//scroll.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(30, 30, 30, 30)));
		//text.setEditable(false);

		simFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		simFrame.getContentPane().add(header, BorderLayout.NORTH);
		simFrame.getContentPane().add(clear, BorderLayout.WEST);
		simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH);
		simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);
		//simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST);
		simFrame.getContentPane().setBackground(new Color(153, 255, 255));
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TBCLog test = new TBCLog();
		test.runLog();
	}

}