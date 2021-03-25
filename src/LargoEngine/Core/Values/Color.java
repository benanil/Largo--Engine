package LargoEngine.Core.Values;

import LargoEngine.Core.Mathf;

public class Color {
    public float r;
    public float g;
    public float b;
    public float a;

    public void Lerp(Color b, float t)
    {
        t = Mathf.Clamp01(t);
        this.r = this.r + (b.r - this.r) * t;
        this.g = this.g + (b.g - this.g) * t;
        this.b = this.b + (b.b - this.b) * t;
        this.a = this.a + (b.a - this.a) * t;
    }

    public void Max(float maxValue)
    {
        this.r = Mathf.Max(r,maxValue);
        this.g = Mathf.Max(g,maxValue);
        this.b = Mathf.Max(b,maxValue);
        this.a = Mathf.Max(a,maxValue);
    }

    public void Clamp01(){
        this.r = Mathf.Clamp01(r);
        this.g = Mathf.Clamp01(g);
        this.b = Mathf.Clamp01(b);
        this.a = Mathf.Clamp01(a);
    }

    // Ready veriables
    public static final Color red    () { return new Color(1f, 0f, 0f, 1f);}
    public static final Color green  () {return new Color(0F, 1F, 0F, 1F); }
    public static final Color blue   () {return new Color(0F, 0F, 1F, 1F); }
    public static final Color white  () {return new Color(1F, 1F, 1F, 1F); }
    public static final Color black  () {return new Color(0F, 0F, 0F, 1F); }
    public static final Color yellow () {return new Color(1F, 235F / 255F, 4F / 255F, 1F); }
    public static final Color cyan   () {return new Color(0F, 1F, 1F, 1F); }
    public static final Color magenta() {return new Color(1F, 0F, 1F, 1F); }
    public static final Color gray   () {return new Color(.5F, .5F, .5F, 1F); }
    public static final Color grey   () {return new Color(.5F, .5F, .5F, 1F); }
    public static final Color clear  () {return new Color(0F, 0F, 0F, 0F); }

    public boolean equals(Color b)
    {
        return b.r == this.r && b.g == this.g && b.b == this.b;
    }

    // Constructors

    public Color() {
        r = 1;
        g = 1;
        b = 1;
        a = 1;
    }

    public Color(float greyness) {
        r = greyness;
        g = greyness;
        b = greyness;
        a = greyness;
    }

    public Color(float r,float g , float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(float r,float g , float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 1;
    }

    public Color(Color extended) {
        r = extended.r;
        g = extended.g;
        b = extended.b;
        a = extended.a;
    }


    //OPERATORS

    public void Plus(Color value){
        this.r += value.r;
        this.g += value.g;
        this.b += value.b;
        this.a += value.a;
    }

    public void Plus(float value) {
        this.r += value;
        this.g += value;
        this.b += value;
        this.a += value;
    }

    // Subtracts color /b/ from color /a/. Each component is subtracted separately.
    public void Negate(Color value) {
        this.r -= value.r;
        this.g -= value.g;
        this.b -= value.b;
        this.a -= value.a;
    }

    public void Negate(float value) {
        this.r -= value;
        this.g -= value;
        this.b -= value;
        this.a -= value;
    }

    // Multiplies color /a/ by the float /b/. Each color component is scaled separately.
    public static final Color Multiply(Color old, float value) {
        return new Color(
        old.r * value,
        old.g * value,
        old.b * value,
        old.a * value
        );
    }

    // Multiplies color /a/ by the float /b/. Each color component is scaled separately.
    public void Multiply(Color value) {
        this.r *= value.r;
        this.g *= value.g;
        this.b *= value.b;
        this.a *= value.a;
    }

    public void Devide(float value) {
        this.r /= value;
        this.g /= value;
        this.b /= value;
        this.a /= value;
    }

}
