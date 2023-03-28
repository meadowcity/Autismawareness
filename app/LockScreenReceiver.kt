class LockScreenReceiver {
    package com.asdidapp.autismawareness

    import android.app.admin.DeviceAdminReceiver
    import android.content.Context
    import android.content.Intent
    import com.asdidapp.utils.LockScreenMessage

    class LockScreenReceiver : DeviceAdminReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            super.onReceive(context, intent)

            if (intent.action == Intent.ACTION_SCREEN_OFF) {
                val lockIntent = Intent(context, LockScreenActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra("phoneNumber", LockScreenMessage.getPhoneNumber(context))
                    putExtra("name", LockScreenMessage.getName(context))
                    putExtra("emergencyContact", LockScreenMessage.getEmergencyContact(context))
                }
                context.startActivity(lockIntent)
            }
        }
    }

}
