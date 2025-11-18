package IS;

import java.util.Objects;

public class Pesnicka implements PesnickaRozhranie {
    private String nazov;
    private String spevak;
    private int trvanie;
    private String zaner;
    private boolean stav;

    // Konštruktor používaný builderom
    public Pesnicka(String nazov, String spevak, int trvanie, String zaner) {
        this.nazov = nazov;
        this.spevak = spevak;
        this.trvanie = trvanie;
        this.zaner = zaner;
    }

    // Gettery
    public String getNazov() { return nazov; }
    public String getSpevak() { return spevak; }
    public int getTrvanie() { return trvanie; }
    public String getZaner() { return zaner; }

    // Prehratie pesničky
    @Override
    public void prehrat() {
        stav = true;
        System.out.println("Pesnička " + nazov + " od " + spevak + " sa prehráva.");
    }

    // Pauznutie pesničky
    @Override
    public void pause() {
        if (stav) {
            stav = false;
            System.out.println("Pesnička " + nazov + " je pauznutá.");
        } else {
            System.out.println("Pesnička nebola spustená.");
        }
    }

    // Porovnanie pesničiek podľa názvu a speváka
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pesnicka)) return false;
        Pesnicka other = (Pesnicka) obj;
        return Objects.equals(nazov, other.nazov) &&
               Objects.equals(spevak, other.spevak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazov, spevak);
    }
}
