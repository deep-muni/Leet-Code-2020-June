package June_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

    Set<Integer> set;
    Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return (int) set.toArray()[random.nextInt(set.size())];
    }

    public void printData(){
        System.out.println(Arrays.toString(set.toArray()));
    }
}
