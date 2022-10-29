package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val item = arrayOf("message 1", "message 2", "message 3", "message 4", "message 5")

        button.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消") { dialog, which ->
                    showToast("dialog關閉")
                }
                .setNegativeButton("自定義Toast") { dialog, which ->
                    val toast = Toast(this)

                    toast.setGravity(Gravity.TOP, 0, 50)

                    toast.duration = Toast.LENGTH_SHORT

                    toast.view =
                        layoutInflater.inflate(R.layout.custom_toast, null)

                    toast.show()
                }
                .setPositiveButton("顯示list") { dialog, which ->
                    AlertDialog.Builder(this)
                        .setTitle("使用List呈現")
                        .setItems(item) { dialogInterface, i ->
                            showToast("你選的是${item[i]}")
                        }.show()
                }.show()
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}