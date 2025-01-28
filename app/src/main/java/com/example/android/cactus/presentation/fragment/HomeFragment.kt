package com.example.android.cactus.presentation.fragment

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.android.cactus.R
import com.example.android.cactus.databinding.BasicdialogBinding
import com.example.android.cactus.databinding.CommonwordsdialogBinding
import com.example.android.cactus.databinding.FragmentHomeBinding
import com.example.android.cactus.databinding.MenudialogBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // Set click listeners
        binding.buttonlearn.setOnClickListener { showLearnDialog() }
        binding.buttoncommon.setOnClickListener { showCommonWordsDialog() }
        binding.buttonHelp.setOnClickListener { showHelpDialog() }
        binding.buttoconver.setOnClickListener { navigateToConversation() }
    }

    private fun showLearnDialog() {
        val dialogBinding = BasicdialogBinding.inflate(layoutInflater)
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(dialogBinding.root)
            dialogBinding.buttonHand.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_handwritingFragment3)
                dismiss()
            }
            dialogBinding.buttonNum.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_mainNumberFragment)
                dismiss()
            }
            dialogBinding.buttonDay.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_dayFragment)
                dismiss()
            }
            dialogBinding.buttonMonth.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_monthFragment)
                dismiss()
            }
            dialogBinding.buttonXlearn.setOnClickListener { dismiss() }
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }

    private fun showCommonWordsDialog() {
        val dialogBinding = CommonwordsdialogBinding.inflate(layoutInflater)
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(dialogBinding.root)
            dialogBinding.buttonNouns.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_commonFragment)
                dismiss()
            }
            dialogBinding.buttonVerb.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_verbFragment)
                dismiss()
            }
            dialogBinding.buttonAdj.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_adjFragment)
                dismiss()
            }
            dialogBinding.buttonXlearn.setOnClickListener { dismiss() }
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }

    private fun showHelpDialog() {
        val dialogBinding = MenudialogBinding.inflate(layoutInflater)
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(dialogBinding.root)
            dialogBinding.feedback.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:example@email.com")
                }
                startActivity(Intent.createChooser(intent, "Send email..."))
            }
            dialogBinding.rate.setOnClickListener {
                val appPackageName = "com.example.cactus"
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                }
            }
            dialogBinding.buttonX.setOnClickListener { dismiss() }
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }

    private fun navigateToConversation() {
        findNavController().navigate(R.id.action_homeFragment2_to_converListFragment)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
