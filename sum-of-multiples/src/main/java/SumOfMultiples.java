import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class SumOfMultiples {

    public final int number;
    public final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        Set<Integer> masterSet = new TreeSet<>();
        int sumTotal = 0;
        for(int item : set) {
            int multiply = 1;
            while((item * multiply) < number) {
                masterSet.add(item * multiply);
                multiply++;
            }
        }
        for(int number : masterSet) {
            sumTotal += number;
        }
        return sumTotal;
    }

}
