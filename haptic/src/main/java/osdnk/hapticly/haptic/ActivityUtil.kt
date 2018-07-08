package osdnk.hapticly.haptic

import android.app.Fragment
import android.app.FragmentManager

class ActivityUtil {
    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }
}