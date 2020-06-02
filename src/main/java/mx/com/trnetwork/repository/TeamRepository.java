package mx.com.trnetwork.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.trnetwork.dto.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	Team findByPlayers(long playerId);
}