package LargoEngine.Core.Renderer;

import org.joml.Matrix4f;

public abstract class CameraBase {
    private Matrix4f projectionMatrix,viewMatrix;
    public float FarPlane = 100;
    public float NearPlane = 0;

    public abstract Matrix4f getViewMatrix();

    public abstract Matrix4f getProjectionMatrix();

}
