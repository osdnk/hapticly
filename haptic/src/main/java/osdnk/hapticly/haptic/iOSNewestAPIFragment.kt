package osdnk.hapticly.haptic

import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v4.app.Fragment
import android.view.HapticFeedbackConstants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import osdnk.hapticly.haptic.ActivityUtil.deprecationDialog

class iOSNewestAPIFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.ios,
                container, false)

        val notificationError: Button = view.findViewById(R.id.notification_error)
        notificationError.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val vibe:Vibrator = activity?.getSystemService(VIBRATOR_SERVICE) as Vibrator
                var effect: VibrationEffect = VibrationEffect.createWaveform(
                        longArrayOf(0, 30, 40, 30, 40, 30), -1

                )
                vibe.vibrate(effect)

            } else {
                deprecationDialog(Build.VERSION_CODES.O, context!!)
            }
        }

        val notificationWarning: Button = view.findViewById(R.id.notification_warning)
        notificationWarning.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val vibe:Vibrator = activity?.getSystemService(VIBRATOR_SERVICE) as Vibrator
                var effect: VibrationEffect = VibrationEffect.createWaveform(
                        longArrayOf(0, 30, 40, 30),
                        intArrayOf(0, 120, 0, 250),
                        -1

                )
                vibe.vibrate(effect)

            } else {
                deprecationDialog(Build.VERSION_CODES.O, context!!)
            }
        }

        val notificationSuccess: Button = view.findViewById(R.id.notification_success)
        notificationSuccess.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val vibe:Vibrator = activity?.getSystemService(VIBRATOR_SERVICE) as Vibrator
                var effect: VibrationEffect = VibrationEffect.createWaveform(
                        longArrayOf(0, 40, 55, 20),
                        intArrayOf(0, 250, 0, 120),
                        -1

                )
                vibe.vibrate(effect)

            } else {
                deprecationDialog(Build.VERSION_CODES.O, context!!)
            }
        }


        return view
    }
}