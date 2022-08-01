package com.byt.tictactoe


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.byt.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.single.setOnClickListener{

            var intent=Intent(this,SingleActivity::class.java)
          resultLanucher.launch(intent)
        }
        binding.multi.setOnClickListener{

            var intent=Intent(this,MultiActivity::class.java)
            resultLanucher.launch(intent)
        }


    }
    var resultLanucher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->if(result.resultCode== Activity.RESULT_OK)
    {

    }
    }
}