package LargoEngine.Core.Components;

import MiddleGames.SceneManager.SceneManager;

import java.util.ArrayList;

public class GameObject extends Component{
    public Transform transform;

    private ArrayList<GameObject> Childs = new ArrayList<GameObject>();
    private ArrayList<Component> Components = new ArrayList<Component>();

    public String Name;

    public GameObject(String name) {
        Name = name;
        this.transform = new Transform();
    }

    public GameObject(String name,Transform transform) {
        Name = name;
        this.transform = transform;
    }

    public <T extends Component> T  GetComponent(Class<T> componentClass){
        for (Component c : Components)
        {
            if (componentClass.isAssignableFrom(c.getClass()))
            {
                return  ((T) c);
            }
        }
        return null;
    }

    public GameObject GetChild(int no){
        return Childs.get(no);
    }

    public <T extends Component> T RemoveComponent(Class<T > componentClass){
        for (int i = 0; i < Components.size();i++)
        {
            Component c = Components.get(i);
            if (componentClass.isAssignableFrom(c.getClass()))
            {
                Components.remove(i);
            }
        }
        return null;
    }

    public void AddComponent(Component c){
        Components.add(c);
        c.gameObject = this;
    }

    public <T extends Component> T GetComponentInChildren(Class<T> componentClass){
        if (GetComponent(componentClass) != null)
            return GetComponent(componentClass);

        for (GameObject go : Childs)
        {
            var goResult = go.GetComponentInChildren(componentClass);
            if (goResult != null)
                return ((T) goResult);
        }
        return null;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Start() {

    }
}
