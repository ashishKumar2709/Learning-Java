package components;
public class Component1 {
    public Component1(){
        System.out.println("From component 1");
    }
    public int getInfo(int[] data) {
        return data[0];
    }

    public final String printInfo() {
        String msg1 = "Component 1 print";
        return msg1;
    }
}
