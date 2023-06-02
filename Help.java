public class Help implements Command{
    @Override
    public void execute() {
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
}
