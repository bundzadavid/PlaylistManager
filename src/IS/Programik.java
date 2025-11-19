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
            System.out.println("2. Vybrať playlist");
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
                        System.out.println("Najprv vytvor playlist.");
                        break;
                    }

                    System.out.println("\n--- Zoznam playlistov ---");
                    for (int i = 0; i < playlisty.size(); i++) {
                        System.out.println((i + 1) + ". " + playlisty.get(i).getNazov());
                    }

                    System.out.print("Vyber playlist: ");
                    int cislo = Integer.parseInt(sc.nextLine());

                    if (cislo > 0 && cislo <= playlisty.size()) {
                        otvorPodmenu(sc, playlisty.get(cislo - 1));
                    } else {
                        System.out.println("Neplatná voľba.");
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Neplatná voľba.");
            }
        }

        sc.close();
    }

    private static void otvorPodmenu(Scanner sc, Playlist playlist) {
        boolean vPodmenu = true;

        while (vPodmenu) {
            System.out.println("\n--- PODMENU: " + playlist.getNazov() + " ---");
            System.out.println("1. Pridať pesničku");
            System.out.println("2. Vybrať pesničku");
            System.out.println("0. Späť");

            int volba = Integer.parseInt(sc.nextLine());

            switch (volba) {
                case 1:
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

                case 2:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist je prázdny.");
                        break;
                    }

                    System.out.println("\n--- Pesničky v playliste ---");
                    List<Pesnicka> zoznam = playlist.getPesnicky();

                    for (int i = 0; i < zoznam.size(); i++) {
                        System.out.println((i + 1) + ". " + zoznam.get(i).getNazov());
                    }

                    System.out.print("Vyber pesničku: ");
                    int index = Integer.parseInt(sc.nextLine());

                    if (index > 0 && index <= zoznam.size()) {
                        prehravac(sc, playlist, index - 1);
                    } else {
                        System.out.println("Neplatná voľba.");
                    }
                    break;

                case 0:
                    vPodmenu = false;
                    break;

                default:
                    System.out.println("Neplatná voľba.");
            }
        }
    }

    private static void prehravac(Scanner sc, Playlist playlist, int index) {
        List<Pesnicka> zoznam = playlist.getPesnicky();
        boolean playing = true;
        boolean isPaused = false;

        while (playing) {
            Pesnicka aktualna = zoznam.get(index);

            if (isPaused) {
                System.out.println("\n⏸ Pesnička je pauznutá: " + aktualna.getNazov());
            } else {
                System.out.println("\n▶ Prehráva sa: " + aktualna.getNazov());
                aktualna.prehrat();
            }

            System.out.println("1. Ďalšia pesnička");
            System.out.println("2. Pauza");
            System.out.println("3. Pokračovať");
            System.out.println("0. Späť");

            int volba = Integer.parseInt(sc.nextLine());

            switch (volba) {
                case 1:
                    index = (index + 1) % zoznam.size();
                    isPaused = false;
                    break;

                case 2:
                    aktualna.pause();
                    isPaused = true;
                    break;

                case 3:
                    aktualna.prehrat();
                    isPaused = false;
                    break;

                case 0:
                    playing = false;
                    break;

                default:
                    System.out.println("Neplatná voľba.");
            }
        }
    }
}
