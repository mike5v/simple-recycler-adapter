package it.mike5v.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.mike5v.example.item.HeaderItem
import it.mike5v.example.item.ElementItem
import it.mike5v.simplerecycleradapter.SimpleRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Michele Quintavalle
 */
class MainActivity : AppCompatActivity() {

    private val adapter by lazy { SimpleRecyclerAdapter() }

    private val header = Header("https://img.purch.com/w/660/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzEwNC84MTkvb3JpZ2luYWwvY3V0ZS1raXR0ZW4uanBn")
    private val elements = listOf(
            Element("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450", "Hello... I'm hungry!"),
            Element("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450", "Hello... I'm hungry!"),
            Element("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450", "Hello... I'm hungry!"),
            Element("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450", "Hello... I'm hungry!"),
            Element("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450", "Hello... I'm hungry!")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
        adapter.clear()
        adapter.add(HeaderItem(header))
        elements.map {
            adapter.add(ElementItem(it))
        }
    }

    private fun setupRecycler() {
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}

data class Header(
        val imageUrl: String
)

data class Element(
        val imageUrl: String,
        val description: String
)