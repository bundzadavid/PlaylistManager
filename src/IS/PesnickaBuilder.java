package IS;

// Použitie návrhového vzoru Builder
public class PesnickaBuilder {
    private String nazov;
    private String spevak;
    private int trvanie;
    private String zaner;

    // nastavenie názvu
    public PesnickaBuilder setNazov(String nazov) {
        this.nazov = nazov;
        return this;
    }

    // nastavenie speváka
    public PesnickaBuilder setSpevak(String spevak) {
        this.spevak = spevak;
        return this;
    }

    // nastavenie trvania
    public PesnickaBuilder setTrvanie(int trvanie) {
        this.trvanie = trvanie;
        return this;
    }

    // nastavenie žánru
    public PesnickaBuilder setZaner(String zaner) {
        this.zaner = zaner;
        return this;
    }

    // vytvorenie finálnej pesničky
    public Pesnicka koniecPesnicky() {
        return new Pesnicka(nazov, spevak, trvanie, zaner);
    }
}
