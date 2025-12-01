package org.example;

public class Calc {
    public static int run(String exp) {

//        String[] bits = exp.split("\\+").trim(); x
//        String[] bits = exp.split(" \\+ ");

        String[] bits = exp.split(" ");
        int result = 0;

        for(int n = 0; n < bits.length; n++){
            if(bits[n].equals("+")){
                if(result == 0)
                result = sum(Integer.parseInt(bits[n-1]), Integer.parseInt(bits[n+1]));
                else
                    result = result + Integer.parseInt(bits[n+1]);
            }
            else if(bits[n].equals("-")){
                if(result == 0)
                result = sub(Integer.parseInt(bits[n-1]), Integer.parseInt(bits[n+1]));
                else
                    result = result - Integer.parseInt(bits[n+1]);
            }
            else continue;
        }
        /*
        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
        } else if (needToMinus) {
            bits = exp.split(" \\- ");
        }

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);

        if (needToPlus) {
            return (sum(a ,b));
        }
        else if (needToMinus) {
            return (sub(a ,b));
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
        */

        return result;
    }

    static int sum(int a, int b) {
        return a + b;
    }

    static int sub(int a, int b) {
        return a - b;
    }


}
