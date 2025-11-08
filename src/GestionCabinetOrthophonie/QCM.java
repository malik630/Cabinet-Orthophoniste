package GestionCabinetOrthophonie;

import java.io.Serializable;

public class QCM extends Question implements Serializable{
  private static int nbRep;

public static int getNbRep() {
	return nbRep;
}

public static void setNbRep(int nbRep) {
	QCM.nbRep = nbRep;
}
}
