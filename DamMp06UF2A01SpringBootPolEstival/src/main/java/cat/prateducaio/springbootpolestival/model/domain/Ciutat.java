package cat.prateducaio.springbootpolestival.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciutats")
public class Ciutat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NOM_CIUTAT", length = 45, unique = true, nullable = false)
	private String nom;

	@Column(name = "CODI_POSTAL", length = 5, nullable = false)
	private String codiPostal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}

}
