package IS;

import java.util.*;

public class PremiovyPouzivatel extends Pouzivatel{

    protected List<Playlist> playlistyPremiovehoPouzivatela;
//konstruktor ktory vola meno z abstraktnej triedy a vyhadzuje chybu ak niekto nezada meno
    PremiovyPouzivatel(String meno) {
        super(meno);
        if (meno == null || meno.isEmpty()) {
            throw new IllegalArgumentException("Meno používateľa nesmie byť prázdne alebo null");
        }
        this.playlistyPremiovehoPouzivatela = new LinkedList<>();


    }
    //prepis metody na vypisanie mena
    @Override
    public void VypisMeno() {
        System.out.println(this.meno);
    }
//prepis metody na pridanie playlistu piramo prem pouzivatelovi ktory moze mat az 100 playlistov inak vyhodi chybu
    @Override
    public void pridatPlaylist(Playlist playlist) {
        if (playlistyPremiovehoPouzivatela.size() < 100) {
            playlistyPremiovehoPouzivatela.add(playlist);
            System.out.println("Playlist: " + playlist.getNazov() + " bol úspešne pridaný.");
        } else {
            throw new IllegalArgumentException("Nemožno pridať ďalší playlist. Dosiahnutý limit (100) playlistov.");
        }
    }
//vypise playlisty prem pouzivatela
    @Override
    public void VypisPlaylistyPouzivatela() {
            for(Playlist playlist : playlistyPremiovehoPouzivatela) {
                System.out.println(playlist.getNazov());}

    }

//odstrani playlist z prem pouzivatela pokial vsak pouzivatel ma nejky playlist ak nie vyhodi chybu
    @Override
    public void odstranPlaylist(Playlist playlist) {
        if (!playlistyPremiovehoPouzivatela.isEmpty()) {
            playlistyPremiovehoPouzivatela.remove(playlist);
            System.out.println("Playlist: " + playlist.getNazov() + " bol úspešne odstranený.");
        } else {
            throw new IllegalArgumentException("Zoznam playlistov je prázdny. Nie je možné odstrániť žiadny playlist.");
        }
    }
//porovnava aby nemali použivatelia rovnake uzivatelske meno
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PremiovyPouzivatel premiovyPouzivatel = (PremiovyPouzivatel) obj;
        return Objects.equals(meno, premiovyPouzivatel.meno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meno);
    }
}
