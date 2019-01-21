import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TalkBoxSimulator extends JFrame implements ActionListener {
JPanel panel1;
JButton b1;

/**
 * Initializing the app when launched.
 * 
  */ 
public TalkBoxSimulator ()
{
	super("TalkBox");
	setSize(500,500);
	setLayout(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    panel1 = new JPanel();
    panel1.setBounds(150, 100, 300, 300);
    b1 = new JButton("Button 1");
    b1.addActionListener(this);
    
    panel1.setBackground(Color.gray);
    
    panel1.add(b1);
    add(panel1);

}
public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	if (source == b1)
	{
		System.out.println("You pressed Button 1");
	}
}
	
	
	
	public static void main(String[] args) {
		TalkBoxSimulator test = new TalkBoxSimulator();
		test.setVisible(true);

	}

}
