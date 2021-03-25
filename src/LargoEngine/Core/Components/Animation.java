package LargoEngine.Core.Components;

import LargoEngine.Core.Mathf;

import java.util.List;

public class Animation {
    public List<Sprite> frames;
    public String name;
    public boolean loop;
    private int allFrames;
    private int currentFrame;

    public Animation(List<Sprite> frames, boolean loop , String name) {
        this.name = name;
        this.frames = frames;
        this.loop = loop;
        allFrames = frames.size()-1;
        currentFrame = -1;
    }

    public Sprite Use()
    {
        if (loop) {
            currentFrame++;
            currentFrame = (int)Mathf.Repeat(currentFrame,allFrames);
            return frames.get(currentFrame);
        }
        else {

        }
        return null;
    }

}
