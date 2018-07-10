package osdnk.hapticly.haptic

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var fragmentManager = getSupportFragmentManager()
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.android -> {
                message.setText(R.string.title_dashboard)
                ActivityUtil.addFragmentToActivity(fragmentManager, AndroidFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.newest_ios -> {
                ActivityUtil.addFragmentToActivity(fragmentManager, iOSNewestAPIFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
