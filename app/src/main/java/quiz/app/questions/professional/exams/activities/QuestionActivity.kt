package quiz.app.questions.professional.exams.activities

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import quiz.app.questions.professional.exams.databinding.ActivityQuestionBinding
import quiz.app.questions.professional.exams.fragments.QuestionPageFragment


private const val NUM_PAGES = 5

class QuestionActivity : FragmentActivity() {

    lateinit var binding: ActivityQuestionBinding
    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        viewPager = binding.pager
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        initListeners();
    }

    private fun initListeners() {
        binding.btnNext.setOnClickListener {
            if (viewPager.currentItem == NUM_PAGES) {
                Toast.makeText(this, "Thats all", Toast.LENGTH_LONG).show();

            } else {
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }

        binding.btnPrevious.setOnClickListener{
            if (viewPager.currentItem == 0) {
                Toast.makeText(this, "No More", Toast.LENGTH_LONG).show();
            } else {
                // Otherwise, select the previous step.
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }
    }


override fun onBackPressed() {
    if (viewPager.currentItem == 0) {
        // If the user is currently looking at the first step, allow the system to handle the
        // Back button. This calls finish() on this activity and pops the back stack.
        super.onBackPressed()
    } else {
        // Otherwise, select the previous step.
        viewPager.currentItem = viewPager.currentItem - 1
    }
}

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment = QuestionPageFragment(position)
}
}