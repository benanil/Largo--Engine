package LargoEngine.Core.Renderer;

import LargoEngine.Core.Components.GameObject;
import LargoEngine.Core.Components.SpriteRenderer;

import java.util.ArrayList;
import java.util.List;

public class Renderer {
    private static final int MAX_BATCH_SIZE = 1000;
    private List<RenderBatch> batches;

    public Renderer(){
        this.batches = new ArrayList<RenderBatch>();
    }

    public void add(GameObject go){
        SpriteRenderer spr = go.GetComponent(SpriteRenderer.class);
        if (spr != null){
            add(spr);
        }
        else {
            System.out.println("game object has not sprite renderer but you trying to add renderer");
        }
    }

    private void add(SpriteRenderer sprite){
        boolean added = false;

        for (RenderBatch batch : batches){
            if (batch.hasRoom()){
                batch.addSprite(sprite);
                added = true;
                break;
            }
        }

        if (!added){
            AddBatch(sprite,"Assets/Shaders/Basic.glsl");
        }
    }

    public void AddBatch(SpriteRenderer sprite, String ShaderPath){
        RenderBatch newBatch = new RenderBatch(MAX_BATCH_SIZE,ShaderPath);
        newBatch.start();
        batches.add(newBatch);
        newBatch.addSprite(sprite);
    }

    public void Render(){
        for (RenderBatch batch : batches){
            batch.render();
        }
    }

}
