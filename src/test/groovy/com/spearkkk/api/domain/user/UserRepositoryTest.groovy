package com.spearkkk.api.domain.user


import com.spearkkk.api.domain.user.role.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.time.LocalDateTime

@SpringBootTest
class UserRepositoryTest extends Specification {
    @Autowired
    UserRepository repository

    def cleanup() {
        repository.deleteAll()
    }

    def "repository should save user."() {
        given:
        def name = "first user name"
        def email = "first user email"
        def picture = "first user picture"
        def role = Role.USER

        def user = User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(role)
                .build()

        when:
        def timestamp = LocalDateTime.now()
        def savedUser = repository.save(user)

        then:
        true
        savedUser.getId() == 1

        savedUser.getName() == name
        savedUser.getEmail() == email
        savedUser.getPicture() == picture
        savedUser.getRole() == role

        savedUser.getCreatedDatetime().isAfter(timestamp)
        savedUser.getModifiedDatetime().isAfter(timestamp)
    }
}
