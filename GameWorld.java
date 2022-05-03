import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public abstract class GameWorld extends World {
    MyGameClient client;
    
    public GameWorld(int width, int height, int cellSize, boolean bounded) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, cellSize, bounded);
    }
    
    public void connect(String ipAddress, int port) {
        client = new MyGameClient(ipAddress, port);
        client.setWorld(this);
        Thread clientThread = new Thread(client);
        clientThread.start();
    }
    
    public MyGameClient getClient() {
        return client;
    }
    
    public GameActor getGameActor(String id) {
            List<GameActor> gmActors = getObjects(GameActor.class);
            for (GameActor ga : gmActors) {
                if (ga.getId().equals(id)) {
                    return ga;
                }
            }
        return null;
    }
    
    @Override
    public void stopped() {
        client.sendMessage("DC");
    }
    
    @Override
    public void started() {
        GameClient client = getClient();
        if (!client.getConnected().get()) {
            Greenfoot.setWorld(new TitleWorld());
        }
    }
}
