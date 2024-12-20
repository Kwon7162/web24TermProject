package kr.ac.kumoh.s20210084.web24TermProject.service

import kr.ac.kumoh.s20210084.web24TermProject.model.Player
import kr.ac.kumoh.s20210084.web24TermProject.repository.PlayerRepository
import org.springframework.stereotype.Service

@Service
class PlayerService(private val repository: PlayerRepository) {
    fun addPlayer(player: Player): Player = repository.save(player)

    fun getAllPlayers(): List<Player> = repository.findAll()
    fun getPlayerById(id: String): Player? = repository.findById(id).orElse(null)
    fun getPlayerByName(name: String): Player = repository.findByName(name)
    fun getPlayerByNum(num: Int): List<Player> = repository.findByNum(num)
    fun getPlayerByPosition(position: String): List<Player> = repository.findByPosition(position)

    fun updateProfile(id: String, player: Player): Player? {
        val targetPlayer = repository.findById(id)

        return if (targetPlayer.isPresent){
            val oldPlayer = targetPlayer.get()
            val updatedPlayer = oldPlayer.copy(
                name = player.name,
                position = player.position,
                num = player.num,
                des = player.des,
                url = player.url
            )
            repository.save(updatedPlayer)
        } else {
            null
        }
    }

    fun deletePlayer(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}