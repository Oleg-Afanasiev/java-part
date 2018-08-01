package com.academy.tests.Lesson10;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.validator.RegistrationValidator;
import org.testng.annotations.Test;
import org.testng.Assert;

@Test
public class FxValidatorTests {
    private RegistrationValidator validator = new RegistrationValidator();

    public static void main(String[] args) {
        new FxValidatorTests().testPasswordValidator();
    }
    public void testPasswordValidator() {

        String[] validPasswords = {"1qweEtyuiq", "123Qwerty"};

        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("", "test")
                .withLastName("", "test")
                .withMail("", "test@mail.ru")
                .withPassword("", "1qweEtyuiq")
                .withConfirmPassword("q", "1qweEtyuiq");
        boolean isValid = validator.validate(registrationForm);
        Assert.assertTrue(isValid);
    }
}
