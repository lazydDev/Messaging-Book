import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 882008;

    public static void main(String[] args) {

        contacts = new ArrayList<>();

        System.out.println("Welcome to the Message Book!");

        showInitialOptions();

    }

    private static void showInitialOptions() {

        System.out.println("Please Choose one Option : ");
        System.out.println("(Make sure that you should answer in numbers!)");

        System.out.println("\n\t1.Contacts" + "\n\t2. Messages" + "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Contacts();
                break;

            case 2:
                Messages();
                break;

            default:
                break;
        }

    }

    private static void Contacts() {

        System.out.println(
                "Please select one option : " + "\n(Make sure to answer in numbers)" + "\n\t1. Show all Contacts"
                        + "\n\t2. Add a new Contact" + "\n\t3. Search for Contact" + "\n\t4.Go Back ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                showAllContacts();
                break;

            case 2:
                addNewContact();
                break;

            case 3:
                searchForContact();
                break;

            case 4:
                showInitialOptions();
                break;

            default:
                System.out.println("Please choose a valid option!");
                break;
        }

    }

    private static void showAllContacts() {

        if (contacts.size() > 0) {

            for (Contact c : contacts) {
                c.getDetails();
                System.out.println("**********");
            }

            Contacts();

        } else {

            System.out.println("Sorry!, you don't have any contacts.");
            Contacts();

        }

    }

    private static void addNewContact() {

        System.out.println("Adding a new contact...");

        System.out.print("Please enter the contact's name : ");

        String name = scanner.next();

        System.out.print("Please enter the contact's Phone Number : ");

        String number = scanner.next();

        System.out.print("Please enter the contact's E-mail Address : ");

        String email = scanner.next();

        if ((name.equals("")) || (number.equals("")) || (email.equals(""))) {

            System.out.println("Error : " + "(Invalid Credentials) " + "Please enter all of the information!");
            addNewContact();

        } else {

            boolean doesExist = false;

            for (Contact c : contacts) {

                if (c.getName().equals(name)) {

                    doesExist = true;

                }

            }

            if (doesExist) {

                System.out.println("The Contact Name you entered (" + name + ") already exists!");
                addNewContact();

            } else {

                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println("Contact Name(" + name + ") Added Successfully!");

            }

        }

        Contacts();

    }

    private static void searchForContact() {

        System.out.print("Please enter the name of the contact you want to search for : ");
        String name = scanner.next();

        if (name.equals("")) {
            System.out.println("Please enter the name of the contact you want to search for : ");
            searchForContact();
        } else {

            boolean doesExist = false;

            for (Contact c : contacts) {

                if (c.getName().equals(name)) {

                    doesExist = true;
                    c.getDetails();

                }

            }

            if (!doesExist) {

                System.out.println("There is no such contact");

            }

        }

        Contacts();

    }

    private static void Messages() {

        System.out.println("Please select one option : " + "\n(Make sure to answer in numbers)"
                + "\n\t1. Show all Messages" + "\n\t2. Send a new Message" + "\n\t3. Go Back");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                showAllMessages();
                break;

            case 2:
                sendNewMessage();
                break;

            default:
                showInitialOptions();
                break;
        }

    }

    private static void showAllMessages() {

        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {

            allMessages.addAll(c.getMessages());

        }

        if (allMessages.size() > 0) {

            for (Message m : allMessages) {

                m.getDetails();
                System.out.println("**********");

            }

        } else {

            System.out.println("You don't have any Messages!");

        }

        Messages();

    }

    private static void sendNewMessage() {

        System.out.print("Whom you want to send the message? : ");
        String name = scanner.nextLine();

        if ((name.equals(""))) {

            System.out.println("Error : " + "(Invalid Credentials) " + "Please enter all of the information!");
            sendNewMessage();

        } else {

            boolean doesExist = false;

            for (Contact c : contacts) {

                if (c.getName().equals(name)) {

                    doesExist = true;

                }

            }

            if (doesExist) {

                System.out.print("What message are you going to say? : ");
                String text = scanner.nextLine();

                if ((text.equals(""))) {

                    System.out.println("Please enter a message!");
                    sendNewMessage();

                } else {

                    id++;

                    Message newMessage = new Message(text, name, id);

                    for (Contact c : contacts) {

                        if (c.getName().equals(name)) {

                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);

                        }

                    }

                }

            } else {

                System.out.println("The user does'nt exists!");

            }

        }

        Messages();

    }

}
