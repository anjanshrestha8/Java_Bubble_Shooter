package bubble_shooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 * Realises the moving arrow at the bottom of the screen.
 * @author Anjan
 *
 */
public class Arrow{

    /**
     * current location of the mouse pointer
     */
    private Point p;

    private static final int TIP_LENGTH = 20;
    private static final int LENGTH = 80;

    /**
     * Constructor for the class arrow.
     */
    public Arrow(){
        p = new Point(Constants.FIELD_SIZE_X/2,0);
    }

    /**
     * Paints the arrow on the bottom of the screen depending on
     * the location of the pointer.
     * @param g2d the graphics where the arrow should be drawn
     * @param base the location of the frame on the screen
     */
    public void paintComponent(Graphics2D g2d, Point base) {
        g2d.setColor(Color.red);
        Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
        int x = mouseLoc.x-base.x;
        int y = mouseLoc.y-base.y;
        if((0<=x) && (x<Constants.FIELD_SIZE_X) && (0<=y) && (y<Constants.FIELD_SIZE_Y)){
            p=mouseLoc;
        }
        x = p.x-base.x;
        y = p.y-base.y;
        double angle = Math.atan((double)(x-Constants.FIELD_SIZE_X/2)/(Constants.FIELD_SIZE_Y-y));
        g2d.rotate(angle,Constants.FIELD_SIZE_X/2,Constants.FIELD_SIZE_Y);
        g2d.drawLine(Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y,
                Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y-LENGTH);
        g2d.drawLine(Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y-LENGTH,
                Constants.FIELD_SIZE_X/2-TIP_LENGTH, Constants.FIELD_SIZE_Y-LENGTH+TIP_LENGTH);
        g2d.drawLine(Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y-LENGTH,
                Constants.FIELD_SIZE_X/2+TIP_LENGTH, Constants.FIELD_SIZE_Y-LENGTH+TIP_LENGTH);
        g2d.rotate(-angle,Constants.FIELD_SIZE_X/2,Constants.FIELD_SIZE_Y);
    }

}
