package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class Anamnese implements Serializable{
    private Set<Question> questions; // On utilisera HashSet.

    // Constructeur initialisation l'ensemble des questions :
	public Anamnese(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	// Intialiser l'ensemble des questions :
	public void setQuestions(Set<Question> questions) {
		this.questions.clear();
		this.questions.addAll(questions);
	}


}
