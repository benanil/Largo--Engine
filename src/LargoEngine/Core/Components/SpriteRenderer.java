package LargoEngine.Core.Components;

import LargoEngine.Core.Renderer.Texture;
import LargoEngine.Core.Values.Color;
import LargoEngine.Core.Values.vec2;

public class SpriteRenderer extends Component {

    public Color color;
    private Sprite sprite;

    public SpriteRenderer() {

        this.color = new Color();
    }

    public SpriteRenderer(Color color) {
        this.color = color;
    }
    public SpriteRenderer(Texture texture)
    {
        this.color = Color.white();
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
