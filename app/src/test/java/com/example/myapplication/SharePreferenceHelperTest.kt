package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.myapplication.sharedpreference.SharePreferenceHelper
import com.example.myapplication.sharedpreference.SharedPreferenceEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

private const val TEST_NAME = "test name"
private const val TEST_CC_NUMBER = "1111 2222 3333 4444"
private const val TEST_CC_NUMBER_INVALID = "1111 2222 3333 4444"
private const val TEST_CC_CVV = "123"
class SharePreferenceHelperTest {
    @Mock
    private lateinit var mockContext:Context
    private lateinit var mockSharedPreferences: SharedPreferences
    private lateinit var sharedPreferenceEntity:SharedPreferenceEntity
    private lateinit var sharedPreferenceEntityInvalid:SharedPreferenceEntity

    @Before
    fun setUp() {
        mockContext = Mockito.mock(Context::class.java)
        mockSharedPreferences = Mockito.mock(SharedPreferences::class.java)
        sharedPreferenceEntity = SharedPreferenceEntity(TEST_NAME, TEST_CC_NUMBER, TEST_CC_CVV, 1000)
        sharedPreferenceEntityInvalid = SharedPreferenceEntity(TEST_NAME, TEST_CC_NUMBER_INVALID, TEST_CC_CVV, 1000)
    }

    @Test
    fun sharePreferenceHelperTest_SaveInformation() {
        val check = SharePreferenceHelper.saveCreditCardInfo(sharedPreferenceEntity, mockContext)
        Assert.assertTrue(check)
    }

    @Test
    fun sharePreferenceHelperTest_SaveInformationFailed() {
        val check = SharePreferenceHelper.saveCreditCardInfo(sharedPreferenceEntityInvalid, mockContext)
        Assert.assertFalse(check)
    }
}