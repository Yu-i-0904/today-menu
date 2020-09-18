package com.example.todaymenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(menuImage)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                menuImage.setImageResource(R.drawable.restaurant)
                menuText.text = ""
                return true
            }
            R.id.staek -> {
                menuImage.setImageResource(R.drawable.staek)
                menuText.text = getString(R.string.steak_text)
                return true
            }
            R.id.locomoco -> {
                menuImage.setImageResource(R.drawable.locomoco)
                menuText.text = getString(R.string.locomoco_text)
                return true
            }
            R.id.burger -> {
                menuImage.setImageResource(R.drawable.hambergar)
                menuText.text = getString(R.string.burger_text)
                return true
            }
            R.id.bread -> {
                menuImage.setImageResource(R.drawable.bread)
                menuText.text = getString(R.string.bread_text)
                return true
            }
            R.id.poki -> {
                menuImage.setImageResource(R.drawable.poki)
                menuText.text = getString(R.string.poki_text)
                return true
            }
            R.id.beer -> {
                menuImage.setImageResource(R.drawable.beer)
                menuText.text = getString(R.string.beer_text)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "${menuText.text}がたいへん!"
                val uri = Uri.fromParts("mailto:", "yu0904ichikawa@gmail.com", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.sms -> {
                val text = "${menuText.text}が食べたい！"
                val uri = Uri.fromParts("smsto", "99999999999999", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menuText.text.isNotEmpty()) {
            menuInflater.inflate(R.menu.context, menu)
        }
    }
}