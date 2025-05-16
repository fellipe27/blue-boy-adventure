package object;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ObjDoor extends SuperObject {
    public ObjDoor(GamePanel gp) {
        this.name = "door";
        this.collision = true;

        try {
            this.image = ImageIO.read(Objects.requireNonNull(
                    getClass().getResourceAsStream("/objects/door.png"))
            );
            this.image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
