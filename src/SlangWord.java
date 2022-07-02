import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SlangWord {
    private HashMap<String, String> map;
    private final Stack<String> historyStack;

    public SlangWord() {
        this.map = new HashMap<>();
        this.historyStack = new Stack();
        if (!ReadSlangwordFile()) {
            ReadSlangwordFile();
        }
    }

    public HashMap<String, String> getMap(){
        return this.map;
    }
    public boolean ReadSlangwordFile() {
        map = new HashMap<>();
        try {
            File file = new File("slang.txt");
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] arrayOfString = data.split("`", 2);
                    if (arrayOfString.length < 2) {
                        continue;
                    }
                    map.put(arrayOfString[0].trim(), arrayOfString[1].trim());
                }
//                System.out.println(map);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
