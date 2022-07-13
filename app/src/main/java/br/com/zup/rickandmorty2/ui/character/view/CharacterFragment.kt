package br.com.zup.rickandmorty2.ui.character.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.rickandmorty2.R
import br.com.zup.rickandmorty2.data.model.CharacterResult
import br.com.zup.rickandmorty2.databinding.FragmentCharacterBinding
import br.com.zup.rickandmorty2.ui.KEY
import br.com.zup.rickandmorty2.ui.adapter.CharacterAdapter
import br.com.zup.rickandmorty2.ui.main.viewmodel.CharacterViewModel


class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding

    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter(arrayListOf(), this::goToCharacterDetail)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        viewModel.getAllCharacter()
        initObserver()

    }

    private fun goToCharacterDetail(character: CharacterResult) {
        val bundle = bundleOf(KEY to character)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_characterFragment_to_detailFragment, bundle
        )
    }


    private fun initObserver() {
        viewModel.characterResponse.observe(this.viewLifecycleOwner) {
            adapter.updateCharacterList(it as MutableList<CharacterResult>)
        }
    }

    private fun setRecyclerView() {
        binding.rvImage.adapter = adapter
        binding.rvImage.layoutManager = GridLayoutManager(context, 2)
    }

}