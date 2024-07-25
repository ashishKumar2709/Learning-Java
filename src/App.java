import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import components.Component1;
import components.Component10;
import components.Component2;
import components.Component3;
import components.Component4;
import components.Component5;
import components.Component6;
import components.Component7;
import components.Component8;
import components.Component9;
import components.CustomException;

sealed class A permits B,C,D{//Sealed classes are classes which only permitted classes can inherit
private int value;
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

final class B extends A {//all permitted classes of a sealed class can be either be final, selaed or non-sealed

}

 sealed class C extends A permits E {

}

 non-sealed class D extends A { //any class can inherit non-sealed class

}

final class E extends C{//no class can inherit final class

}

class F extends D {

}

enum Seasons {
    SUMMER(35), RAINY(30), AUTUM(25), WINTER(20), SPRING(25);

    private int temp;

    Seasons(int temp) {// parameterized and default constructor can be created as in normal class
        this.temp = temp;
    }

    public int getTemp() {// getters and setters methods can be created in enum as well
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
};

@FunctionalInterface // functional interface has only one method
interface Vehicle {// all the methods in interface are public and abstract by default
    String runsOn = "ground"; // variables declared here are by default static and final

    void travel();
}

class Motorcycle implements Vehicle {
    public void travel() {
        System.out.println("travelling..");
    }
}

class Traveller {
    public void travel(Vehicle bike) {
        bike.travel();
    }
}

@FunctionalInterface
interface Feature4 {
    void showInfo(int n);
}

@FunctionalInterface
interface Feature5 {
    int add(int a, int b);
}

abstract class Feature {
    public abstract void click();
}

class Feature1 extends Feature {
    public void click() {
        System.out.println("Clicked");
    }
}

class Feature2 {
    public void add() {
        System.out.println("adding");
    }
}

abstract class Feature3 {
    public abstract void read();
}

class WebPage {
    private int data[];

    public WebPage() {

    };

    public WebPage(int[] data) {
        this.data = data;// this refers to object which is calling the method or constructor, hence
                         // variable is the instance variable
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data2) {
        this.data = data2;
    }
}

 class Counter{
    private int count = 0;
     public synchronized void increment(){//prevent race-condition//syncronised keyword is used for the syncronous operation of two or more operation happening simultaneously
        count++;
    }
    public int getCount(){
        return count;
    }
}
class Student implements Comparable<Student>{
    private int age;
    private String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "Student:{name="+name+", age="+age+"}";
    }

    @Override
    public int compareTo(Student that) {
        return this.age-that.age;
    }

}

record DataCarrier(String name, int id){
    //we can create a parameterized constructor to implement some checks-- 
    //this implementation is further reduced using compact canonical constructor
    //record cannot inherit any other class but can implement interface 
    //and one can define custom methods in record as well 
    //static variables can be defined here but to define instance variable it should be mentioned as paramenter eg: name , id
    public DataCarrier{
        if(id==0){
            throw new IllegalArgumentException("Id cannot be zero");
        }
    }
}

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, World!");
        int data[] = { 7, 9, 1, 1, 3, 4, 5 };
        int arr[] = { 4, 6, 8, 9, 0, 2, 1 };
        WebPage obj1 = new WebPage();
        WebPage obj2 = new WebPage(arr);
        int result1[] = obj2.getData();
        obj1.setData(data);
        int result[] = obj1.getData();
        for (int ele : result) {
            System.out.print(ele + ", ");
        }
        System.out.println();
        for (int ele : result1) {
            System.out.print(ele + ", ");
        }
        System.out.println();
        Component1 obj3 = new Component1();
        Component2 obj4 = new Component2();
        Component1 obj5 = new Component3(5);// dynamic method dispatch, upcasting
        Component3 obj6 = (Component3) obj5; // downcasting;
        obj6.showInfo();
        System.out.println("Component1:" + obj3.getInfo(data));
        System.out.println("Component2:" + obj4.getInfo(data));
        Component4 obj7 = new Component4();
        // obj7.printInfo();
        Component4.printInfo();// static method
        System.out.println("Component3:" + obj5.getInfo(data));// methods of 1 is acccessible
        // System.out.println("Component3:" + obj5.printInfo());
        // System.out.println(Arrays.toString(result));

