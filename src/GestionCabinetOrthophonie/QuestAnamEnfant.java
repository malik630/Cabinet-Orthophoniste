package GestionCabinetOrthophonie;

import java.io.Serializable;

public class QuestAnamEnfant extends QuestAnam implements Serializable{
	private CatQuestEnfants catEnfants;
	public QuestAnamEnfant(String enonce, CatQuestEnfants catEnfants) {
		super(enonce);
		this.catEnfants = catEnfants;
	}
	public String getCategorieEnfants(){
		return catEnfants.name();
	}

}
