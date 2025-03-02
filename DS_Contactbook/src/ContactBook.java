import java.util.*;

public class ContactBook {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("**********************************************");
            System.out.println("(A)dd\n(D)elete\n(E)mail search\n(P)rint\n(S)earch\n(Q)uit");
            System.out.println("**********************************************");
            System.out.print("Please Enter a command: ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "A":
                    addContact();
                    break;
                case "D":
                    deleteContact();
                    break;
                case "E":
                    searchByEmail();
                    break;
                case "P":
                    printContacts();
                    break;
                case "S":
                    searchByName();
                    break;
                case "Q":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid command! Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine().trim();
        contacts.removeIf(contact -> contact.name.equalsIgnoreCase(name));
        System.out.println("Contact deleted if it existed.");
    }

    private static void searchByEmail() {
        System.out.print("Enter email to search: ");
        String email = scanner.nextLine().trim();
        for (Contact contact : contacts) {
            if (contact.email.equalsIgnoreCase(email)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("No contact found with that email.");
    }

    private static void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            contacts.forEach(System.out::println);
        }
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("No contact found with that name.");
    }
}
