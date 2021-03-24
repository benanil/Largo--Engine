package LargoEngine.Core.Components;

import LargoEngine.Core.Renderer.Texture;
import LargoEngine.Core.Values.vec2;

import java.util.ArrayList;
import java.util.List;

public class SpriteSheet {

    private Texture texture;
    private List<Sprite> sprites;

    public SpriteSheet(Texture texture,int spriteWidth,int spriteHeight,int numSprites,int spacing)
    {
        this.sprites = new ArrayList<>();
        this.texture = texture;
        int currentX = 0;
        int currentY = texture.getHeight() - spriteHeight;

        for (int i = 0; i < numSprites; i++){
            float topY = (currentY + spriteHeight) / (float)texture.getHeight();
            float rightX = (currentX + spriteWidth) / (float)texture.getWidth();
            float leftX = currentX / (float)texture.getWidth();
            float bottomY = currentY / (float)texture.getHeight();

            vec2[] texCoords = {
                new vec2(rightX, topY),
                new vec2(rightX, bottomY),
                new vec2(leftX, bottomY),
                new vec2(leftX, topY)
            };

            Sprite sprite = new Sprite(this.texture,texCoords);
            this.sprites.add(sprite);

            currentX += spriteWidth + spacing;

            if (currentX >= texture.getWidth())
            {
                currentX = 0;
                currentY -= spriteHeight + spacing;
            }
        }
    }

    public Sprite GetSprite(int index)
    {
        return sprites.get(index);
    }

}
