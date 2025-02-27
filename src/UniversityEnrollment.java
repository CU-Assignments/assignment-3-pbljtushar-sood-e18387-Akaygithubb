import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    private static final int MAX_CAPACITY = 2; // Assume max students in course
    private static int enrolledStudents = 2; // Assume course is already full

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            System.out.print("Prerequisite: ");
            String prerequisite = scanner.nextLine();

            if (!prerequisite.equalsIgnoreCase("Core Java")) {
                throw new PrerequisiteNotMetException("Error: Complete Core Java before enrolling in " + course);
            }

            if (enrolledStudents >= MAX_CAPACITY) {
                throw new CourseFullException("Error: " + course + " is already full.");
            }

            enrolledStudents++;
            System.out.println("Enrollment successful in " + course);
        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
