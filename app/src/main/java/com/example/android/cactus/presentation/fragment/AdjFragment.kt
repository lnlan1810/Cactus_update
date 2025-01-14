package com.example.android.cactus.presentation.fragment

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentAdjBinding
import com.example.android.cactus.domain.model.Vocabulary
import com.example.android.cactus.domain.model.VocabularyCategory
import com.example.android.cactus.domain.repository.AdjRepository
import com.example.android.cactus.domain.repository.WordRepository
import com.example.android.cactus.presentation.adapter.VocabularyCategoryAdapter
import com.example.android.cactus.presentation.adapter.WordAdapter

class AdjFragment : Fragment(R.layout.fragment_adj) {
    private var _binding: FragmentAdjBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAdjBinding.bind(view)
        binding.buttonback.setOnClickListener {
            activity?.onBackPressed()
        }
        val categories = listOf(
            context?.let {
                VocabularyCategory(
                    title = "Описание внешности, размеров и веса",
                    meaning = it.getString(R.string.adj_size),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Маленький",
                                it.getString(R.string.small),
                                R.mipmap.small,
                                R.raw.small
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Большой",
                                it.getString(R.string.big),
                                R.mipmap.big,
                                R.raw.big
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Огромный",
                                it.getString(R.string.huge),
                                R.mipmap.huge,
                                R.raw.huge
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Высокий",
                                it.getString(R.string.tall_high),
                                R.mipmap.tall_high,
                                R.raw.tall_high
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Низкий",
                                it.getString(R.string.low_short),
                                R.mipmap.low_short,
                                R.raw.low_short
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Новый",
                                it.getString(R.string.new_adj),
                                R.mipmap.new_adj,
                                R.raw.new_adj
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Полный",
                                it.getString(R.string.full),
                                R.mipmap.full,
                                R.raw.full
                            )
                        },

                        context?.let {
                            Vocabulary(
                                "Пустой",
                                it.getString(R.string.empty),
                                R.mipmap.empty,
                                R.raw.empty
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Тяжёлый",
                                it.getString(R.string.heavy),
                                R.mipmap.heavy,
                                R.raw.heavy
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Лёгкий",
                                it.getString(R.string.light_easy),
                                R.mipmap.light_easy,
                                R.raw.light_easy
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Длинный",
                                it.getString(R.string.long_adj),
                                R.mipmap.long_adj,
                                R.raw.long_adj
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Короткий",
                                it.getString(R.string.short_adj),
                                R.mipmap.short_adj,
                                R.raw.short_adj
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Широкий",
                                it.getString(R.string.wide_broad),
                                R.mipmap.wide_broad,
                                R.raw.wide_broad
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Узкий",
                                it.getString(R.string.narrow_tight),
                                R.mipmap.narrow_tight,
                                R.raw.narrow_tight
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Чистый",
                                it.getString(R.string.clean),
                                R.mipmap.clean,
                                R.raw.clean
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Грязный",
                                it.getString(R.string.dirty),
                                R.mipmap.dirty,
                                R.raw.dirty
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Тонкий",
                                it.getString(R.string.thin),
                                R.mipmap.thin,
                                R.raw.thin
                            )
                        }

                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Русские прилагательные для описания человека",
                    meaning = it.getString(R.string.adj_describe),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Молодой",
                                it.getString(R.string.young),
                                R.mipmap.young,
                                R.raw.young
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Старый",
                                it.getString(R.string.old),
                                R.mipmap.old,
                                R.raw.old
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Сильный",
                                it.getString(R.string.strong),
                                R.mipmap.strong,
                                R.raw.strong
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Слабый",
                                it.getString(R.string.weak),
                                R.mipmap.weak,
                                R.raw.weak
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Страшный",
                                it.getString(R.string.scary),
                                R.mipmap.scary,
                                R.raw.scary
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Красивый",
                                it.getString(R.string.beautiful),
                                R.mipmap.beautiful,
                                R.raw.beautiful
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Милый",
                                it.getString(R.string.cute),
                                R.mipmap.cute,
                                R.raw.cute
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Худой",
                                it.getString(R.string.skinny),
                                R.mipmap.skinny,
                                R.raw.skinny
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Толстый",
                                it.getString(R.string.fat),
                                R.mipmap.fat,
                                R.raw.fat
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Богатый",
                                it.getString(R.string.rich),
                                R.mipmap.rich,
                                R.raw.rich
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Бедный",
                                it.getString(R.string.poor),
                                R.mipmap.poor,
                                R.raw.poor
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Больной",
                                it.getString(R.string.ill),
                                R.mipmap.ill,
                                R.raw.ill
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Здоровый",
                                it.getString(R.string.healthy),
                                R.mipmap.healthy,
                                R.raw.healthy
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Старший",
                                it.getString(R.string.older),
                                R.mipmap.older,
                                R.raw.older
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Младший",
                                it.getString(R.string.younger),
                                R.mipmap.younger,
                                R.raw.younger
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Детский",
                                it.getString(R.string.kids),
                                R.mipmap.kids,
                                R.raw.kids
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Взрослый",
                                it.getString(R.string.adult),
                                R.mipmap.adult,
                                R.raw.adult
                            )
                        }
                    )
                )
            },

            context?.let {
                VocabularyCategory(
                    title = "Описание вкусов и температур",
                    meaning = it.getString(R.string.adj_tastes),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Острый",
                                it.getString(R.string.spicy),
                                R.mipmap.spicy,
                                R.raw.spicy
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Солёный",
                                it.getString(R.string.salty),
                                R.mipmap.salty,
                                R.raw.salty
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Сладкий",
                                it.getString(R.string.sweet),
                                R.mipmap.sweet,
                                R.raw.sweet
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Кислый",
                                it.getString(R.string.sour),
                                R.mipmap.sour,
                                R.raw.sour
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Холодный",
                                it.getString(R.string.cold),
                                R.mipmap.cold,
                                R.raw.cold
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Тёплый",
                                it.getString(R.string.warm),
                                R.mipmap.warm,
                                R.raw.warm
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Горячий",
                                it.getString(R.string.hot),
                                R.mipmap.hot,
                                R.raw.hot
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Жаркий",
                                it.getString(R.string.air_hot),
                                R.mipmap.air_hot,
                                R.raw.air_hot
                            )
                        }
                    )
                )
            },

            context?.let {
                VocabularyCategory(
                    title = "Описание цветов",
                    meaning = it.getString(R.string.adj_colors),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Белый",
                                it.getString(R.string.white),
                                R.mipmap.white,
                                R.raw.white
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Красный",
                                it.getString(R.string.red),
                                R.mipmap.red,
                                R.raw.red
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Чёрный",
                                it.getString(R.string.black),
                                R.mipmap.black,
                                R.raw.black
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Зелёный",
                                it.getString(R.string.green),
                                R.mipmap.green,
                                R.raw.green
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Жёлтый",
                                it.getString(R.string.yellow),
                                R.mipmap.yellow,
                                R.raw.yellow
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Синий",
                                it.getString(R.string.intense_blue),
                                R.mipmap.intense_blue,
                                R.raw.intense_blue
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Голубой",
                                it.getString(R.string.light_blue),
                                R.mipmap.light_blue,
                                R.raw.light_blue
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Серый",
                                it.getString(R.string.gray),
                                R.mipmap.gray,
                                R.raw.gray
                            )
                        }
                    )
                )
            },

            context?.let {
                VocabularyCategory(
                    title = "Оценка вещей",
                    meaning = it.getString(R.string.adj_evaluating),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Важный",
                                it.getString(R.string.important),
                                R.mipmap.important,
                                R.raw.important
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Хороший",
                                it.getString(R.string.good),
                                R.mipmap.good,
                                R.raw.good
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Плохой",
                                it.getString(R.string.bad),
                                R.mipmap.bad,
                                R.raw.bad
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Любимый",
                                it.getString(R.string.favorite),
                                R.mipmap.favorite,
                                R.raw.favorite
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Нужный",
                                it.getString(R.string.necessary),
                                R.mipmap.necessary,
                                R.raw.necessary
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Знаменитый",
                                it.getString(R.string.famous),
                                R.mipmap.famous,
                                R.raw.famous
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Знакомый",
                                it.getString(R.string.known_familiar),
                                R.mipmap.known_familiar,
                                R.raw.known_familiar
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Похожий",
                                it.getString(R.string.similar),
                                R.mipmap.similar,
                                R.raw.similar
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Следующий",
                                it.getString(R.string.next),
                                R.mipmap.next,
                                R.raw.next
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Личный",
                                it.getString(R.string.personal),
                                R.mipmap.personal,
                                R.raw.personal
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Простой",
                                it.getString(R.string.simple),
                                R.mipmap.simple,
                                R.raw.simple
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Сложный",
                                it.getString(R.string.complicated),
                                R.mipmap.complicated,
                                R.raw.complicated
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Единственный",
                                it.getString(R.string.only),
                                R.mipmap.only,
                                R.raw.only
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Последний",
                                it.getString(R.string.last_latest),
                                R.mipmap.last_latest,
                                R.raw.last_latest
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Лучший",
                                it.getString(R.string.best),
                                R.mipmap.best,
                                R.raw.best
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Основной",
                                it.getString(R.string.primary_basic),
                                R.mipmap.primary_basic,
                                R.raw.primary_basic
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Особый",
                                it.getString(R.string.special),
                                R.mipmap.special,
                                R.raw.special
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Обычный",
                                it.getString(R.string.usual),
                                R.mipmap.usual,
                                R.raw.usual
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Поздний",
                                it.getString(R.string.late),
                                R.mipmap.late,
                                R.raw.late
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Ранний",
                                it.getString(R.string.early),
                                R.mipmap.early,
                                R.raw.early
                            )
                        }
                    )
                )
            },

            context?.let {
                VocabularyCategory(
                    title = "Описание форм и материалов",
                    meaning = it.getString(R.string.adj_shapes),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Мягкий",
                                it.getString(R.string.soft),
                                R.mipmap.soft,
                                R.raw.soft
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "жёсткий",
                                it.getString(R.string.hard),
                                R.mipmap.hard,
                                R.raw.hard
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Круглый",
                                it.getString(R.string.round),
                                R.mipmap.round,
                                R.raw.round
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Квадратный",
                                it.getString(R.string.square),
                                R.mipmap.square,
                                R.raw.square
                            )
                        }
                    )
                )
            },

            context?.let {
                VocabularyCategory(
                    title = "Описание мест",
                    meaning = it.getString(R.string.adj_places),
                    items = listOf(
                        context?.let {
                            Vocabulary(
                                "Долгий",
                                it.getString(R.string.long_trip),
                                R.mipmap.long_trip,
                                R.raw.long_trip
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Быстрый",
                                it.getString(R.string.fast),
                                R.mipmap.fast,
                                R.raw.fast
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Медленный",
                                it.getString(R.string.slow),
                                R.mipmap.slow,
                                R.raw.slow
                            )
                        },
                        context?.let {
                            Vocabulary(
                                "Глубокий",
                                it.getString(R.string.deep),
                                R.mipmap.deep,
                                R.raw.deep
                            )
                        },

                        context?.let {
                            Vocabulary(
                                "Рабочий",
                                it.getString(R.string.working),
                                R.mipmap.working,
                                R.raw.working
                            )
                        }
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