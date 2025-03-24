package szamalk.hu.modell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Szak {

    private String nev;
    private transient UUID azonosito;
    public static List<String> tantargyak;

    public Szak(String sor) {
        String[] adatok = sor.split(";");
        String nev = adatok[0];
        String tantargyakSora = adatok[1];
        String[] tantargyak = tantargyakSora.split(";");
        this.nev = nev;
        Szak.tantargyak = new ArrayList<>();
        Szak.tantargyak.addAll(Arrays.asList(tantargyak));
        ujIdGeneralas();
        szakBeolvasasa();
    }

    public Szak(String nev, String tantargy) {
        this(nev, new ArrayList<>());
        tantargyak.add(String.valueOf(tantargy));
    }

    public Szak(String nev, List<String> tantargyak) {
        this.nev = nev;
        this.tantargyak = tantargyak;
        ujIdGeneralas();
    }


    public void ujIdGeneralas(){
        azonosito = UUID.randomUUID();
    }

    public static void szakKiirasa(){
        String fajlNev = "targyak.dat";
        tantargyak = new ArrayList<>();
        Szak szak1 = new Szak("prog alapok", "program tervező");
        Szak szak2 = new Szak("pr", "marketing");
        String tartalma = "Tantárgyak || Szak neve" + "\n" + szak1.nev + "||" + szak1.tantargyak + "\n" + szak2.nev + "||" + szak2.tantargyak;
        try {
            Files.write(Path.of(fajlNev), tartalma.getBytes());
        } catch (IOException e) {
            System.out.println("HIBA A KIÍRÁS KÖZBEN!");
        }
    }

    public static void szakBeolvasasa(){
        String fn = "targyak.dat";
        try {
            List<String> tartalom = Files.readAllLines(Path.of(fn));
            tartalom.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("HIBA A FÁJL BEOLVASÁSA KÖZBEN!" + e.getMessage());
        }
    }

   public static List<Tantargy> getTargyakNevSzerint(){
        List<Tantargy> tantargyNevek = new ArrayList<>();
        Tantargy t1 = new Tantargy("tanar1", "targy1", "igen", 4, 6);
        Tantargy t2 = new Tantargy("tanar2", "targy2", "nem", 20, 3);
        Tantargy t3 = new Tantargy("tanar3", "targy3", "igen", 10, 1);
        tantargyNevek.add(t1);
        tantargyNevek.add(t2);
        tantargyNevek.add(t3);
        tantargyNevek.sort(Tantargy.rendezNev());
        return getTargyakNevSzerint();
   }

   private List<Tantargy> getTargyakKreditSzerint(){
        return null;
   }

    public UUID getAzonosito() {
        return azonosito;
    }

    public String getNev() {
        return nev;
    }

    public static List<String> getTantargyak() {
        return tantargyak;
    }

    void statisztika(){
        String fajlNev = "statisztika.txt";
    }

    @Override
    public String toString() {
        return "Szak{" +
                "nev='" + nev + '\'' +
                ", azonosito=" + azonosito +
                ", tantargyak=" + tantargyak +
                '}';
    }

    public Collection<Object> getTargyak() {
        return getTargyak();
    }
}
