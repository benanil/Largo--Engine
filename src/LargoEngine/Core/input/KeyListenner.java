package LargoEngine.Core.input;

import static org.lwjgl.glfw.GLFW.*;

public final class KeyListenner {

    private static KeyListenner instance;
    private static boolean keyPressed[] = new boolean[350];

    public static KeyListenner get(){
        if (KeyListenner.instance == null){
            KeyListenner.instance = new KeyListenner();
        }
        return  KeyListenner.instance;
    }

    public static void KeyCallBack(Long window,int key,int scancode,int action,int mods)
    {
        if (action == GLFW_PRESS)
        {
            get().keyPressed[key] = true;
        }else if (action == GLFW_RELEASE)
        {
            get().keyPressed[key] = false;
        }
    }

    public static boolean isKeyPressed(int keycode)
    {
        return get().keyPressed[keycode];
    }

    public static boolean PressingAnyAxis()
    {
        return isKeyPressed(GLFW_KEY_A) || isKeyPressed(GLFW_KEY_D) || isKeyPressed(GLFW_KEY_W) || isKeyPressed(GLFW_KEY_S);
    }

    public static float Horizontal()
    {
        if (isKeyPressed(GLFW_KEY_A)){
            return -1;
        }
        else if (isKeyPressed(GLFW_KEY_D)){
            return 1;
        }

        return 0;
    }

    public static float Vertical()
    {
        if (isKeyPressed(GLFW_KEY_S)){
            return -1;
        }
        else if (isKeyPressed(GLFW_KEY_W)){
            return 1;
        }

        return 0;
    }
}
