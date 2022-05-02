import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleWorld extends World {
    private TextField addressField;
    private NumberTextField portField;
    
    public TitleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        int ww = getWidth();
        int wh = getHeight();
        StartButton btn = new StartButton();
        addObject(btn, getWidth() / 2, getHeight() / 2);
                
        addressField = new TextField(100, 20);
        addressField.setText("localhost");
        int afw = addressField.getImage().getWidth();
        int afh = addressField.getImage().getHeight();
        addObject(addressField, ww / 2, wh - afh);
        int afx = addressField.getX();
        int afy = addressField.getY();
        Text ipLabel = new Text("ADDRESS");
        ipLabel.setSize(20);
        int ipw = ipLabel.getImage().getWidth();
        int iph = ipLabel.getImage().getHeight();
        addObject(ipLabel, afx - afw / 2 - ipw / 2 - 5, afy);
        
        Text portLabel = new Text("PORT");
        portLabel.setSize(20);
        int plw = portLabel.getImage().getWidth();
        int plh = portLabel.getImage().getHeight();
        addObject(portLabel, afx + afw / 2 + plw / 2 + 5, afy);
        int plx = portLabel.getX();
        int ply = portLabel.getY();
        
        portField = new NumberTextField(50, 20);
        portField.setValue(1234);
        int pfw = portField.getImage().getWidth();
        int pfh = portField.getImage().getHeight();
        addObject(portField, plx + plw / 2 + 5 + pfw / 2, ply);
    }
    
    public TextField getAddressField() {
        return addressField;
    }
}
