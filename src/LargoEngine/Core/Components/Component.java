package LargoEngine.Core.Components;

public abstract class Component {
    public GameObject gameObject = null;
    public abstract void Update();
    public abstract void Start();
}
