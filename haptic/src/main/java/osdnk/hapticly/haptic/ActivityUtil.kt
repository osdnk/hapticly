package osdnk.hapticly.haptic

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog


object ActivityUtil {
    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

    fun deprecationDialog(version: Int, context: Context) {
        val builder = AlertDialog.Builder(context!!)
        builder.setMessage("Available since API " + version.toString())
                .setTitle("Can't handle").create().show()
        builder.create()
    }
}