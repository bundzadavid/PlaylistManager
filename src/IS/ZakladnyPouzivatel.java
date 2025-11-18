package IS;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ZakladnyPouzivatel extends Pouzivatel {
    protected List<Playlist> playlistyZakladnehoPouzivatela;
//vytvorenie konstruktora pre zakl pouzivatela stym že musi byt zadane meno inak vyhodi chybu
    ZakladnyPouzivatel(String meno) {
        super(meno);
        if (meno == null || meno.isEmpty()) {
            throw new IllegalArgumentException("Meno používateľa nesmie byť prázdne alebo null");
        }
        this.playlistyZakladnehoPouzivatela = new LinkedList<>();

    }
//vypis mena
    @Override
    public void VypisMeno() {
        System.out.println(this.meno);
    }
//vypise vetky playlisty zakl pouzivatela
    @Override
    public void VypisPlaylistyPouzivatela() {
        System.out.println("Zoznam playlistov pre používateľa " + this.meno + ":");
        for(Playlist playlist : playlistyZakladnehoPouzivatela) {
            System.out.println(playlist.getNazov());
        }
    }
//prida playlist zakl pouzivatelovi ktory može mat max 5 playlistov inak vyhodi chybu
    @Override
    public void pridatPlaylist(Playlist playlist) {
        if (playlistyZakladnehoPouzivatela.size() < 5) {
            playlistyZakladnehoPouzivatela.add(playlist);
            System.out.println("Playlist: "+playlist.getNazov()+ " bol úspešne pridaný.");
        }
        else {
            throw new IllegalArgumentException("Nemožno pridať ďalší playlist. Dosiahnutý limit (5) playlistov.");
        }


    }
//odstrani playlist zo zakl pouzivatela pokial nejaky playlist ma pridany
    @Override
    public void odstranPlaylist(Playlist playlist) {

        if (!playlistyZakladnehoPouzivatela.isEmpty()) {
            playlistyZakladnehoPouzivatela.remove(playlist);
            System.out.println("Playlist: " +playlist.getNazov()+ " bol úspešne odstranený.");

        }  else {
            throw new IllegalArgumentException("Zoznam playlistov je prázdny. Nie je možné odstrániť žiadny playlist.");
        }
    }

//porovnanva ci zakl pozivatel nema rovnake meno
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ZakladnyPouzivatel zakladnyPouzivatel = (ZakladnyPouzivatel) obj;
        return Objects.equals(meno, zakladnyPouzivatel.meno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meno);
    }


}