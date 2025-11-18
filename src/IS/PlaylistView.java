package IS;
//MVC VIEW
public class PlaylistView {
    //vytvorenie view pre controller
    public void vypisPlaylistPridat(Playlist playlist) {
        System.out.println("do playlistu "+ playlist.getNazov() + "ste uspešne pridali pesničku ");

    }
    public void vypisPlaylistOdobrat(Playlist playlist) {
        System.out.println("z playlistu" + playlist.getNazov() +"ste odobrali pesnicku ");

    }

}