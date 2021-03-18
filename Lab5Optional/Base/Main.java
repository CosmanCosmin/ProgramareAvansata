package Base;

import Commands.*;
import Exceptions.*;
import Multimedia.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CommandNotFound, PathNullException, NameNullException, ArtistNullException {
        Scanner scanner = new Scanner(System.in);
        String inputText;
        String[] words;
        Catalog catalog = new Catalog();
        do {
            inputText = scanner.nextLine();
            //System.out.println("Got new command:" + inputText);
            words = inputText.split(" ");
            if(words.length != 1){
                System.out.println("Should only type one word!");
            }
            switch (words[0]){
                case "add":
                    System.out.print("Name:");
                    String name = scanner.nextLine();
                    System.out.print("Path:");
                    String path = scanner.nextLine();
                    System.out.print("Type of object(image or song):");
                    String typeOfObject = scanner.nextLine();
                    if (typeOfObject.equals("image")){
                        Command addCommand = new AddCommand(catalog, new Image(name, path));
                    }
                    else if (typeOfObject.equals("song")){
                        System.out.print("Artist:");
                        String artist = scanner.nextLine();
                        Command addCommand = new AddCommand(catalog, new Song(name, path, artist));
                    }
                    break;
                case "list":
                    Command listCommand = new ListCommand(catalog);
                    break;
                case "play":
                    System.out.print("Index:");
                    Command playCommand = new PlayCommand(catalog, scanner.nextInt());
                    scanner.nextLine();
                    break;
                case "save":
                    Command saveCommand = new SaveCommand(catalog);
                    break;
                case "load":
                    System.out.print("Path:");
                    String loadPath = scanner.nextLine();
                    Command loadCommand = new LoadCommand(catalog, loadPath);
                    break;
                case "report":
                    System.out.println("Not yet!");
                    break;
                case "exit":
                    break;
                default:
                    throw new CommandNotFound(inputText);
            }
            System.out.println("Command executed!");
        } while (inputText.compareTo("exit") != 0);
    }
}
