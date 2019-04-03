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
	
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger("talkbot");//TalkBoxConfigurationGUI.class);
	public static void runLog()
	{
		JFrame simFrame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		JTabbedPane tabbedPane = new JTabbedPane();
		simFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simFrame.setVisible(true);
		simFrame.setMinimumSize(new Dimension(800,600));
		JButton clear = new JButton("ClearAll");
		JTextArea simText = new JTextArea(10,10);
		JTextArea configText = new JTextArea(10, 10);
		JScrollPane simScroll = new JScrollPane (simText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane configScroll = new JScrollPane (configText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		File simFile = new File("loggerFiles" + File.separator + "MySimlogs.log");
		File configFile = new File("loggerFiles" + File.separator + "MyConfiglogs.log");
		
		tabbedPane.addTab("Simulator Logs", panel1);
		tabbedPane.addTab("Configurator Logs", panel2);

		
		ActionListener clearListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == clear)
				{
					FileWriter fwOb;
					try {
						fwOb = new FileWriter("loggerFiles" + File.separator + "MyConfiglogs.log", false);
						 PrintWriter pwOb = new PrintWriter(fwOb, false);
						    pwOb.flush();
						    pwOb.close();
						    fwOb.close();
						    
						    fwOb = new FileWriter("loggerFiles" + File.separator + "MySimlogs.log", false);
						    pwOb = new PrintWriter(fwOb, false);
							    pwOb.flush();
							    pwOb.close();
							    fwOb.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					try {
				          BufferedReader input = new BufferedReader(new InputStreamReader(
				              new FileInputStream(simFile)));
				          simText.read(input, "READING FILE :-)");
				        } catch (Exception b) {
				          b.printStackTrace();
				        }
					try {
				          BufferedReader input = new BufferedReader(new InputStreamReader(
				              new FileInputStream(configFile)));
				          configText.read(input, "READING FILE :-)");
				        } catch (Exception c) {
				          c.printStackTrace();
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
	              new FileInputStream(simFile)));
	          simText.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
		try {
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(configFile)));
	          configText.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
		panel1.setLayout(new BorderLayout());
		panel1.add(simScroll,BorderLayout.CENTER);
		panel2.setLayout(new BorderLayout());
		panel2.add(configScroll,BorderLayout.CENTER);
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