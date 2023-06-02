public class Print implements Command{
    @Override
    public void execute() {
        if (Main.svgLines != null) {//ако има поне една линия в svg файла.
            System.out.println("SVG File:");
            for (String line : Main.svgLines) {//цикъл foreach обхожда всеки ред.
                System.out.println(line);
            }
        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }
}
