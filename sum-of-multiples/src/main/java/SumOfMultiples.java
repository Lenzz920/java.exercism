import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    private final int limit;
    private final int[] factors;

    SumOfMultiples(int limit, int[] factors) {
        this.limit = limit;
        this.factors = factors;
    }

    int getSum() {
        Set<Integer> masterSet = new HashSet<>();
        int sumTotal = 0;
        for (int item : factors) {
            int multiply = 1;
            if (item == 0) {
                continue;
            }
            while ((item * multiply) < limit) {
                masterSet.add(item * multiply);
                multiply++;
            }
        }
        for (int number : masterSet) {
            sumTotal += number;
        }
        return sumTotal;
    }
}