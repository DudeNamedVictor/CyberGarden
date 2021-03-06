package com.example.cybergarden.presenter.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.R
import com.example.cybergarden.data.QuestionItem
import com.example.cybergarden.databinding.QuestionsLayoutFragmentBinding


class QuestionsFragment : Fragment() {

    private lateinit var binding: QuestionsLayoutFragmentBinding
    private val data = mutableListOf<QuestionItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuestionsLayoutFragmentBinding.inflate(inflater, container, false)
        binding.toolbar.apply {
            toolbarTitle.setText(R.string.faq)
            back.visibility = View.VISIBLE
            back.setOnClickListener {
                findNavController().popBackStack()
            }
        }
        initializeData()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = QuestionsAdapter(data)

        binding.recyclerView.addOnItemTouchListener(
            QuestionsAdapter.RecyclerItemClickListener(binding.recyclerView,
                object : QuestionsAdapter.RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        data[position].hideItem = !data[position].hideItem
                        binding.recyclerView.adapter?.notifyDataSetChanged()
                    }
                })
        )

        return binding.root
    }

    private fun initializeData() {
        data.add(
            QuestionItem(
                "Какие документы необходимы для поступления?", "Обязательные документы:\n" +
                        "ㅡ паспорт (2-3 стр.);\n" +
                        "ㅡ документ об образовании (аттестат или диплом) с приложением;\n" +
                        "ㅡ СНИЛС;\n" +
                        "ㅡ 2 фотографии размером 3х4 см (для сдающих вступительные испытания).\n" +
                        ".\n" +
                        " \n" +
                        "Дополнительно вы можете предоставить:\n" +
                        "1. документы, подтверждающие наличие индивидуальных достижений, для начисления дополнительных баллов;\n" +
                        "2. документы, подтверждающие наличие особых прав;\n" +
                        "3. договор о целевом обучении;\n" +
                        "4. диплом олимпиады для получения льгот;\n" +
                        "5. копию трудовой книжки или справку с места работы (для поступающих на заочную форму обучения)."
            )
        )
        data.add(
            QuestionItem(
                "Как подать документы онлайн?",
                "В соответствии с Правилами приема Вы можете подать документы через личный кабинет абитуриента или отправить сканы требуемых документов по электронной почте."
            )
        )
        data.add(
            QuestionItem(
                "Действуют ли результаты ЕГЭ прошлых лет?",
                "Результаты ЕГЭ действуют в течение 4 лет, следующих за годом сдачи экзамена. В 2021 году действуют результаты ЕГЭ 2017-2021 гг. При наличии нескольких действующих результатов ЕГЭ разных лет по одному и тому же предмету абитуриент использует лучший результат."
            )
        )
        data.add(
            QuestionItem(
                "В какой форме проводятся вступительные испытания?",
                "Вступительные испытания по математике, физике и информатике проводятся в форме тестирования. По русскому языку абитуриенты пишут изложение."
            )
        )
        data.add(
            QuestionItem(
                "Я не сдаю ЕГЭ по физике. Можно ли мне будет сдать этот предмет в университете?",
                "Школьники поступают только по результатам ЕГЭ. Однако, в приемную кампанию 2021 будет реализовано существенное изменение в этой части: абитуриентам теперь предоставлено право выбора одного из предметов, результаты которых необходимо предъявить в приемную комиссию. При поступлении в наш Университет на любое направление вы можете сдать либо физику, либо информатику. Можете сдать в школе оба предмета, а затем выбрать предмет с более высоким баллом ЕГЭ."
            )
        )
        data.add(
            QuestionItem(
                "Как лучше подготовиться к вступительным испытаниям?",
                "Для подготовки к вступительным испытаниям Вы можете записаться на десятидневные подготовительные курсы, которые проходят в начале июля."
            )
        )
        data.add(
            QuestionItem(
                "Как проводится конкурс на бюджетные места?",
                "Конкурс на бюджетные места проводится строго на основании поданных заявлений о согласии на зачисление. Заявление о согласии на зачисление подаётся на одно направление и только в один вуз. При подаче заявления абитуриент представляет оригинал документа об образовании либо уникальную информацию о документе об образовании посредством ЕПГУ.\n" +
                        "На основании поданных согласий на зачисление составляются ранжированные списки абитуриентов по каждому направлению. Зачислению подлежат абитуриенты, набравшие наибольшее число баллов до заполнения выделенного на соответствующее направление числа мест."
            )
        )
        data.add(
            QuestionItem(
                "Как учитываются индивидуальные достижения?",
                "Индивидуальные достижения учитываются на основании документов, подтверждающих эти достижения. Полученные баллы добавляются к суммарным конкурсным баллам за вступительные испытания. При приеме на обучение по программам бакалавриата поступающему может быть начислено за индивидуальные достижения не более 10 баллов суммарно."
            )
        )
        data.add(
            QuestionItem(
                "Как будет проходить зачисление в 2021 году?",
                "Зачисление на очную форму обучения будет происходит в два этапа:\n" +
                        "1 этап – зачисление льготных категорий абитуриентов: особая квота, целевая квота;\n" +
                        "2 этап – зачисление на оставшиеся вакантными бюджетные места абитуриентов, представивших ОРИГИНАЛЫ документов об образовании и выразивших согласие на зачисление.\n" +
                        "Представить согласие на зачисление в СКФ МТУСИ можно не более 10 раз."
            )
        )
        data.add(
            QuestionItem(
                "Сколько нужно баллов, чтобы поступить на платной основе?",
                "Для поступления на платной основе достаточно набрать по каждому предмету (математика, русский язык, физика или информатика) не менее 40 баллов.\n" +
                        "Обратите внимание: зачисление на платные места возможно только после заключения договора и подтверждения факта оплаты первого семестра обучения."
            )
        )

    }
}