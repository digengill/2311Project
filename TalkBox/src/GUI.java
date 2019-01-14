import java.awt.Dimension;
import javax.swing.*;   

public class GUI {
	public static void main(String[] args) {  
		
		// Creating instance of JFrame
       
		
		JFrame myFrame = new JFrame("My First Swing Example");
        // Setting the width and height of frame
        myFrame.setSize(350, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific 
         * positions in a JFrame. Inside panels we can add text 
         * fields, buttons and other components.
         */
       
        
        JPanel panel = new JPanel();    
        // adding panel to frame
        myFrame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
       // placeComponents(panel);

        // Setting the frame visibility to true
        myFrame.setVisible(true);
    }
	
	private static void placeComponents(JPanel panel) {
		
		/* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
        panel.setLayout(null);

        // Creating JLabel
        JLabel userLabel = new JLabel("User");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left 
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        


	}
		
		
		
		
		
		
		
		
		
		JFrame f=new JFrame();//creating instance of JFrame  
		          
		
		
		
		
		
		
		
		
//		JButton b=new JButton("click");//creating instance of JButton  
//		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
//		          
//		f.add(b);//adding button in JFrame  
//		          
//		f.setSize(400,500);//400 width and 500 height  
//		f.setLayout(null);//using no layout managers  
//		f.setVisible(true);//making the frame visible  
//		
//		JButton b1= new JButton(String.valueOf("Hello"));
//		b1.setPreferredSize(new Dimension(40,40));
//		}  

}
