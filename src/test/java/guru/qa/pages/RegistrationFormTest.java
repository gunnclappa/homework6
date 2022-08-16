package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.*;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    private static final String URL = "/automation-practice-form";

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    public RegistrationFormTest openPage() {
        open(URL);
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationFormTest setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormTest setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormTest setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormTest setGender(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormTest setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormTest setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormTest setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormTest setHobbies(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormTest setPicture(String value) {
        uploadPicture.uploadFile(new File(value));

        return this;
    }

    public RegistrationFormTest setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormTest setState(String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormTest setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormTest clickSubmit() {
        submit.pressEnter();

        return this;
    }

    public RegistrationFormTest checkResultTableVisible() {
        resultTableComponent.checkVisible();

        return this;
    }

    public RegistrationFormTest checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
}
