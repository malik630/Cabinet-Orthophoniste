package GestionCabinetOrthophonie;

import java.io.Serializable;

abstract public class QuestAnam implements Serializable{
	private String enonce;
	private String reponseLibreAnamnese;
	public QuestAnam(String enonce){
		this.enonce = enonce;
	}
	public String getEnonce() {
		return enonce;
	}
	public String getReponseLibreAnamnese() {
		return reponseLibreAnamnese;
	}
	public void setReponseLibreAnamnese(String reponseLibreAnamnese) {
		this.reponseLibreAnamnese = reponseLibreAnamnese;
	}
	
}
