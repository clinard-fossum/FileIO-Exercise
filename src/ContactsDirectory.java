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


        List<String> contactList = Arrays.asList("Jane | 2102341234", "Logan | 2345436789", "Sarah | 2802349876",
                "Rhianna | 2654597654", "Alexandra | 2105567854");
        Path filepath = Paths.get(String.valueOf(file));
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
                    for (String contact : contactList) {
                        System.out.println(contact + "\n");
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


//                    List<String> updatedList = new ArrayList<>();
//
//                    try {
//                        List<String> namesFromFile = Files.readAllLines(file);
//                        for (String line : namesFromFile) {
//                            String name = searchContact;
//                            if (name.equalsIgnoreCase("fer")) {
//                                System.out.println("That's me");
//                            }
//                            name = line.split(" ")[0];
//                            int age = Integer.parseInt(line.split(" | ")[1]);
//
//                            System.out.println("name = " + name);
//                            System.out.println("age = " + age);
//
//                            if (name.equalsIgnoreCase("ryan")) {
//                                updatedList.add(name + " " + 35);
//                                continue;
//                            }
//                            updatedList.add(line);
//                        }
//
//                        Files.write(file, updatedList);
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }


                    try {
                        List<String> namesFromFile = Files.readAllLines(file);
                        for (String contact : namesFromFile) {
                            if (contact.equalsIgnoreCase(searchContact)) {
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
                    System.out.println("Which contact do you wish to delete?");
                    String deleteContact;
                    deleteContact = sc.nextLine();
                    try {
                        List<String> contactD = Files.readAllLines(file);
                        for (String contact : contactD) {
                            if (contact.equalsIgnoreCase(deleteContact)) {
                                contactD.add("");
                                continue;
                            }
                            contactD.add(contact);
                        }

                        Files.write(Paths.get("data", "groceries.txt"), contactD);

                                System.out.println("Contact deleted successfully");


                        break;
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

