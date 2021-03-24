package MiddleGames.SceneManager;

import LargoEngine.Core.Components.GameObject;
import LargoEngine.Core.Components.SpriteRenderer;
import LargoEngine.Core.Components.Transform;
import LargoEngine.Core.Renderer.Camera2D;
import LargoEngine.Core.Renderer.CameraBase;
import LargoEngine.Core.Renderer.Texture;
import LargoEngine.Core.Time;
import LargoEngine.Core.Values.Color;
import LargoEngine.Core.Values.vec3;
import MiddleGames.AssetManager;


public class LevelEditorScene extends Scene{

    Camera2D Camera;

    public LevelEditorScene() {
        System.out.println("We are in level editor now");

        Camera = new Camera2D(new vec3(-250,-0,0));

        GameObject obj1 = new GameObject("Object 1", new Transform(new vec3(100, 100), new vec3(256, 256)));
        obj1.AddComponent(new SpriteRenderer(AssetManager.GetTexture("Assets/Images/mario.png")));
        this.AddGameObjectToScene(obj1);

        GameObject obj2 = new GameObject("Object 2", new Transform(new vec3(400, 100), new vec3(256, 256)));
        obj2.AddComponent(new SpriteRenderer(AssetManager.GetTexture("Assets/Images/block.png")));
        this.AddGameObjectToScene(obj2);

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

        this.renderer.Render();
    }

    @Override
    public CameraBase GetCamera() {
        return Camera;
    }
}
