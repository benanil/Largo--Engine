package LargoEngine.Core.Components;

import LargoEngine.Core.Values.vec3;

public class Transform {
    public vec3 position;
    public vec3 Scale;

    public Transform() {
        position = vec3.Zero;
        Scale = vec3.One;
    }

    public Transform(vec3 position) {
        Scale = vec3.One;
        this.position = position;
    }

    public Transform(vec3 position,vec3 scale) {
        Scale = scale;
        this.position = position;
    }
}
