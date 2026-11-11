import java.util.HashMap;
import java.util.Map;

class Tournament {
  Map<String, Team> teams = new HashMap<>();

  String printTable() {
    throw new UnsupportedOperationException("Please implement the Tournament.printTable() method.");
  }

  void applyResults(String resultString) {
    String[] rows = resultString.split("\n");

    for (String row : rows) {
      if(row.isEmpty()) {
        continue;
      }
      String[] parts = row.split(";");
      if (!teams.containsKey(parts[0])) {
        teams.put(parts[0], new Team(parts[0]));
      }
      if (!teams.containsKey(parts[1])) {
        teams.put(parts[1], new Team(parts[1]));
      }
      fillStats(parts[2], teams.get(parts[0]), teams.get(parts[1]));
    }
  }

  private void fillStats(String outcome, Team firstTeam, Team secondTeam) {
    firstTeam.matchesPlayed++;
    secondTeam.matchesPlayed++;

    if (outcome.equals("win")) {
      firstTeam.points += 3;
      firstTeam.wins++;
      secondTeam.losses++;
    } else if (outcome.equals("draw")) {
      firstTeam.points += 1;
      secondTeam.points += 1;
      firstTeam.draws++;
      secondTeam.draws++;
    } else {
      secondTeam.points += 3;
      firstTeam.losses++;
      secondTeam.wins++;
    }
  }
}

class Team implements Comparable<Team> {
  final String teamName;
  int matchesPlayed;
  int wins;
  int draws;
  int losses;
  int points;

  public Team(String teamName) {
    this.teamName = teamName;
  }

  public int compareTo(Team t1) {
    return Integer.compare(t1.points, this.points);
  }

  @Override
  public String toString() {
    return teamName
        + " | "
        + matchesPlayed
        + " | "
        + wins
        + " | "
        + draws
        + " | "
        + losses
        + " | "
        + points;
  }
}
