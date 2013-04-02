
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



public class Alusta {

    private int x;
    private int y;
    private int leveys;
    private int korkeus;
    private BufferedImage image;

    public Alusta(int x, int y, int leveys, int korkeus)  {
        this.x = x;
        this.y = y;
        this.leveys = leveys;
        this.korkeus = korkeus;
        
        try {
            this.image = ImageIO.read(new File("alusta-pohja.gif"));
        
        } catch (IOException ex) {
            Logger.getLogger(Alusta.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public BufferedImage getImage() {
        return this.image;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void liiku(int nopeus) {
        this.x -= nopeus;
    }
}
