package MiddleGames.SceneManager;

import LargoEngine.Core.Components.GameObject;
import LargoEngine.Core.Renderer.CameraBase;
import LargoEngine.Core.Renderer.Renderer;

import java.util.ArrayList;

public abstract class Scene {
    public boolean IsRunning;
    public ArrayList<GameObject> SceneObjects = new ArrayList<GameObject>();
    public Renderer renderer;

    public Scene(){

    }

    public void Start()
    {
        renderer = new Renderer();

        for (GameObject go : SceneObjects){
            go.Start();
            renderer.add(go);
        }

        IsRunning = true;
    }

    public void AddGameObjectToScene(GameObject go){
        if (!IsRunning){
            SceneObjects.add(go);
        }
        else {
            SceneObjects.add(go);
            go.Start();
        }
    }

    public abstract CameraBase GetCamera();

    public abstract void Init();

    public abstract void Update();
}
