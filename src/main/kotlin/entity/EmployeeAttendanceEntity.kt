package entity

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDate

@Serdeable
@Entity
@Table(name = "attendance")
@IdClass(EmployeeAttendanceId::class)
class EmployeeAttendanceEntity {

    @Id
    lateinit var employeeId: String

    @Id
    lateinit var date: LocalDate


    var status: String = "not specified"

    var name: String? = null
}

class EmployeeAttendanceId(
    var employeeId: String = "",
    var date: LocalDate = LocalDate.MIN
)