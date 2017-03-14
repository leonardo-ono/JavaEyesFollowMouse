
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author leonardo
 */
public class Eye {

    private Vec2 position;
    private double r1;
    private double r2;
    
    public Eye(double x, double y, double r1, double r2) {
        position = new Vec2(x, y);
        this.r1 = r1;
        this.r2 = r2;
    }

    public void draw(Graphics g, Vec2 mousePosition) {
        Vec2 irisPosition = mousePosition.sub(position);
        double irisDistanceFromCenter = Math.min(r1 - r2, irisPosition.getLength());
        irisPosition.normalize();
        irisPosition.multiply(irisDistanceFromCenter);
        irisPosition = irisPosition.add(position);
        
        g.setColor(Color.BLACK);
        g.fillOval((int) (position.getX() - r1 - 8), (int) (position.getY() - r1 - 8), (int) (2 * r1 + 16), (int) (2 * r1 + 16));
        
        g.setColor(Color.WHITE);
        g.fillOval((int) (position.getX() - r1), (int) (position.getY() - r1), (int) (2 * r1), (int) (2 * r1));

        g.setColor(Color.BLACK);
        g.fillOval((int) (irisPosition.getX() - r2), (int) (irisPosition.getY() - r2), (int) (2 * r2), (int) (2 * r2));
    }
    
}
