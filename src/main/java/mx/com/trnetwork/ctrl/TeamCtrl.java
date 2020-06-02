package mx.com.trnetwork.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.trnetwork.dto.Team;
import mx.com.trnetwork.repository.TeamRepository;

@RestController
@RequestMapping("/team")
public class TeamCtrl {

	@Autowired
	TeamRepository teamRepo;

	@GetMapping
	List<Team> allTeams() {
		return (List<Team>) teamRepo.findAll();
	}

	@PostMapping
	Team crear(@RequestBody Team t) {
		return teamRepo.save(t);
	}

}
