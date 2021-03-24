package LargoEngine.Core.Components;

import LargoEngine.Core.Renderer.Texture;
import LargoEngine.Core.Values.vec2;

public class Sprite {
    public Texture texture;
    public vec2[] texCoords;

    public Sprite(Texture texture)
    {
        this.texture = texture;
        vec2[] texCoords = {
                new vec2(1, 1),
                new vec2(1, 0),
                new vec2(0, 0),
                new vec2(0, 1)
        };
        this.texCoords = texCoords;
    }

    public Sprite(Texture texture,vec2[] texCoord){
        this.texture = texture;
        this.texCoords = texCoord;
    }
}