        double num = 5.7;
        // int i= num;
        int i = (int) num; // typecasting
        System.out.println("Res: " + i);
        Feature obj8 = new Feature1();
        obj8.click();

        // inner class
        Component5 obj9 = new Component5();
        Component5.Component51 obj10 = obj9.new Component51();// instantiating inner class
        obj10.printInfo();

        // anonymous inner class
        Feature2 obj11 = new Feature2()// no semi-colon
        {// anonymous inner class
            public void add() {// locally defined add method
                System.out.println("add new");
            }
        };
        obj11.add();// locally defined add method will be called

        // anonymous-abstract class
        Feature3 obj12 = new Feature3() {
            public void read() {
                System.out.println("reading");
            }
        };
        obj12.read();

        // Interface

        Vehicle bike = new Motorcycle();
        Traveller man = new Traveller();
        man.travel(bike);

        // enum

        Seasons[] seasons = Seasons.values();
        for (Seasons s : seasons) {
            System.out.println(s.ordinal() + ". " + s + ": " + s.getTemp() + "C");
        }

        // lambda expression - used only with functional interface
        Feature4 obj = a -> System.out.println("show data: " + a); // anonymous class with lambda expression
        obj.showInfo(5);

        Feature5 obj13 = (a, b) -> a + b;

        int sumResult = obj13.add(4, 5);
        System.out.println("Sum: " + sumResult);
        
        
        //Threads
        Component9 obj17 = new Component9(); //runnable implemented class
        Component10 obj18 = new Component10();
        Counter obj19 = new Counter();
        Runnable obj20 = ()->{ //runnable instantiated as anonymous fn
            for(int j=0; j<100000; j++){
                obj19.increment();
            }
        };
        Runnable obj21 = ()->{ //runnable instantiated as anonymous fn
            for(int j=0; j<100000; j++){
                obj19.increment();
            }
        };
        Thread t1 = new Thread(obj20);
        Thread t2 = new Thread(obj21); //runnable instance passed while creating new thread instance


        // obj17.start();
        // obj18.start();
        t1.start();
        t2.start();
        t1.join();//join method is used for wating for the threads to complete and then process further
        t2.join();

        int resCount = obj19.getCount();
        System.out.println("Count: "+ resCount);
        
        obj17.setPriority(5); //setPriority is used to add priority for a particular thread from 1-10

        //Collection -Arraylist
        ArrayList<Integer> list = new ArrayList<Integer>();//Arraylist with integer Elements
        
        list.add(33);
        list.add(65);
        list.add(97);
        list.add(99);
        list.add(55);
        list.add(36);
        System.out.println(list);
        System.out.println(list.get(2));
        list.set(2, 81);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        //Collection - HashSet

        Set<String>set = new HashSet<>();//Duplicate values are not not stored in set. Also don't support index values.
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        set.add("D");
        set.add("B");
        set.add("E");
        System.out.println("Set: "+set);
        System.out.println(set.size());
        set.remove("C");
        System.out.println(set);

        //TreeSet
        Set<Integer>set2 = new TreeSet<Integer>(); //This is like hashset but stores sorted values.
        set2.add(45);
        set2.add(43);
        set2.add(34);
        set2.add(78);
        set2.add(87);
        set2.add(45);
        set2.add(43);
        set2.add(86);
        System.out.println("Set2: "+ set2);

        Iterator <Integer> values =  set2.iterator();
        while (values.hasNext()) {//hasnext is true if there is a next value
            System.out.println("TS values"+values.next());//next return next value in set
        }


        //MAP

