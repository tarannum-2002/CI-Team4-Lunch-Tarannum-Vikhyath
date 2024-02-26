package dto

import entity.EmployeeEntity
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Employee(val id: String, val name: String) {
    fun toEmployeeEntity(): EmployeeEntity {
        val employeeEntity = EmployeeEntity()
        employeeEntity.name = this.name
        employeeEntity.id = this.id
        return employeeEntity
    }
}
