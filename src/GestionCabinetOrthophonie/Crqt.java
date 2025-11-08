package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Crqt extends CompteRendu implements Serializable{
	public int scoreTotal() {
        int somme = 0;
        for (Question question : ((TestQuestions) test).getQuestions()) {
            somme += question.getScore();
        }
        return somme;
    }
}
