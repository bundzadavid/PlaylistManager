package IS;

import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private int id;                // ID z databázy
    private String nazov;
    private List<Pesnicka> pesnicky;

    private Playlist(String nazov) {
        this.nazov = nazov;
        this.pesnicky = new LinkedList<>();
    }

    public String getNazov() { return nazov; }

    public void pridajPesnicku(Pesnicka pesnicka) throws PrekrocenyLimitException {
        if (pesnicky.size() >= 10) {
            throw new PrekrocenyLimitException();
        }
        pesnicky.add(pesnicka);
    }

    public void odoberPesnicku(Pesnicka pesnicka) throws PrazdnyZoznamException {
        if (pesnicky.isEmpty()) {
            throw new PrazdnyZoznamException();
        }
        pesnicky.remove(pesnicka);
    }

    public void vypisZoznamPlaylistu() {
        System.out.println("\n| Zoznam playlistu: " + nazov + " |");
        if (pesnicky.isEmpty()) {
            System.out.println("| (playlist je prázdny) |");
        } else {
            for (Pesnicka p : pesnicky) {
                System.out.println("| " + p.getNazov() + " - " + p.getSpevak() +
                                   " (" + p.getTrvanie() + "s, " + p.getZaner() + ") |");
            }
        }
    }

    public Pesnicka najdiPesnicku(String nazovPesnicky) {
        for (Pesnicka p : pesnicky) {
            if (p.getNazov().equalsIgnoreCase(nazovPesnicky)) {
                return p;
            }
        }
        return null;
    }

    public static class PlaylistFactory {
        public static Playlist createPlaylist(String nazov) {
            return new Playlist(nazov);
        }
    }

    // --- ID pre databázu ---
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Pesnicka> getPesnicky() {
    return pesnicky;
}

public boolean isEmpty() {
    return pesnicky.isEmpty();
}

}
