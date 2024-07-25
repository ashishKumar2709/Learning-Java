package components;
import java.util.Arrays;

public class Component2 extends Component1 {
    public Component2(){
        System.out.println("From component 2");
    }
    @Override//annotations are used to indicate the desired actions, which help in in finding out bugs and issues.
    public int getInfo(int[] data) {
        Arrays.sort(data);
        return data[0];
    }
    // Cannot override final method public String printInfo(){

    // }
}
