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
	JButton changeAudio, changeImage, Apply;
	JLabel imagePreview;
	ImageIcon preview;
	JComboBox chooseButton;
	int buttonNUM;
	

	 Configuration con;
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

        con.setImagePath(1, 1, "1st.png");
        con.setImagePath(1, 2, "1st.png");
        con.setImagePath(1, 3, "1st.png");
        con.setImagePath(1, 4, "1st.png");


		main = new JPanel();
		center = new JPanel();
		center2 = new JPanel();
		centerHold = new JPanel();
		
		Apply = new JButton("Apply");
		Apply.addActionListener(this);
		
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
		center2.add(Apply);
		
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
	public void outputSerial() throws FileNotFoundException, IOException
	{
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("serial/log.bin")));
		
		obj.writeObject(con);
		obj.close();
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == changeAudio)
		{
			String test = fileChooser();
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last);
			/**
			File sourceOfFile = new File(test);
			File destinationofFile = new File(con.getRelativePathToAudioFiles().toString());
			try {
			    FileUtils.copyDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			    a.printStackTrace();
			}
			*/
            System.out.println(test+"   "+last);
            System.out.println(filename);
            System.out.println(con.getRelativePathToAudioFiles());

            con.setAudioName(1, buttonNUM, filename);
		}
		else if(source == changeImage)
		{
			// Images/filename.
			String test = fileChooser();
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last+1);
			/**
			File sourceOfFile = new File(test);
			File destinationofFile = new File(con.getRelativePathToAudioFiles().toString());
			try {
			    FileUtils.copyDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			    a.printStackTrace();
			}
			*/
            System.out.println(test+"   "+last);
            System.out.println(filename);
            String imagepath = "Images/"+filename;
            System.out.println(imagepath);

            con.setImagePath(1, buttonNUM, imagepath);
            
		}
		else if (source == Apply)
		{
			try {
				outputSerial();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		TalkBoxConfigurationGUI test = new TalkBoxConfigurationGUI();
		test.setVisible(true);
		test.pack();
		
		
		
	}

}