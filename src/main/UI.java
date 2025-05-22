package main;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial40, arial80B;
    public boolean messageOn = false;
    public String message = "";

    public UI(GamePanel gp) {
        this.gp = gp;
        this.arial40 = new Font("Arial", Font.PLAIN, 40);
        this.arial80B = new Font("Arial", Font.BOLD, 80);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public int getXForCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        return gp.screenWidth / 2 - length / 2;
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80f) );

        String text = "PAUSED";
        int x = getXForCenteredText(text), y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial40);
        g2.setColor(Color.WHITE);

        if (gp.gameState == gp.playState) {}
        if (gp.gameState == gp.pauseState) drawPauseScreen();
    }
}
