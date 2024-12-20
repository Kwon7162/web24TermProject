package kr.ac.kumoh.s20210084.web24TermProject.controller

import com.mongodb.client.model.geojson.Position
import kr.ac.kumoh.s20210084.web24TermProject.model.Player
import kr.ac.kumoh.s20210084.web24TermProject.service.PlayerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = ["http://localhost:3000","https://kchtermproject.netlify.app"])
class PlayerController(private val service: PlayerService) {
    @PostMapping
    fun addPlayer(@RequestBody player: Player): Player = service.addPlayer(player)

    @GetMapping
    fun getAllPlayers() : List<Player> = service.getAllPlayers()

    @GetMapping("/{id}")
    fun getPlayerById(@PathVariable id: String): Player? = service.getPlayerById(id)

    @GetMapping("/name/{name}")
    fun getPlayerByName(@PathVariable name: String): Player? = service.getPlayerByName(name)

    @GetMapping("/num/{num}")
    fun getPlayerByNum(@PathVariable num: Int): List<Player> = service.getPlayerByNum(num)

    @GetMapping("/position/{position}")
    fun getPlayerByPosition(@PathVariable position: String): List<Player> = service.getPlayerByPosition(position)

    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: String, @RequestBody playerDetails: Player) : Player? = service.updateProfile(id, playerDetails)

    @DeleteMapping("/{id}")
    fun deletePlayer(@PathVariable id: String): Map<String, String> {
        return if (service.deletePlayer(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}