package LargoEngine.Core.Components;

import LargoEngine.Core.Values.vec3;

public class Transform {
    public vec3 position;
    public vec3 scale;

    public Transform() {
        position = vec3.Zero;
        scale = vec3.One;
    }

    public Transform(vec3 position) {
        scale = vec3.One;
        this.position = position;
    }

    public Transform(vec3 position,vec3 scale) {
        this.scale = scale;
        this.position = position;
    }

    public Transform copy()
    {
        return new Transform(new vec3(this.position),new vec3(this.scale));
    }

    public boolean equals(Transform b)
    {
        return this.position.equals(position) && this.scale.equals(scale);
    }

}
