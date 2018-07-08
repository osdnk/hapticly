package osdnk.hapticly.haptic

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


object ActivityUtil {
    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }
}