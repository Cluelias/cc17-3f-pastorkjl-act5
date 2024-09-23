package com.example.artspaceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat.Type.systemBars

class MainActivity : AppCompatActivity() {

    private val images = arrayOf(R.drawable.artwork_1, R.drawable.artwork_2, R.drawable.artwork_3,
        R.drawable.artwork_4, R.drawable.artwork_5, R.drawable.artwork_6, R.drawable.artwork_7,
        R.drawable.artwork_8, R.drawable.artwork_9, R.drawable.artwork_10)

    private val descriptions = arrayOf(
        "Ethereal",
        "Sweet Osmanthus",
        "Fleeting Thoughts",
        "Moon Seller",
        "Mystic Rose",
        "Mom? Dad? Friends?",
        "Hundred Years Ago",
        "Spirited Away",
        "Vocaloid Forever",
        "Dark Hour"
    )

    private val descriptions2 = arrayOf(
        "摸鱼斋, washanapple (2023)",
        "しょくむら, syokumura (2018)",
        "RiN, 218rin_ (2022)",
        "沁, loika (2024)",
        "Cluelias (2020)",
        "Jean-Baptiste Monge (1996)",
        "RiN, @218rin_ (2023)",
        "Ghibli Studio (2020)",
        "Yuji/河底9, hoteiblender (2021)",
        "Shin Megami Tensei (2006)"
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val description2TextView = findViewById<TextView>(R.id.description2TextView)
        val previousButton = findViewById<Button>(R.id.previousButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        imageView.setImageResource(images[currentIndex])
        descriptionTextView.text = descriptions[currentIndex]
        description2TextView.text = descriptions2[currentIndex]

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            imageView.setImageResource(images[currentIndex])
            descriptionTextView.text = descriptions[currentIndex]
            description2TextView.text = descriptions2[currentIndex]

            when (currentIndex) {
                images.size - 1 -> nextButton.isEnabled = false
                else -> nextButton.isEnabled = true
            }

            previousButton.isEnabled = true
        }

        previousButton.setOnClickListener {
            currentIndex = if (currentIndex - 1 < 0) images.size - 1 else currentIndex - 1
            imageView.setImageResource(images[currentIndex])
            descriptionTextView.text = descriptions[currentIndex]
            description2TextView.text = descriptions2[currentIndex]

            when (currentIndex) {
                0 -> previousButton.isEnabled = false
                else -> previousButton.isEnabled = true
            }

            nextButton.isEnabled = true
        }

        previousButton.isEnabled = false
    }
}
