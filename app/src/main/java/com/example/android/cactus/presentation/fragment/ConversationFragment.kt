package com.example.android.cactus.presentation.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentConversationBinding
import com.example.android.cactus.domain.model.Conversation
import com.example.android.cactus.domain.repository.ConversationRepository
import com.example.android.cactus.presentation.service.ConversationService

class ConversationFragment : Fragment(R.layout.fragment_conversation), ConversationService.UIUpdateCallback {

    private var _binding: FragmentConversationBinding? = null
    private val binding get() = _binding!!

    private var binder: ConversationService.ConversationBinder? = null
    private var conversationService: ConversationService? = null
    private var conversation: Conversation? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binder = service as? ConversationService.ConversationBinder
            conversationService = binder?.getService()
            conversationService?.setUIUpdateCallback(this@ConversationFragment) // Set callback for UI update
            connectConversation()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            conversationService = null
            binder = null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConversationBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun connectConversation() {
        val idConversation = arguments?.getInt("idConversation")
        idConversation?.let {
            setData(idConversation)
            playConversation(idConversation)
        }
        // Đặt trạng thái mặc định cho nút phát/dừng
        binding.ibPausePlay.setBackgroundResource(R.drawable.ic_pause)
    }

    private fun playConversation(idConversation: Int) {
        conversationService?.currentConversation(idConversation)
        with(binding) {
            ibPrev.setOnClickListener {
                conversationService?.previousConversation()
                setData(conversationService?.currentPosition)
                conversationService?.play()
                ibPausePlay.setBackgroundResource(R.drawable.ic_pause)
            }
            ibNext.setOnClickListener {
                conversationService?.nextConversation()
                setData(conversationService?.currentPosition)
                conversationService?.play()
                ibPausePlay.setBackgroundResource(R.drawable.ic_pause)
            }
            ibPausePlay.setOnClickListener {
                if (conversationService?.isPlay() == true) {
                    conversationService?.pause()
                    ibPausePlay.setBackgroundResource(R.drawable.ic_play_arrow_white_32dp)
                } else {
                    conversationService?.play()
                    ibPausePlay.setBackgroundResource(R.drawable.ic_pause)
                }
            }

            repeatButton.setOnClickListener {
                val isRepeat = conversationService?.toggleRepeat() == true
                val icon = if (isRepeat) R.drawable.ic_repeat_one else R.drawable.ic_repeat
                repeatButton.setImageResource(icon)
                conversationService?.play()

            }


        }
    }

    private fun setData(id: Int?) {
        id?.let {
            conversation = ConversationRepository.conversations[id]
        }
        binding.tvTema.text = conversation?.tema
        binding.tvText.text = conversation?.text
    }

    // Cập nhật giao diện khi thay đổi bài hát
    override fun updateUI(conversationId: Int) {
        conversation = ConversationRepository.conversations[conversationId]
        binding.tvTema.text = conversation?.tema
        binding.tvText.text = conversation?.text
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonback.setOnClickListener {
                activity?.onBackPressed()
            }
        }

        activity?.bindService(
            Intent(context, ConversationService::class.java),
            connection,
            Context.BIND_AUTO_CREATE
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.unbindService(connection)
        _binding = null
    }
}
