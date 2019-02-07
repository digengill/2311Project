import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;

import javafx.scene.layout.Border;

public class TalkBoxConfigurationApp extends JFrame implements ActionListener {


	String b1Input;
	String b2Input;
	String b3Input;
	String b4Input;
	String b5Input;
	String b6Input;
	JLabel buttons [] = new JLabel [6];
	JLabel labels [] = new JLabel [6];
	JButton apply;
	JTextField phrases [] = new JTextField[6];
	JTextField name [] = new JTextField[6];
	int x, y;
	
	TalkBoxConfigurationApp(){
		super();
		//sizevariables
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		x = screenSize.width; y = screenSize.height-120; int ratiox = x/1090, ratioy=y/1080;  System.out.println(x + " " + y);
		//Set frames and pane
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(7, 1));
		Container pane [] = new Container [7];
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			//Buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JLabel("Button " + (i+1) + ": ");	 buttons[i].setSize(190, 65);	buttons[i].setFont(new Font("Dialog", Font.BOLD, 18));
				//TEXTFIELDS
			phrases[i] = new JTextField(); phrases[i].setColumns(65);; MaxLengthTextDocument max = new MaxLengthTextDocument();
			max.setMaxChars(30); phrases[i].setDocument(max);  
			//Labels
			labels[i] = new JLabel("             Label: "); labels[i].setSize(175, 65); labels[i].setFont(new Font("Dialog", Font.BOLD, 18));
				//LABEL NAMES
			name[i] = new JTextField(); name[i].setColumns(45); MaxLengthTextDocument max2 = new MaxLengthTextDocument();
			max2.setMaxChars(30); phrases[i].setDocument(max2); 
				//PANES
			pane[i] = new Container(); pane[i].setLayout(new FlowLayout(FlowLayout.CENTER));
			pane[i].add(buttons[i]); pane[i].add(phrases[i]); pane[i].add(labels[i]);  pane[i].add(name[i]);
		}
		apply = new JButton("Apply"); apply.setFont(new Font("Dialog", Font.BOLD, 20));
		pane[6] = new Container();
		pane[6].setLayout(new FlowLayout(FlowLayout.RIGHT)); pane[6].add(apply);
		
		
		
		for (int i = 0; i < pane.length; i++) {
			frame.add(pane[i]);
		}
		//Add ActionListener
		apply.addActionListener(this);
		
		frame.setSize(screenSize.width, screenSize.height-120);
		frame.setVisible(true);
	}
	
	
	
	//method to choose button and write content for that button
	void writeToFile(String fileContent, String buttonFile) {
		File f1= new File("");
	}
	 
	 public static void main(String[] args) {
		TalkBoxConfigurationApp prac = new TalkBoxConfigurationApp();
	}
		
	TalkBoxSimulator talk1= new TalkBoxSimulator();
	TalkBoxSimulator talk2= new TalkBoxSimulator("sad","","","","","");
	TalkBoxSimulator talk3= new TalkBoxSimulator("sad","Nice","","","","");

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == apply) {
			for (int i = 0; i < phrases.length; i++) {
				//Rewrite
				try {
					Rewrite(phrases[i].getText(), i);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

	public void Rewrite (String phrase, int i) throws IOException {
		/*i++;
		if (phrase.equals("") || phrase.isEmpty()) {
			return;
		}
		FileWriter fileWriter = new FileWriter("btn" + i + ".txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		//Write to file
		printWriter.println(phrase);
		*/
	}
	
	
		
}
