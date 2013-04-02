
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Maailma pelimaailma = new Maailma();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pelimaailma);
        Pelimoottori moottori = new Pelimoottori(kayttoliittyma, pelimaailma);

        SwingUtilities.invokeLater(kayttoliittyma);

        moottori.start();
    }
}
