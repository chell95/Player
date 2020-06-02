package mx.com.trnetwork.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.trnetwork.dto.Player;
import mx.com.trnetwork.repository.PlayerRepository;
import mx.com.trnetwork.service.SoccerService;

@RestController
@RequestMapping("/player")
public class PlayerCtrl {

	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	SoccerService serv;

	@GetMapping
	List<Player> allPLayers() {
		return (List<Player>) playerRepo.findAll();
	}

	@PostMapping
	Player crear(@RequestBody Player p) {
		serv.addPlayerToTeam(p, p.getTeam().getId());
		return playerRepo.save(p);
	}

	@PutMapping
	Player actualizar(@RequestBody Player p) {
		return playerRepo.save(p);

	}

}
