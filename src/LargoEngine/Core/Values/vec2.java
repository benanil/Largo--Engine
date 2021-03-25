package LargoEngine.Core.Values;

import LargoEngine.Core.Mathf;

public class vec2 {
    public float x;
    public float y;

    public static final vec2 Zero = new vec2(0,0);
    public static final vec2 One = new vec2(1,1);

    public vec2() {
        this.x = 0;
        this.y = 0;
    }

    public vec2(float x,float y) {
        this.x = x;
        this.y = y;
    }

    public void Multiply(float value) {
        x *= value;
        y *= value;
    }

    public void Devide(float value) {
        x /= value;
        y /= value;
    }

    public void Negate(float value) {
        x -= value;
        y -= value;
    }

    public void Add(float value) {
        x += value;
        y += value;
    }

    public void Add(vec2 value) {
        x += value.x;
        y += value.y;
    }

    public boolean equals(vec2 b)
    {
        return this.x == b.x && this.y == b.y;
    }

    public void Set(float newX, float newY) { x = newX; y = newY; }

    public static vec2 Lerp(vec2 a, vec2 b, float t) {
        t = Mathf.Clamp01(t);
        return new vec2(
                a.x + (b.x - a.x) * t,
                a.y + (b.y - a.y) * t
        );
    }

    public static vec2 LerpUnclamped(vec2 a, vec2 b, float t) {
        return new vec2(
                a.x + (b.x - a.x) * t,
                a.y + (b.y - a.y) * t
        );
    }

    // Moves a point /current/ towards /target/.
    public static vec2 MoveTowards(vec2 current, vec2 target, float maxDistanceDelta) {
        // avoid vector ops because current scripting backends are terrible at inlining
        float toVector_x = target.x - current.x;
        float toVector_y = target.y - current.y;

        float sqDist = toVector_x * toVector_x + toVector_y * toVector_y;

        if (sqDist == 0 || (maxDistanceDelta >= 0 && sqDist <= maxDistanceDelta * maxDistanceDelta))
            return target;

        float dist = (float)Math.sqrt(sqDist);

        return new vec2(current.x + toVector_x / dist * maxDistanceDelta,
                current.y + toVector_y / dist * maxDistanceDelta);
    }

}
