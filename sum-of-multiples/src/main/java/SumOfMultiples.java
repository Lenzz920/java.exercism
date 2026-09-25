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

        for(int factor : factors) {
            if (factor == 0) {
                continue;
            }
            for(int multiple = factor; multiple<limit; multiple += factor) {
                masterSet.add(multiple);
            }
        }

        return masterSet.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}