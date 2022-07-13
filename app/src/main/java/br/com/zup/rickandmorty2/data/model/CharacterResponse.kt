package br.com.zup.rickandmorty2.data.model


import br.com.zup.rickandmorty2.data.model.CharacterResult
import br.com.zup.rickandmorty2.data.model.Info
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<CharacterResult>
)