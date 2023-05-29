import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Create implements Command {
    public Map shapeMap = new HashMap<>();
    public String filePath;
    public String parameters;
    public String[]commandParts;
    public List <String> svgLines;
    public String shapeType;
    public int i = 0;
    public Create(String filePath,String parameters,String[]commandParts,List <String> svgLines,String shapeType,Map shapeMap){
        this.filePath = filePath;
        this.parameters = parameters;
        this.commandParts = commandParts;
        this.svgLines = svgLines;
        this.shapeType = shapeType;
        this.shapeMap = shapeMap;

    }
    @Override
    public void execute() {
        i++;
        if (svgLines != null) {
            if (shapeType.equalsIgnoreCase("circle")) {
                int x = Integer.parseInt(commandParts[2]);
                int y = Integer.parseInt(commandParts[3]);
                int r = Integer.parseInt(commandParts[4]);
                String color = commandParts[5];
                parameters = String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\"/>",x,y,r,color);
                try {
                    svgLines = Files.readAllLines(new File(filePath).toPath());
                    int penultimateIndex = svgLines.size() - 2;//add
                    svgLines.add(penultimateIndex,parameters);
                    Files.write(Paths.get(filePath), svgLines);
                    System.out.println("Parameters added to SVG file successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while modifying the SVG file: " + e.getMessage());
                }
                System.out.println("Circle shape created.");
            } else if (shapeType.equalsIgnoreCase("square")) {
                int x = Integer.parseInt(commandParts[2]);
                int y = Integer.parseInt(commandParts[3]);
                int width = Integer.parseInt(commandParts[4]);
                int height = Integer.parseInt(commandParts[5]);
                String color = commandParts[6];
                parameters = String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\"/>", x, y, width, height, color);
                try {
                    svgLines = Files.readAllLines(new File(filePath).toPath());
                    int penultimateIndex = svgLines.size() - 2;
                    svgLines.add(penultimateIndex,parameters);
                    Files.write(Paths.get(filePath), svgLines);
                    System.out.println("Parameters added to SVG file successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while modifying the SVG file: " + e.getMessage());
                }
                System.out.println("Square shape created.");
            } else if (shapeType.equalsIgnoreCase("ellipse")) {
                int x = Integer.parseInt(commandParts[2]);
                int y = Integer.parseInt(commandParts[3]);
                int width = Integer.parseInt(commandParts[4]);
                int height = Integer.parseInt(commandParts[5]);
                String color = commandParts[6];
                parameters = String.format("<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" fill=\"%s\" />", x, y, width, height, color);
                try {
                    svgLines = Files.readAllLines(new File(filePath).toPath());
                    int penultimateIndex = svgLines.size() - 2;
                    svgLines.add(penultimateIndex,parameters);
                    Files.write(Paths.get(filePath), svgLines);
                    System.out.println("Parameters added to SVG file successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while modifying the SVG file: " + e.getMessage());
                }
                System.out.println("Ellipse shape created.");
            } else {
                System.out.println("Invalid shape type. Available shapes: circle, square, ellipse.");
            }
            //shapeMap.put(i,parameters);
        }
    }
}
