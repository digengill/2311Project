import javax.swing.text.*;

public class MaxLengthTextDocument extends PlainDocument {
    //Store maximum characters permitted
    private int maxChars;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // the length of string that will be created is getLength() + str.length()
        if(str != null && (getLength() + str.length() < maxChars)) {
            super.insertString(offs, str, a);
        }
    }
    
    public void setMaxChars (int num) {
    	this.maxChars = num;
    }
}