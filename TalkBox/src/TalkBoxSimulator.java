import java.awt.*;
import javax.swing.*;
public class TalkBoxSimulator extends JFrame {
JPanel panel1;
JButton b1;

/**
 * Initializing the app when launched.
 * 
  */ 
public TalkBoxSimulator()
{
	super("TalkBox");
	setSize(800,800);
	setLayout(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    panel1 = new JPanel();
    panel1.setBounds(150, 100, 400, 400);
    b1 = new JButton("Button 1");
    
    panel1.setBackground(Color.gray);
    
    panel1.add(b1);
    add(panel1);

}
	
	
	
	
	public static void main(String[] args) {
		TalkBoxSimulator test = new TalkBoxSimulator();
		test.setVisible(true);

	}

}
