package main;

import object.ObjKey;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font arial40, arial80B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        this.arial40 = new Font("Arial", Font.PLAIN, 40);
        this.arial80B = new Font("Arial", Font.BOLD, 80);
        this.keyImage = new ObjKey(gp).image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        g2.setFont(arial40);
        g2.setColor(Color.WHITE);

        if (gameFinished) {
            String text;
            int textLength;

            text = "You found the treasure!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            g2.drawString(text, gp.screenWidth / 2 - textLength / 2, gp.screenHeight / 2 - gp.tileSize * 3);

            text = "Your time is: " + dFormat.format(playTime) + "!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            g2.drawString(text, gp.screenWidth / 2 - textLength / 2, gp.screenHeight / 2 + gp.tileSize * 4);

            g2.setFont(arial80B);
            g2.setColor(Color.YELLOW);

            text = "Congratulations!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            g2.drawString(text, gp.screenWidth / 2 - textLength / 2, gp.screenHeight / 2 + gp.tileSize * 2);

            gp.gameThread = null;
        } else {
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            playTime += (double) 1 / 60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65);

            if (messageOn) {
                g2.setFont(g2.getFont().deriveFont(30f));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
