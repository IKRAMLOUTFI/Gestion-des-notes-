package M;

public class Matiere {
    private String code;
    private String designation;
    private int volumeHoraire;

    public Matiere(String code, String designation, int volumeHoraire) {
        this.code = code;
        this.designation = designation;
        this.volumeHoraire = volumeHoraire;
    }

    public String getCode() {
        return code;
    }
    public String getDesignation() {
        return designation;
    }
    public int getVolumeHoraire() {
        return volumeHoraire;
    }
}


