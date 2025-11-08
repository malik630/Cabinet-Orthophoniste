package GestionCabinetOrthophonie;

import java.io.Serializable;

public class QuestAnamAdulte extends QuestAnam implements Serializable{
	private CatQuestAdulte catAdulte;
	public QuestAnamAdulte(String enonce, CatQuestAdulte catAdulte) {
		super(enonce);
		this.catAdulte = catAdulte;
	}
	public String getCategorieAdulte(){
		return catAdulte.name();
	}
}
