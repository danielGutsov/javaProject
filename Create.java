import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Create implements Command {
    public String filePath;
    public String parameters;
    public List <String> svgLines;
    public String shapeType;
    public Create(String filePath,String parameters,List <String> svgLines,String shapeType){
        this.filePath = filePath;
        this.parameters = parameters;
        this.svgLines = svgLines;
        this.shapeType = shapeType;
    }
    @Override
    public void execute() {
        Main.i++;
        if (svgLines != null) {
                if (shapeType.equalsIgnoreCase("circle")) {
                    int x = Integer.parseInt(Main.commandParts[2]);
                    int y = Integer.parseInt(Main.commandParts[3]);
                    int r = Integer.parseInt(Main.commandParts[4]);
                    String color = Main.commandParts[5];
                    parameters = String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\"/>", x, y, r, color);
                    Main.shapeMapText = Main.shapeMapText + parameters;
                    Main.circleShapes = Main.circleShapes + parameters;
                    try {
                        svgLines = Files.readAllLines(new File(filePath).toPath());
                        int penultimateIndex = svgLines.size() - 2;
                        svgLines.add(penultimateIndex, parameters);
                        Files.write(Paths.get(filePath), svgLines);
                        System.out.println("Parameters added to SVG file successfully.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while modifying the SVG file: " + e.getMessage());
                    }
                    System.out.println("Circle shape created.");
                } else if (shapeType.equalsIgnoreCase("square")) {
                    int x = Integer.parseInt(Main.commandParts[2]);
                    int y = Integer.parseInt(Main.commandParts[3]);
                    int width = Integer.parseInt(Main.commandParts[4]);
                    int height = Integer.parseInt(Main.commandParts[5]);
                    String color = Main.commandParts[6];
                    parameters = String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\"/>", x, y, width, height, color);
                    Main.shapeMapText = Main.shapeMapText + parameters;
                    Main.squareShapes = Main.squareShapes + parameters;
                    try {
                        svgLines = Files.readAllLines(new File(filePath).toPath());
                        int penultimateIndex = svgLines.size() - 2;
                        svgLines.add(penultimateIndex, parameters);
                        Files.write(Paths.get(filePath), svgLines);
                        System.out.println("Parameters added to SVG file successfully.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while modifying the SVG file: " + e.getMessage());
                    }
                    System.out.println("Square shape created.");
                } else if (shapeType.equalsIgnoreCase("ellipse")) {
                    int x = Integer.parseInt(Main.commandParts[2]);
                    int y = Integer.parseInt(Main.commandParts[3]);
                    int width = Integer.parseInt(Main.commandParts[4]);
                    int height = Integer.parseInt(Main.commandParts[5]);
                    String color = Main.commandParts[6];
                    parameters = String.format("<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" fill=\"%s\" />", x, y, width, height, color);
                    Main.shapeMapText = Main.shapeMapText + parameters;
                    Main.ellipseShapes = Main.ellipseShapes + parameters;
                    try {
                        svgLines = Files.readAllLines(new File(filePath).toPath());
                        int penultimateIndex = svgLines.size() - 2;
                        svgLines.add(penultimateIndex, parameters);
                        Files.write(Paths.get(filePath), svgLines);
                        System.out.println("Parameters added to SVG file successfully.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while modifying the SVG file: " + e.getMessage());
                    }
                    System.out.println("Ellipse shape created.");
                } else {
                    System.out.println("Invalid shape type. Available shapes: circle, square, ellipse.");
                }
            }
        Main.shapeMap.put(Main.i, parameters);
        }
}
