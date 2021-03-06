package com.example.my_first_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_choise_of_excursion.*
import kotlinx.android.synthetic.main.activity_quest_choise_go_or_make.*

class quest_choise_go_or_make : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_choise_go_or_make)
        button6.setOnClickListener {
            val db = Firebase.firestore
            db.collection("Quests")
                .document("Test2")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val test = task.result.data
                        if (test != null) {
                            Log.d("testDB",test.toString())
                            testExcursion.name=test["name"] as String
                            testExcursion.text = test["discription"] as String
                            testExcursion.cost=test["cost"] as Long
                            testExcursion.mark=test["mark"] as Long
                            Log.d("testDB",test["cost"].toString())


                        }
                    }
                }
            val intent = Intent(this, ChoiseOfQuest::class.java)
            startActivity(intent)
        }
    }
}