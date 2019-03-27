package talkbot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import javax.swing.*;

import org.apache.commons.io.FileUtils;

import javafx.scene.paint.Color;

import java.util.*;

public class TalkBoxConfigurationGUI extends JFrame implements ActionListener {
	
	JPanel main, org, center,center2,centerHold, namePanel, previewPanel, eastPanel, westPanel, menu, menuMain;
	JPanel options;
	JButton add, remove, change;
	JButton enterName;
	JButton aAudio;
	JButton aImage, simLog;
	
	JButton changeAudio, changeImage, Apply, nameEnter, audioPreview, addButton, removeButton, changeButton, ab,rb, back;
	JLabel imagePreview;
	ImageIcon preview, goBack;
	JComboBox chooseButton;
	JComboBox<String> chooseSet, chooseSetMain;
	
	String holdName, newbtnImg, newbtnAudio;
	JTextField btnName, btnName2;
	int buttonNUM = 1, set = 1;

	
	//new testing Sets
	JPanel SetSelect;
	JButton AddSet, RemoveSet;
	
	
	
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
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

org = new JPanel();
//content pane layout
org.setLayout(new FlowLayout());
//Setting up Options
options= new JPanel();
options.setPreferredSize(new Dimension(800, 500));
options.setBackground(java.awt.Color.GRAY);

add = new JButton("Add"); remove = new JButton("Remove"); change = new JButton("Change");
try {
	this.goBack = new ImageIcon(ImageIO.read(new File("angry.png")).getScaledInstance(100, 100, Image.SCALE_DEFAULT));
} catch (IOException e) {
	e.printStackTrace();
}
back = new JButton(goBack);
back.addActionListener(this);

main = new JPanel();
center = new JPanel();
center2 = new JPanel();
centerHold = new JPanel();
namePanel = new JPanel();
previewPanel = new JPanel();
eastPanel = new JPanel();
westPanel = new JPanel();
menuMain = new JPanel();

btnName = new JTextField(20);
btnName2 = new JTextField(20);

btnName.addActionListener(this);
btnName2.addActionListener(this);

imagePreview = new JLabel("Image",preview, JLabel.CENTER );

changeAudio = new JButton("Change Audio");
changeImage = new JButton("Change Image");

changeAudio.addActionListener(this);
changeImage.addActionListener(this);



 enterName = new JButton("Apply Name");
 aAudio = new JButton("Add Audio");
 aImage = new JButton("Add Image");
 
 simLog = new JButton("Log");
 simLog.addActionListener(this);



audioPreview = new JButton("Audio Preview");
nameEnter = new JButton("Apply Name");
Apply = new JButton("SAVE SETTINGS");
Apply.addActionListener(this);
nameEnter.addActionListener(this);

String[] bnames = new String [con.getSetAt(0)+1];//{"Pick Button","1","2","3","4","5","6"};
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
chooseSet = new JComboBox<String>();
chooseSet.addItem("Phrases"); chooseSet.addItem("Emotions");
chooseSet.addActionListener(
		new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{		
					JComboBox combo = (JComboBox)e.getSource();
					set = combo.getSelectedIndex();
					if (set < (1))
						set=1;
					//System.out.println(set);
					//if (set==1) {
					
					String[] bnames = new String [con.getSetAt(set)+1];//{"Pick Button","1","2","3","4","5","6"};
					bnames[0] = "Pick Button";
					for (int i = 1; i < bnames.length; i++) {
						bnames[i] = ""+i;
					}
					chooseButton = new JComboBox(bnames);
					
				//	} 
//						else if (set==2) {
//						String[] bnames = new String [con.getSetAt(1)+1];//{"Pick Button","1","2","3","4","5","6"};
//						bnames[0] = "Pick Button";
//						for (int i = 1; i < bnames.length; i++) {
//							bnames[i] = ""+i;
//						}
						//System.out.println(con.getSetAt(1)+1);
						//chooseButton = new JComboBox(bnames);
				//	}
				}
		}
		);

	this.setLayout(new GridLayout());

	addButton = new JButton("Add Button");
	removeButton = new JButton("Remove Button");
	changeButton = new JButton("Change Button");
	addButton.addActionListener(this);
	removeButton.addActionListener(this);
	changeButton.addActionListener(this);
	
	
//	GridBagConstraints GBC = new GridBagConstraints();
//	GBC.gridy = 2;
//	GBC.ipady = 100;
//	GBC.ipadx = 50;

	
		menu = new JPanel();
		
