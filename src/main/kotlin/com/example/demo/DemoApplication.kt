package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class HelloController(val exerciseRepository: ExerciseRepository) {
    @GetMapping("/")
    fun hello() = exerciseRepository.save(Exercise(1, "Squat"))

    @GetMapping("/hello")
    fun pikfjes(): MutableList<Exercise> {
        return exerciseRepository.findAll()
    }
}

@Entity
data class Exercise(
        @Id @GeneratedValue
        val id: Int = 0,
        val name: String
) {
    constructor() : this(0, "")
}

@Repository
interface ExerciseRepository : JpaRepository<Exercise, Int>
