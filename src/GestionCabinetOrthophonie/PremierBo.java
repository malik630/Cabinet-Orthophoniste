package GestionCabinetOrthophonie;

import java.io.Serializable;

public class PremierBo extends BO implements Serializable{
	private Anamnese anamnese;

	public Anamnese getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese) {
		this.anamnese = anamnese;
	}

}
