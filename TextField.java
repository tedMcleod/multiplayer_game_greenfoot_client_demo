import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Write a description of class TextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextField extends Actor {
    
    private boolean isSelected;
    private Color bgColor;
    private Color textColor;
    private Color borderColor;
    private int width;
    private int height;
    private String text;
    
    public TextField(int width, int height) {
        this.width = width;
        this.height = height;
        bgColor = Color.WHITE;
        textColor = Color.BLACK;
        borderColor = Color.BLACK;
        isSelected = false;
        text = "";
        updateImage();
    }
    
    public void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(bgColor);
        img.fill();
        img.setColor(borderColor);
        img.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
        img.setColor(textColor);
        img.drawString(text, 5, img.getHeight() - 5);
        setImage(img);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            setSelected(true);
        } else {
            for (TextField tf : getWorld().getObjects(TextField.class)) {
                if (Greenfoot.mouseClicked(tf)) {
                    setSelected(false);
                }
            }
        }
        if (isSelected()) {
            if (Greenfoot.isKeyDown("backspace")) {
                if (getText().length() > 0) {
                        setText(getText().substring(0, getText().length() - 1));
                    }
            } else {
                String key = Greenfoot.getKey();
                if (key != null) {
                    if (Greenfoot.isKeyDown("control")) {
                        if (key.equals("v")) {
                            Clipboard cb =Toolkit.getDefaultToolkit().getSystemClipboard();
                            try {
                                setText(cb.getData(DataFlavor.stringFlavor).toString());
                            } catch (Exception err) {
                                err.printStackTrace();
                            }
                        }
                    } else if (isValidKey(key)){
                        setText(getText() + key);
                    }
                }
            }
        }
    }
    
    public boolean isValidKey(String key) {
        if (key.length() > 1) return false;
        char c = key.charAt(0);
        return c >= 32 && c <= 127;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String txt) {
        text = txt;
        updateImage();
    }
    
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    
    public boolean isSelected() {
        return isSelected;
    }
}
