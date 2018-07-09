package osdnk.hapticly.haptic

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.HapticFeedbackConstants.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class AndroidFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val version = android.os.Build.VERSION.CODENAME
        // Inflate the layout for this fragment

        val view = inflater?.inflate(R.layout.sample_fragment,
                container, false)

        val clockTick: Button = view!!.findViewById(R.id.clock_tick)
        clockTick.setOnClickListener {
            view.performHapticFeedback(CLOCK_TICK)
        }

        val contextClick: Button = view.findViewById(R.id.context_click)
        contextClick.setOnClickListener {
            view.performHapticFeedback(CONTEXT_CLICK)
        }


        val keyboardPress: Button = view.findViewById(R.id.keyboard_press)
        keyboardPress.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                view.performHapticFeedback(KEYBOARD_PRESS)
            } else {
                val builder = AlertDialog.Builder(activity)
                builder.setMessage("Available since 27")
                        .setTitle("Can't handle").create().show()
                val dialog = builder.create()
            }
        }




        return view
    }
}