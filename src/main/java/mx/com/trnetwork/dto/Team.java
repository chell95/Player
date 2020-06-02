package mx.com.trnetwork.dto;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
public class Team {
	@Id
	//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_Sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sequences")
//	@TableGenerator( name = "sequences", valueColumnName = "team_seq")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "team")
	@JsonIgnore
	private List<Player> players;

	public Team() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}