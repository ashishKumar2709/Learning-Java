package components;
public class Component3 extends Component2 {
    public Component3(){
        System.out.println("From component 3");
    }
    public Component3(int n){
        this();
        System.out.println("From parameterized constructor component 3: "+ n);
    }
    public void showInfo(){
        System.out.println("No data");
    }
}
