
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krister
 */
public class Esine {

    private int x;
    private int y;
    private int korkeus;
    private int leveys;
    private esineTyypit tyyppi;
    private int pisteet;
    private BufferedImage kuva;
    private boolean elossa;

    public Esine(int x, int y) {
        this.x = x;
        this.y = y;
        this.korkeus = 30;
        this.leveys = 30;
        this.elossa = true;
        
        

    }

    public enum esineTyypit {

        tahti, kolikko, sieni
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getKorkeus() {
        return this.korkeus;
    }
    public int getLeveys() {
        return this.leveys;
    }
    public BufferedImage getKuva() {
        return this.kuva;
    }
    public boolean getElossa() {
        return this.elossa;
    }
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void setElossa(boolean arvo) {
        this.elossa = arvo;
    }

    public void setTyyppi(String tyyppi) {
        try {
            this.tyyppi = esineTyypit.valueOf(tyyppi);
            
            switch (this.tyyppi) {
                case tahti:
                    this.pisteet = 100;
                    makePicture();
                    break;
                case kolikko:
                    this.pisteet = 10;
                    makePicture();
                    break;
                case sieni:
                    this.pisteet = 50;
                    makePicture();
                    break;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Esine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void makePicture() throws IOException {
        
        switch (this.tyyppi) {
            case tahti:
                this.kuva = ImageIO.read(new File("tahti.gif"));;
                break;
            case kolikko:
                this.kuva = ImageIO.read(new File("kolikko.gif"));
                break;
            case sieni:
                this.kuva = ImageIO.read(new File("sieni.gif"));
                break;
        }
    }
    
    public void liiku(int nopeus) {
        this.x -= nopeus;
    }
    
    
}

