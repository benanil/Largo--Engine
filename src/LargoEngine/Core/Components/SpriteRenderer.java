package LargoEngine.Core.Components;

import LargoEngine.Core.Renderer.RenderBatch;
import LargoEngine.Core.Renderer.Texture;
import LargoEngine.Core.Values.Color;
import LargoEngine.Core.Values.vec2;

public class SpriteRenderer extends Component {

    private Color color;
    private Sprite sprite;

    private Transform lastTransform;

    public boolean isDirty;

    public SpriteRenderer(Color color)
    {
        this.color = color;
        this.sprite = new Sprite(null);
    }

    public SpriteRenderer(Sprite sprite)
    {
        this.color = Color.white();
        this.sprite = sprite;
    }

    @Override
    public void Update() {
        if (lastTransform.equals(gameObject.transform))
        {
            lastTransform = gameObject.transform.copy();
            isDirty = true;
        }
    }

    @Override
    public void Start() {
        lastTransform = gameObject.transform.copy();
    }

    public Texture getTexture() {
        return sprite.texture;
    }

    public Color getColor()
    {
        return sprite.color;
    }

    public vec2[] getTexCoords()
    {
        return sprite.texCoords;
    }

    public void SetSprite(Sprite sprite)
    {
        this.sprite = sprite;
        isDirty = true;
    }

    public void setColor(Color color)
    {
        if (this.color != color)
        {
            isDirty = true;
            this.color = color;
        }
    }


}
