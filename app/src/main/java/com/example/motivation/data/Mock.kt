package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase (val description: String, val CategoryId: Int)

class Mock {

    private val infinity = MotivationConstants.FILTER.INFINIT
    private val anchor = MotivationConstants.FILTER.ANCHOR
    private val ice = MotivationConstants.FILTER.ICE

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", anchor),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", anchor),
        Phrase("Quando está mais escuro, vemos mais estrelas!", anchor),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", anchor),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", anchor),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", anchor),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", ice),
        Phrase("Você perde todas as chances que você não aproveita.", ice),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", ice),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", ice),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", ice),
        Phrase("Se você acredita, faz toda a diferença.", ice),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", ice)
    )


    fun getPhrase(value: Int): String {
        val filtered = listPhrases.filter { (it.CategoryId == value || value == infinity) }


        val rand = Random.nextInt(filtered.size)


        return filtered[rand].description
    }



}