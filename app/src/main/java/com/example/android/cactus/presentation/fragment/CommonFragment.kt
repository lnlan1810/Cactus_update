package com.example.android.cactus.presentation.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentCommonBinding
import com.example.android.cactus.domain.model.Vocabulary
import com.example.android.cactus.domain.model.VocabularyCategory
import com.example.android.cactus.presentation.adapter.VocabularyCategoryAdapter


class CommonFragment : Fragment(R.layout.fragment_common) {

    private var _binding: FragmentCommonBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCommonBinding.bind(view)

        // Dữ liệu mẫu
// Dữ liệu mẫu
        val categories = listOf(
            context?.let {
                VocabularyCategory(
                    title = "Человек",
                    meaning = it.getString(R.string.person) ,
                    items = listOf(
                        context?.let { Vocabulary("Человек", it.getString(R.string.person), R.drawable.person, R.raw.one) },
                        context?.let { Vocabulary("Друг", it.getString(R.string.friend), R.mipmap.friend, R.raw.one) },
                        context?.let { Vocabulary("Ребёнок", it.getString(R.string.child), R.mipmap.child, R.raw.one) },
                        context?.let { Vocabulary("Женщина", it.getString(R.string.woman), R.mipmap.woman, R.raw.one) },
                        context?.let { Vocabulary("Мужчина", it.getString(R.string.man), R.mipmap.man, R.raw.one) },
                        context?.let { Vocabulary("Мальчик", it.getString(R.string.boy), R.mipmap.boy, R.raw.one) },
                        context?.let { Vocabulary("Девочка", it.getString(R.string.girl), R.mipmap.girl, R.raw.one) },
                        context?.let { Vocabulary("Девушка", it.getString(R.string.girlfriend), R.mipmap.girlfriend, R.raw.one) },
                        context?.let { Vocabulary("Парень", it.getString(R.string.boyfriend), R.mipmap.boyfriend, R.raw.one) },
                        context?.let { Vocabulary("Имя", it.getString(R.string.name), R.mipmap.name, R.raw.one) },
                        context?.let { Vocabulary("Фамилия", it.getString(R.string.surname), R.mipmap.surname, R.raw.one) },
                        context?.let { Vocabulary("Начальник", it.getString(R.string.boss), R.mipmap.boss, R.raw.one) },
                        context?.let { Vocabulary("Гость", it.getString(R.string.visitor), R.mipmap.visitor, R.raw.seven) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Семья",
                    meaning = it.getString(R.string.family),
                    items = listOf(
                        context?.let { Vocabulary("Семья", it.getString(R.string.family), R.mipmap.family, R.raw.one) },
                        context?.let { Vocabulary("Отец", it.getString(R.string.father), R.mipmap.father, R.raw.one) },
                        context?.let { Vocabulary("Папа", it.getString(R.string.dad), R.mipmap.dad, R.raw.one) },
                        context?.let { Vocabulary("Мама", it.getString(R.string.mother), R.mipmap.mother, R.raw.one) },
                        context?.let { Vocabulary("Сын", it.getString(R.string.son), R.mipmap.son, R.raw.one) },
                        context?.let { Vocabulary("Дочь", it.getString(R.string.daughter), R.mipmap.daughter, R.raw.one) },
                        context?.let { Vocabulary("Брат", it.getString(R.string.brother), R.mipmap.brother, R.raw.one) },
                        context?.let { Vocabulary("Сестра", it.getString(R.string.sister), R.mipmap.sister, R.raw.one) },
                        context?.let { Vocabulary("Жена", it.getString(R.string.wife), R.mipmap.wife, R.raw.one) },
                        context?.let { Vocabulary("Муж", it.getString(R.string.husband), R.mipmap.husband, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Место",
                    meaning = it.getString(R.string.place),
                    items = listOf(
                        context?.let { Vocabulary("Место", it.getString(R.string.place), R.mipmap.place, R.raw.one) },
                        context?.let { Vocabulary("Земля", it.getString(R.string.earth), R.mipmap.earth, R.raw.one) },
                        context?.let { Vocabulary("Город", it.getString(R.string.town), R.mipmap.town, R.raw.one) },
                        context?.let { Vocabulary("Улица", it.getString(R.string.street), R.mipmap.street, R.raw.one) },
                        context?.let { Vocabulary("Москва", it.getString(R.string.Moscow), R.mipmap.moscow, R.raw.one) },
                        context?.let { Vocabulary("Страна", it.getString(R.string.country), R.mipmap.country, R.raw.one) },
                        context?.let { Vocabulary("Россия", it.getString(R.string.Russia), R.mipmap.russia, R.raw.one) },
                        context?.let { Vocabulary("Дорога", it.getString(R.string.road), R.mipmap.road, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Природа",
                    meaning = it.getString(R.string.forest),
                    items = listOf(
                        context?.let { Vocabulary("Лес", it.getString(R.string.forest), R.mipmap.forest, R.raw.one) },
                        context?.let { Vocabulary("Воздух", it.getString(R.string.air), R.mipmap.air, R.raw.one) },
                        context?.let { Vocabulary("Огонь", it.getString(R.string.fire), R.mipmap.fire, R.raw.one) },
                        context?.let { Vocabulary("Вода", it.getString(R.string.water), R.mipmap.water, R.raw.one) },
                        context?.let { Vocabulary("Ветер", it.getString(R.string.wind), R.mipmap.wind, R.raw.one) },
                        context?.let { Vocabulary("Солнце", it.getString(R.string.sun), R.mipmap.sun, R.raw.one) },
                        context?.let { Vocabulary("Луна", it.getString(R.string.moon), R.mipmap.moon, R.raw.one) },
                        context?.let { Vocabulary("Дерево", it.getString(R.string.tree), R.mipmap.tree, R.raw.one) },
                        context?.let { Vocabulary("Снег", it.getString(R.string.snow), R.mipmap.snow, R.raw.one) },
                        context?.let { Vocabulary("Небо", it.getString(R.string.sky), R.mipmap.sky, R.raw.one) },
                        context?.let { Vocabulary("Море", it.getString(R.string.sea), R.mipmap.sea, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Животные",
                    meaning = it.getString(R.string.animal),
                    items = listOf(
                        context?.let { Vocabulary("Животное", it.getString(R.string.animal), R.mipmap.animal, R.raw.one) },
                        context?.let { Vocabulary("Собака", it.getString(R.string.dog), R.mipmap.dog, R.raw.one) },
                        context?.let { Vocabulary("Кошка (мужская)", it.getString(R.string.catmale), R.mipmap.catmale, R.raw.one) },
                        context?.let { Vocabulary("Кошка (женская)", it.getString(R.string.catfemale), R.mipmap.catfemale, R.raw.one) },
                        context?.let { Vocabulary("Комар", it.getString(R.string.mosquito), R.mipmap.mosquito, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Дом",
                    meaning = it.getString(R.string.house),
                    items = listOf(
                        context?.let { Vocabulary("Дом", it.getString(R.string.house), R.mipmap.house, R.raw.one) },
                        context?.let { Vocabulary("Квартира", it.getString(R.string.apartment), R.mipmap.apartment, R.raw.one) },
                        context?.let { Vocabulary("Дверь", it.getString(R.string.door), R.mipmap.door, R.raw.one) },
                        context?.let { Vocabulary("Окно", it.getString(R.string.window), R.mipmap.window, R.raw.one) },
                        context?.let { Vocabulary("Стол", it.getString(R.string.table), R.mipmap.table, R.raw.one) },
                        context?.let { Vocabulary("Комната", it.getString(R.string.room), R.mipmap.room, R.raw.one) },
                        context?.let { Vocabulary("Книга", it.getString(R.string.book), R.mipmap.book, R.raw.one) },
                        context?.let { Vocabulary("Свет", it.getString(R.string.light), R.mipmap.light, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Ежедневная жизнь",
                    meaning = it.getString(R.string.dailyLife),
                    items = listOf(
                        context?.let { Vocabulary("Деньги", it.getString(R.string.money), R.mipmap.money, R.raw.one) },
                        context?.let { Vocabulary("Письмо", it.getString(R.string.letter), R.mipmap.letter, R.raw.one) },
                        context?.let { Vocabulary("Школа", it.getString(R.string.school), R.mipmap.school, R.raw.one) },
                        context?.let { Vocabulary("Университет", it.getString(R.string.university), R.mipmap.university, R.raw.one) },
                        context?.let { Vocabulary("Машина", it.getString(R.string.car), R.mipmap.car, R.raw.one) },
                        context?.let { Vocabulary("Компьютер", it.getString(R.string.computer), R.mipmap.computer, R.raw.one) },
                        context?.let { Vocabulary("Ноутбук", it.getString(R.string.laptop), R.mipmap.laptop, R.raw.one) },
                        context?.let { Vocabulary("Телефон", it.getString(R.string.phone), R.mipmap.phone, R.raw.one) },
                        context?.let { Vocabulary("Наушники", it.getString(R.string.earphones), R.mipmap.earphones, R.raw.one) },
                        context?.let { Vocabulary("Зарядка", it.getString(R.string.charger), R.mipmap.charger, R.raw.one) },
                        context?.let { Vocabulary("Вебсайт", it.getString(R.string.website), R.mipmap.website, R.raw.one) },
                        context?.let { Vocabulary("Приложение", it.getString(R.string.app), R.mipmap.app, R.raw.one) },
                        context?.let { Vocabulary("Игра", it.getString(R.string.game), R.mipmap.game, R.raw.one) },
                        context?.let { Vocabulary("Помощь", it.getString(R.string.help), R.mipmap.help, R.raw.one) },
                        context?.let { Vocabulary("Завтрак", it.getString(R.string.breakfast), R.mipmap.breakfast, R.raw.one) },
                        context?.let { Vocabulary("Ужин", it.getString(R.string.lunch), R.mipmap.lunch, R.raw.one) },
                        context?.let { Vocabulary("Ужин", it.getString(R.string.dinner), R.mipmap.dinner, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Время",
                    meaning = it.getString(R.string.time),
                    items = listOf(
                        context?.let { Vocabulary("Время", it.getString(R.string.time), R.mipmap.time, R.raw.one) },
                        context?.let { Vocabulary("Минута", it.getString(R.string.minute), R.mipmap.minute, R.raw.one) },
                        context?.let { Vocabulary("Час", it.getString(R.string.hour), R.mipmap.hour, R.raw.one) },
                        context?.let { Vocabulary("День", it.getString(R.string.day1), R.mipmap.day1, R.raw.one) },
                        context?.let { Vocabulary("Неделя", it.getString(R.string.week), R.mipmap.week, R.raw.one) },
                        context?.let { Vocabulary("Будни", it.getString(R.string.weekdays), R.mipmap.weekdays, R.raw.one) },
                        context?.let { Vocabulary("Выходные", it.getString(R.string.weekend), R.mipmap.weekend, R.raw.one) },
                        context?.let { Vocabulary("Месяц", it.getString(R.string.month1), R.mipmap.month1, R.raw.one) },
                        context?.let { Vocabulary("Год", it.getString(R.string.year), R.mipmap.year, R.raw.one) },
                        context?.let { Vocabulary("Ночь", it.getString(R.string.night), R.mipmap.night, R.raw.one) },
                        context?.let { Vocabulary("Жизнь", it.getString(R.string.life), R.mipmap.life, R.raw.one) },
                        context?.let { Vocabulary("Утро", it.getString(R.string.morning), R.mipmap.morning, R.raw.one) },
                        context?.let { Vocabulary("Вечер", it.getString(R.string.evening), R.mipmap.evening, R.raw.one) }
                    )
                )
            },
            context?.let {
                VocabularyCategory(
                    title = "Части тела",
                    meaning = it.getString(R.string.bodyParts),
                    items = listOf(
                        context?.let { Vocabulary("Голова", it.getString(R.string.head), R.mipmap.head, R.raw.one) },
                        context?.let { Vocabulary("Лицо", it.getString(R.string.face), R.mipmap.face, R.raw.one) },
                        context?.let { Vocabulary("Глаз", it.getString(R.string.eye), R.mipmap.eye, R.raw.one) },
                        context?.let { Vocabulary("Нос", it.getString(R.string.nose), R.mipmap.nose, R.raw.one) },
                        context?.let { Vocabulary("Ухо", it.getString(R.string.ear), R.mipmap.ear, R.raw.one) },
                        context?.let { Vocabulary("Голос", it.getString(R.string.voice), R.mipmap.voice, R.raw.one) },
                        context?.let { Vocabulary("Тело", it.getString(R.string.body), R.mipmap.body, R.raw.one) },
                        context?.let { Vocabulary("Рука", it.getString(R.string.arm), R.mipmap.arm, R.raw.one) },
                        context?.let { Vocabulary("Нога", it.getString(R.string.leg), R.mipmap.leg, R.raw.one) },
                        context?.let { Vocabulary("Палец", it.getString(R.string.finger), R.mipmap.finger, R.raw.one) },
                        context?.let { Vocabulary("Спина", it.getString(R.string.back), R.mipmap.back, R.raw.one) },
                        context?.let { Vocabulary("Сердце", it.getString(R.string.heart), R.mipmap.heart, R.raw.one) },
                        context?.let { Vocabulary("Кровь", it.getString(R.string.blood), R.mipmap.blood, R.raw.one) }
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