package com.example.android.cactus.presentation.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentVerbBinding
import com.example.android.cactus.domain.model.Vocabulary
import com.example.android.cactus.domain.model.VocabularyCategory
import com.example.android.cactus.presentation.adapter.VocabularyCategoryAdapter
import com.example.android.cactus.presentation.adapter.WordAdapter

class VerbFragment : Fragment(R.layout.fragment_verb) {
    private var _binding: FragmentVerbBinding? = null
    private val binding get() = _binding!!
    private var verbAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVerbBinding.bind(view)
        binding.buttonback.setOnClickListener {
            activity?.onBackPressed()
        }
        val categories = listOf(
            context?.let {
                VocabularyCategory(
                    title = "знать",
                    meaning = it.getString(R.string.z_nat) ,
                    items = listOf(
                        context?.let { Vocabulary("знать", it.getString(R.string.z_nat), R.mipmap.z_nat, R.raw.z_nat) },
                        context?.let { Vocabulary("я знаю", it.getString(R.string.z_naty), R.mipmap.i, R.raw.z_naty) },
                        context?.let { Vocabulary("ты знаешь", it.getString(R.string.z_natyu), R.mipmap.you, R.raw.z_natyu) },
                        context?.let { Vocabulary("он/она знает", it.getString(R.string.z_natye), R.mipmap.she, R.raw.z_natye) },
                        context?.let { Vocabulary("мы знаем", it.getString(R.string.z_natw), R.mipmap.we, R.raw.z_natw) },
                        context?.let { Vocabulary("вы знаете", it.getString(R.string.z_natypl), R.mipmap.youu, R.raw.z_natypl) },
                        context?.let { Vocabulary("они знают", it.getString(R.string.z_natt), R.mipmap.they, R.raw.z_natt) }

                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "жить",
                    meaning = it.getString(R.string.z_zhit),
                    items = listOf(
                        Vocabulary("жить", it.getString(R.string.z_zhit), R.mipmap.z_zhit, R.raw.z_zhit),
                        Vocabulary("я живу", it.getString(R.string.z_zhity), R.mipmap.i, R.raw.z_zhity),
                        Vocabulary("ты живёшь", it.getString(R.string.z_zhitu), R.mipmap.you, R.raw.z_zhitu),
                        Vocabulary("он/она живёт", it.getString(R.string.z_zhite), R.mipmap.she, R.raw.z_zhite),
                        Vocabulary("мы живём", it.getString(R.string.z_zhitw), R.mipmap.we, R.raw.z_zhitw),
                        Vocabulary("вы живёте", it.getString(R.string.z_zhitpl), R.mipmap.youu, R.raw.z_zhitpl),
                        Vocabulary("они живут", it.getString(R.string.z_zhitt), R.mipmap.they, R.raw.z_zhitt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "любить",
                    meaning = it.getString(R.string.z_lovet),
                    items = listOf(
                        Vocabulary("любить", it.getString(R.string.z_lovet), R.mipmap.z_lovet, R.raw.z_lovet),
                        Vocabulary("я люблю", it.getString(R.string.z_lovety), R.mipmap.i, R.raw.z_lovety),
                        Vocabulary("ты любишь", it.getString(R.string.z_lovetu), R.mipmap.you, R.raw.z_lovetu),
                        Vocabulary("он/она любит", it.getString(R.string.z_lovete), R.mipmap.she, R.raw.z_lovete),
                        Vocabulary("мы любим", it.getString(R.string.z_lovetw), R.mipmap.we, R.raw.z_lovetw),
                        Vocabulary("вы любите", it.getString(R.string.z_lovetpl), R.mipmap.youu, R.raw.z_lovetpl),
                        Vocabulary("они любят", it.getString(R.string.z_lovett), R.mipmap.they, R.raw.z_lovett)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "работать",
                    meaning = it.getString(R.string.z_work),
                    items = listOf(
                        Vocabulary("работать", it.getString(R.string.z_work), R.mipmap.z_work, R.raw.z_work),
                        Vocabulary("я работаю", it.getString(R.string.z_worky), R.mipmap.i, R.raw.z_worky),
                        Vocabulary("ты работаешь", it.getString(R.string.z_worku), R.mipmap.you, R.raw.z_worku),
                        Vocabulary("он/она работает", it.getString(R.string.z_worke), R.mipmap.she, R.raw.z_worke),
                        Vocabulary("мы работаем", it.getString(R.string.z_workw), R.mipmap.we, R.raw.z_workw),
                        Vocabulary("вы работаете", it.getString(R.string.z_workpl), R.mipmap.youu, R.raw.z_workpl),
                        Vocabulary("они работают", it.getString(R.string.z_workt), R.mipmap.they, R.raw.z_workt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "ждать",
                    meaning = it.getString(R.string.z_wait),
                    items = listOf(
                        Vocabulary("ждать", it.getString(R.string.z_wait), R.mipmap.z_wait, R.raw.z_wait),
                        Vocabulary("я жду", it.getString(R.string.z_waity), R.mipmap.i, R.raw.z_waity),
                        Vocabulary("ты ждёшь", it.getString(R.string.z_waitu), R.mipmap.you, R.raw.z_waitu),
                        Vocabulary("он/она ждёт", it.getString(R.string.z_waite), R.mipmap.she, R.raw.z_waite),
                        Vocabulary("мы ждём", it.getString(R.string.z_waitw), R.mipmap.we, R.raw.z_waitw),
                        Vocabulary("вы ждёте", it.getString(R.string.z_waitpl), R.mipmap.youu, R.raw.z_waitpl),
                        Vocabulary("они ждут", it.getString(R.string.z_waitt), R.mipmap.they, R.raw.z_waitt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "говорить",
                    meaning = it.getString(R.string.z_speak),
                    items = listOf(
                        Vocabulary("говорить", it.getString(R.string.z_speak), R.mipmap.z_speak, R.raw.z_speak),
                        Vocabulary("я говорю", it.getString(R.string.z_speaky), R.mipmap.i, R.raw.z_speaky),
                        Vocabulary("ты говоришь", it.getString(R.string.z_speaku), R.mipmap.you, R.raw.z_speaku),
                        Vocabulary("он/она говорит", it.getString(R.string.z_speake), R.mipmap.she, R.raw.z_speake),
                        Vocabulary("мы говорим", it.getString(R.string.z_speakw), R.mipmap.we, R.raw.z_speakw),
                        Vocabulary("вы говорите", it.getString(R.string.z_speakpl), R.mipmap.youu, R.raw.z_speakpl),
                        Vocabulary("они говорят", it.getString(R.string.z_speakt), R.mipmap.they, R.raw.z_speakt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "думать",
                    meaning = it.getString(R.string.z_think),
                    items = listOf(
                        Vocabulary("думать", it.getString(R.string.z_think), R.mipmap.z_think, R.raw.z_think),
                        Vocabulary("я думаю", it.getString(R.string.z_thinky), R.mipmap.i, R.raw.z_thinky),
                        Vocabulary("ты думаешь", it.getString(R.string.z_thinku), R.mipmap.you, R.raw.z_thinku),
                        Vocabulary("он/она думает", it.getString(R.string.z_thinke), R.mipmap.she, R.raw.z_thinke),
                        Vocabulary("мы думаем", it.getString(R.string.z_thinkw), R.mipmap.we, R.raw.z_thinkw),
                        Vocabulary("вы думаете", it.getString(R.string.z_thinkpl), R.mipmap.youu, R.raw.z_thinkpl),
                        Vocabulary("они думают", it.getString(R.string.z_thinkt), R.mipmap.they, R.raw.z_thinkt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "понимать",
                    meaning = it.getString(R.string.z_understand),
                    items = listOf(
                        Vocabulary("понимать", it.getString(R.string.z_understand), R.mipmap.z_understand, R.raw.z_understand),
                        Vocabulary("я понимаю", it.getString(R.string.z_understandy), R.mipmap.i, R.raw.z_understandy),
                        Vocabulary("ты понимаешь", it.getString(R.string.z_understandu), R.mipmap.you, R.raw.z_understandu),
                        Vocabulary("он/она понимает", it.getString(R.string.z_understande), R.mipmap.she, R.raw.z_understande),
                        Vocabulary("мы понимаем", it.getString(R.string.z_understandw), R.mipmap.we, R.raw.z_understandw),
                        Vocabulary("вы понимаете", it.getString(R.string.z_understandpl), R.mipmap.youu, R.raw.z_understandpl),
                        Vocabulary("они понимают", it.getString(R.string.z_understandt), R.mipmap.they, R.raw.z_understandt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "мочь",
                    meaning = it.getString(R.string.z_can),
                    items = listOf(
                        Vocabulary("мочь", it.getString(R.string.z_can), R.mipmap.z_can, R.raw.z_can),
                        Vocabulary("я могу", it.getString(R.string.z_cany), R.mipmap.i, R.raw.z_cany),
                        Vocabulary("ты можешь", it.getString(R.string.z_canu), R.mipmap.you, R.raw.z_canu),
                        Vocabulary("он/она может", it.getString(R.string.z_cane), R.mipmap.she, R.raw.z_cane),
                        Vocabulary("мы можем", it.getString(R.string.z_canw), R.mipmap.we, R.raw.z_canw),
                        Vocabulary("вы можете", it.getString(R.string.z_canpl), R.mipmap.youu, R.raw.z_canpl),
                        Vocabulary("они могут", it.getString(R.string.z_cant), R.mipmap.they, R.raw.z_cant)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "хотеть",
                    meaning = it.getString(R.string.z_want),
                    items = listOf(
                        Vocabulary("хотеть", it.getString(R.string.z_want), R.mipmap.z_want, R.raw.z_want),
                        Vocabulary("я хочу", it.getString(R.string.z_wanty), R.mipmap.i, R.raw.z_wanty),
                        Vocabulary("ты хочешь", it.getString(R.string.z_wantu), R.mipmap.you, R.raw.z_wantu),
                        Vocabulary("он/она хочет", it.getString(R.string.z_wante), R.mipmap.she, R.raw.z_wante),
                        Vocabulary("мы хотим", it.getString(R.string.z_wantw), R.mipmap.we, R.raw.z_wantw),
                        Vocabulary("вы хотите", it.getString(R.string.z_wantpl), R.mipmap.youu, R.raw.z_wantpl),
                        Vocabulary("они хотят", it.getString(R.string.z_wantt), R.mipmap.they, R.raw.z_wantt)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "делать",
                    meaning = it.getString(R.string.z_do),
                    items = listOf(
                        Vocabulary("делать", it.getString(R.string.z_do), R.mipmap.z_do, R.raw.z_do),
                        Vocabulary("я делаю", it.getString(R.string.z_doy), R.mipmap.i, R.raw.z_doy),
                        Vocabulary("ты делаешь", it.getString(R.string.z_dou), R.mipmap.you, R.raw.z_dou),
                        Vocabulary("он/она делает", it.getString(R.string.z_doe), R.mipmap.she, R.raw.z_doe),
                        Vocabulary("мы делаем", it.getString(R.string.z_dow), R.mipmap.we, R.raw.z_dow),
                        Vocabulary("вы делаете", it.getString(R.string.z_dopl), R.mipmap.youu, R.raw.z_dopl),
                        Vocabulary("они делают", it.getString(R.string.z_dot), R.mipmap.they, R.raw.z_dot)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "брать",
                    meaning = it.getString(R.string.z_take),
                    items = listOf(
                        Vocabulary("брать", it.getString(R.string.z_take), R.mipmap.z_take, R.raw.z_take),
                        Vocabulary("я беру", it.getString(R.string.z_takey), R.mipmap.i, R.raw.z_takey),
                        Vocabulary("ты берёшь", it.getString(R.string.z_takeu), R.mipmap.you, R.raw.z_takeu),
                        Vocabulary("он/она берёт", it.getString(R.string.z_takee), R.mipmap.she, R.raw.z_takee),
                        Vocabulary("мы берём", it.getString(R.string.z_takew), R.mipmap.we, R.raw.z_takew),
                        Vocabulary("вы берёте", it.getString(R.string.z_takepl), R.mipmap.youu, R.raw.z_takepl),
                        Vocabulary("они берут", it.getString(R.string.z_taket), R.mipmap.they, R.raw.z_taket)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "давать",
                    meaning = it.getString(R.string.z_give),
                    items = listOf(
                        Vocabulary("давать", it.getString(R.string.z_give), R.mipmap.z_give, R.raw.z_give),
                        Vocabulary("я даю", it.getString(R.string.z_givey), R.mipmap.i, R.raw.z_givey),
                        Vocabulary("ты даёшь", it.getString(R.string.z_giveu), R.mipmap.you, R.raw.z_giveu),
                        Vocabulary("он/она даёт", it.getString(R.string.z_givee), R.mipmap.she, R.raw.z_givee),
                        Vocabulary("мы даём", it.getString(R.string.z_givew), R.mipmap.we, R.raw.z_givew),
                        Vocabulary("вы даёте", it.getString(R.string.z_givepl), R.mipmap.youu, R.raw.z_givepl),
                        Vocabulary("они дают", it.getString(R.string.z_givet), R.mipmap.they, R.raw.z_givet)
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "помнить",
                    meaning = it.getString(R.string.z_remember),
                    items = listOf(
                        Vocabulary("помнить", it.getString(R.string.z_remember), R.mipmap.z_remember, R.raw.z_remember),
                        Vocabulary("я помню", it.getString(R.string.z_remembery), R.mipmap.i, R.raw.z_remembery),
                        Vocabulary("ты помнишь", it.getString(R.string.z_rememberu), R.mipmap.you, R.raw.z_rememberu),
                        Vocabulary("он/она помнит", it.getString(R.string.z_remembere), R.mipmap.she, R.raw.z_remembere),
                        Vocabulary("мы помним", it.getString(R.string.z_rememberw), R.mipmap.we, R.raw.z_rememberw),
                        Vocabulary("вы помните", it.getString(R.string.z_rememberpl), R.mipmap.youu, R.raw.z_rememberpl),
                        Vocabulary("они помнят", it.getString(R.string.z_remembert), R.mipmap.they, R.raw.z_remembert)
                    )
                )
            }
        )

        // Gán adapter cho RecyclerView dọc
        binding.recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = VocabularyCategoryAdapter(categories) { vocabulary ->
                MediaPlayer.create(requireContext(), vocabulary.soundRes).start()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
