package components;

public class Component10 extends Thread{//class Thread makes the new class a separate thread
    public void run(){//need to override the run method in thread
        for(int i=0; i<=10;i++){
            System.out.println("From Class10");
            try {
                Thread.sleep(10);//sleep method is used to add delays in ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
    }
}
