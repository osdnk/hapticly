package osdnk.hapticly.haptic

import android.content.Context
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

    fun deprecationDialog(version: Int, context: Context) {
        val builder = AlertDialog.Builder(context!!)
        builder.setMessage("Available since API " + version.toString())
                .setTitle("Can't handle").create().show()
        builder.create()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.sample_fragment,
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




        return view
    }
}