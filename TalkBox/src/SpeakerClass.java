// Speaker Shit  
// text to speech 
import java.util.Locale; 
import javax.speech.Central; 
import javax.speech.synthesis.Synthesizer; 
import javax.speech.synthesis.SynthesizerModeDesc; 
//Scanner from file
import java.io.*;
import java.util.*;

public class SpeakerClass {
	
	    public SpeakerClass (String btn)  throws Exception
	    { 
	    	
	    	File file = new File(btn);
	    	Scanner scanner  = new Scanner(file);
	  

           // set property as Kevin Dictionary 
            System.setProperty("freetts.voices", 
              "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");  
                  
            // Register Engine 
 Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");  
  
             //Create a Synthesizer 
             Synthesizer synthesizer =                                          
               Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));      
      
            // Allocate synthesizer 
            synthesizer.allocate();  
              
            // Resume Synthesizer 
            synthesizer.resume(); 
            
	        try 
	        {     
	              
	            while(scanner.hasNextLine()) {
	            	String talk = scanner.nextLine();
	            	 // speaks the given text until queue is empty. 
	            	synthesizer.speakPlainText(talk, null);          
	            	synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY); 
	              
	            	// Deallocate the Synthesizer. 
	            	synthesizer.deallocate(); 
	            }
	                                            
	        }  
	  
	        catch (Exception e)  
	        { 
	            e.printStackTrace(); 
	        } 
	    } 
	} 

