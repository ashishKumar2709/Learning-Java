package components;

import java.util.Scanner;

public class Component8 {
    public int inputReader(){
        int num =0;
        try (Scanner sc = new Scanner(System.in)) {
            num = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return num;
    }
}
