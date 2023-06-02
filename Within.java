public class Within implements Command {
    @Override
    public void execute() {
        if (Main.svgLines != null) {
            if (Main.commandParts.length == 2) {
                Main.shape = Main.commandParts[1];
                switch (Main.shape){
                    case "circle":
                        System.out.println(Main.circleShapes);
                        break;
                    case "square":
                        System.out.println(Main.squareShapes);
                        break;
                    case "ellipse":
                        System.out.println(Main.ellipseShapes);
                        break;
                }

            } else {
                System.out.println("this shape doesn't exist");
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }
}

