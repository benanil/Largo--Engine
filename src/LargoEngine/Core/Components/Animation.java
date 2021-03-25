package LargoEngine.Core.Components;

import java.util.PriorityQueue;
import java.util.Queue;

public class Animation {
    public Queue<Sprite> frames;
    public Queue<Sprite> usedFrames;
    public String name;
    public boolean loop;

    public Animation(Queue<Sprite> frames, boolean loop , String name) {
        this.name = name;
        this.frames = frames;
        this.loop = loop;
        usedFrames = new PriorityQueue<>();
    }

    public Sprite Use()
    {
        var oldFrame = frames.remove();
        if (loop) {
            frames.add(oldFrame);
        }
        else {
            usedFrames.add(oldFrame);
        }
        return oldFrame;
    }

    public void Reload()
    {
        for (Sprite sprite: usedFrames){
            frames.add(sprite);
        }
    }

}
