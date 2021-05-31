package com.example.home2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.home2.models.User

class SignUp : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var addUser: Button
    lateinit var mobileNumberET: EditText
    lateinit var barangayET: Spinner

    lateinit var submitBtn: Button
    private var spinner: Spinner? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    val barangayList =  arrayOf("Abanao-Zandueta-Kayong-Chugum-Otek",
        "A. Bonifacio-Caguioa-Rimando",
        "Alfonso Tabora",
        "Ambiong",
        "Andres Bonifacio (Lower Bokawkan)",
        "Apugan-Loakan",
        "Asin Road",
        "Atok Trail",
        "Aurora Hill North Central",
        "Aurora Hill Proper (Malvar-Sgt. Floresca)",
        "Aurora hill South Central",
        "Bagong Lipunan (Market Area)",
        "Bakakeng Central",
        "Bakakeng North",
        "Bal-Marcoville",
        "Balsigan",
        "Bayan Park East",
        "Bayan Park Village",
        "Bayan Park West",
        "BGH Compound",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val databaseHandler = UsersTableHandler(this)
        mobileNumberET = findViewById(R.id.mobile_number)
        barangayET = findViewById(R.id.spinnerBarangay)



        //database
        addUser = findViewById(R.id.submitBtn)
        addUser.setOnClickListener {
            // get text from fields
            val mobileNumber = mobileNumberET.text.toString().toDouble()
            val barangay = barangayET.selectedItem.toString()
            //assign to model
            val user = User(mobileNumber, barangay)
            //saving to db
            databaseHandler.create(user)
        }

        findViewById<Button>(R.id.submitBtn).setOnClickListener { MainActivity() }


        spinner = findViewById(R.id.spinnerBarangay)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, barangayList)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext, "$items", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "None", Toast.LENGTH_LONG).show()
    }

    public fun MainActivity(){
        val login = Intent(this, LogIn::class.java)
        startActivity(login)
    }

}



