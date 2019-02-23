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
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;

import javafx.scene.paint.Color;

public class TalkBoxConfigurationGUI extends JFrame implements ActionListener {
	
	JPanel main, center,center2,centerHold, namePanel, previewPanel, eastPanel;
	JButton changeAudio, changeImage, Apply, nameEnter, audioPreview;
	JLabel imagePreview;
	ImageIcon preview;
	JComboBox chooseButton;
	
	JTextField btnName;
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

		main = new JPanel();
		center = new JPanel();
		center2 = new JPanel();
		centerHold = new JPanel();
		namePanel = new JPanel();
		previewPanel = new JPanel();
		eastPanel = new JPanel();
		
		btnName = new JTextField(20);
		btnName.addActionListener(this);
		
		audioPreview = new JButton("Audio Preview");
		nameEnter = new JButton("Apply Name");
		Apply = new JButton("SAVE SETTINGS");
		Apply.addActionListener(this);
		nameEnter.addActionListener(this);
		
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
		
		centerHold.setLayout(new GridLayout(6,1));
		center.setLayout(new GridLayout(2,3));
		namePanel.setLayout(new GridLayout(3,1));
		previewPanel.setLayout(new GridLayout(1,3));
		eastPanel.setLayout(new GridLayout(5,1));
		
		center.add(chooseButton);
		centerHold.add(center);
		centerHold.add(Box.createRigidArea(new Dimension(10, 30)));
		
		center2.add(changeAudio);
		center2.add(changeImage);
		centerHold.add(center2);
		
		previewPanel.add(imagePreview);
		previewPanel.add(audioPreview);
		centerHold.add(previewPanel);
		centerHold.add(Box.createRigidArea(new Dimension(10, 30)));

		namePanel.add(new JLabel("Enter Button Name"));
		namePanel.add(btnName);
		namePanel.add(nameEnter);
		
		centerHold.add(namePanel);
		
		
		eastPanel.add(Apply);
		
		main.add(centerHold,BorderLayout.CENTER);
		main.add(eastPanel, BorderLayout.EAST);
		
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
			
			File sourceOfFile = new File(test);
			File destinationofFile = new File(con.getRelativePathToAudioFiles().toString());
			try {
			    FileUtils.copyFileToDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			    a.printStackTrace();
			}
			
            System.out.println(test+"   "+last);
            System.out.println(filename);
            System.out.println(con.getRelativePathToAudioFiles());

            //con.setAudioName(1, buttonNUM, filename);
		}
		else if(source == changeImage)
		{
			// Images/filename.
			String test = fileChooser();
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last+1);
			
			File sourceOfFile = new File(test);
			File destinationofFile = new File("Images");
			try {
			    FileUtils.copyFileToDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			    a.printStackTrace();
			}
			
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