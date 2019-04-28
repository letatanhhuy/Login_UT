package com.example.myapplication.ui

import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.NumberPicker
import com.example.myapplication.R
import com.example.myapplication.util.CreditCardValidator
import kotlinx.android.synthetic.main.login_view.*

class LoginFragment:Fragment(),View.OnClickListener {
    private lateinit var creditCardValidator: CreditCardValidator
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        creditCardValidator = CreditCardValidator()
        saveButton.setOnClickListener(this)
        revertButton.setOnClickListener(this)
        creditInput.addTextChangedListener(creditCardValidator)

        expirationDatePicker.findViewById<NumberPicker>(Resources.getSystem()
            .getIdentifier("day", "id", "android"))
            .visibility = View.GONE
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.saveButton -> {
                Log.d(TAG, "onClick: saveButton")
            }
            R.id.revertButton -> {
                Log.d(TAG,"onClick: revertButton")
            }
        }
    }

    companion object {
        private const val TAG = "LoginFragment"
    }
}