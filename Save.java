import java.util.List;

public class Save implements Command{
    public List<String> svgLines;
    public String filePath;
    public List<String> updatedSvgLines;

    public Save(List<String> svgLines,String filePath,List<String> updatedSvgLines){
        this.svgLines = svgLines;
        this.filePath = filePath;
        this.updatedSvgLines = updatedSvgLines;
    }
    @Override
    public void execute() {

        if (svgLines != null && filePath != null) {
            updatedSvgLines = svgLines;

        } else {
            System.out.println("No SVG file is currently opened.");
        }
    }
}

