import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return (!myCollection.containsAll(theirCollection) && !theirCollection.containsAll(myCollection));
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCardsSet = new HashSet<>(collections.getFirst());
        for(Set<String> collection : collections) {
            commonCardsSet.retainAll(collection);
        }
        return commonCardsSet;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCardsSet = new HashSet<>(collections.getFirst());
        for(Set<String> collection : collections) {
            allCardsSet.addAll(collection);
        }
        return allCardsSet;
    }
}