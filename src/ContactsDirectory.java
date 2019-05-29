import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsDirectory {

    public static void main(String[] args) {
        String dataDirectory = "data";
        Scanner sc = new Scanner(System.in);
        String topBar = "\n Name | Phone Number\n " + "-------------------\n ";
        String AskAbout = "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):";


        Path folder = Paths.get(dataDirectory);
        Path file = Paths.get(dataDirectory, "contactExercise.txt");

        Path filepath = Paths.get(String.valueOf(file));
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> updatedList = new ArrayList<>();


        try {
            Files.write(filepath, contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int contactOptions = 0;

        System.out.println(AskAbout);

        while (contactOptions < 5) {

            contactOptions = Integer.parseInt(sc.nextLine());


            switch (contactOptions) {
                case 1:
                    System.out.println(topBar);
                    try {
                        List<String> yourContactList = Files.readAllLines(file);
                        for (String contact : yourContactList) {
                            System.out.println(contact + "\n");
                        }
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(AskAbout);
                    break;


                case 2:
                    System.out.println("Please enter name of desired contact");
                    String newContact;
                    newContact = sc.nextLine();
                    System.out.println("Please enter number of desired contact");
                    String addPhoneNumber;
                    addPhoneNumber = sc.nextLine();

                    try {
                        Files.write(file, Arrays.asList(newContact + " | " + addPhoneNumber), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Your contact was added");
                    System.out.println(AskAbout);
                    break;

                case 3:
                    System.out.println("Please enter name and number of contact you're searching for\n");
                    String searchContact;
                    searchContact = sc.nextLine();

                    try {
                        List<String> namesFromFile = Files.readAllLines(file);
                        for (String contact : namesFromFile) {
                            if (contact.contains(searchContact)) {
                                System.out.println(topBar);
                                System.out.println(contact);
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    System.out.println(AskAbout);
                    break;

                case 4:
                    System.out.println("Who would you like to remove?");
                    String contact = sc.nextLine();
                    try {
                        List<String> lines = Files.readAllLines(file);
//                        List<String> updatedList = new ArrayList<>();
                        for (String line : lines) {
                            if (!line.contains(contact)) {
                                updatedList.add(line);
                            }
                        }
                        if (!updatedList.contains(contact)) {
                            System.out.println("\nContact " + contact + " deleted\n");
                        }
                        Files.write(Paths.get(String.valueOf(file)), updatedList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(AskAbout);
                    break;


                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid number");
            }

        }
    }
}

