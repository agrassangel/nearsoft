package nearsoft.testcase.first;


import cucumber.api.java.en.Given;

import java.util.ArrayList;
import java.util.Collections;

public class FirstClass {
    private ArrayList<Integer> newArray;
    public FirstClass(){
        newArray=new ArrayList<>();
        initializeArrfay();

    }
    private void initializeArrfay(){
        newArray.add(5);
        newArray.add(8);
        newArray.add(1);
        newArray.add(6);
        newArray.add(2);
    }

    public void sortArray(){
        Collections.sort(newArray);
        System.out.println(newArray.toString());
    }



}
