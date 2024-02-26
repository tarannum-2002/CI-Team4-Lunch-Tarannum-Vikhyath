package entity

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Serdeable
@Entity
@Table(name = "employee")
class EmployeeEntity {
    @Id
    var id: String = ""
    var name: String = ""
}