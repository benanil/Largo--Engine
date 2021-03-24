package LargoEngine.Core.input;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

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

}
