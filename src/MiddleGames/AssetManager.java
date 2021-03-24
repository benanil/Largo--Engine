package MiddleGames;

import LargoEngine.Core.Components.SpriteSheet;
import LargoEngine.Core.Renderer.Shader;
import LargoEngine.Core.Renderer.Texture;

import java.io.File;
import java.util.HashMap;

public final class AssetManager {

    private static HashMap<String,Shader> Shaders = new HashMap<String,Shader>();
    private static HashMap<String, Texture> Textures = new HashMap<>();
    private static HashMap<String, SpriteSheet> spriteSheets = new HashMap<>();

    public static Shader GetShader(String filePath)
    {
        if (Shaders.containsKey(filePath)) {
            return Shaders.get(filePath);
        }
        else{
            final var shader = new Shader(filePath);
            shader.Compile();
            Shaders.put(filePath,shader);
            return shader;
        }
    }

    public static Texture GetTexture(String filePath)
    {
        if (Textures.containsKey(filePath))
        {
            return Textures.get(filePath);
        }
        else{
            final Texture texture = new Texture(filePath);
            Textures.put(filePath,texture);
            return texture;
        }
    }

    public static void addSpriteSheet(String filePath, SpriteSheet spriteSheet){
        File file = new File(filePath);

        if (!spriteSheets.containsKey(file.getAbsolutePath())) {
            spriteSheets.put(file.getAbsolutePath(),spriteSheet);
        }

    }

    public static SpriteSheet getSpriteSheet(String resourceName)
    {
        File file = new File(resourceName);

        assert spriteSheets.containsKey(file.getAbsolutePath()) : "error sprite sheet initializing";

        return spriteSheets.get(file.getAbsolutePath());
    }

}