//		menu.setLayout(new GridBagLayout());
//		menu.add(Box.createRigidArea(new Dimension(70, 100)), GBC);
//		menu.add(addButton, GBC);
//		menu.add(Box.createRigidArea(new Dimension(100, 100)), GBC);
//		menu.add(removeButton, GBC);
//		//GBC.gridy = 3;
//		menu.add(Box.createRigidArea(new Dimension(100, 100)), GBC);
//		menu.add(changeButton, GBC);
//		menu.add(Box.createRigidArea(new Dimension(70, 100)), GBC);

		menu.setLayout(new GridLayout(2, 3, 100, 100));
		menuMain.setLayout(new BorderLayout());
		menu.add(addButton);
		menu.add(Box.createRigidArea(new Dimension(100, 100)));
		menu.add(removeButton);
		menu.add(Box.createRigidArea(new Dimension(100, 100)));
		menu.add(changeButton);
		menu.add(simLog);
		

	this.add(menu);
	// BorderLayout.CENTER);
	//this.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.NORTH);
	//this.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.SOUTH);
	//this.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.EAST);
	//this.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.WEST);
	
	
	
	//Testing PresetPanel
	
	
//	ArrayList<Buttons> test = new ArrayList<Buttons>();
//	Preset P = new Preset("Weather", test);
//	Preset B = new Preset("Weather2", test);
//	PresetSelect = new JPanel();
//	PresetSelect.setLayout(new GridBagLayout());
	AddSet = new JButton("Add Set");
	RemoveSet = new JButton("Remove Set");
	
	
	
	ActionListener PresetPanelListener= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == AddSet)
			{
//				Preset Q = new Preset("TestName");
//				ChoosePreset.add(Q);
//				PresetNames.addItem(Q.GetName());
//				
//				PresetNames.updateUI();
				con.addSetAt(set + 1, "TestName");
				
				menu.revalidate();
				menu.repaint();
			}
			else if (e.getSource() == RemoveSet)
			{
				if(chooseSet.getSelectedIndex() >= 0)
				{
					System.out.println(con.getSetButtonsAt(chooseSet.getSelectedIndex()));
					con.removeSetAt(chooseSet.getSelectedIndex());
				
					//System.out.println(PresetNames.getSelectedIndex());
					//System.out.println(ChoosePreset.get(PresetNames.getSelectedIndex()));
					
//					ChoosePreset.remove(PresetNames.getSelectedIndex());
//					PresetNames.removeItemAt(PresetNames.getSelectedIndex());
					chooseSet.updateUI();
					menu.revalidate();
					menu.repaint();
				}
				else
				{
				System.out.println("Error cannot remove 0 presets");
				}
			}
		}
	};
	
	AddSet.addActionListener(PresetPanelListener);
	RemoveSet.addActionListener(PresetPanelListener);
	
	//chooseSetMain = new ArrayList<String>();
	chooseSetMain = new JComboBox<String>();

//	ChoosePreset.add(P);
//	ChoosePreset.add(B);
//	PresetNames.addItem(P.GetName());
//	PresetNames.addItem(B.GetName());
	chooseSetMain.addActionListener(PresetPanelListener);
	
	//ChoosePreLabel = new JLabel("Choose a Preset");
	//GBC.gridy = 0;
	
	menu.add(Box.createRigidArea(new Dimension(70, 100))); //,GBC);
	/*PresetSelect*/menu.add(AddSet);//, GBC);
	
	menu.add(Box.createRigidArea(new Dimension(100, 100)));//, GBC);
	/*PresetSelect*/menu.add(chooseSet);//(chooseSetMain);//, GBC);
	menu.add(Box.createRigidArea(new Dimension(100, 100)));//, GBC);
	//menu.add(Box.createRigidArea(new Dimension(150, 100)), GBC);
	/*PresetSelect*/menu.add(RemoveSet);//, GBC);
	menu.add(Box.createRigidArea(new Dimension(70, 100)));//, GBC);
	//menu.setMinimumSize(new Dimension(500, 500));
	//PresetSelect.add(ChoosePreLabel);
	//this.add(PresetSelect);
	//this.add(Box.createRigidArea(new Dimension(100, 100)), GBC);


