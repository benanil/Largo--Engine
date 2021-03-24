package MiddleGames.SceneManager;

import LargoEngine.Core.Components.GameObject;

public final class SceneManager {

    public static int currentSceneIndex = -1;
    public static Scene CurrentScene;

    public static final void ChangeScane(int newScene){

        if (currentSceneIndex != newScene) // zaten aynı sahne olduğu anlamına gelir
        switch (newScene)
        {
            case 0: CurrentScene = new LevelEditorScene();
                    CurrentScene.Init();
                    CurrentScene.Start();
                break;
            case 1: CurrentScene = new LevelScene();
                    CurrentScene.Init();
                    CurrentScene.Start();
            default:
                assert false : "Unknown scene" + newScene;
        }
    }

    public GameObject Find(String name)
    {
        for (int i = 0;1 < CurrentScene.SceneObjects.size();i++)
        {
            if (CurrentScene.SceneObjects.get(i).Name == name)
            {
                return  CurrentScene.SceneObjects.get(i);
            }
        }
        return null;
    }

}
