package MiddleGames;

import LargoEngine.Core.Renderer.Shader;
import LargoEngine.Core.Renderer.Texture;

import java.util.HashMap;

public final class AssetManager {

    private static HashMap<String,Shader> Shaders = new HashMap<String,Shader>();
    private static HashMap<String, Texture> Textures = new HashMap<String,Texture>();

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

}
