package ex4;

public class Dictionnaire extends Document {
    private String langue;

    public Dictionnaire(String titre, String langue) {
        super(titre);
        this.langue = langue;
    }

    public String getLangue() {
        return langue;
    }

    @Override
    public String toString() {
        return "Dictionnaire [numEnreg=" + getNumEnreg()
                + ", titre=" + getTitre()
                + ", langue=" + langue + "]";
    }
}