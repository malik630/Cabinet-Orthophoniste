package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestQuestions extends Test implements Serializable {
	private Set<Question> questions; // on utilisera HashSet

	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public void supprimerQuestion(Question question) {
       if ( this.questions.contains(question)) {
    	   questions.remove(question);
       }

	}
	public void ajouterQuestion(Question question) {

	    	   questions.add(question);
	       }
	public void creerListeQuestions(){
		   this.questions = new HashSet();

	}


}
