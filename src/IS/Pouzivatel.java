package IS;
//vytvorenie abstraktnej triedy pre rozdelenie pouzivatelov
public abstract class  Pouzivatel {
    String meno;

    public Pouzivatel(String meno){
        this.meno = meno;
    }

    public void pridatPlaylist(Playlist playlist){

    }

    public void odstranPlaylist(Playlist playlist){

    }
    public abstract void VypisMeno();

    public abstract void VypisPlaylistyPouzivatela();


}
