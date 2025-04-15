package M;

public abstract class Professeur {
    protected String nom;
    protected int heures;

    public Professeur(String nom, int heures) {
        this.nom = nom;
        this.heures = heures;
    }

    public abstract double calculerSalaire();
}


