package components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Component7 {
    public int inputReader(){
        int num =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
             num = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}
