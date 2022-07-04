import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int chon;
        Stack<String> historyStack;
        SlangWord slang = new SlangWord();
        System.out.println(slang.ReadSlangwordFile());
        System.out.println(slang.getMap().get("BBC"));
        do
        {
            System.out.println("1. Tim kiem theo slang word");
            System.out.println("2. Tim kiem theo dinh nghia");
            System.out.println("3. Hien thi history");
            System.out.println("4. Them 1 slang word moi");
            System.out.println("5. Sua 1 slang word");
            System.out.println("6. Xoa 1 slang word");
            System.out.println("7. Reset danh sach slang word goc");
            System.out.println("8. Random 1 slang word");
            System.out.println("9. Do vui voi random slang word");
            System.out.println("10. Do vui voi dinh nghia slang word");
            System.out.println("____________________________");
            System.out.print("Chon chuc nang : ");
            chon = in.nextInt();
            switch(chon)
            {
                case 1:
                    slang.findBySlangword();
                    break;
                case 2:
                    slang.findByDefinition();2
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:
                {
                    System.out.println("Thoat!");
                    System.exit(0);
                }
            }
        }
        while(chon!=0);
    }
}