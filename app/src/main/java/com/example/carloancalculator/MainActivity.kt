package com.example.carloancalculator

import android.icu.util.Currency
import android.icu.util.CurrencyAmount
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    fun resetinput(view: View) {
        //TODO: Clear all inputs and output
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
    }

   private fun calculateLoan() {
        //TODO: get all inputs from user and perform calculation

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error))
            return
        }

        val carPrice=editTextCarPrice.text.toString().toInt()
        val downPayment=editTextDownPayment.text.toString().toInt()
        val loanPeriod=editTextLoanPeriod.text.toString().toInt()
        val interestRate=editTextInterestRate.text.toString().toFloat()

        val loan=carPrice-downPayment
        val interest=loan*interestRate*loanPeriod
        val montlyRepayment=(loan+interest)/loanPeriod/12

        //TODO: display the output
        //val pound=java.util.Currency.getInstance("RM")
        textViewLoan.setText(getString(R.string.loan)+"${loan}")
        textViewInterest.setText(getString(R.string.interest)+"${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment)+"${montlyRepayment}")
    }
}
