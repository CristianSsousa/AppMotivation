package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences
    private var categoryId = MotivationConstants.FILTER.INFINIT
    private val mock: Mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()

        securityPreferences = SecurityPreferences(this)
        setListeners()
        handleUserName()
        handleFilter(R.id.image_icon_infinite)
        handleNextPhrase()


    }

    override fun onClick(view: View) {
        val id: Int = view.id

        val listId = listOf(
            R.id.image_icon_infinite,
            R.id.image_icon_anchor,
            R.id.image_icon_ice
        )
        if(id in listId) {
            handleFilter(id)
        }else if (id == R.id.button_new_phrase) {
             handleNextPhrase()
        }else if (id == R.id.text_user_name) {
            startActivity(Intent(this,UserActivity::class.java))
           
        }
    }

    private fun setListeners(){
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageIconAnchor.setOnClickListener(this)
        binding.imageIconIce.setOnClickListener(this)
        binding.imageIconInfinite.setOnClickListener(this)
        binding.textUserName.setOnClickListener(this)

    }

    private fun handleNextPhrase(){
        binding.textMotivation.text = mock.getPhrase(categoryId)
    }


    private fun handleFilter(id: Int){
        binding.imageIconInfinite.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
        binding.imageIconAnchor.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageIconIce.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id){
            R.id.image_icon_infinite -> {
                binding.imageIconInfinite.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ANCHOR
            }
            R.id.image_icon_anchor -> {
                binding.imageIconAnchor.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ANCHOR
            }
            R.id.image_icon_ice -> {
                binding.imageIconIce.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ICE
            }
        }
    }

    private fun handleUserName(){
         val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
         binding.textUserName.text = "Ola, $name"
     }
}
