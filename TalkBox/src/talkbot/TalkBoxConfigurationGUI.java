package talkbot;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.io.*;

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
import javax.swing.*;

import org.apache.commons.io.FileUtils;

import javafx.scene.paint.Color;

public class TalkBoxConfigurationGUI extends JFrame implements ActionListener {
	
	JPanel main, org, center,center2,centerHold, namePanel, previewPanel, eastPanel, westPanel;
	JPanel options;
	JButton add, remove, change;
	JButton enterName;
	JButton aAudio;
	JButton aImage;
	
	JButton changeAudio, changeImage, Apply, nameEnter, audioPreview, addButton, removeButton, ab,rb;
	JLabel imagePreview;
	ImageIcon preview;
	JComboBox chooseButton, chooseSet;
	
	String hold, newbtnImg, newbtnAudio;
	JTextField btnName, btnName2;
	int buttonNUM=1, set=1;
	private final static String newline = "\n";


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
		org = new JPanel();
		//content pane layout
		org.setLayout(new FlowLayout());
		//Setting up Options
		options= new JPanel();
		options.setPreferredSize(new Dimension(800, 500));
		options.setBackground(java.awt.Color.GRAY);
		
		add = new JButton("Add"); remove = new JButton("Remove"); change = new JButton("Change");
		
		main = new JPanel();
		center = new JPanel();
		center2 = new JPanel();
		centerHold = new JPanel();
		namePanel = new JPanel();
		previewPanel = new JPanel();
		eastPanel = new JPanel();
		westPanel = new JPanel();
		
		btnName = new JTextField(20);
		btnName2 = new JTextField(20);

		btnName.addActionListener(this);
		btnName2.addActionListener(this);

		
		addButton = new JButton("Add Button");
		removeButton = new JButton("Remove Button");
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		
		 enterName = new JButton("Apply Name");
		 aAudio = new JButton("Add Audio");
		 aImage = new JButton("Add Image");
		

		
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
		
