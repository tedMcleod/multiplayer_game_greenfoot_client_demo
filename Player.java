import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends LocalActor {
    
    private int SHOT_CD = 60;
    private int shotCooldown = 0;
    
    public Player(String id) {
        super(id);
    }
    
    public void act() {
        if (shotCooldown > 0) shotCooldown--;
        if (Greenfoot.isKeyDown("down")) {
            move(-1);
        } else if (Greenfoot.isKeyDown("up")) {
            move(1);
        }
        
        if (Greenfoot.isKeyDown("left")) {
            turn(-1);
        } else if (Greenfoot.isKeyDown("right")) {
            turn(1);
        }
        
        if (Greenfoot.isKeyDown("space") && shotCooldown == 0) {
            shotCooldown = SHOT_CD;
            fireShot();
        }
        if (getX() < 0) {
            setLocation(getWorld().getWidth(), getY());
        } else if (getX() > getWorld().getWidth()) {
            setLocation(0, getY());
        }
        
        if (getY() < 0) {
            setLocation(getX(), getWorld().getHeight());
        } else if (getY() > getWorld().getHeight()) {
            setLocation(getX(), 0);
        }
    }
    
    public void fireShot() {
        Shot shot = new Shot();
        getWorld().addObject(shot, getX(), getY());
        shot.setRotation(getRotation());
    }
    
    @Override
    public void onDestroy(GameWorld world) {
        for (Shot s : world.getObjects(Shot.class)) s.destroy();
        Greenfoot.stop();
        Greenfoot.setWorld(new TitleWorld());
        Greenfoot.start();
    }
}
