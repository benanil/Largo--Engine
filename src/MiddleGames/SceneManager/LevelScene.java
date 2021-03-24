package MiddleGames.SceneManager;

import LargoEngine.Core.Renderer.Camera2D;
import LargoEngine.Core.Renderer.CameraBase;
import LargoEngine.Core.Values.Color;
import LargoEngine.Core.Values.vec3;
import MiddleGames.MainWindow;

public class LevelScene extends Scene {

    Camera2D camera2D;

    public LevelScene(){
        System.out.println("inside LevelScane");
        MainWindow.get().backGroundColor = new Color(.3f);
        camera2D = new Camera2D(new vec3(-600,-350,0));
    }

    @Override
    public CameraBase GetCamera() {
        return camera2D;
    }

    @Override
    public void Init() {

    }

    @Override
    public void Update() {

    }
}
