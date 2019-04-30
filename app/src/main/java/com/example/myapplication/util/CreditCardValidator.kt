package com.example.myapplication.util

import android.support.annotation.VisibleForTesting
import android.text.Editable
import android.text.TextWatcher
import java.lang.StringBuilder

class CreditCardValidator:TextWatcher {
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        val originString = s.toString()
        val newString = updateCreditCardText(originString)
        if (newString != originString) {
            s?.apply {
                clear()
                append(newString)
            }
        }
    }

    @VisibleForTesting
    fun updateCreditCardText(input:String):String {
        val originString = input.replace("\\s".toRegex(),"")
        val sb = StringBuilder(originString)

        var i = 4
        while (i < sb.length) {
            sb.insert(i, " ")
            i+=5
        }
        return sb.toString()
    }

    companion object {
        fun isValidCreditCardNumber(s:String):Boolean {
            var retVal = true
            if(s.length == 19) {
                val temp = s.replace("\\s".toRegex(),"")
                for (c in temp) {
                    if (!c.isDigit()) {
                        retVal = false
                        break
                    }
                }
            } else {
                retVal = false
            }
            return retVal
        }
        private const val TAG = "CreditCardValidator"
    }
}