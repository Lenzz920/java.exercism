import java.util.Collections;
import java.util.List;

class HighScores {

    List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        return highScores.getLast();
    }

    Integer personalBest() {
         highScores.sort(Collections.reverseOrder());
         return highScores.getFirst();
    }

//    List<Integer> personalTopThree() {

//    }


}
