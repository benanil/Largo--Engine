package LargoEngine.Core.Renderer;

import LargoEngine.Core.Components.GameObject;
import LargoEngine.Core.Components.SpriteRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import imgui.*;

public class Renderer {
    private static final int MAX_BATCH_SIZE = 1000;
    private List<RenderBatch> batches;

    public Renderer(){
        this.batches = new ArrayList<RenderBatch>();
    }

    public void add(GameObject go){
        SpriteRenderer spr = go.GetComponent(SpriteRenderer.class);
        if (spr != null){
            add(spr,go.zIndex);
        }
        else {
            System.out.println("game object has not sprite renderer but you trying to add renderer");
        }
    }

    private void add(SpriteRenderer sprite,int zIndex){
        boolean added = false;

        for (RenderBatch batch : batches){
            if (batch.hasRoom() && batch.zIndex == sprite.gameObject.zIndex){
                batch.addSprite(sprite);
                added = true;
                break;
            }
        }

        if (!added){
            AddBatch(sprite,"Assets/Shaders/Basic.glsl",zIndex);
            Collections.sort(batches);
        }
    }

    public void AddBatch(SpriteRenderer sprite, String ShaderPath,int zIndex){
        RenderBatch newBatch = new RenderBatch(MAX_BATCH_SIZE,ShaderPath,zIndex);
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
