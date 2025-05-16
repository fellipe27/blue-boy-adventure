package object;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ObjBoots extends SuperObject {
    public ObjBoots(GamePanel gp) {
        this.name = "boots";

        try {
            this.image = ImageIO.read(
                    Objects.requireNonNull(getClass().getResourceAsStream("/objects/boots.png"))
            );
            this.image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
