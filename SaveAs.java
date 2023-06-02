import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveAs implements Command{
    @Override
    public void execute() {

        if (Main.svgLines != null && Main.filePath != null) {
            try {
                Files.write(Path.of(Main.newFilePath), Main.svgLines);
                System.out.println("Changes saved to a new SVG file: " + Main.newFilePath);
            } catch (IOException e) {
                System.out.println("An error occurred while saving the new SVG file: " + e.getMessage());
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }
}
