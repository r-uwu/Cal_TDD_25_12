package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String exp) {

        exp = exp.replaceAll("[(]", "( ");
        exp = exp.replaceAll("[)]"," )");

        ArrayList<String> bits = new ArrayList<>(Arrays.asList(exp.split("\\s+")));

        if(bits.contains("("))
        {
            int start = 0, end = 0;

            for(int i = 0; i < bits.size(); i++)
            {
                if(bits.get(i).equals("("))
                    start = i;
                if(bits.get(i).equals(")")){
                    end = i;
                    break;
                }
            }

            String innerExp = String.join(" ",(bits.subList(start+1, end)));

            bits.subList(start, end+1).clear();
            int innerVal = run(innerExp);
            bits.add(start, String.valueOf(innerVal));
        }
        return calc(bits);
    }


    static int calc(ArrayList<String> bits) {

        String op;

        int i = 1;
        while (i < bits.size()) {
            op = bits.get(i);
            if (op.equals("*")) {

                bits.set(i - 1, String.valueOf(Integer.parseInt(bits.get(i - 1)) * Integer.parseInt(bits.get(i + 1))));
                bits.remove(i);
                bits.remove(i);
            }
            else if(op.equals("/"))
            {
                bits.set(i - 1, String.valueOf(Integer.parseInt(bits.get(i - 1)) / Integer.parseInt(bits.get(i + 1))));
                bits.remove(i);
                bits.remove(i);
            }
            else {
                i += 2;
            }
        }
        int result = Integer.parseInt(bits.get(0));

        for(int n = 1; n < bits.size(); n+=2){
            op = bits.get(n);

            if(op.equals("+"))
                result+= Integer.parseInt(bits.get(n+1));
            else if(op.equals("-"))
                result-=Integer.parseInt(bits.get(n+1));
        }
        return result;
    }
}
