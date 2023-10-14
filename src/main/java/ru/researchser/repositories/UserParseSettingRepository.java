package ru.researchser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.researchser.models.parser.UserParserSetting;

@Repository
public interface UserParseSettingRepository extends JpaRepository<UserParserSetting, Long> {
}