package M;

public class Vacataire extends Professeur {
    public Vacataire(String nom, int heures) {
        super(nom, heures);
    }

    public double calculerSalaire() {
        return heures * 300;
    }
}


