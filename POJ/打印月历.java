import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int monthDay[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = sc.nextInt();
        int month = sc.nextInt();
        boolean isLunar = false;
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            isLunar = true;
        }
        year--;
        int days = year / 4 * (365 * 3 + 366) - year / 100 + year / 400 + (year % 4) * 365;
        for(int i = 0; i < month - 1; i++){
            days += monthDay[i];
        }
        if(isLunar && month > 2){
            days ++;
        }
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int week = (days + 1) % 7;
        for(int i = 0; i < week; i++){
            System.out.print("    ");
        }
        int n = 1;
        for(n = 1; n <= 7 - week; n++){
            System.out.format("%3d ", n);
        }
        System.out.println();
        for(int i = 0; i < (monthDay[month] - 7 + week) / 7; i++){
            for(int j = 0; j < 7; j++){
                System.out.format("%3d ", ++n);
            }
            System.out.println();
        }
        while(n <= monthDay[month]){
            System.out.format("%3d ", ++n);
        }
        System.out.println();
    }
}