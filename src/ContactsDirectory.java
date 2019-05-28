import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ContactsDirectory {

    public static void main(String[] args) {
        String dataDirectory = "data";

        Path folder = Paths.get(dataDirectory);
        Path file = Paths.get(dataDirectory, "contactExercise.txt");

        if (Files.notExists(folder)) {
            try {
                Files.createDirectories(folder);
                System.out.println(folder + " directory was created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(folder + " directory already exist!");
        }

        if (! Files.exists(file)) {
            try {
                Files.createFile(file);
                System.out.println(file + " file was created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(file + " file already exist!");
        }

        List<String> contactList = Arrays.asList("Jane | 2102341234", "Logan | 2345436789", "Sarah | 2802349876",
                "Rhianna | 2654597654", "Alexandra | 2105567854");
        Path filepath = Paths.get(String.valueOf(file));
        try {
            Files.write(filepath, contactList);
            System.out.println("Your list was added.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n Name | Phone Number\n " + "-------------------\n " + contactList.get(0) +
                "\n " + contactList.get(1));
    }
}
