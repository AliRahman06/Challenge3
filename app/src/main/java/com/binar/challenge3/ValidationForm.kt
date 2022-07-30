package com.binar.challenge3

import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.widget.addTextChangedListener

object ValidationForm {

    fun EditText.isValid(): Boolean{
        return if (this.text.isEmpty()){
            this.callError("Harap diisi")
            false
        }else{
            true
        }
    }

    private fun EditText.callError(errorMsg: String){
        this.addTextChangedListener { this.error = null }

        this.error = errorMsg
    }

    fun RadioGroup.isValid():Boolean{
        return if (this.checkedRadioButtonId == -1){
            this.callError("Harap diisi")
            false
        }else{
            true
        }
    }

    private fun RadioGroup.callError(errorMsg: String){
        val radio =  this.getChildAt(0) as RadioButton
        this.setOnCheckedChangeListener { _, _ ->
            radio.error = null
        }

        radio.error = errorMsg
    }

}