package repository

import entity.EmployeeEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface EmployeeRepository : CrudRepository<EmployeeEntity, String> {
}