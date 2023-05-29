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
        try {//проверява за грешки
            Main.svgLines = Files.readAllLines(Path.of(filePath));//Path е клас част от java.nio.file пакет за методи за работа с патове.
            System.out.println("SVG file opened: " + filePath);
        } catch (IOException e) {//взима грешките от try
            System.out.println("An error occurred while opening the SVG file: " + e.getMessage());
        }
    }
}
