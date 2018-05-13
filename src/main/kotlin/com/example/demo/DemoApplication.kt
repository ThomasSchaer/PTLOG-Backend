package com.example.demo

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
    @GetMapping("/exercises/{id}")
    fun getOne (@PathVariable id: Int) = exerciseRepository.getOne(id)

    @DeleteMapping("/exercises/{id}")
    fun deleteOne (@PathVariable id: Int) = exerciseRepository.deleteById(id)
}

@Entity
class Exercise(
        @Id @GeneratedValue
        val id: Int = 0,
        val name: String
) {
    constructor() : this(0, "")
}

@Repository
interface ExerciseRepository : JpaRepository<Exercise, Int>
