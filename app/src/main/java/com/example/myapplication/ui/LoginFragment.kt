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
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.sharedpreference.SharePreferenceHelper
import com.example.myapplication.sharedpreference.SharedPreferenceEntity
import com.example.myapplication.util.CreditCardValidator
import kotlinx.android.synthetic.main.login_view.*
import java.text.SimpleDateFormat

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
        txtCCNum.addTextChangedListener(creditCardValidator)

        expirationDatePicker.findViewById<NumberPicker>(Resources.getSystem()
            .getIdentifier("day", "id", "android"))
            .visibility = View.GONE
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.saveButton -> {

                Log.d(TAG, "onClick: saveButton")
                if(SharePreferenceHelper.saveCreditCardInfo(
                    SharedPreferenceEntity(txtCCName.text.toString()
                                            ,txtCCNum.text.toString()
                                            ,txtCCccv.text.toString()
                                            ,1000L), context)) {
                    Toast.makeText(context, "SAVE SUCCESSFUL", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.revertButton -> {
                Log.d(TAG,"onClick: revertButton")
                val ccInfo = SharePreferenceHelper.getCreditCardInfo(context)
                txtCCName.setText(ccInfo.name)
                txtCCNum.setText(ccInfo.number)
                txtCCccv.setText(ccInfo.ccv)
                expirationDatePicker.updateDate(1989,1,11)
                Toast.makeText(context, "REVERT SUCCESSFUL", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "LoginFragment"
    }
}