//	menuMain.add(menu, BorderLayout.CENTER);
//	
//	menu.setBackground(java.awt.Color.cyan);
//	menuMain.setBackground(java.awt.Color.cyan);
//	
//	menuMain.add(Box.createRigidArea(new Dimension(100, 300)),BorderLayout.NORTH);
//	menuMain.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.SOUTH);
//	menuMain.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.EAST);
//	menuMain.add(Box.createRigidArea(new Dimension(100, 100)),BorderLayout.WEST);
//	this.setContentPane(menuMain);

	}
	
	public void simulatorLog()
	{
		JFrame simFrame = new JFrame();
		simFrame.setVisible(true);
		simFrame.setMinimumSize(new Dimension(800,600));
		JTextArea text = new JTextArea(10,10);
		File fname = new File("Textfiles/info.txt");
		try {
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(fname)));
	          text.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
		simFrame.getContentPane().add(text, BorderLayout.CENTER);
		simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
		simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH);
		simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);
		simFrame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST);

		
	}

	
	
	
	
	public void changeButton()
	{
		JFrame cb = new JFrame();
		cb.setVisible(true);
		cb.setMinimumSize(new Dimension(800,600));
		//cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				try {
			this.preview = new ImageIcon(ImageIO.read(new File("sad.png")).getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
		
		main.setLayout(new BorderLayout());
		centerHold.setLayout(new GridLayout(6,1));
		center.setLayout(new GridLayout(2,3));
		namePanel.setLayout(new GridLayout(3,1));
		previewPanel.setLayout(new GridLayout(1,3));
		eastPanel.setLayout(new GridLayout(5,2));
		westPanel.setLayout(new GridLayout(3,2));
		
		main.removeAll();
		centerHold.removeAll();
		center.removeAll();
		namePanel.removeAll();
		previewPanel.removeAll();
		eastPanel.removeAll();
		westPanel.removeAll();
		
		westPanel.add(back);

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
		cb.setContentPane(org);
	}
	
	public void addButton()
	{
		//set = 1;
		
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
			 holdName = btnName.getText();
			System.out.println(holdName);
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
			int last = test.lastIndexOf('\\'); System.out.println(last);
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
	    		JOptionPane.showMessageDialog(new JFrame(), "Invalid Audio. Default Audio is set.");

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
	    		JOptionPane.showMessageDialog(new JFrame(), "Invalid Image. Default image is set.");

            }
			}
		}
		else if (source == ab)
		{
			 holdName = btnName2.getText();
			 if (holdName=="" ||holdName==null)
				 holdName="N/A";
				//System.out.println(holdName);
			    btnName2.setText("");
			    if (newbtnAudio=="" || newbtnAudio==null)
			    	newbtnAudio="default.wav";
			    if (newbtnImg=="" || newbtnImg==null)
			    	newbtnImg="Images/default.png";
			con.Addbtn(set,holdName,newbtnAudio,newbtnImg);
    		JOptionPane.showMessageDialog(new JFrame(), "New button added.\n Button Set: "+set+"\n Button Name: "+holdName+"\n Audio Name: "+newbtnAudio+"\n Image Name: "+newbtnImg);

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
			int holdName = Integer.parseInt(btnName2.getText());
			//System.out.println(holdName);
		    btnName2.setText("");
//		    if ((set==1 && (holdName < 1 || holdName > con.getSetAt(0)) || (set==2 && (holdName<1 || holdName>con.getSetAt(0)))))
//		    	{
//		    		JOptionPane.showMessageDialog(new JFrame(), "Invalid Button Number.\n Try Again.");
//		    	}
		    if (holdName < 1 || holdName > con.getSetAt(0) || holdName > con.getSetAt(1))
	    	{
	    		JOptionPane.showMessageDialog(new JFrame(), "Invalid Button Number.\n Try Again.");
	    	}
		    else
		    {
	    	JOptionPane.showMessageDialog(new JFrame(), "Button removed.\n Button Set: "+set+"Button Name: "+con.getBtnName(set, holdName));

		    con.Removebtn(set, holdName);

		    }
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
		else if (source == changeButton)
		{
			
			changeButton();
		}
		else if(source == back)
		{
			TalkBoxConfigurationGUI test1 = new TalkBoxConfigurationGUI();
			
			test1.setVisible(true);
			test1.pack();
		}
		else if( source == simLog)
		{
			
			simulatorLog();
		}
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		TalkBoxConfigurationGUI test = new TalkBoxConfigurationGUI();
		test.setVisible(true);
		test.pack();
		
		
		
	}

}