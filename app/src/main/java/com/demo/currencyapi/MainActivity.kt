package com.demo.currencyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var convtbtn12: Button

    var fromarylist = arrayOf(
        "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
        "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
        "BSD", "BTC", "BTN", "BWP", "BYN", "BYR", "BZD", "CAD", "CDF", "CHF",
        "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF",
        "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GEL",
        "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK",
        "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP",
        "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KRW", "KWD", "KYD",
        "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD",
        "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MRU", "MUR", "MVR",
        "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD",
        "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON",
        "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
        "SLL", "SLE", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS",
        "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD",
        "UYU", "UZS", "VES", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU",
        "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMK", "ZMW", "ZWL"
    )

    var toarylist = arrayOf(
        "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
        "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
        "BSD", "BTC", "BTN", "BWP", "BYN", "BYR", "BZD", "CAD", "CDF", "CHF",
        "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF",
        "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GEL",
        "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK",
        "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP",
        "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KRW", "KWD", "KYD",
        "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD",
        "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MRU", "MUR", "MVR",
        "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD",
        "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON",
        "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
        "SLL", "SLE", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS",
        "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD",
        "UYU", "UZS", "VES", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU",
        "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMK", "ZMW", "ZWL"
    )

    lateinit var fromview: AutoCompleteTextView
    lateinit var toview: AutoCompleteTextView

    lateinit var result: TextView

    lateinit var amnt: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fromview = findViewById(R.id.fromview)
        toview = findViewById(R.id.toview)

        result = findViewById(R.id.result)
        amnt = findViewById(R.id.amnt)
        convtbtn12 = findViewById(R.id.convtbtn12)

//        currencyapi()

        var adapter = ArrayAdapter(this@MainActivity, R.layout.element, fromarylist)
        fromview.setAdapter(adapter)

        var adapter2 = ArrayAdapter(this@MainActivity, R.layout.element, toarylist)
        toview.setAdapter(adapter2)

        convtbtn12.setOnClickListener {

            var from = fromview.text.toString()
            var to = toview.text.toString()
            var amount = amnt.text.toString()

            Log.e("-=--", "convtbtn: $from")
            Log.e("-=--", "convtbtn: $to")
            Log.e("-=--", "convtbtn: $amount")


            if (from.isNotEmpty() && to.isNotEmpty()) {
                // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)

                if (amount.isEmpty()) {
                    amount = "1"
                }

                val url =
                    "https://currency-conversion-and-exchange-rates.p.rapidapi.com/convert?from=$from&to=$to&amount=$amount"

                // Request a string response from the provided URL.
                val stringRequest =
                    object : StringRequest(
                        Request.Method.GET,
                        url,
                        Response.Listener<String> { response ->
                            // Display the first 500 characters of the response string.

                            Log.e("response", "currencyapi: $response")

                            var jsonob = JSONObject(response)

                            var rate = jsonob.get("result")

                            result.setText("$rate")

                            Log.e("rate", "onCreate: $rate")

                        },
                        {
                            Log.e("currencyerror", "currencyapi: ${it.localizedMessage}")
                        }) {
                        override fun getHeaders(): MutableMap<String, String> {
                            var hashkey = HashMap<String, String>()

                            hashkey.put(
                                "x-rapidapi-key",
                                "db204bc25emsh5e0d742b779536cp1cdd12jsnadc6b180a2d1"
                            )
                            hashkey.put(
                                "x-rapidapi-host",
                                "currency-conversion-and-exchange-rates.p.rapidapi.com"
                            )

                            return hashkey
                        }
                    }

                // Add the request to the RequestQueue.
                queue.add(stringRequest)
            }

        }

    }

}