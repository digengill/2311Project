import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.*;

import sun.applet.Main;
import sun.audio.*;

public class practiceUsama {
	
	
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream("/path/to/sounds/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(System.getProperty("user.dir"));

		
		   // open the sound file as a Java input stream
	    String gongFile = "/Users/Desktop/musicA1.m4a";
	    try {
		    InputStream in = new FileInputStream("musicA1.m4a");
		    // create an audiostream from the inputstream
		    AudioStream audioStream = new AudioStream(in);

		    // play the audio clip with the audioplayer class
		    //AudioPlayer.player.start(audioStream);


	    }
	    catch(FileNotFoundException e){
	    	System.out.println("Error 1");
	    }
	    catch(IOException e){
	    	System.out.println("Error 1");
	    }
	    playSound("musicA1.m4a");
	   
	 
		

	}

}
