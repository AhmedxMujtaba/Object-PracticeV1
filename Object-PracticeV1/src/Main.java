import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // ArrayList to store university objects
    static ArrayList<University> universityList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("Menu");
            System.out.println("1- Add New University");
            System.out.println("2- View University Details");
            System.out.println("3- View  All Universities");
            System.out.println("0- Exit");

            int option = input.nextInt();

            switch (option) {
                case 0:
                    return;
                case 1:
                    universityList.add(University.createNewUniversity());
                    System.out.println("University added successfully!");
                    break;

                case 2:
                    viewUniversityDetails();
                    break;

                case 3:
                    displayAllUniversitiesData();
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    // Method to view university details
    private static void viewUniversityDetails() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter University ID to view details: ");
        int idToView = input.nextInt();
        boolean found = false;

        for (University university : universityList) {
            if (university.getUniversityID() == idToView) {
                university.getUniversityDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("University with ID " + idToView + " not found");
        }
    }
    private static void displayAllUniversitiesData(){

        for (int i = 0; i < universityList.size(); i++)
        {
           University university = universityList.get(i);
           university.getUniversityDetails();
        }
    }
}

class University {
    private String universityName;
    private int universityID;
    private int universityStudentsCount;

    // Constructor should initialize universityStudentsCount
    public University(String universityName, int universityID, int universityStudentsCount) {
        this.universityName = universityName;
        this.universityID = universityID;
        this.universityStudentsCount = universityStudentsCount;
    }

    // Getter methods
    public int getUniversityID() {
        return universityID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public int getUniversityStudentsCount() {
        return universityStudentsCount;
    }

    // Method to print university details
    public void getUniversityDetails() {
        System.out.println("University ID: " + getUniversityID());
        System.out.println("University Name: " + getUniversityName());
        System.out.println("University Students Count: " + getUniversityStudentsCount());
    }

    // Method to create a new university
    public static University createNewUniversity() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new university Name: ");
        String name = input.nextLine();
        System.out.println("Enter new university ID: ");
        int id = input.nextInt();
        System.out.println("Enter new university Students Count: ");
        int studentsCount = input.nextInt();

        return new University(name, id, studentsCount);
    }
}
