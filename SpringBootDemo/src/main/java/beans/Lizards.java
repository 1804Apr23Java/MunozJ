package beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LIZARDS")
public class Lizards implements Serializable {

	
	public Lizards (int id, String color, String habitat) {
		super();
		this.id = id;
		this.color = color;
		this.habitat = habitat;
		
	}
	
	public Lizards(String color, String habitat) {
		super();
		this.color = color;
		this.habitat = habitat;
		
	}

	public Lizards() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897553647260794654L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1,name="flashcardSequence",sequenceName="SQ_FLASHCARD_PK")
	@Column(name="FLASHCARD_ID")
	private int id;
	
	@Column(name="QUESTION")
	private String color;
	
	@Column(name="ANSWER")
	private String habitat;
	
//	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
//	@JoinColumn(name="CATEGORY_ID")
//	private String habitat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return color;
	}

	public void setCuestion(String color) {
		this.color = color;
	}

//	public String getHabitat() {
//		return habitat;
//	}

	public void setAnswer(String habitat) {
		this.habitat = habitat;
	}
	
	public String getHabitat() {
		return this.habitat;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + color + ", answer=" + habitat + "]";
	}


}