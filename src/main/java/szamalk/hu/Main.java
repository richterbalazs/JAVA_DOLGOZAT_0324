package szamalk.hu;

import szamalk.hu.modell.Szak;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static List<Szak> szakok = new ArrayList<>();

    public static void main(String[] args) {
            Szak.szakKiirasa();
            Szak.szakBeolvasasa();
        }
    }