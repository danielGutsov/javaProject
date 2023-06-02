import java.util.*;
import java.util.List;


public class Main {
    public static int i = 0;
    public static String filePath = null;
    public static List<String> svgLines;
    public static List<String> OriginalSvgLines = null;
    public static List<String> updatedSvgLines = null;
    public static Map<Integer, String> shapeMap = new HashMap<>();
    public static String parameters;
    public static String[] commandParts;
    public static List<String> svgLines1;
    public static String shapeMapText;
    public static String newFilePath = null;
    public static String circleShapes;
    public static String squareShapes;
    public static String ellipseShapes;
    public static String shape;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a command (type 'help' for available commands): ");
            String input = scanner.nextLine();

            commandParts = input.trim().split(" ");
            String command = commandParts[0];

            switch (command) {
                case "open":
                    if (commandParts.length > 1) {
                        filePath = commandParts[1];
                        Command Open = new Open(filePath);
                        Open.execute();
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
                    Command Save = new Save(svgLines, filePath, updatedSvgLines);
                    Save.execute();
                    break;
                case "saveas":
                    if (commandParts.length == 2) {
                        String newFilePath = commandParts[1];
                        Command SaveAs = new SaveAs();
                        SaveAs.execute();
                    } else {
                        System.out.println("Please provide a file path after the 'saveas' command.");
                    }
                    break;
                case "help":
                    Command Help = new Help();
                    Help.execute();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "print":
                    Command Print = new Print();
                    Print.execute();
                    break;
                case "create":
                    if (svgLines != null) {
                        if (commandParts.length > 1) {
                            String shapeType = commandParts[1];
                            Command Create = new Create(filePath, parameters, svgLines, shapeType);
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
                        if (commandParts.length == 1) {
                            Command Erase = new Erase();
                            Erase.execute();
                        } else if (commandParts.length == 2) {
                            Command Erase = new Erase();
                            Erase.execute();
                        } else {
                            System.out.println("shape with with this number doesn't exist");
                        }
                    } else {
                        System.out.println("No SVG file is currently opened.");
                    }
                    break;
                case "within":
                    Command Within = new Within();
                    Within.execute();
            }
        }
    }
}
