package LargoEngine.Core.Components;

import LargoEngine.Core.Values.Color;
import LargoEngine.Core.Values.vec2;

public class SpriteRenderer extends Component {

    public Color color;
    public Sprite sprite;

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

    }

    @Override
    public void Start() {

    }

    public vec2[] getTexCoords() {
        vec2[] texCoords = {
                new vec2(1, 1),
                new vec2(1, 0),
                new vec2(0, 0),
                new vec2(0, 1)
        };
        return texCoords;
    }
}
