package mx.com.trnetwork.service;

import java.util.List;

import mx.com.trnetwork.dto.Player;
import mx.com.trnetwork.dto.Team;

public interface SoccerService {
	public List<String> getAllTeamPlayers(long teamId);

	public void addPlayerToTeam(Player p, Long teamId);

	public List<Team> getTeams();
}