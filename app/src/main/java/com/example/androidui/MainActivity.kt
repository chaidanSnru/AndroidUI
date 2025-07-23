package com.example.androidui

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gridLayout: GridLayout = findViewById(R.id.myGridLayout)

        val rowCount = 8
        val columnCount = 8
        gridLayout.rowCount = rowCount
        gridLayout.columnCount = columnCount

        for (row in 0 until rowCount) {
            for (col in 0 until columnCount) {
                val cell = View(this)

                val params = GridLayout.LayoutParams(
                    GridLayout.spec(row, 1f), // แถว, น้ำหนัก
                    GridLayout.spec(col, 1f)  // คอลัมน์, น้ำหนัก
                )
                params.width = 0
                params.height = 0
                params.setMargins(1, 1, 1, 1)
                cell.layoutParams = params

                // สลับสีพื้นหลัง
                if ((row + col) % 2 == 0) {
                    cell.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                } else {
                    cell.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                }

                gridLayout.addView(cell)
            }
        }
    }
}
