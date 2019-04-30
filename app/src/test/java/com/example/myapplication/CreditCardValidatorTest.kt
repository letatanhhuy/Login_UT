package com.example.myapplication

import com.example.myapplication.util.CreditCardValidator
import org.junit.Assert
import org.junit.Test

class CreditCardValidatorTest {
    var creditCardValidator = CreditCardValidator()
    @Test
    fun creditCardValidator_updateInput() {
        Assert.assertEquals("", creditCardValidator.updateCreditCardText(""))
        Assert.assertEquals("1", creditCardValidator.updateCreditCardText("1"))
        Assert.assertEquals("1234 5", creditCardValidator.updateCreditCardText("12345"))
        Assert.assertEquals("1234", creditCardValidator.updateCreditCardText("1234"))
        Assert.assertEquals("1111 2222 3333 4444", creditCardValidator.updateCreditCardText("1111222233334444"))
    }


    @Test
    fun creditCardValidator_isValidCreditCardNumber_simpleTestCase() {
        assert(CreditCardValidator.isValidCreditCardNumber("1111222233334444"))
    }
    @Test
    fun creditCardValidator_isValidCreditCardNumber_lengthIsNotValidCase() {
        Assert.assertFalse(CreditCardValidator.isValidCreditCardNumber("1"))
        Assert.assertFalse(CreditCardValidator.isValidCreditCardNumber("111122223333444"))
        Assert.assertFalse(CreditCardValidator.isValidCreditCardNumber("11112222333344445"))
        Assert.assertFalse(CreditCardValidator.isValidCreditCardNumber(""))

    }
    @Test
    fun creditCardValidator_isValidCreditCardNumber_haveNonDigitInputCase() {
        Assert.assertFalse(CreditCardValidator.isValidCreditCardNumber("111122223333444A"))
        Assert.assertFalse(CreditCardValidator.isValidCreditCardNumber("11112222333-4444"))
    }
}