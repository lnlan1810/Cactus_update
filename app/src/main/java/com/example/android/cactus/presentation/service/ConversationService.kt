package com.example.android.cactus.presentation.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.android.cactus.R
import com.example.android.cactus.domain.model.Conversation
import com.example.android.cactus.domain.repository.ConversationRepository

class ConversationService : Service() {
    private var isRepeat = false
    private var isShuffle = false
    private var mediaPlayer: MediaPlayer = MediaPlayer()
    var currentPosition: Int = 0
    private var conversationBinder: ConversationBinder = ConversationBinder()
    private var conversations: List<Conversation> = ConversationRepository.conversations
    private var notificationService: NotificationService? = null
    private var callback: UIUpdateCallback? = null // Thêm callback

    inner class ConversationBinder : Binder() {
        fun getService(): ConversationService = this@ConversationService
    }

    override fun onCreate() {
        super.onCreate()
        notificationService = NotificationService(this)
        notificationService!!.setNotification(currentPosition)
    }

    override fun onBind(intent: Intent): IBinder = conversationBinder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "PREVIOUS" -> { previousConversation() }
            "PAUSE" -> { if (mediaPlayer.isPlaying) mediaPlayer.pause() else mediaPlayer.start() }
            "NEXT" -> { nextConversation() }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun playNextShuffledSong() {
        if (isShuffle) {
            // Đợi bài hiện tại phát xong rồi mới chuyển sang bài ngẫu nhiên
            mediaPlayer.setOnCompletionListener {
                // Chuyển bài ngẫu nhiên
                currentPosition = (0 until conversations.size).random()
                currentConversation(currentPosition)
            }
        } else {
            nextConversation() // Nếu shuffle không được bật, phát bài tiếp theo theo thứ tự bình thường
        }
    }


    fun previousConversation() {
        if (isShuffle) {
            currentPosition = (0 until conversations.size).random()
        } else {
            if (currentPosition == 0) {
                currentPosition = conversations.size - 1
            } else {
                currentPosition--
            }
        }
        currentConversation(currentPosition)
    }

    fun nextConversation() {
        if (isShuffle) {
            currentPosition = (0 until conversations.size).random()
        } else {
            if (currentPosition == conversations.size - 1) {
                currentPosition = 0
            } else {
                currentPosition++
            }
        }
        currentConversation(currentPosition)
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun play() {
        // Nếu bật repeat, lặp lại bài hát
        if (isRepeat) {
            mediaPlayer.isLooping = true
        } else {
            mediaPlayer.isLooping = false
        }

        // Nếu đang ở chế độ shuffle và bài hát chưa bắt đầu phát (chưa chơi), chọn bài ngẫu nhiên
        if (isShuffle && !mediaPlayer.isPlaying) {
            currentPosition = (0 until conversations.size).random()
            currentConversation(currentPosition)  // Phát bài ngẫu nhiên
        } else if (!isShuffle) {
            // Nếu không ở chế độ shuffle, phát từ vị trí hiện tại
            mediaPlayer.start()
        } else {
            // Nếu bài hát đang phát, tiếp tục phát
            mediaPlayer.start()
        }

        callback?.updateUI(currentPosition)  // Cập nhật UI
    }

    fun isPlay() = mediaPlayer.isPlaying

    fun currentConversation(selectedConversationId: Int) {
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer.reset() // Reset MediaPlayer before assigning a new song
        mediaPlayer = MediaPlayer.create(applicationContext, conversations[selectedConversationId].audio)
        currentPosition = selectedConversationId

        // Cài đặt các listener cho MediaPlayer
        mediaPlayer.setOnCompletionListener {
            // Tự động chuyển sang bài tiếp theo khi hoàn thành
            nextConversation()
        }

        mediaPlayer.setOnErrorListener { mp, what, extra ->
            // Xử lý lỗi nếu có
            true
        }

        mediaPlayer.setOnPreparedListener {
            // Phát nhạc sau khi MediaPlayer được chuẩn bị
            mediaPlayer.start()
        }

        mediaPlayer.start()

        // Cập nhật giao diện (UI) khi chuyển bài
        callback?.updateUI(selectedConversationId)

        notificationService?.setNotification(selectedConversationId)
    }
    fun toggleRepeat(): Boolean {
        isRepeat = !isRepeat
        return isRepeat
    }

    // Thiết lập callback UI
    fun setUIUpdateCallback(callback: UIUpdateCallback) {
        this.callback = callback
    }

    interface UIUpdateCallback {
        fun updateUI(conversationId: Int)

    }

}
