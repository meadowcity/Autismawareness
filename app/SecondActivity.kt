class SecondActivity {
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.TextView

    class SecondActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_second)

            val name = intent.getStringExtra("name")

            val textView: TextView = findViewById(R.id.name_text_view)
            textView.text = "My Name is $name\nI have been medically diagnosed with Autism\nTend to interpret statements literally\nAppear rude or sound tactless\nespecially when anxious or confused\nPlease contact:"
        }
    }

}
