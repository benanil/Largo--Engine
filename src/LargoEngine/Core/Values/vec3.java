package LargoEngine.Core.Values;

import LargoEngine.Core.Mathf;
import org.joml.Vector3f;

public class vec3 {
    public static final float kEpsilon = 0.00001F;
    public static final float kEpsilonNormalSqrt = 1e-15F;

    public static final vec3 Zero = new vec3(0,0,0);
    public static final vec3 One = new vec3(1,1,1);

    public float x;
    public float y;
    public float z;

    public String ToString()
    {
        return "(" + "x: " + x + " y: " + y + " z: " + z + ")";
    }

    public vec3(float x,float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public vec3(float x,float y,float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public vec3(vec3 value) {
        this.x = value.x;
        this.y = value.y;
        this.z = value.z;
    }

    public vec3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // OPERATORS
    public vec3 Multiply(float value) {
        x *= value;
        y *= value;
        z *= value;
        return this;
    }

    public vec3 Multiply(vec3 value) {
        x *= value.x;
        y *= value.y;
        z *= value.z;
        return this;
    }

    public vec3 Add(float value) {
        x += value;
        y += value;
        z += value;
        return this;
    }

    public vec3 Add(vec3 value) {
        x += value.x;
        y += value.y;
        z += value.z;
        return this;
    }

    public vec3 Add(float value,float value1,float value2) {
        x += value;
        y += value1;
        z += value2;
        return this;
    }

    public vec3 Devide(float value) {
        x /= value;
        y /= value;
        z /= value;
        return this;
    }

    public vec3 Devide(vec3 value) {
        x /= value.x;
        y /= value.y;
        z /= value.z;
        return this;
    }

    public vec3 Negate(float value) {
        x -= value;
        y -= value;
        z -= value;
        return this;
    }

    public vec3 Negate(vec3 value) {
        x -= value.x;
        y -= value.y;
        z -= value.z;
        return this;
    }

    public boolean equals(vec3 b)
    {
        return this.x == b.x && this.y == b.y && this.z == b.z;
    }

    // METHODS
    public Vector3f ToJava(){
        return new Vector3f(x,y,z);
    }

    public void Lerp(vec3 b, float t)
    {
        t = Mathf.Clamp01(t);

        this.x = this.x + (b.x - this.x) * t;
        this.y = this.y + (b.y - this.y) * t;
        this.z = this.z + (b.z - this.z) * t;
    }

    public void MoveTowards(vec3 current, vec3 target, float maxDistanceDelta)
    {
        // avoid vector ops because current scripting backends are terrible at inlining
        float toVector_x = target.x - current.x;
        float toVector_y = target.y - current.y;
        float toVector_z = target.z - current.z;

        float sqdist = toVector_x * toVector_x + toVector_y * toVector_y + toVector_z * toVector_z;

        if (sqdist == 0 || (maxDistanceDelta >= 0 && sqdist <= maxDistanceDelta * maxDistanceDelta)) {
            this.x = target.x;
            this.y = target.y;
            this.z = target.z;
        }

        var dist = (float)Math.sqrt(sqdist);

        this.x = this.x + toVector_x / dist * maxDistanceDelta;
        this.y = this.y + toVector_y / dist * maxDistanceDelta;
        this.z = this.z + toVector_z / dist * maxDistanceDelta;
    }

}
