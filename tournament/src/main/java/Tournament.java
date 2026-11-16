import java.util.*;

class Tournament {
  private final Map<String, Team> teams = new HashMap<>();
  private final int WIN_POINTS = 3;
  private final int DRAW_POINTS = 1;

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
    teams.computeIfAbsent(team, Team::new);
  }

  private void registerWin(Team firstTeam, Team secondTeam) {
    firstTeam.points += WIN_POINTS;
    firstTeam.wins++;
    secondTeam.losses++;
  }

  private void registerDraw(Team firstTeam, Team secondTeam) {
    firstTeam.points += DRAW_POINTS;
    secondTeam.points += DRAW_POINTS;
    firstTeam.draws++;
    secondTeam.draws++;
  }

  private void fillStats(String outcome, Team firstTeam, Team secondTeam) {
    firstTeam.matchesPlayed++;
    secondTeam.matchesPlayed++;

    if (outcome.equals("win")) {
      registerWin(firstTeam, secondTeam);
    } else if (outcome.equals("draw")) {
      registerDraw(firstTeam, secondTeam);
    } else {
      registerWin(secondTeam, firstTeam);
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

  public int compareTo(Team otherTeam) {
    int byPoints = Integer.compare(otherTeam.points, this.points);
    if (byPoints != 0) {
      return byPoints;
    }
    return this.teamName.compareTo(otherTeam.teamName);
  }

  @Override
  public String toString() {
    return "%-30s | %2d | %2d | %2d | %2d | %2d\n"
        .formatted(teamName, matchesPlayed, wins, draws, losses, points);
  }
}
