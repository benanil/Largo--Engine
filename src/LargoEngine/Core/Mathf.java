package LargoEngine.Core;

public final class Mathf {

    // Returns the sine of angle /f/ in radians.
    public static final float Sin(float f) { return (float)Math.sin(f); }

    // Returns the cosine of angle /f/ in radians.
    public static final float Cos(float f) { return (float)Math.cos(f); }

    // Returns the tangent of angle /f/ in radians.
    public static final float Tan(float f) { return (float)Math.tan(f); }

    // Returns the arc-sine of /f/ - the angle in radians whose sine is /f/.
    public static final float Asin(float f) { return (float)Math.asin(f); }

    // Returns the arc-cosine of /f/ - the angle in radians whose cosine is /f/.
    public static final float Acos(float f) { return (float)Math.acos(f); }

    // Returns the arc-tangent of /f/ - the angle in radians whose tangent is /f/.
    public static final float Atan(float f) { return (float)Math.atan(f); }

    // Returns the angle in radians whose ::ref::Tan is @@y/x@@.
    public static final float Atan2(float y, float x) { return (float)Math.atan2(y, x); }

    // Returns square root of /f/.
    public static final float Sqrt(float f) { return (float)Math.sqrt(f); }

    // Returns the absolute value of /f/.
    public static final float Abs(float f) { return (float)Math.abs(f); }

    // Returns the absolute value of /value/.
    public static final int Abs(int value) { return Math.abs(value); }

    public static float Min(float a, float b) { return a < b ? a : b; }
    // Returns the smallest of two or more values.
    public static float Min(float[] values)
    {
        int len = values.length;
        if (len == 0)
            return 0;
        float m = values[0];
        for (int i = 1; i < len; i++)
        {
            if (values[i] < m)
                m = values[i];
        }
        return m;
    }

    public static int Min(int a, int b) { return a < b ? a : b; }
    // Returns the smallest of two or more values.
    public static int Min(int[] values)
    {
        int len = values.length;
        if (len == 0)
            return 0;
        int m = values[0];
        for (int i = 1; i < len; i++)
        {
            if (values[i] < m)
                m = values[i];
        }
        return m;
    }

    public static float Max(float a, float b) { return a > b ? a : b; }

    // Returns largest of two or more values.
    public static float Max(float[] values)
    {
        int len = values.length;
        if (len == 0)
            return 0;
        float m = values[0];
        for (int i = 1; i < len; i++)
        {
            if (values[i] > m)
                m = values[i];
        }
        return m;
    }

    public static int Max(int a, int b) { return a > b ? a : b; }
    // Returns the largest of two or more values.
    public static int Max(int[] values)
    {
        int len = values.length;
        if (len == 0)
            return 0;
        int m = values[0];
        for (int i = 1; i < len; i++)
        {
            if (values[i] > m)
                m = values[i];
        }
        return m;
    }

    // Returns /f/ raised to power /p/.
    public static float Pow(float f, float p) { return (float)Math.pow(f, p); }

    // Returns e raised to the specified power.
    public static float Exp(float power) { return (float)Math.exp(power); }

    // Returns the natural (base e) logarithm of a specified number.
    public static float Log(float f) { return (float)Math.log(f); }

    // Returns the base 10 logarithm of a specified number.
    public static float Log10(float f) { return (float)Math.log10(f); }

    // Returns the smallest integer greater to or equal to /f/.
    public static float Ceil(float f) { return (float)Math.ceil(f); }

    // Returns the largest integer smaller to or equal to /f/.
    public static float Floor(float f) { return (float)Math.floor(f); }

    // Returns /f/ rounded to the nearest integer.
    public static float Round(float f) { return (float)Math.round(f); }

    // Returns the smallest integer greater to or equal to /f/.
    public static int CeilToInt(float f) { return (int)Math.ceil(f); }

    // Returns the largest integer smaller to or equal to /f/.
    public static int FloorToInt(float f) { return (int)Math.floor(f); }

    // Returns /f/ rounded to the nearest integer.
    public static int RoundToInt(float f) { return (int)Math.round(f); }

