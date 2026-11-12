import java.util.*;

class Tournament {
  Map<String, Team> teams = new HashMap<>();

  String printTable() {
    List<Team> teamList = new ArrayList<>(teams.values());
    Collections.sort(teamList);

    String header = "Team                           | MP |  W |  D |  L |  P\n";

    StringBuilder table = new StringBuilder(header);
    for (Team team : teamList) {
      table.append(team);
    }

    return table.toString();
  }

  void applyResults(String resultString) {
    String[] rows = resultString.split("\n");

    for (String row : rows) {
      if (row.isEmpty()) {
        continue;
      }
      String[] parts = row.split(";");
      addTeamToMap(parts[0]);
      addTeamToMap(parts[1]);
      fillStats(parts[2], teams.get(parts[0]), teams.get(parts[1]));
    }
  }

  private void addTeamToMap(String team) {
    if (!teams.containsKey(team)) {
      teams.put(team, new Team(team));
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

  public int compareTo(Team other) {
    int byPoints = Integer.compare(other.points, this.points);
    if (byPoints != 0) {
      return byPoints;
    }
    return this.teamName.compareTo(other.teamName);
  }

  @Override
  public String toString() {
    return "%-30s | %2d | %2d | %2d | %2d | %2d\n"
        .formatted(teamName, matchesPlayed, wins, draws, losses, points);
  }
}
