import java.awt.Dimension;
import javax.swing.*;   

public class GUI {
	public static void main(String[] args) {  
		JFrame f=new JFrame();//creating instance of JFrame  
		          
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		          
		f.add(b);//adding button in JFrame  
		          
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		
		JButton b1= new JButton(String.valueOf("Hello"));
		b1.setPreferredSize(new Dimension(40,40));
		}  

}
