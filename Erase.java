import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Erase implements Command {
    @Override
    public void execute() {
        if (Main.svgLines != null) {
            if (Main.commandParts.length == 1) {
                try {
                    Main.svgLines.clear();
                    Main.svgLines1 = Main.OriginalSvgLines;
                    Main.svgLines = Main.svgLines1;
                    Files.write(Paths.get(Main.filePath), Main.svgLines);
                } catch (IOException e) {
                    System.out.println("An error occurred while errasing the shapes");
                }
            }
                else if (Main.commandParts.length == 2) {
                    try {
                        int shapeNumber = Integer.parseInt(Main.commandParts[1]);
                        Main.shapeMap.remove(shapeNumber);
                        Main.shapeMapText = Main.shapeMap.toString();

                        Main.svgLines.clear();
                        Main.svgLines = Main.OriginalSvgLines;
                        Files.write(Paths.get(Main.filePath), Main.svgLines);

                        Main.svgLines = Files.readAllLines(new File(Main.filePath).toPath());
                        int penultimateIndex = Main.svgLines.size() - 2;
                        Main.svgLines.add(penultimateIndex, Main.shapeMapText);
                        Files.write(Paths.get(Main.filePath), Main.svgLines);

                    } catch (IOException e){
                        System.out.println("error");
                    }
                } else {
                    System.out.println("shape with with this number doesn't exist");
                }
            } else {
                System.out.println("No SVG file is currently opened.");
            }
        }
    }
