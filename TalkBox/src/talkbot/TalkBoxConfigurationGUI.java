package talkbot;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import javafx.scene.paint.Color;

public class TalkBoxConfigurationGUI extends JFrame implements ActionListener {
	
	JPanel main, center,center2,centerHold;
	JButton changeAudio, changeImage;
	JLabel imagePreview;
	ImageIcon preview;
	JComboBox chooseButton;
	int buttonNUM;
	

	static Configuration con;
	private ObjectInputStream in;
	
	public TalkBoxConfigurationGUI()
	{
		super("Configurator");
try {
			
			in = new ObjectInputStream(new FileInputStream("serial/log.bin"));
			con = (Configuration) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setMinimumSize(new Dimension(800,500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main = new JPanel();
		center = new JPanel();
		center2 = new JPanel();
		centerHold = new JPanel();
		
		try {
			this.preview = new ImageIcon(ImageIO.read(new File("sad.png")).getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imagePreview = new JLabel("Image",preview, JLabel.CENTER );
		
		changeAudio = new JButton("Change Audio");
		changeImage = new JButton("Change Image");

		changeAudio.addActionListener(this);
		changeImage.addActionListener(this);
		
		String[] bnames = {"Pick Button","1","2","3","4","5","6"};
		chooseButton = new JComboBox(bnames);
		chooseButton.addActionListener(

		        new ActionListener(){
		            public void actionPerformed(ActionEvent e){
		                JComboBox combo = (JComboBox)e.getSource();
		                buttonNUM = combo.getSelectedIndex();
		                System.out.println(buttonNUM);
		            }
		        }
				);
		
		centerHold.setLayout(new GridLayout(3,1));
		center.setLayout(new GridLayout(1,3));
		
		
		center.add(chooseButton);
		center.add(changeAudio);
		center.add(changeImage);
		center2.add(imagePreview);
		
		centerHold.add(center);
		centerHold.add(Box.createRigidArea(new Dimension(10,50)));
		centerHold.add(center2);

		main.add(centerHold,BorderLayout.CENTER);
		
		centerHold.setBackground(java.awt.Color.GREEN);
		main.setBackground(java.awt.Color.GREEN);
		center2.setBackground(java.awt.Color.GREEN);


		this.setContentPane(main);
	}
	
	public void imagePreview()
	{
		
		
	}
	public String fileChooser()
	{
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.showOpenDialog(chooser);
		
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		   System.out.println("You chose to open this directory: " +
		        chooser.getSelectedFile().getAbsolutePath());
		
		return chooser.getSelectedFile().getAbsolutePath().toString();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == changeAudio)
		{
			String test = fileChooser();
            System.out.println("CHANGE AUDIO"+ test);
            con.setAudioName(1, buttonNUM-1, test);
		}
		else if(source == changeImage)
		{
			String test = fileChooser();
            System.out.println("CHANGE IMAGE"+ test);
            con.setImagePath(1, buttonNUM-1, test);
            
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("serial/log.bin")));
		
		TalkBoxConfigurationGUI test = new TalkBoxConfigurationGUI();
		test.setVisible(true);
		test.pack();
		
		obj.writeObject(con);
		obj.close();
	}

}