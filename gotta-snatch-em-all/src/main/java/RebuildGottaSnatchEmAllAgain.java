import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RebuildGottaSnatchEmAllAgain {
    Set<String> collection = new HashSet<>();
    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    RebuildGottaSnatchEmAllAgain(Set<String> collection) {
        this.collection = Set.copyOf(collection);
    }

    public static Set<String> cards(List<String> cardList) {
        return new HashSet<>(cardList);
    }

    public static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    public static boolean canTrade(Set<String> myCollection, Set<String> otherCollection) {
        return (!myCollection.containsAll(otherCollection) && !otherCollection.containsAll(myCollection));
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        return collections.stream()
                .reduce((first, next) -> {
                    Set<String> common = new HashSet<>(first);
                    common.retainAll(next);
                    return common;
                })
                .orElse(new HashSet<>());
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }


}
