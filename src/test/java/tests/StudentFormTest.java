package tests;

import dto.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        app.getStudent().selectFormMenu();
    }

    @Test
    public void StudentFormTest() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@gmail.com")
                .gender("male")
                .mobile("7921234567")
                .dateOfBirth("11 10 1989")
                .subjects(new String[]{"Math", "Chem"})
                .hobbies(new String[]{"Music", "Reading"})
                .picture("/Users/user/Tools/WhatsApp Image 2022-06-20 at 11.51.49.jpeg")
                .currentAddress("Kiryat Ata, Sde Boker 13")
                .state("Haryana")
                .city("Karnal")
                .build();
        app.getStudent().fillStudentForm(student);
    }
}
