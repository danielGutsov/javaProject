import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

public class Main {
    public static String filePath = null;//тук съхраняваме path на svg файла.
    public static List<String> svgLines = null;
    public static List<String> OriginalSvgLines = null;

    public static Map<Integer, String> shapeMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parameters = null;
        while (true) {
            System.out.print("Enter a command (type 'help' for available commands): ");
            String input = scanner.nextLine();

            String[] commandParts = input.trim().split(" ");
            String command = commandParts[0];

            switch (command) {
                case "open":
                    if (commandParts.length > 1) {
                        filePath = commandParts[1];
                        Command Open = new Open(filePath);
                        Open.execute();
                        OriginalSvgLines = svgLines;
                    } else {
                        System.out.println("Please provide a file path after the 'open' command.");
                    }
                    break;
                case "close":
                    Command Close = new Close(svgLines, shapeMap, filePath);
                    Close.execute();
                    System.out.println(shapeMap);
                    break;
                case "save":
                    saveChanges();
                    break;
                case "saveas":
                    if (commandParts.length > 1) {
                        String newFilePath = commandParts[1];
                        saveChangesAs(newFilePath);
                    } else {
                        System.out.println("Please provide a file path after the 'saveas' command.");
                    }
                    break;
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "print":
                    printSvg();
                    break;
                case "create":
                    if (svgLines != null) {
                        if (commandParts.length > 1) {
                            String shapeType = commandParts[1];
                            Command Create = new Create(filePath, parameters, commandParts, svgLines, shapeType, shapeMap);
                            Create.execute();
                        } else {
                            System.out.println("Please provide a shape type after the 'create' command.");
                        }
                    } else {
                        System.out.println("No SVG file is currently opened.");
                    }
                    break;
                case "erase":
                    if (svgLines != null) {
                        if (commandParts.length > 1) {
                            if (commandParts[1].equals("all")) {
                                //  eraseAllShape();
                            } else {
                                int shapeNumber = Integer.parseInt(commandParts[1]);
                                // eraseShape(shapeNumber);
                            }
                        } else {
                            System.out.println("Please provide a shape number after the 'erase' command.");
                        }
                    } else {
                        System.out.println("No SVG file is currently opened.");
                    }
                    break;
                case "within":
                    System.out.println(shapeMap);
                    shapeMap.remove(2);
                    System.out.println(shapeMap);
            }
        }
    }
    private static void saveChanges() {
        if (svgLines != null && filePath != null) {
            try {
                List<String> updatedSvgLines = new ArrayList<>();
                System.out.println(svgLines);
                System.out.println(updatedSvgLines);
                for (String line : svgLines) {
                    updatedSvgLines.add(line);
                }
                System.out.println(svgLines);
                System.out.println(updatedSvgLines);
                Files.write(Path.of(filePath), updatedSvgLines);
                System.out.println(svgLines);
                System.out.println(updatedSvgLines);
                System.out.println("Changes saved to the SVG file.");
            } catch (IOException e) {
                System.out.println("An error occurred while saving the SVG file: " + e.getMessage());//съобщение за грешката
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }

    private static void saveChangesAs(String newFilePath) {
        if (svgLines != null && filePath != null) {
            try {
                Files.write(Path.of(newFilePath), svgLines);//промените в svg файла се запазват в newFilePath.
                System.out.println("Changes saved to a new SVG file: " + newFilePath);
            } catch (IOException e) {
                System.out.println("An error occurred while saving the new SVG file: " + e.getMessage());
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }

    private static void printHelp() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>    opens <file>");
        System.out.println("close          closes currently opened file");
        System.out.println("save           saves the currently open file");
        System.out.println("saveas <file>  saves the currently open file in <file>");
        System.out.println("help           prints this information");
        System.out.println("exit           exits the program");
        System.out.println("print          shows the SVG file with all changes made so far");
        System.out.println("create <shape> creates a new shape (circle, square, ellipse)");
        System.out.println("erase <n>      erases the shape with number <n>");
        System.out.println("erase all      erases all shapes");
        System.out.println("within <option> shows all shapes of the given type (e.g., within circle)");
    }

    private static void printSvg() {
        if (svgLines != null) {//ако има поне една линия в svg файла.
            System.out.println("SVG File:");
            for (String line : svgLines) {//цикъл foreach обхожда всеки ред.
                System.out.println(line);
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }
    private static void eraseShape(String command) {
        if (svgLines != null) {
            if (command.equalsIgnoreCase("all")) {
                svgLines.clear();
                shapeMap.clear();
                System.out.println("All shapes erased.");
            } else {
                int shapeNumber = Integer.parseInt(command);
                String shapeType = shapeMap.get(shapeNumber);
                if (shapeType != null) {
                    int index = shapeNumber - 1;
                    svgLines.remove(index);
                    shapeMap.remove(shapeNumber);
                    System.out.println("Shape erased: " + shapeNumber);
                } else {
                    System.out.println("Invalid shape number. Please provide a valid shape number.");
                }
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }
}
