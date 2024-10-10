package main;

import mino.Block;
import mino.Mino;
import mino.Mino_L1;

import java.awt.*;

public class PlayManager {

    //main play area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int leftX, rightX, topY, bottomY;

    //mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    public PlayManager() {

        //main frame area frame
        leftX = (GamePanel.WIDTH/2) - (WIDTH/2);
        rightX = leftX + WIDTH;
        topY = 50;
        bottomY = topY + HEIGHT;

        MINO_START_X = leftX + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = topY + Block.SIZE;

        //set the starting mino
        currentMino = new Mino_L1();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }

    public void update() {

        currentMino.update();
    }

    public void draw(Graphics2D g2) {

        //draw play area frame
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(leftX - 4, topY - 4, WIDTH + 8, HEIGHT + 8);

        //draw next mino frame
        int x = rightX + 100;
        int y = bottomY - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont((new Font("Arial", Font.PLAIN, 30)));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y + 60);

        //draw the currentMino
        if(currentMino != null) {
            currentMino.draw(g2);
        }
    }
}
