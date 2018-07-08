package osdnk.hapticly.haptic

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class ArticleFragment : Fragment() {
    class ExampleFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.activity_main, container, false)
        }
    }
}
