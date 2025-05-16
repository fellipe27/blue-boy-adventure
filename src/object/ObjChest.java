package object;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ObjChest extends SuperObject {
    public ObjChest(GamePanel gp) {
        this.name = "chest";
        this.collision = true;

        try {
            this.image = ImageIO.read(
                    Objects.requireNonNull(getClass().getResourceAsStream("/objects/chest.png"))
            );
            this.image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
