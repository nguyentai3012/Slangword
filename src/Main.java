import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        SlangWord slang = new SlangWord();
        System.out.println(slang.ReadFile());
        do
        {
            System.out.println("1. Search for slang word");
            System.out.println("2. Search for definition");
            System.out.println("3. History");
            System.out.println("4. Add new slang");
            System.out.println("5. Edit slang");
            System.out.println("6. Delete slang");
            System.out.println("7. Reset slang");
            System.out.println("8. Random 1 slang word");
            System.out.println("9. Quiz game 1:");
            System.out.println("10. Quiz game 2");
            System.out.println("____________________________");
            System.out.print("Your choice : ");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> slang.findBySlangword();
                case 2 -> slang.findByDefinition();
                case 3 -> slang.showHistory();
                case 4 -> slang.AddNewSlangWord();
                case 5 -> slang.EditSlangWord();
                case 6 -> slang.DeleteSlangWord();
                case 7 -> slang.Reset();
                case 8 -> slang.RandomSlangWord();
                case 9 -> slang.QuizFirst();
                case 10 -> slang.QuizSecond();
                case 11 -> {
                    System.out.println("Exit!");
                    System.exit(0);
                }
            }
        }
        while(choice!=0);
    }
}