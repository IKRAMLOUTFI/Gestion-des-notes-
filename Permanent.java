package M;

public class Permanent extends Professeur {
    public Permanent(String nom, int heures) {
        super(nom, heures);
    }

    public double calculerSalaire() {
        return heures * 200;
    }
}