        Map<String, Integer> map = new HashMap<>(); //stores key value pair
        map.put("ele1", 34);
        map.put("ele2", 45);
        map.put("ele3", 78);
        map.put("ele4", 87);
        map.put("ele5", 89);
        map.put("ele6", 95);
        map.put("ele1", 22);//keys are unique and here value addition to same key will overwrite the previous value
        System.out.println("Map: " +map);
        for(String key : map.keySet()){
            System.out.println(key+": "+map.get(key));
        }

        //HashTable is similar to HashMap but it is syncronised, which is good to prevent race conditions.
        
        //Sort
        ArrayList <String>strList = new ArrayList<>();
        
        strList.add("Himalayas");
        strList.add("Shivaliks");
        strList.add("Kanchanjunga");
        strList.add("K2");
        strList.add("Mount Abu");
        strList.add("Aravallis");
        strList.add("AnaiMudi");
        strList.add("NamchaBarua");
        strList.add("GuruSikhar");

        //sort above based on string length
        Comparator<String> comp = new Comparator<>() {
            public int compare(String a, String b){
                if(a.length()>b.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        System.out.println("Unsorted: "+strList);

        Collections.sort(strList,comp);
        System.out.println("Sorted: "+strList);


        List <Student> students = new ArrayList<>(); 
        students.add(new Student(23, "Ajay"));
        students.add(new Student(32, "Birender"));
        students.add(new Student(29, "Chandra"));
        students.add(new Student(30, "Dinesh"));
        students.add(new Student(31, "Ekka"));
        students.add(new Student(23, "Farz"));
        students.add(new Student(40, "Ganesh"));
        System.out.println(students);
        Collections.sort(students);
        for(Student s: students){
            System.out.println(s);
        }

        //Streams
        List<Integer>list3 = Arrays.asList(23,45,56,67,34,63,33);

        

        Stream<Integer> listStream = list3.stream();//a stream can only be operated upon once
        Stream<Integer> listStream2 = list3.stream();

        Stream<Integer> resStream1 = listStream.filter(ele->ele%2==0).map(ele->ele/2).sorted();
        int resStream = listStream2.filter(ele->ele%2==0).map(ele->ele/2).reduce(0, (c, e)->c+e);
        resStream1.forEach(ele->System.out.println("Sorted"+ele));
        System.out.println("ResStream: "+resStream);

        // Exceptions //runtime exceptions can be caught by using try catch block
        
        //Input

        Component7 obj15 = new Component7();//buffered reader

        Component8 obj16 = new Component8();//Scanner
        
        // int num1 = obj15.inputReader();

        // int num2 = obj16.inputReader();
        

        // System.out.println("Number from Input1: "+ num1);
        // System.out.println("Number from Input2: "+ num2);

        //selaed class
        var numInput = obj16.inputReader(); // variables can be declared with var, but need intial value as it infers type from the value
        E obj22 = new E();
        obj22.setValue(numInput);

        System.out.println("Sealed class"+obj22.getValue());


        //Record class
        DataCarrier name1 = new DataCarrier("Name1", 1234);//data stored in record is immutable hence variables are final
        DataCarrier name2 = new DataCarrier("Name1", 1234);
        DataCarrier name3 = new DataCarrier("Name2", 5345);


        System.out.println(name1);//default toString is created in record calss
        System.out.println("Record"+" "+name1.name()+" "+name1.id());//default getter methods are created for each variable with variable name.
        System.out.println(name2.equals(name1));//default equals class is created
        System.out.println(name3);
        Component6 obj14 = new Component6();
        try {
            obj14.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int x = 5;
        int y = 6;
        int result2 = 0;
        String str = null;
            int[] arr2 = new int[5];
        try {
            result2 = x/y; //when exception is met, appropriate catch block will be executed and further execution will stop
            if(result2==0){
                throw new CustomException("Some msg");
            }
            
        } catch (CustomException e) {
            System.out.println(e+"\ndefault o/p: ");
            result2 = x/1;//we can write additional logic which will work if exception occurs
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(result2);
        // System.out.println(arr2[5]); 
        // System.out.println(str.length());

        // try {
        //     Class.forName("App");
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
    }
}
