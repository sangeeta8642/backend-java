package com.scrub.pro.scrubPro.Enums;

public enum StoryStatusType {
    TODO,
    IN_PROGRESS,
    DONE,
    QA;

    public static StoryStatusType fromString(String status) {
        return switch (status.toUpperCase()) {
            case "TODO" -> TODO;
            case "IN_PROGRESS" -> IN_PROGRESS;
            case "DONE" -> DONE;
            case "QA" -> QA;
            default -> throw new IllegalArgumentException("Invalid status: " + status);
        };
    }
}
