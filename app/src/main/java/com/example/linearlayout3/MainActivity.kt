package com.example.linearlayout3

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    private fun setSupportActionBar(toolbar: Toolbar) {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.font_small -> {
                textView.textSize = 10f
                true
            }
            R.id.font_medium -> {
                textView.textSize = 16f
                true
            }
            R.id.font_large -> {
                textView.textSize = 20f
                true
            }
            R.id.normal_item -> {
                Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.color_red -> {
                textView.setTextColor(Color.RED)
                true
            }
            R.id.color_black -> {
                textView.setTextColor(Color.BLACK)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


/*package com.example.linearlayout3
选中框
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.AbsListView.MultiChoiceModeListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var itemList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        // 准备数据
        itemList = ArrayList()
        for (i in 1..10) {
            itemList.add("Item $i")
        }

        // 设置适配器
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_activated_1,
            itemList
        )
        listView.adapter = adapter

        // 设置 ListView 的多选模式和上下文菜单
        listView.choiceMode = AbsListView.CHOICE_MODE_MULTIPLE_MODAL
        listView.setMultiChoiceModeListener(object : MultiChoiceModeListener {
            override fun onItemCheckedStateChanged(
                mode: ActionMode,
                position: Int,
                id: Long,
                checked: Boolean
            ) {
                val checkedCount = listView.checkedItemCount
                mode.title = "$checkedCount selected"
            }

            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                val inflater = mode.menuInflater
                inflater.inflate(R.menu.context_menu, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                if (item.itemId == R.id.action_delete) {
                    // 删除选中的项目
                    for (i in adapter.count - 1 downTo 0) {
                        if (listView.isItemChecked(i)) {
                            itemList.removeAt(i)
                        }
                    }
                    adapter.notifyDataSetChanged()
                    mode.finish()
                    return true
                }
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode) {
                // 清除选择状态
            }
        })
    }
}*/


/*
package com.example.linearlayout3
//import android.R
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.linearlayout3.R; // 将 `com.example.myapp` 替换为您的实际包名
登录


// 替换为您的实际包名

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 设置一个按钮来触发自定义对话框
        val showDialogButton =
            findViewById<Button>(R.id.showDialogButton) // 确保 activity_main.xml 中有此按钮
        showDialogButton.setOnClickListener { v: View? -> showCustomDialog() }
    }

    private fun showCustomDialog() {
        // 使用 LayoutInflater 加载自定义布局
        val inflater = layoutInflater
        val dialogView: View = inflater.inflate(R.layout.dialog_custom, null)

        // 创建 AlertDialog.Builder 并设置自定义视图
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        // 创建 AlertDialog
        val alertDialog = builder.create()

        // 获取布局中的组件
        val username = dialogView.findViewById<EditText>(R.id.username)
        val password = dialogView.findViewById<EditText>(R.id.password)
        val cancelButton = dialogView.findViewById<Button>(R.id.cancel_button)
        val signInButton = dialogView.findViewById<Button>(R.id.sign_in_button)

        // 设置按钮事件
        cancelButton.setOnClickListener { v: View? -> alertDialog.dismiss() }

        signInButton.setOnClickListener { v: View? ->
            // 获取用户名和密码
            val user = username.text.toString()
            val pass = password.text.toString()
            // 在此处理登录逻辑
            alertDialog.dismiss()
        }

        // 显示 AlertDialog
        alertDialog.show()


    }
}
*/


/*
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

*/
/*动物头像*//*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 数据源
        val data: MutableList<Map<String, Any?>> = ArrayList()
        val images = intArrayOf(
            R.drawable.lion,     // 正确：不要加 .jpg 后缀
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant
        )

        val names = arrayOf("Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant")

        for (i in images.indices) {
            val item: MutableMap<String, Any?> = HashMap()
            item["text"] = names[i]
            item["image"] = images[i]

            data.add(item)
        }

        // SimpleAdapter 适配器
        val adapter = SimpleAdapter(
            this, data, R.layout.list_item,
            arrayOf<String>("image", "text"), intArrayOf(R.id.image, R.id.text)
        )

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        // 列表项点击事件，显示 Toast
        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    this@MainActivity,
                    names[position],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}
*/


/*
package com.example.linearlayout3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//前两次实验
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}*/
