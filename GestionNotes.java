package M;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionNotes {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Etudiant> etudiants = new ArrayList<>();
    static ArrayList<Matiere> matieres = new ArrayList<>();

    public static void main(String[] args) {
        int choix;
        do {
            System.out.println("\n *** Gestion des Notes ***");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Ajouter une matière");
            System.out.println("3. Ajouter une note à un étudiant");
            System.out.println("4. Afficher les notes d’un étudiant");
            System.out.println("5. Afficher moyenne et mention d’un étudiant");
            System.out.println("6. Calculer le salaire d’un enseignant");
            System.out.println("0. Quitter");
            System.out.print("Choissizez votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Clear

            switch (choix) {
                case 1 -> ajouterEtudiant();
                case 2 -> ajouterMatiere();
                case 3 -> ajouterNoteEtudiant();
                case 4 -> afficherNotesEtudiant();
                case 5 -> afficherMoyenneEtMention();
                case 6 -> calculerSalaireProfesseur();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    static void ajouterEtudiant() {
        System.out.print("Code : ");
        String code = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();

        etudiants.add(new Etudiant(code, nom, prenom, age, email));
        System.out.println("Étudiant ajouté.");
    }

    static void ajouterMatiere() {
        System.out.print("Code : ");
        String code = scanner.nextLine();
        System.out.print("Désignation : ");
        String designation = scanner.nextLine();
        System.out.print("Volume horaire : ");
        int vh = scanner.nextInt();
        scanner.nextLine();

        matieres.add(new Matiere(code, designation, vh));
        System.out.println("Matière ajoutée.");
    }

    static Etudiant chercherEtudiant(String code) {
        for (Etudiant e : etudiants) {
            if (e.getCode().equals(code)) return e;
        }
        return null;
    }

    static Matiere chercherMatiere(String code) {
        for (Matiere m : matieres) {
            if (m.getCode().equals(code)) return m;
        }
        return null;
    }

    static void ajouterNoteEtudiant() {
        System.out.print("Code étudiant : ");
        String codeEtudiant = scanner.nextLine();
        Etudiant etu = chercherEtudiant(codeEtudiant);
        if (etu == null) {
            System.out.println("Invalid name !");
        }

        System.out.print("Code matière : ");
        String codeMatiere = scanner.nextLine();
        Matiere mat = chercherMatiere(codeMatiere);
        if (mat == null) {
            System.out.println("Invalid course !");
        }

        System.out.print("Note : ");
        double valeur = scanner.nextDouble();
        scanner.nextLine();

        etu.ajouterNote(new Note(mat, valeur));
        System.out.println("Note added successfully !");
    }

    static void afficherNotesEtudiant() {
        System.out.print("Code étudiant : ");
        String code = scanner.nextLine();
        Etudiant etu = chercherEtudiant(code);
        if (etu != null) {
            System.out.println("Notes de " + etu.getNomComplet() + " :");
            for (Note n : etu.getNotes()) {
                System.out.println(n.getMatiere().getDesignation() + " : " + n.getValeur());
            }
        } else {
            System.out.println("Invalid student ! ");
        }
    }

    static void afficherMoyenneEtMention() {
        System.out.print("Code student : ");
        String code = scanner.nextLine();
        Etudiant etu = chercherEtudiant(code);
        if (etu != null) {
            double moy = etu.calculerMoyenne();
            System.out.println("Moyenne : " + moy);
            System.out.println("Mention : " + etu.getMention());
        } else {
            System.out.println("Invalid student !");
        }
    }

    static void calculerSalaireProfesseur() {
        System.out.print("Prof name : ");
        String nom = scanner.nextLine();
        System.out.print(" # hours : ");
        int heures = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type (permanent/vacataire) : ");
        String type = scanner.nextLine().toLowerCase();

        Professeur prof;
        if (type.equals("permanent")) {
            prof = new Permanent(nom, heures);
        } else if (type.equals("vacataire")) {
            prof = new Vacataire(nom, heures);
        } else {
            System.out.println("Type invalide.");
            return;
        }

        System.out.println("Salaire de " + nom + " : " + prof.calculerSalaire() + " Dhs");
    }
}


