package MiddleGames.SceneManager;

import LargoEngine.Core.Components.GameObject;
import LargoEngine.Core.Components.SpriteRenderer;
import LargoEngine.Core.Components.SpriteSheet;
import LargoEngine.Core.Components.Transform;
import LargoEngine.Core.Renderer.Camera2D;
import LargoEngine.Core.Renderer.CameraBase;
import LargoEngine.Core.Values.vec3;
import MiddleGames.AssetManager;


public class LevelEditorScene extends Scene{

    Camera2D Camera;

    public LevelEditorScene() {
        System.out.println("We are in level editor now");

        LoadResources();

        SpriteSheet spriteSheet = AssetManager.getSpriteSheet("Assets/Images/spriteSheet.png");

        Camera = new Camera2D(new vec3(-250,-0,0));
        GameObject obj1 = new GameObject("Object 1", new Transform(new vec3(100, 100), new vec3(256, 256)));
        obj1.AddComponent(new SpriteRenderer(spriteSheet.GetSprite(0)));
        this.AddGameObjectToScene(obj1);

        GameObject obj2 = new GameObject("Object 2", new Transform(new vec3(400, 100), new vec3(256, 256)));
        obj2.AddComponent(new SpriteRenderer(spriteSheet.GetSprite(10)));
        this.AddGameObjectToScene(obj2);
    }

    private void LoadResources() {
         AssetManager.addSpriteSheet("Assets/Images/spriteSheet.png",
                 new SpriteSheet(AssetManager.GetTexture("Assets/Images/spriteSheet.png")
                         ,8 , 8 , 26 , 0));
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
