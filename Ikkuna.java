
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ikkuna extends JPanel {

    private Maailma maailma;
    private JLabel hahmoKuva;

    public Ikkuna(Maailma maailma) {
        this.maailma = maailma;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.GREEN);

        ArrayList<Alusta> alustat = maailma.getAlustat();
        for (Alusta alusta : alustat) {
            
            g.fillRect(alusta.getX() + 1, alusta.getY() + 1, alusta.getLeveys() - 2, alusta.getKorkeus() -2);
            g.drawImage(alusta.getImage(), alusta.getX(), alusta.getY(), alusta.getLeveys(), alusta.getKorkeus(), this);
        }
        
        g.setColor(Color.BLACK);
        
        Pelihahmo hahmo = maailma.getPelihahmo();
        this.hahmoKuva = new JLabel(hahmo.getKuva());
        hahmoKuva.setBounds(hahmo.getX(), hahmo.getY(), hahmo.getHalkaisija(), hahmo.getHalkaisija());
        
        
        g.fillOval(hahmo.getX(), hahmo.getY(), hahmo.getHalkaisija(), hahmo.getHalkaisija());
        
        ArrayList<Esine> esineet = maailma.getEsineet();
        for (Esine esine : esineet) {
            if (esine.getElossa()) {
                g.drawImage(esine.getKuva(), esine.getX(), esine.getY(), this);
            }
        }
        int style = Font.BOLD | Font.ITALIC;
        g.setColor(Color.orange);
        g.setFont(new Font("Arial",style,20));
        g.drawString(Integer.toString(hahmo.getPisteet()), 20, 20);
        
        g.drawString("X: " + maailma.getPelihahmo().getX() + " Y: " + maailma.getPelihahmo().getY(), 20, 50);
        
        
        // kutsu getToolkit().sync() varmistaa että jokainen piirtokutsu
        // hoidetaan heti
        getToolkit().sync();
    }
    
    public void setKuva() {
        this.remove(hahmoKuva);
        this.add(hahmoKuva);
    }
}
