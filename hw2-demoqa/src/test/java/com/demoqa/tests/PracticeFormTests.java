package com.demoqa.tests;

import com.demoqa.models.Student;
import com.demoqa.pages.PracticeForm;
import com.demoqa.pages.ThankYouPage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests {

    PracticeForm practiceForm = new PracticeForm();
    ThankYouPage thankYouPage = new ThankYouPage();

    @Test
    void testCanFillPracticeForm() {
        Student expectedStudent = new Student("test", "test", "test@gmail.com", "Male", "7800000000",
                LocalDate.of(2000, 3, 11), "Maths", "Sports", "image.jpg", "Test address", "NCR", "Delhi");

        System.out.println(expectedStudent.getDateOfBirthday());
        step("Fill Student Registration Form", () -> {
            practiceForm.openPage()
                    .enterFirstName(expectedStudent.getFirstName())
                    .enterLastName(expectedStudent.getLastName())
                    .enterEmail(expectedStudent.getEmail())
                    .selectGender(expectedStudent.getGender())
                    .enterMobileNumber(expectedStudent.getMobileNumber())
                    .selectDateOfBirthday(expectedStudent.getMonthAsNumber(), expectedStudent.getYear(), expectedStudent.getDay())
                    .enterSubject(expectedStudent.getSubject())
                    .checkHobby(expectedStudent.getHobby())
                    .uploadImage(expectedStudent.getImage("src/test/resources/files/"))
                    .enterAddress(expectedStudent.getAddress())
                    .selectLocation(expectedStudent.getState(), expectedStudent.getCity())
                    .clickOnCreateStudentButton();
        });

        step("Check Thank You Page", () -> {
            thankYouPage.checkPageTitle("Thanks for submitting the form");
            thankYouPage.verifyRowValue("Student Name", expectedStudent.getFullName());
            thankYouPage.verifyRowValue("Student Email", expectedStudent.getEmail());
            thankYouPage.verifyRowValue("Gender", expectedStudent.getGender());
            thankYouPage.verifyRowValue("Mobile", expectedStudent.getMobileNumber());
            thankYouPage.verifyRowValue("Date of Birth", expectedStudent.getDateOfBirthday());
            thankYouPage.verifyRowValue("Subjects", expectedStudent.getSubject());
            thankYouPage.verifyRowValue("Hobbies", expectedStudent.getHobby());
            thankYouPage.verifyRowValue("Picture", expectedStudent.getImageName());
            thankYouPage.verifyRowValue("State and City", expectedStudent.getLocation());
        });
    }
}
