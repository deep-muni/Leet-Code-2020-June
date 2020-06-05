package June_5;

import java.util.Arrays;

public class Random_Pick_Weight {

    int[] sum_arr;

    public Random_Pick_Weight(int[] w) {
        sum_arr = new int[w.length];
        int sum = 0;
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            sum_arr[i] = sum;
        }

        System.out.println("Weights Array cumulative sum: " + Arrays.toString(sum_arr));

    }

    public int pickIndex() {
        double random = sum_arr[sum_arr.length - 1] * Math.random();

        System.out.println("\nRandom number:" + random);

        for(int i = 0; i < sum_arr.length; i++){
            if(random < sum_arr[i]) {
                return i;
            }
        }

        return -1;
    }

}
