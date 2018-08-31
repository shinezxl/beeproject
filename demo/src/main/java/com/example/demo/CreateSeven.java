package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateSeven {
    static int maxBlue = 16;
    static int minBlue = 1;
    static int maxReds = 33;
    public static void  initSeven(){
        Random rand=new Random();
        int redNumber=0;
        List<Integer> dream = new ArrayList();
        for (int i = 1; i <= 6; i++) {
            redNumber++;
            int maxRed= maxReds- (6-i);
            if (i==6){
                redNumber=rand.nextInt(maxRed - redNumber + 1) + redNumber;
                dream.add(redNumber);
                break;
            }
            int [] arr = new int [6-i];
            for (int j = 0; j < 6-i; j++) {
                arr[j]=rand.nextInt(maxRed - redNumber + 1) + redNumber;
            }
            Arrays.sort(arr);
            redNumber = arr[0];
            dream.add(redNumber);
        }
        int blueNumber=rand.nextInt(maxBlue - minBlue + 1) + minBlue;
        dream.add(blueNumber);
        String aaa = "";
        for (Integer dreamNumber : dream) {
            if (dreamNumber<10){
                aaa="0"+dreamNumber;
            }else {
                aaa = String.valueOf(dreamNumber);
            }
            System.out.print(aaa+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int count =10;
        for (int i = 0; i < count; i++) {
            initSeven();
        }

    }
}
