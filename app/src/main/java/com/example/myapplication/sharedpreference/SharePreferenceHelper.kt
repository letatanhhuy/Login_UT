package com.example.myapplication.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.myapplication.util.CreditCardValidator


private const val KEY_NAME = "cc_info_name"
private const val KEY_CREDIT_CARD_NUMBER = "cc_info_number"
private const val KEY_CREDIT_CARD_CVV = "cc_info_cvv"
private const val KEY_CREDIT_CARD_EXPIRATION_DATE = "cc_info_expiration_date"

object SharePreferenceHelper {
    private fun getSharePreference(context: Context?):SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
    fun saveCreditCardInfo(sharedPreferenceEntity: SharedPreferenceEntity
                           , context: Context?):Boolean {
        var retVal:Boolean
        if (CreditCardValidator.isValidCreditCardNumber(sharedPreferenceEntity.number)) {
            val editor = getSharePreference(context).edit()
            editor.putString(KEY_NAME, sharedPreferenceEntity.name)
            editor.putString(KEY_CREDIT_CARD_NUMBER, sharedPreferenceEntity.number)
            editor.putString(KEY_CREDIT_CARD_CVV, sharedPreferenceEntity.ccv)
            editor.putLong(KEY_CREDIT_CARD_EXPIRATION_DATE, sharedPreferenceEntity.expDate)
            return editor.commit()
        } else {
            retVal = false
        }
        return retVal
    }
    fun getCreditCardInfo(context: Context?):SharedPreferenceEntity {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return SharedPreferenceEntity(sharedPreferences.getString(KEY_NAME,"")
            , sharedPreferences.getString(KEY_CREDIT_CARD_NUMBER,"")
            , sharedPreferences.getString(KEY_CREDIT_CARD_CVV,"")
            , sharedPreferences.getLong(KEY_CREDIT_CARD_EXPIRATION_DATE,0))
    }
}