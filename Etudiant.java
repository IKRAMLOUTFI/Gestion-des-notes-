package M;

import java.util.ArrayList;

public class Etudiant {
    private String code;
    private String nom;
    private String prenom;
    private int age;
    private String email;
    private ArrayList<Note> notes;

    public Etudiant(String code, String nom, String prenom, int age, String email) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.notes = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }
    public String getNomComplet() {
        return nom + " " + prenom;
    }
    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void ajouterNote(Note note) {
        notes.add(note);
    }

    public double calculerMoyenne() {
        if (notes.isEmpty()) return 0;
        double total = 0;
        for (Note note : notes) {
            total += note.getValeur();
        }
        return total / notes.size();
    }

    public String getMention() {
        double moyenne = calculerMoyenne();
        if (moyenne >= 18) return "Très Bien";
        else if (moyenne >= 16) return "Bien";
        else if (moyenne >= 12) return "Assez Bien";
        else if (moyenne >= 10) return "Passable";
        else return "Invalid";
    }
}
