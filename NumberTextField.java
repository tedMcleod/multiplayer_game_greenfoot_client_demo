import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NumberTextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberTextField extends TextField {
    
    public NumberTextField(int width, int height) {
        super(width, height);
    }
    
    @Override
    public boolean isValidKey(String key) {
        return super.isValidKey(key) && Character.isDigit(key.charAt(0));
    }
    
    public int getValue() {
        return Integer.parseInt(getText());
    }
    
    public void setValue(int value) {
        setText("" + value);
    }
}
