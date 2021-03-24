package LargoEngine.Core.Values;

import org.joml.Vector4f;

public class vec4 {
    public static final float kEpsilon = 0.00001F;
    public static final float kEpsilonNormalSqrt = 1e-15F;

    public float x;
    public float y;
    public float z;
    public float w;

    public vec4(float x,float y,float z,float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public vec4() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    // OPERATORS
    public vec4 Multiply(float value) {
        x *= value;
        y *= value;
        z *= value;
        w *= value;
        return this;
    }

    public vec4 Multiply(vec4 value) {
        x *= value.x;
        y *= value.y;
        z *= value.z;
        w *= value.w;
        return this;
    }

    public vec4 Add(float value) {
        x += value;
        y += value;
        z += value;
        w *= value;
        return this;
    }

    public vec4 Add(vec4 value) {
        x += value.x;
        y += value.y;
        z += value.z;
        w *= value.w;
        return this;
    }

    public vec4 Add(float value,float value1,float value2,float value3) {
        x += value;
        y += value1;
        z += value2;
        w *= value3;
        return this;
    }

    public vec4 Devide(float value) {
        x /= value;
        y /= value;
        z /= value;
        w /= value;
        return this;
    }

    public vec4 Devide(vec4 value) {
        x /= value.x;
        y /= value.y;
        z /= value.z;
        w /= value.w;
        return this;
    }

    public vec4 Negate(float value) {
        x -= value;
        y -= value;
        z -= value;
        z -= value;
        return this;
    }

    public vec4 Negate(vec4 value) {
        x -= value.x;
        y -= value.y;
        z -= value.z;
        z -= value.w;
        return this;
    }

    // METHODS
    public Vector4f ToJava(){
        return new Vector4f(x,y,z,w);
    }



}
