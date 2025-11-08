package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Question implements Serializable {

	private String enonce;
	private transient Set<String> listeReponse; // On utilisera HashSet
    private int score;
    public Question() {
        this.listeReponse = new HashSet<String>();
    }
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Set<String> getListeReponse() {
		return listeReponse;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public void setListeReponse(Set<String> listeReponse) {
		this.listeReponse = listeReponse;
	}
	public void ajouterReponse(String elem) {

 	   listeReponse.add(elem);
    }
	public String getEnonce() {
		return enonce;
	}

	public int hashCode() {
		return Objects.hash(enonce);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(enonce, other.enonce);
	}
	@Override
	public String toString() {
		return "Question [enonce=" + enonce + ", listeReponse=" + listeReponse + ", score=" + score + "]";
	}

}
