import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsDirectory {

    public static void main(String[] args) {
        String dataDirectory = "data";
        Scanner sc = new Scanner(System.in);
        String topBar = "\n Name | Phone Number\n " + "-------------------\n ";


        Path folder = Paths.get(dataDirectory);
        Path file = Paths.get(dataDirectory, "contactExercise.txt");


        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        List<String> contactList = Arrays.asList("Jane | 2102341234", "Logan | 2345436789", "Sarah | 2802349876",
                "Rhianna | 2654597654", "Alexandra | 2105567854");
        Path filepath = Paths.get(String.valueOf(file));
        try {
            Files.write(filepath, contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int contactOptions;
        contactOptions = sc.nextInt();

    switch (contactOptions) {
            case 1:
                System.out.println(topBar);
                for (String contact : contactList) {
                    System.out.println(contact + "\n");
                }
                break;

            case 2:
                System.out.println("Please enter name and number of desired contact");
                String newContact;
                newContact = sc.nextLine();
                try {
                    Files.write(
                            file,
                            Arrays.asList(newContact),
                            StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Your contact was added");
                break;

            case 3:
                System.out.println("Please enter name and number of contact you're searching for\n");
                String searchContact;
                searchContact = sc.nextLine();
                try {
                    List<String> namesFromFile = Files.readAllLines(file);
                    for (String contact : namesFromFile) {
                        if (contact.equalsIgnoreCase(searchContact)) {
                            System.out.println(topBar);
                            System.out.println(contact);
                        }
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }
                break;

            case 4:
                System.out.println("Which contact do you wish to delete?");
                String deleteContact;
                deleteContact = sc.nextLine();
                try {
                    List<String>contactD = Files.readAllLines(file);
                    for (String contact : contactD) {
                        if (contact.equalsIgnoreCase(deleteContact)) {
                            System.out.println("Contact deleted successfully");
                        }
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case 5:
                System.out.println("Exit");
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Please enter a valid number");
        }

    }

}
