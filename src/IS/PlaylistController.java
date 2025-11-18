package IS;
//MVC Controller
public class PlaylistController {
    final private Playlist model;
    final private PlaylistView view;
//konstruktor pre kontrolu playlistu
    public PlaylistController(Playlist model, PlaylistView view) {
        this.model = model;
        this.view = view;
    }
//pridanie pesnicky s vypisanim do akeho playlistu
    public void addSongToPlaylist(Pesnicka pesnicka) throws PrekrocenyLimitException {
        model.pridajPesnicku(pesnicka);
        view.vypisPlaylistPridat(model);
    }
//odobranie pesnicky s vypisanim z akeho playlistu
    public void removeSongFromPlaylist(Pesnicka pesnicka) throws  PrazdnyZoznamException{
        model.odoberPesnicku(pesnicka);
        view.vypisPlaylistOdobrat(model);
    }
}