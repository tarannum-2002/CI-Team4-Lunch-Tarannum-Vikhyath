package service

import dto.Employee
import jakarta.inject.Inject
import jakarta.inject.Singleton
import repository.EmployeeRepository

@Singleton
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun checkIfEmployeeExists(id:String): Boolean {
        return employeeRepository.existsById(id)
    }

    fun createEmployeeRecord(employee:Employee){
        employeeRepository.save(employee.toEmployeeEntity())
    }
}