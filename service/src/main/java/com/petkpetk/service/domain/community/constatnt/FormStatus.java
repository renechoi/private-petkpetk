package com.petkpetk.service.domain.community.constatnt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FormStatus {
    CREATE("저장", false),
    UPDATE("수정", true);

    private final String description;
    private final Boolean update;

}
