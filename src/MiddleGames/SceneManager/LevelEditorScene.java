package MiddleGames.SceneManager;

import LargoEngine.Core.Components.*;
import LargoEngine.Core.Renderer.Camera2D;
import LargoEngine.Core.Renderer.CameraBase;
import LargoEngine.Core.Time;
import LargoEngine.Core.Values.vec3;
import LargoEngine.Core.input.KeyListenner;
import MiddleGames.AssetManager;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LevelEditorScene extends Scene{

    Camera2D Camera;

    GameObject player;

    public LevelEditorScene() {
        System.out.println("We are in level editor now");

        LoadResources();

        SpriteSheet spriteSheet = AssetManager.getSpriteSheet("Assets/Images/spriteSheet.png");

        Camera = new Camera2D(new vec3(-250,-0,0));
        GameObject obj1 = new GameObject("Object 1", new Transform(new vec3(100, 100), new vec3(256, 256)));
        obj1.AddComponent(new SpriteRenderer(spriteSheet.GetSprite(0)));
        this.AddGameObjectToScene(obj1);

        player = new GameObject("Object 2", new Transform(new vec3(400, 100), new vec3(256, 256)));
        player.AddComponent(new SpriteRenderer(spriteSheet.GetSprite(10)));

        var animation = new ArrayList<Animation>();

        Queue<Sprite> run = new PriorityQueue<>();
        run.add(spriteSheet.GetSprite(1));
        run.add(spriteSheet.GetSprite(2));
        run.add(spriteSheet.GetSprite(3));

        animation.add(new Animation(run,true,"run"));

        player.AddComponent(new Animator(animation,player.GetComponent(SpriteRenderer.class),.3f));

        this.AddGameObjectToScene(player);

    }

    private void LoadResources() {
         AssetManager.addSpriteSheet("Assets/Images/spriteSheet.png",
                 new SpriteSheet(AssetManager.GetTexture("Assets/Images/spriteSheet.png")
                         ,16 , 16 , 26 , 0));
    }

    @Override
    public void Init() {

    }

    @Override
    public void Update() {
        // fps test
        //System.out.println("" + (1f/ Time.DeltaTime) + "FPS");

        for (GameObject go : this.SceneObjects) {
            go.Update();
        }
        if (KeyListenner.PressingAnyAxis())
        {
            player.transform.position.Add(new vec3(KeyListenner.Horizontal() * 100 * Time.DeltaTime,KeyListenner.Vertical() * 100 * Time.DeltaTime));
        }

        this.renderer.Render();
    }

    @Override
    public CameraBase GetCamera() {
        return Camera;
    }
}
