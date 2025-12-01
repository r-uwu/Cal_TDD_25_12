package org.example;

public class Calc {
    public static int run(String exp) {

//        String[] bits = exp.split("\\+").trim(); x
//        String[] bits = exp.split(" \\+ ");

        String[] bits = exp.split(" ");
        int result = Integer.parseInt(bits[0]);
        String op;

        for(int n = 1; n < bits.length; n+=2){
            op = bits[n];

            if(op.equals("+"))
                result+= Integer.parseInt(bits[n+1]);
            else if(op.equals("-"))
                result-=Integer.parseInt(bits[n+1]);
            else if(op.equals("*"))
                result*=Integer.parseInt(bits[n+1]);
            else if(op.equals("/"))
                result/=Integer.parseInt(bits[n+1]);
        }
        return result;
    }

}
