package prototype.command;

import java.util.Scanner;

public class ExecuteCommand {
    private int cmdNum;
    public ExecuteCommand(int cmdNum)
    {
        this.cmdNum = cmdNum;
        runCommand();
    }


    public void runCommand()
    {
        switch (cmdNum){
            case 1: {
                addBook();
                break;
            }
            case 2: {
                System.out.println("Deleting a book");
                break;
            }
            default:{
                System.out.println("You have selected process " + cmdNum);
            }
        }
    }

    public void addBook()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();
        System.out.println("Enter the genre of the book:");
        String genre = scanner.nextLine();
        System.out.println("Enter the publisher of the book:");
        String publisher = scanner.nextLine();
        System.out.println("Book added: " + title + " by " + author);
    }
}
