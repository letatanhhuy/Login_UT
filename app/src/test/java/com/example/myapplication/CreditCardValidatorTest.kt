package com.example.myapplication

import com.example.myapplication.util.CreditCardValidator
import org.junit.Assert
import org.junit.Test

class CreditCardValidatorTest {
    @Test
    fun creditCardValidator_simpleTestCase() {
        assert(CreditCardValidator.isVaidCreditCardNumber("1111222233334444"))
    }
    @Test
    fun creditCardValidator_lengthIsNotValidCase() {
        Assert.assertFalse(CreditCardValidator.isVaidCreditCardNumber("111122223333444"))
        Assert.assertFalse(CreditCardValidator.isVaidCreditCardNumber("11112222333344445"))
        Assert.assertFalse(CreditCardValidator.isVaidCreditCardNumber(""))
    }
    @Test
    fun creditCardValidator_haveNonDigitInputCase() {
        Assert.assertFalse(CreditCardValidator.isVaidCreditCardNumber("111122223333444A"))
        Assert.assertFalse(CreditCardValidator.isVaidCreditCardNumber("11112222333-4444"))
    }
}