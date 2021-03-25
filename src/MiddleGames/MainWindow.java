package MiddleGames;

import LargoEngine.Core.Values.Color;
import MiddleGames.SceneManager.SceneManager;
import LargoEngine.Core.Time;
import LargoEngine.Core.input.KeyListenner;
import LargoEngine.Core.input.MouseListener;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class MainWindow implements Runnable{
    private int width, height;
    private String title;
    public long glfwWindow;

    public Color backGroundColor;

    private static MainWindow window = null;
    public static Thread MainThread;

    private MainWindow() {
        this.width = 1000;
        this.height = 700;
        this.title = "Largo Engine";
        backGroundColor = new Color(.4f);
    }

    public static MainWindow get() {
        if (window == null) {
            window = new MainWindow();
        }

        window.MainThread = new Thread(window,"Largo Engine");

        return window;
    }

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();

        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // terminate glfw
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init() {
        // Setup an error callback
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW.");
        }

        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        // Create the window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if (glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window.");
        }

        glfwSetKeyCallback(glfwWindow, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        glfwSetCursorPosCallback(glfwWindow,MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow,MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow,MouseListener::mouseScrollCallback);

        glfwSetKeyCallback(glfwWindow, KeyListenner::KeyCallBack);


        // Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(glfwWindow);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        glEnable(GL_BLEND);
        glBlendFunc(GL_ONE,GL_ONE_MINUS_SRC_ALPHA);

        SceneManager.ChangeScane(0);
    }

    // main loop od game engine
    public void loop() {
        float beginTime = (float)glfwGetTime();
        float endTime = (float)glfwGetTime();

        while (!glfwWindowShouldClose(glfwWindow)) {
            // Poll events
            glfwPollEvents();

            MainInputs();

            MouseListener.endFrame();

            glClearColor(backGroundColor.r , backGroundColor.g , backGroundColor.b, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            if(Time.DeltaTime >= 0)
                SceneManager.CurrentScene.Update();

            glfwSwapBuffers(glfwWindow);

            endTime = (float)glfwGetTime();
            Time.DeltaTime = endTime - beginTime;
            beginTime = endTime;
        }
    }

    private void MainInputs()
    {
        if (KeyListenner.isKeyPressed(GLFW_KEY_ENTER))
        {
            System.out.println("enter amano");
        }
    }

}
