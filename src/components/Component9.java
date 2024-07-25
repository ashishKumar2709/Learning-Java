package components;

public class Component9 extends Thread{
    public void run(){
        for(int i=0; i<=10; i++){
            System.out.println("From Class9");
             try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
       
    }
}
