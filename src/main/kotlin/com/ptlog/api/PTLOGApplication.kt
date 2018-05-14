package com.ptlog.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
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
    @PostMapping("/exercises")
    fun postExercise(@RequestBody exercise: Exercise): Exercise {
        return exerciseRepository.save(exercise)
    }

    @PutMapping("/exercises")
    fun putExercise(@RequestBody exercise: Exercise): Exercise {
        return exerciseRepository.save(exercise)
    }

    @GetMapping("/exercises")
    fun getExercises(): List<Exercise> {
        return exerciseRepository.findAll()
    }

    @GetMapping("/exercises/{name}")
    fun getOne (@PathVariable move: String) = exerciseRepository.getOne(move)

    @DeleteMapping("/exercises/{move}")
    fun deleteOne (@PathVariable move: String) = exerciseRepository.deleteById(move)
}

@Entity
class Exercise(
        @Id @GeneratedValue
        val move: String,
        val kilogram: Int,
        val repetition: Int
) {
    constructor() : this("", 0, 0)
}

@Repository
interface ExerciseRepository : JpaRepository<Exercise, String>
