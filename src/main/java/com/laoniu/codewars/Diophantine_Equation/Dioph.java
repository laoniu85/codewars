package com.laoniu.codewars.Diophantine_Equation;

public class Dioph {

    public static String solEquaStr(long n) {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        long count=0;
        for (long i = 1; i <= Math.sqrt(n); i++) {
            // your code
            if(n%i==0){
                long a= i;
                long b= n/i;
                if((b+a)%2==0&&(b-a)%4==0){
                    long x = (b+a)/2;
                    long y = (b-a)/4;
                    if(count>0){
                        sb.append(", ");
                    }
                    sb.append("[").append(x).append(", ").append(y).append("]");
                    count++;
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

}