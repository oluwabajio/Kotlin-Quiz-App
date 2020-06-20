package quiz.app.questions.professional.exams.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import quiz.app.questions.professional.exams.databinding.FragmentQuestionPageBinding
import quiz.app.questions.professional.exams.models.Question
import quiz.app.questions.professional.exams.models.Supplier


class QuestionPageFragment(val position: Int) : Fragment() {
   lateinit var binding: FragmentQuestionPageBinding
    lateinit var question: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionPageBinding.inflate(inflater,container,false)
        val view = binding.root

       //Toast.makeText(activity, "position is "+ position, Toast.LENGTH_LONG).show()
         question = Supplier.questions[position]

        initViews(question);
        return view

    }

    private fun initViews(question: Question) {
        binding.tvQuestion.text = question.currentQuestion
        binding.tvOptionA.text = question.optionA
        binding.tvOptionB.text = question.optionB
        binding.tvOptionC.text = question.optionC
        binding.tvOptionD.text = question.optionD

        binding.tvOptionA.setOnClickListener {
            getResult("a")
        }
        binding.tvOptionB.setOnClickListener {
            getResult("b")
        }
        binding.tvOptionC.setOnClickListener {
            getResult("c")
        }
        binding.tvOptionD.setOnClickListener {
            getResult("d")
        }
    }

    private fun getResult(selection: String) {
        if (selection.equals(question.answer, ignoreCase = true)) {
            Toast.makeText(activity, "You Are Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(activity, "You Are Wrong", Toast.LENGTH_LONG).show();
        }


    }
}