		String[] bnames = new String [con.getSet1()];//{"Pick Button","1","2","3","4","5","6"};
		bnames[0] = "Pick Button";
		for (int i = 1; i < bnames.length; i++) {
			bnames[i] = ""+i;
		}
		chooseButton = new JComboBox(bnames);
		chooseButton.addActionListener(

		        new ActionListener(){
		            public void actionPerformed(ActionEvent e){
		                JComboBox combo = (JComboBox)e.getSource();
		                buttonNUM = combo.getSelectedIndex();
		                if (buttonNUM==(-1))
		                	buttonNUM=1;
		                //System.out.println(buttonNUM);
		            }
		        }
				);
		chooseSet = new JComboBox();
		chooseSet.addItem("Phrases"); chooseSet.addItem("Emotions");
		chooseSet.addActionListener(
				new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
							JComboBox combo = (JComboBox)e.getSource();
							set = combo.getSelectedIndex()+1;
							if (set==(-1))
								set=1;
							//System.out.println(set);
							if (set==1) {
								String[] bnames = new String [con.getSet1()];//{"Pick Button","1","2","3","4","5","6"};
								bnames[0] = "Pick Button";
								for (int i = 1; i < bnames.length; i++) {
									bnames[i] = ""+i;
								}
								chooseButton = new JComboBox(bnames);
							} else if (set==2) {
								String[] bnames = new String [con.getSet2()];//{"Pick Button","1","2","3","4","5","6"};
								bnames[0] = "Pick Button";
								for (int i = 1; i < bnames.length; i++) {
									bnames[i] = ""+i;
								}
								chooseButton = new JComboBox(bnames);
							}
						}
				}
				);
		main.setLayout(new BorderLayout());
		centerHold.setLayout(new GridLayout(6,1));
		center.setLayout(new GridLayout(2,3));
		namePanel.setLayout(new GridLayout(3,1));
		previewPanel.setLayout(new GridLayout(1,3));
		eastPanel.setLayout(new GridLayout(5,2));
		westPanel.setLayout(new GridLayout(3,2));
		
		westPanel.add(addButton);
		westPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		westPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		westPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		westPanel.add(removeButton);
		westPanel.add(Box.createRigidArea(new Dimension(10, 30)));

		center.add(chooseSet); //Change made here
		center.add(chooseButton);
		centerHold.add(center);
		centerHold.add(Box.createRigidArea(new Dimension(10, 30)));
		
		center2.add(changeAudio);
		center2.add(changeImage);
		centerHold.add(center2);
		
		previewPanel.add(imagePreview);
		previewPanel.add(audioPreview);
		imagePreview.setVisible(false);
		audioPreview.setVisible(false);

		
		centerHold.add(previewPanel);
		centerHold.add(Box.createRigidArea(new Dimension(10, 30)));

		namePanel.add(new JLabel("Enter Button Name"));
		namePanel.add(btnName);
		namePanel.add(nameEnter);
		
		centerHold.add(namePanel);
		
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		eastPanel.add(Box.createRigidArea(new Dimension(10, 30)));

		eastPanel.add(Apply);
		
		main.add(centerHold,BorderLayout.CENTER);
		main.add(eastPanel, BorderLayout.EAST);
		main.add(westPanel, BorderLayout.WEST);
		
		centerHold.setBackground(java.awt.Color.GREEN);
		main.setBackground(java.awt.Color.GREEN);
		center2.setBackground(java.awt.Color.GREEN);
		westPanel.setBackground(java.awt.Color.GREEN);
		eastPanel.setBackground(java.awt.Color.GREEN);
		previewPanel.setBackground(java.awt.Color.yellow);
		org.setBackground(java.awt.Color.GREEN);

		
		org.add(main);
		this.setContentPane(org);
		
		
		
	}
	
	public void addButton()
	{
		set =1;
		JFrame addB = new JFrame("Add Button");
		JPanel amain = new JPanel();
		
		aAudio.addActionListener(this);
		aImage.addActionListener(this);

		enterName.addActionListener(this);
		addB.setVisible(true);
		addB.setMinimumSize(new Dimension(500,500));
		
		ab = new JButton("ADD BUTTON");
		ab.addActionListener(this);
		
		
		
		amain.setLayout(new GridLayout(6,3));
		
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(chooseSet);
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(new JLabel("Enter Button Name"));
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(Box.createRigidArea(new Dimension(10, 30)));

		amain.add(btnName2);
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(aAudio);
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(aImage);
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(Box.createRigidArea(new Dimension(10, 30)));
		amain.add(ab);
		amain.add(Box.createRigidArea(new Dimension(10, 30)));

		addB.setContentPane(amain);
		//public void Addbtn (int set, String bname, String audioname, String image) {
		 
		
	}
	
	public void removeButton()
	{
		set = 1;
		JFrame rmv = new JFrame("Remove Button");
		rmv.setMinimumSize(new Dimension(400,500));

		rmv.setVisible(true);
		JPanel rmain = new JPanel();
		rb = new JButton("REMOVE BUTTON");
		rb.addActionListener(this);
		
		rmain.setLayout(new GridLayout(4,3));
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(chooseSet);
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(new JLabel("Enter Button Number"));
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(btnName2);
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		rmain.add(rb);
		rmain.add(Box.createRigidArea(new Dimension(10, 30)));
		
		rmv.setContentPane(rmain);

	}
	
	public void imagePreview()
	{
		
		
	}
	
	public String fileChooser()
	{
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = chooser.showOpenDialog(null);
		 String filename = null;
        File f = chooser.getSelectedFile();
        if (JFileChooser.CANCEL_OPTION == result) {
           // System.out.println("canceled");
        } else if (JFileChooser.APPROVE_OPTION== result) {
            filename = f.getAbsolutePath();
            //System.out.println(filename+"   APPROVE");
        }else{
            //System.out.println(result);
        }
		
		String path = filename;
		   
		
		return path;
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
			if (test == null)
			{
				//System.out.println("null");
			}
			else
			{
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last);
			
			File sourceOfFile = new File(test);
			File destinationofFile = new File(con.getRelativePathToAudioFiles().toString());
			try {
			    FileUtils.copyFileToDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			   // a.printStackTrace();
			}
			
           // System.out.println(test+"   "+last);
           // System.out.println(filename);
           // System.out.println(con.getRelativePathToAudioFiles());
            if (filename.endsWith(".wav"))
            	con.setAudioName(set, buttonNUM, filename);
            else { //If wrong file 
					File f = new File(con.getRelativePathToAudioFiles()+filename);
					f.delete();
				
            	con.setAudioName(set, buttonNUM, "default.wav");
            }
			}
		}
		else if(source == changeImage)
		{
			// Images/filename.
			String test = fileChooser();
			if (test == null)
			{
				//System.out.println("null");
			}
			else
			{
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last+1);
			
			File sourceOfFile = new File(test);
			File destinationofFile = new File("Images");
			try {
			    FileUtils.copyFileToDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			   // a.printStackTrace();
			}
			
           // System.out.println(test+"   "+last);
           // System.out.println(filename);
            String imagepath = "Images/"+filename;
          //  System.out.println(imagepath);
            if (imagepath.endsWith(".png") || imagepath.endsWith(".PNG"))
            	con.setImagePath(set, buttonNUM, imagepath);
            else {
            	File f = new File(imagepath);
            	f.delete();
            	con.setImagePath(set, buttonNUM, "Images/default.png");
            }
			}
            
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
		
		else if (source == nameEnter)
		{
			String text = btnName.getText();
			con.setBtnName(set, buttonNUM, text);
			//System.out.println(text);
		    btnName.setText("");
			
		}
	
		else if (source == addButton)
		{
			addButton();
		}
		else if (source == removeButton)
		{
			removeButton();
		}
		/**
		else if (source == enterName)
		{
			 hold = btnName.getText();
			System.out.println(hold);
		    btnName2.setText("");
		}
		*/
		else if (source == aAudio)
		{
			String test = fileChooser();
			if (test == null)
			{
			//	System.out.println("null");
			}
			else
			{
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last);
			
			File sourceOfFile = new File(test);
			File destinationofFile = new File(con.getRelativePathToAudioFiles().toString());
			try {
			    FileUtils.copyFileToDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			   // a.printStackTrace();
			}
			
          //  System.out.println(test+"   "+last);
           // System.out.println(filename);
            if (filename.endsWith(".wav"))
            	newbtnAudio = filename;

            else { //If wrong file 
				File f = new File(con.getRelativePathToAudioFiles()+filename);
				f.delete();
				newbtnAudio = "default.wav";
            }
			}
		}
		else if (source == aImage)
		{
			String test = fileChooser();
			if (test == null)
			{
			//	System.out.println("null");
			}
			else
			{
			int last = test.lastIndexOf('\\');
			String filename = test.substring(last+1);
			
			File sourceOfFile = new File(test);
			File destinationofFile = new File("Images");
			try {
			    FileUtils.copyFileToDirectory(sourceOfFile, destinationofFile);
			} catch (IOException a) {
			   // a.printStackTrace();
			}
			
          //  System.out.println(test+"   "+last);
          //  System.out.println(filename);
            if (filename.endsWith(".png"))
            	newbtnImg = "Images/"+filename;
            	
            else { //If wrong file 
					File f = new File("Images/"+filename);
					f.delete();
				newbtnImg = "Images/default.png";
            }
			}
		}
		else if (source == ab)
		{
			 hold = btnName2.getText();
			 if (hold=="" || hold==null)
				 hold="N/A";
				//System.out.println(hold);
			    btnName2.setText("");
			con.Addbtn(set,hold,newbtnAudio,newbtnImg);
			try {
				outputSerial();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//public void Addbtn (int set, String bname, String audioname, String image) {

		}
		else if (source == rb)
		{
			int hold = Integer.parseInt(btnName2.getText());
			//System.out.println(hold);
		    btnName2.setText("");
		    if ((set==1 && (hold<1 || hold>con.getSet1()) || (set==2 && (hold<1 || hold>con.getSet2()))))
		    	hold=1;
		    con.Removebtn(set, hold);
			try {
				outputSerial();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//	public void Removebtn (int set, int num) {

			
			
		}
	
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		TalkBoxConfigurationGUI test = new TalkBoxConfigurationGUI();
		test.setVisible(true);
		test.pack();
		
		
		
	}

}