package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Crex extends CompteRendu implements Serializable{
  public double scoreTotal (TestExercices test) {
      if (test.getExercices().isEmpty()) {
          return 0;
      }

      int somme = 0;
      for (Exercice exercice : test.getExercices()) {
          somme += exercice.getScore();
      }
      return (double) somme / test.getExercices().size();
  }
  }

