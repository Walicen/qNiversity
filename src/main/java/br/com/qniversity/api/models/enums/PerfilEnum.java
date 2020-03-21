package br.com.qniversity.api.models.enums;

public enum PerfilEnum {
    ROLE_ADMIN(2),
    ROLE_USUARIO(1);

    private final int level;

    PerfilEnum(int level) {
        this.level = level;
    }
}