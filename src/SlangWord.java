import java.io.File;
import java.util.*;

public class SlangWord {
    private HashMap<String, String> map;
    private final Stack<String> historyStack;
    Scanner sc = new Scanner(System.in);
    public SlangWord() {
        this.historyStack = new Stack<>();
        this.map = new HashMap<>();
        if (!ReadFile()) {
            ReadFile();
        }
    }

    public boolean ReadFile() {
        map = new HashMap<>();
        try {
            File file = new File("slang.txt");
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
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
        System.out.println("Enter slang word: ");
        String SlagWord = sc.nextLine();
        historyStack.push(SlagWord);

        if (map.containsKey(SlagWord)) {
            System.out.println("Slang word is : ");
            System.out.println(map.get(SlagWord));
        } else {
            System.out.println("Not existed!");
        }
    }
    public void findByDefinition() {
        System.out.println("Definition: ");
        String definition = sc.nextLine();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().toLowerCase().contains(definition.toLowerCase())) {
                System.out.println(entry.getKey());
            }
        }
    }
    public void showHistory() {
        System.out.println("History:");
        int count = 0;
        for (int i = this.historyStack.size() - 1; i >= 0; i--) {
            System.out.println(this.historyStack.get(i));
            count++;
            if (count == 10) {
                break;
            }
        }
    }
    public void AddNewSlangWord() {
        System.out.println("Enter slang word: ");
        String slag = sc.nextLine();
        System.out.println("Enter definition: ");
        String mean = sc.nextLine();
        if (map.containsKey(slag)) {
            System.out.println("Slang word existed!!");
            System.out.println("0.Cancel");
            System.out.println("1.Add new");
            System.out.println("2.Edit");
            String choose = sc.nextLine();
            switch (choose) {
                case "0":
                    break;
                case "1":
                    map.put(slag, mean);
                    break;
                case "2":
                    map.put(slag, map.get(slag) + "| " + mean);
                    break;
                default:
                    System.out.println("Wrong inputted!");
                    break;
            }
        }else{
            map.put(slag, mean);
            System.out.println("Add new slang successful");
        }
    }

    public void EditSlangWord() {
        System.out.println("Enter slang word : ");
        String slang = sc.nextLine();
        if (!map.containsKey(slang)) {
            System.out.println("Slang word can't not find!");
        } else {
            System.out.println("Your choice: ");
            System.out.println("0.Cancel");
            System.out.println("1.Edit slang word");
            System.out.println("2.Edit the meaning slang word");
            System.out.println("3.Edit slang word and its definition");
            String choose = sc.nextLine();
            switch (choose) {
                case "0":
                    break;
                case "1":
                    System.out.println("Enter new slang word:");
                    String NewSlangWord = sc.nextLine();
                    map.put(NewSlangWord, map.get(slang));
                    map.remove(slang);
                    break;
                case "2":
                    System.out.println("Enter new definition:");
                    String NewMeanning = sc.nextLine();
                    map.put(slang, NewMeanning);
                    break;
                case "3":
                    System.out.println("Enter new slang word:");
                    NewSlangWord = sc.nextLine();
                    System.out.println("Enter new definition:");
                    NewMeanning = sc.nextLine();
                    map.remove(slang);
                    map.put(NewSlangWord, NewMeanning);
                    break;
                default:
                    System.out.println("Wrong inputted!!");
                    break;
            }
        }
    }
    public void DeleteSlangWord() {
        System.out.println("Enter the slang word want to delete: ");
        String SlangWord = sc.nextLine();
        if (!map.containsKey(SlangWord)) {
            System.out.println("Slang does not exist!");
        } else {
            System.out.println("Do you want to delete this slang word " + SlangWord +  "?");
            System.out.println("1.OK");
            System.out.println("2.Cancel");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    map.remove(SlangWord);
                    System.out.println("Delete success!");
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Wrong inputted!!");
            }
        }
    }

    public void Reset() {
        this.map.clear();
        ReadFromSlangwordFile();
        System.out.println("Reset success");
    }

    private void ReadFromSlangwordFile() {
    }

    public void RandomSlangWord() {
        System.out.println("Random slang word :");
        Random generator = new Random();
        Object[] key = map.keySet().toArray();
        int numberRd = generator.nextInt(key.length);
        String randomKey = key[numberRd].toString();
        System.out.println("Key : " + randomKey);
        System.out.println("Dinh nghia : " + map.get(randomKey));
    }
    public void QuizFirst() {
        ArrayList<String> answers = new ArrayList<>();
        String correctAnswer;
        System.out.println("Welcome to Quiz Game!");
        System.out.println("Choose the right meaning of the slang: ");
        Random generator = new Random();
        Object[] key = map.keySet().toArray();
        int numberRd = generator.nextInt(key.length);
        String randomKey = key[numberRd].toString();
        correctAnswer = map.get(randomKey);
        answers.add(correctAnswer);
        for (int i = 0; i < 3; i++) {
            numberRd = generator.nextInt(numberRd);
            answers.add(map.get(key[numberRd].toString()));
        }
        Collections.shuffle(answers);
        System.out.println("Slang word : " + randomKey);
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + " " + answers.get(i));
        }
        System.out.print("Your answer: ");
        String choice = sc.nextLine();

        try {
            if (answers.get(Integer.parseInt(choice) - 1).equals(correctAnswer)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void QuizSecond() {
        List<String> answers = new ArrayList<>();
        String correctAnswer;
        System.out.println("Welcome to Quiz Game!");
        System.out.println("Choose the right slang word for the following definition: ");
        Random generator = new Random();
        Object[] key = map.keySet().toArray();
        int numberRd = generator.nextInt(key.length);
        String randomKey = key[numberRd].toString();
        correctAnswer = randomKey;
        answers.add(correctAnswer);
        for (int i = 0; i < 3; i++) {
            numberRd = generator.nextInt(numberRd);
            answers.add(key[numberRd].toString());
        }
        Collections.shuffle(answers);
        System.out.println("Definition : " + map.get(randomKey));
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + " " + answers.get(i));
        }
        String choose = sc.nextLine();

        try {
            if (answers.get(Integer.parseInt(choose) - 1).equals(correctAnswer)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
