package mx.com.trnetwork.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.trnetwork.dto.Player;
import mx.com.trnetwork.dto.Team;
import mx.com.trnetwork.repository.PlayerRepository;
import mx.com.trnetwork.repository.TeamRepository;

@Service
public class SoccerServiceImpl implements SoccerService {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public List<String> getAllTeamPlayers(long teamId) {
		List<String> result = new ArrayList<String>();
		List<Player> players = playerRepository.findByTeamId(teamId);
		for (Player player : players) {
			result.add(player.getName());
		}
		return result;
	}

	@Override
	public void addPlayerToTeam(Player newPlayer, Long teamId) {
		System.out.println(newPlayer);
		Optional<Team> barcelona = teamRepository.findById(teamId);
		newPlayer.setTeam(barcelona.get());
		playerRepository.save(newPlayer);

	}

	@Override
	public List<Team> getTeams() {
		List<Team> teams = (List<Team>) teamRepository.findAll();
		return teams;
	}

}
