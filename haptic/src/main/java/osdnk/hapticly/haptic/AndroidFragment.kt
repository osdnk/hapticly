package osdnk.hapticly.haptic

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.HapticFeedbackConstants.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import osdnk.hapticly.haptic.ActivityUtil.deprecationDialog

class AndroidFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.android_fragment,
                container, false)

        val clockTick: Button = view!!.findViewById(R.id.clock_tick)
        clockTick.setOnClickListener {
            view.performHapticFeedback(CLOCK_TICK)
        }

        val contextClick: Button = view.findViewById(R.id.context_click)
        contextClick.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.performHapticFeedback(CONTEXT_CLICK)
            } else {
                deprecationDialog(Build.VERSION_CODES.M, context!!)
            }
        }

        val keyboardPress: Button = view.findViewById(R.id.keyboard_press)
        keyboardPress.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(KEYBOARD_PRESS)
            } else {
                deprecationDialog(Build.VERSION_CODES.O_MR1, context!!)
            }
        }

        val keyboardRelease: Button = view.findViewById(R.id.keyboard_release)
        keyboardRelease.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(KEYBOARD_RELEASE)
            } else {
                deprecationDialog(Build.VERSION_CODES.O_MR1, context!!)
            }
        }

        val keyboardTap: Button = view.findViewById(R.id.keyboard_tap)
        keyboardTap.setOnClickListener {
            view.performHapticFeedback(KEYBOARD_TAP)
        }

        val longPress: Button = view.findViewById(R.id.long_press)
        longPress.setOnClickListener {
            view.performHapticFeedback(LONG_PRESS)
        }

        val textHandleMove: Button = view.findViewById(R.id.text_handle_move)
        textHandleMove.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(KEYBOARD_RELEASE)
            } else {
                deprecationDialog(Build.VERSION_CODES.O_MR1, context!!)
            }
        }

        val virtualKey: Button = view.findViewById(R.id.virtual_key)
        virtualKey.setOnClickListener {
            view.performHapticFeedback(VIRTUAL_KEY)
        }

        val virtualKeyRelease: Button = view.findViewById(R.id.virtual_key_release)
        virtualKeyRelease.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(VIRTUAL_KEY_RELEASE)
            } else {
                deprecationDialog(Build.VERSION_CODES.O_MR1, context!!)
            }
        }
        return view
    }
}