    // Returns the sign of /f/.
    public static float Sign(float f) { return f >= 0F ? 1F : -1F; }

    // The infamous ''3.14159265358979...'' value (RO).
    public static final float PI = (float)Math.PI;

    // A representation of positive infinity (RO).
    public static final float Infinity = 900000000f;

    // A representation of negative infinity (RO).
    public static final float NegativeInfinity = -90000000f;

    // Degrees-to-radians conversion constant (RO).
    public static final float Deg2Rad = PI * 2F / 360F;

    // Radians-to-degrees conversion constant (RO).
    public static final float Rad2Deg = 1F / Deg2Rad;

    // A tiny floating point value (RO).
    public static final float Epsilon = 0.0000001f;

    // Clamps a value between a minimum float and maximum float value.
    public static float Clamp(float value, float min, float max)
    {
        if (value < min)
            value = min;
        else if (value > max)
            value = max;
        return value;
    }

    // Clamps value between min and max and returns value.
    // Set the position of the transform to be that of the time
    // but never less than 1 or more than 3
    //
    public static int Clamp(int value, int min, int max)
    {
        if (value < min)
            value = min;
        else if (value > max)
            value = max;
        return value;
    }

    // Clamps value between 0 and 1 and returns value
    public static float Clamp01(float value)
    {
        if (value < 0F)
            return 0F;
        else if (value > 1F)
            return 1F;
        else
            return value;
    }

    // Interpolates between /a/ and /b/ by /t/. /t/ is clamped between 0 and 1.
    public static float Lerp(float a, float b, float t)
    {
        return a + (b - a) * Clamp01(t);
    }

    // Interpolates between /a/ and /b/ by /t/ without clamping the interpolant.
    public static float LerpUnclamped(float a, float b, float t)
    {
        return a + (b - a) * t;
    }

    // Same as ::ref::Lerp but makes sure the values interpolate correctly when they wrap around 360 degrees.
    public static float LerpAngle(float a, float b, float t)
    {
        float delta = Repeat((b - a), 360);
        if (delta > 180)
            delta -= 360;
        return a + delta * Clamp01(t);
    }

    // Moves a value /current/ towards /target/.
    static public float MoveTowards(float current, float target, float maxDelta)
    {
        if (Mathf.Abs(target - current) <= maxDelta)
            return target;
        return current + Mathf.Sign(target - current) * maxDelta;
    }

    // Same as ::ref::MoveTowards but makes sure the values interpolate correctly when they wrap around 360 degrees.
    static public float MoveTowardsAngle(float current, float target, float maxDelta)
    {
        float deltaAngle = DeltaAngle(current, target);
        if (-maxDelta < deltaAngle && deltaAngle < maxDelta)
            return target;
        target = current + deltaAngle;
        return MoveTowards(current, target, maxDelta);
    }

    // Interpolates between /min/ and /max/ with smoothing at the limits.
    public static float SmoothStep(float from, float to, float t)
    {
        t = Mathf.Clamp01(t);
        t = -2.0F * t * t * t + 3.0F * t * t;
        return to * t + from * (1F - t);
    }

    //*undocumented
    public static float Gamma(float value, float absmax, float gamma)
    {
        boolean negative = value < 0F;
        float absval = Abs(value);
        if (absval > absmax)
            return negative ? -absval : absval;

        float result = Pow(absval / absmax, gamma) * absmax;
        return negative ? -result : result;
    }

    // Compares two floating point values if they are similar.
    public static boolean Approximately(float a, float b)
    {
        return Abs(b - a) < Max(0.000001f * Max(Abs(a), Abs(b)), Epsilon * 8);
    }

    // Calculates the shortest difference between two given angles.
    public static float DeltaAngle(float current, float target)
    {
        float delta = Mathf.Repeat((target - current), 360.0F);
        if (delta > 180.0F)
            delta -= 360.0F;
        return delta;
    }

    // Loops the value t, so that it is never larger than length and never smaller than 0.
    public static float Repeat(float t, float length)
    {
        return Clamp(t - Mathf.Floor(t / length) * length, 0.0f, length);
    }
}
