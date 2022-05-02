import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class GameActor extends Actor {
    
    private String id;
    
    public GameActor(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void onDestroy(GameWorld world) {
        world.removeObject(this);
    }
    
    public void destroy() {
        GameWorld gw = getWorldOfType(GameWorld.class);
        if (gw != null) {
            onDestroy(gw);
            if (gw.getClient() != null && gw.getClient().getConnected().get()) {
                gw.getClient().sendMessage("DESTROY " + getId());
            }
        }
    }
}
