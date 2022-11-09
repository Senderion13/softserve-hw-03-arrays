import java.lang.Math;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] values = {1, 0, 2, 5, 6, 4, 10, 3};
        int[] first = {1, 3, 5, 7, 9};
        int[] second = {2, 4};
        ex1(values);
        ex2(values);
        ex3(first, second);
    }

    static void ex1(int[] values) {
        int min = 0;
        int max = 0;
        for (int i = 1; i< values.length; i++) {
            if(values[min] > values[i])min = i;
            if(values[max] < values[i])max = i;
        }
        if(min < max) {
            int var = 0;
            for (int i = min; i < max; i++) {
                var += values[i];
            }
            System.out.println("max index: " + max);
            System.out.println("min index: " + min);
            System.out.println(var);
        } else if (min > max) {
            int var = 0;
            for (int i = max; i < min; i++) {
                var += values[i];
            }
            System.out.println("max index: " + max);
            System.out.println("min index: " + min);
            System.out.println(var);
        } else {
            System.out.println(values[min]);
        }
    }

    static void ex2(int[] values) {
        int[] result = new int[values.length];
        result[0] = values[values.length-1];
        for (int i = 1; i < values.length; i++) {
            result[i] = values[i-1];
            //System.out.println(result[i]);
        }
        values = result;
        System.out.println(Arrays.toString(values));
    }

    static void ex3 (int[] first, int[] second) {
        int[] result = new int[first.length+second.length];
        int minLength = Math.min(first.length, second.length);
        int f=0,s=0;
        for(int i = 0; i < minLength*2; i++) {
            if(i % 2 == 0) {
                result[i] = first[f];
                f++;
            }
            else {
                result[i] = second[s];
                s++;
            }
        }
        if(first.length < second.length) {
            for (int i = 0; i < second.length - first.length; i++) {
                result[second.length + i] = second[second.length - first.length + i];
            }
        }
        else if(first.length > second.length) {
            for (int i = 0; i < first.length - second.length; i++) {
                result[first.length + i - 1] = first[first.length - second.length + i - 1];
            }
        }
        System.out.println(Arrays.toString(result));
    }
}