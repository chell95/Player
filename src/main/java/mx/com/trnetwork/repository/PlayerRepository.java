package mx.com.trnetwork.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.trnetwork.dto.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findByTeamId(long teamId);
}
