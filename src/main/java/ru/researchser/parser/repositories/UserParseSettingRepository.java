package ru.researchser.parser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.researchser.parser.models.UserParseSetting;

@Repository
public interface UserParseSettingRepository extends JpaRepository<UserParseSetting, Long> {
}