package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormTest;
import org.junit.jupiter.api.*;

public class DemoqaTest {

    RegistrationFormTest registrationFormTest = new RegistrationFormTest();

    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        // Set Values
        registrationFormTest.openPage()
                .setFirstName("Kayrat")
                .setLastName("Nurekenov")
                .setEmail("Test@Test.com")
                .setGender("Male")
                .setNumber("8800800800")
                .setBirthDate("21", "April", "1999")
                .setSubjects("Maths")
                .setHobbies("Music")
                .setPicture("src/test/resources/cat.jpg")
                .setAddress("Abbey Road: London, England")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();

        // Assertions
        registrationFormTest.checkResultTableVisible()
                .checkResult("Student Name", "Kayrat Nurekenov")
                .checkResult("Student Email", "Test@Test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8800800800")
                .checkResult("Date of Birth", "21 April,1999")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "cat.jpg")
                .checkResult("Address", "Abbey Road: London, England")
                .checkResult("State and City", "Haryana Karnal");
    }
}
