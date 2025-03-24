import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import szamalk.hu.modell.Szak;
import szamalk.hu.modell.Tantargy;

import java.util.List;

class SzakTest {
    Szak szak;
    @BeforeEach
    void ini(){
        szak = new Szak("ez egy szak neve");
        Assertions.assertTrue(szak.getTargyak().size() > 0);
    }

    void testSzakTargyNevek(){
        for (Tantargy tantargy : szak) {
            Assertions.assertTrue(tantargy.getTargy_nev().length() > 3);
        }
    }

    void testGetTargyak(){
        List<Tantargy> targyak = szak.getTargyak();
        int eredeti = targyak.size();
        targyak.add(new Tantargy());
        Assertions.assertTrue(eredeti == szak.getTargyak().size());
    }
}