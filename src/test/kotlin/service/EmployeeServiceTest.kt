package service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import repository.EmployeeRepository

class EmployeeServiceTest {

    private val employeeRepository = mock(EmployeeRepository::class.java)
    private val employeeService = EmployeeService(employeeRepository)

    @Test
    fun checkIfEmployeeExists(){
    `when`(employeeRepository.existsById("employeeId")).thenReturn(true)

    val exists = employeeService.checkIfEmployeeExists("employeeId")

    assertTrue(exists)
}

}