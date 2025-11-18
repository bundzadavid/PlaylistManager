package IS;

import java.util.*;

public class Programik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Playlist> playlisty = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\n--- HLAVNÉ MENU ---");
            System.out.println("1. Vytvoriť playlist");
            System.out.println("2. Zobraziť všetky playlisty");
            System.out.println("3. Vybrať playlist");
            System.out.println("0. Koniec");
            System.out.print("Vyber možnosť: ");

            int volba = Integer.parseInt(sc.nextLine());
            switch (volba) {
                case 1:
                    System.out.print("Zadaj názov playlistu: ");
                    String nazov = sc.nextLine();
                    Playlist novy = Playlist.PlaylistFactory.createPlaylist(nazov);
                    playlisty.add(novy);
                    System.out.println("Playlist \"" + nazov + "\" bol vytvorený.");
                    break;

                case 2:
                    if (playlisty.isEmpty()) {
                        System.out.println("Žiadne playlisty zatiaľ neexistujú.");
                    } else {
                        for (Playlist pl : playlisty) {
                            System.out.println("- " + pl.getNazov());
                        }
                    }
                    break;

                case 3:
                    if (playlisty.isEmpty()) {
                        System.out.println("Najprv vytvor playlist.");
                        break;
                    }
                    for (int i = 0; i < playlisty.size(); i++) {
                        System.out.println((i+1) + ". " + playlisty.get(i).getNazov());
                    }
                    int cislo = Integer.parseInt(sc.nextLine());
                    if (cislo > 0 && cislo <= playlisty.size()) {
                        otvorPodmenu(sc, playlisty.get(cislo-1));
                    }
                    break;

                case 0:
                    running = false;
                    break;
            }
        }
        sc.close();
    }

    private static void otvorPodmenu(Scanner sc, Playlist playlist) {
        boolean vPodmenu = true;
        while (vPodmenu) {
            System.out.println("\n--- PODMENU: " + playlist.getNazov() + " ---");
            System.out.println("1. Zobraziť pesničky");
            System.out.println("2. Pridať pesničku");
            System.out.println("3. Vymazať pesničku");
            System.out.println("4. Prehrať pesničku");
            System.out.println("5. Pauznúť pesničku");
            System.out.println("0. Späť");

            int volba = Integer.parseInt(sc.nextLine());
            switch (volba) {
                case 1:
                    playlist.vypisZoznamPlaylistu();
                    break;
                case 2:
                    System.out.print("Názov: ");
                    String nazov = sc.nextLine();
                    System.out.print("Spevák: ");
                    String spevak = sc.nextLine();
                    System.out.print("Trvanie: ");
                    int trvanie = Integer.parseInt(sc.nextLine());
                    System.out.print("Žáner: ");
                    String zaner = sc.nextLine();

                    Pesnicka nova = new PesnickaBuilder()
                            .setNazov(nazov)
                            .setSpevak(spevak)
                            .setTrvanie(trvanie)
                            .setZaner(zaner)
                            .koniecPesnicky();
                    try {
                        playlist.pridajPesnicku(nova);
                        System.out.println("Pesnička pridaná.");
                    } catch (PrekrocenyLimitException e) {
                        System.out.println("Playlist má maximálne 10 pesničiek!");
                    }
                    break;
                case 3:
                    System.out.print("Zadaj názov pesničky: ");
                    String removeNazov = sc.nextLine();
                    Pesnicka toRemove = playlist.najdiPesnicku(removeNazov);
                    if (toRemove != null) {
                        try {
                            playlist.odoberPesnicku(toRemove);
                            System.out.println("Pesnička odstránená.");
                        } catch (PrazdnyZoznamException e) {
                            System.out.println("Playlist je prázdny.");
                        }
                    } else {
                        System.out.println("Pesnička sa nenašla.");
                    }
                    break;
                case 4:
                    System.out.print("Zadaj názov pesničky: ");
                    String playNazov = sc.nextLine();
                    Pesnicka toPlay = playlist.najdiPesnicku(playNazov);
                    if (toPlay != null) toPlay.prehrat();
                    else System.out.println("Pesnička sa nenašla.");
                    break;
                case 5:
                    System.out.print("Zadaj názov pesničky: ");
                    String pauseNazov = sc.nextLine();
                    Pesnicka toPause = playlist.najdiPesnicku(pauseNazov);
                    if (toPause != null) toPause.pause();
                    else System.out.println("Pesnička sa nenašla.");
                    break;
                case 0:
                    vPodmenu = false;
                    break;
            }
        }
    }
}
