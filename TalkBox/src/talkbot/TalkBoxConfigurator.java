package talkbot;

import java.io.Serializable;
import java.nio.file.Path;

/**
 * This interface represents the configuration of a particular TalkBox device.
 * Each TalkBox device has a number of audio buttons, followed by a number of swap buttons.
 * An audio button plays an audio file when pressed.
 * A swap button associates the audio buttons with a new set of audio files when pressed.
 * Swap button 1 selects audio set 1, Swap button 2 selects audio set 2 etc.
 * If there are not enough swap buttons for each audio set, then the last swap button cycles through all remaining audio sets.
 * 
 * @author bil
 *
 */
public interface TalkBoxConfigurator extends Serializable {

    /**
     * Returns the number of physical buttons that when pressed will play an audio file.
     * 
     * @return int A positive integer
     */
    public int getNumberOfAudioButtons();
    
    /**
     * Returns the number of sets of audio files that this configuration supports.
     * 
     * @return int A positive integer
     */
    public int getNumberOfAudioSets();
    
    /**
     * Returns the total number of buttons in this TalkBox. 
     * 
     * @return int A positive integer
     */
    public int getTotalNumberOfButtons();
    
    /**
     * Returns a Path relative to this configuration object where all audio files can be found
     * @return Path A Path object that identifies the directory that contains the audio files
     */
    public Path getRelativePathToAudioFiles();
    
    /**
     * Returns a 2-dimensional array of Strings that contains the names of all audio files.
     * Each row of the array is an audio set.
     * The dimensions of the array are given by {@link #getNumberOfAudioButtons() getNumberOfAudioButtons}
     * and {@link #getNumberOfAudioSets() getNumberOfAudioSets}
     * @return A 2-dimensional array of Strings
     */
    public String[][] getAudioFileNames();
    
}
