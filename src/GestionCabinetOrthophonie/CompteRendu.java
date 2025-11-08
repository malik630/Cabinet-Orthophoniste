package GestionCabinetOrthophonie;

import java.io.Serializable;

public class CompteRendu implements Serializable{
    protected Test test;
    private String conclusion;
    public int scoreTotal (Test test) {
		return 0;

    }

    public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

}
