package LargoEngine.Core.Renderer;

import LargoEngine.Core.Values.vec3;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera2D extends CameraBase{

    private volatile Matrix4f projectionMatrix,viewMatrix;
    public vec3 position;

    public Camera2D (vec3 pos){
        this.position = pos;
        this.projectionMatrix = new Matrix4f();
        this.viewMatrix = new Matrix4f();
        AdjustProjection();
    }

    public void AdjustProjection(){
        projectionMatrix.identity();
        projectionMatrix.setOrtho(0.0f, 32.0f * 40.0f, 0.0f, 32.0f * 21.0f, NearPlane, FarPlane);
    }

    @Override
    public Matrix4f getViewMatrix(){
        Vector3f cameraFront = new Vector3f(0.0f, 0.0f, -1.0f);
        Vector3f cameraUp = new Vector3f(0.0f, 1.0f, 0.0f);
        this.viewMatrix.identity();
        viewMatrix.setLookAt(new Vector3f(position.x, position.y, 20),
                cameraFront.add(position.x, position.y, 0.0f),
                cameraUp);

        return this.viewMatrix;
    }

    @Override
    public Matrix4f getProjectionMatrix(){
        return projectionMatrix;
    }
}
