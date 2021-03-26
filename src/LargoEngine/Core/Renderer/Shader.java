package LargoEngine.Core.Renderer;

import LargoEngine.Core.Values.Color;
import LargoEngine.Core.Values.vec2;
import LargoEngine.Core.Values.vec3;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;

public class Shader {

    private int shaderProgram;
    private String vertexSource;
    private String fragmentSource;
    private String filePath;
    private boolean beingUsed;
    //for debug
    public String Name;

    public Shader (String filePath) {
        this.filePath = filePath;

        try{
            String source = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] splitString = source.split("(#type)( )+([a-zA-Z]+)");
            int index = source.indexOf("#type") + 6;
            int eol = source.indexOf("\r\n",index);
            String firstPattern = source.substring(index,eol).trim();

            index = source.indexOf("#type",eol)+6;
            eol = source.indexOf("\r\n",index);
            String secondPattern = source.substring(index,eol).trim();

            if (firstPattern.equals("vertex")){
                vertexSource = splitString[1];
            }
            else if (firstPattern.equals("fragment")){
                fragmentSource = splitString[1];
            }
            else {
                throw new IOException("when " + filePath + " initializing  first path failed");
            }

            if (secondPattern.equals("vertex")){
                vertexSource = splitString[2];
            }
            else if (secondPattern.equals("fragment")){
                fragmentSource = splitString[2];
            }
            else {
                throw new IOException("when " + filePath + " initializing  second path failed");
            }


        }catch(IOException ex){
            ex.printStackTrace();
            assert false : ex.getLocalizedMessage();
        }
    }

    public void Compile(){
        System.out.println("shader start compiling");

        int vertexId, fragmentId;

        // Load and compile shaders
        vertexId = glCreateShader(GL_VERTEX_SHADER);
        // pass vertex shader to the gpu
        glShaderSource(vertexId,vertexSource);
        glCompileShader(vertexId);

        // check errors
        int success = glGetShaderi(vertexId,GL_COMPILE_STATUS);

        if (success == GL_FALSE){
            int len = glGetShaderi(vertexId,GL_INFO_LOG_LENGTH);
            System.out.println(glGetShaderInfoLog(vertexId,len));
            assert  false: "failed compile vertex";
        }

        fragmentId = glCreateShader(GL_FRAGMENT_SHADER);
        // pass vertex shader to the gpu
        glShaderSource(fragmentId,fragmentSource);
        glCompileShader(fragmentId);

        // check errors
        success = glGetShaderi(fragmentId,GL_COMPILE_STATUS);

        if (success == GL_FALSE){
            int len = glGetShaderi(fragmentId,GL_INFO_LOG_LENGTH);
            System.out.println(glGetShaderInfoLog(fragmentId,len));
            assert  false: "failed compile fragment";
        }

        // link shaders

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexId);
        glAttachShader(shaderProgram, fragmentId);
        glLinkProgram(shaderProgram);

        // check for linking errors

        success = glGetProgrami(shaderProgram,GL_LINK_STATUS);
        if (success == GL_FALSE){
            int len= glGetProgrami(shaderProgram,GL_INFO_LOG_LENGTH);
            System.out.println(glGetProgramInfoLog(shaderProgram,len));
            assert  false: "failed shader linking";
        }
        System.out.println("compile success");

    }

    public void Use(){
        if (!beingUsed){
            beingUsed = true;
            glUseProgram(shaderProgram);
        }
    }

    public void Detach(){
        beingUsed = false;
        glUseProgram(0);
    }

    public int getShaderProgram() {
        return shaderProgram;
    }

    public static int PropertyToId(int shaderProgram, String property){
        return glGetUniformLocation(shaderProgram,property);
    }

    // these below codes for Changing shader's value

    public void UploadMatrix4(int propertyId, Matrix4f mat4){
        FloatBuffer matBuffer = BufferUtils.createFloatBuffer(16);
        mat4.get(matBuffer);
        glUniformMatrix4fv(propertyId,false,matBuffer);
    }

    public void UploadMatrix4(String varName, Matrix4f mat4){
        int varLocation = glGetUniformLocation(shaderProgram,varName);
        Use();
        FloatBuffer matBuffer = BufferUtils.createFloatBuffer(16);
        mat4.get(matBuffer);
        glUniformMatrix4fv(varLocation,false,matBuffer);
    }

    public void UploadFloat(String varName, float value){
        int varLocation = glGetUniformLocation(shaderProgram,varName);
        glUniform1f(varLocation,value);
    }

    public void UploadFloat(int PropertyId, float value){
        glUniform1f(PropertyId,value);
    }

    public void UploadColor(String varName, Color value){
        int varLocation = glGetUniformLocation(shaderProgram,varName);

        glUniform4f(varLocation,value.r,value.g,value.b,value.a);
    }

    public void UploadColor(int PropertyId, Color value){
        glUniform4f(PropertyId,value.r,value.g,value.b,value.a);
    }

    public void UploadVec2(String varName, vec2 value){
        int varLocation = glGetUniformLocation(shaderProgram,varName);

        glUniform2f(varLocation,value.x,value.y);
    }

    public void UploadVec2(int PropertyId, vec2 value){
        glUniform2f(PropertyId,value.x,value.y);
    }

    public void UploadVec3(String varName, vec3 value){
        int varLocation = glGetUniformLocation(shaderProgram,varName);

        glUniform3f(varLocation,value.x,value.y,value.z);
    }

    public void UploadVec3(int PropertyId, vec3 value){
        glUniform3f(PropertyId,value.x,value.y,value.z);
    }

    public void UploadTexture(int PropertyID,int slot) {
        glGetUniformi(PropertyID,slot);
    }

    public void uploadIntArray(String varName, int[] array) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        Use();
        glUniform1iv(varLocation, array);
    }

    public void uploadIntArray(int varName, int[] array) {
        Use();
        glUniform1iv(varName, array);
    }
}
