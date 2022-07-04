import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SlangWord {
    private HashMap<String, String> map;
    private final Stack<String> historyStack;
    Scanner sc = new Scanner(System.in);
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
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void findBySlangword() {
        System.out.println("Nhap slag word can lay : ");
        String SlagWord = sc.nextLine();
        historyStack.push(SlagWord);

        if (map.containsKey(SlagWord)) {
            System.out.println("Slangword tim duoc la : ");
            System.out.println(map.get(SlagWord));
        } else {
            System.out.println("Khong ton tai slangword nay!");
        }
    }
    public void findByDefinition() {
        System.out.println("Nhap dinh nghia: ");
        String definition = sc.nextLine();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().toLowerCase().contains(definition.toLowerCase())) {
                System.out.println(entry.getKey());
            }
        }
    }
}
