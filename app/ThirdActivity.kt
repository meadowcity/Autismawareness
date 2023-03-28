class ThirdActivity {
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText

    class ThirdActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_third)

            val phoneNumberField: EditText = findViewById(R.id.phone_number_field)
            val nextButton: Button = findViewById(R.id.next_button_3)
            nextButton.setOnClickListener {
                val phoneNumber = phoneNumberField.text.toString()
                val intent = Intent(this@ThirdActivity, LockScreenActivity::class.java)
                intent.putExtra("phoneNumber", phoneNumber)
                startActivity(intent)
            }
        }
    }

}
