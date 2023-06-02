import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Open implements Command{
    public String filePath;

    public Open(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void execute() {
        try {
            Main.svgLines = Files.readAllLines(Path.of(filePath));
            Main.OriginalSvgLines = Files.readAllLines(Path.of(filePath));
            System.out.println("SVG file opened: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while opening the SVG file: " + e.getMessage());
        }
    }
}
