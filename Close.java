import java.util.List;
import java.util.Map;

public class Close implements Command{
    public List <String> svgLines;
    public Map<Integer, String> shapeMap;
    public String filePath;
    public Close(List <String> svgLines, Map<Integer, String> shapeMap,String filePath){
        this.svgLines = svgLines;
        this.shapeMap = shapeMap;
        this.filePath = filePath;
    }
    @Override
    public void execute() {
        svgLines = null;
        shapeMap.clear();
        filePath = null;
        System.out.println("SVG file closed.");
    }
}
