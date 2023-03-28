class LockScreenActivity {
    package com.asdidapp.autismawareness

    import android.Manifest
    import android.content.Intent
    import android.content.pm.PackageManager
    import android.os.Bundle
    import android.provider.Settings
    import android.widget.Button
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity

    class LockScreenActivity : AppCompatActivity() {

        private val PERMISSION_REQUEST_CODE = 123

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_lock_screen)

            val phoneNumber = intent.getStringExtra("phoneNumber")
            val message = "My Name is ${intent.getStringExtra("name")}\nI have been medically diagnosed with Autism\nTend to interpret statements literally\nAppear rude or sound tactless\nespecially when anxious or confused\nPlease contact: ${intent.getStringExtra("emergencyContact")} at $phoneNumber"

            val button = findViewById<Button>(R.id.permission_button)
            button.setOnClickListener {
                if (checkSelfPermission(Manifest.permission.SHOW_WHEN_LOCKED) == PackageManager.PERMISSION_GRANTED) {
                    startLockScreenService(message)
                } else {
                    requestPermission()
                }
            }
        }

        private fun startLockScreenService(message: String) {
            val intent = Intent(this, LockScreenService::class.java).apply {
                putExtra("message", message)
            }
            startService(intent)
            finish()
        }

        private fun requestPermission() {
            if (shouldShowRequestPermissionRationale(Manifest.permission.SHOW_WHEN_LOCKED)) {
                Toast.makeText(this, "Permission is needed to show message on lock screen", Toast.LENGTH_SHORT).show()
            }
            requestPermissions(arrayOf(Manifest.permission.SHOW_WHEN_LOCKED), PERMISSION_REQUEST_CODE)
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            if (requestCode == PERMISSION_REQUEST_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLockScreenService("Message")
            } else {
                Toast.makeText(this, "Permission denied, please grant the permission to use this feature.", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Settings.ACTION_APPLICATION_DETAILS_SETTINGS.toUri()
                    addCategory(Intent.CATEGORY_DEFAULT)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                }
                startActivity(intent)
            }
        }
    }

}