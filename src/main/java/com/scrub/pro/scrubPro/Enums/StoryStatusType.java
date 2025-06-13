package com.scrub.pro.scrubPro.Enums;

public enum StoryStatusType {
    TODO,
    IN_PROGRESS,
    DONE;

    public static StoryStatusType fromString(String status) {
        return switch (status.toUpperCase()) {
            case "TODO" -> TODO;
            case "IN_PROGRESS" -> IN_PROGRESS;
            case "DONE" -> DONE;
            default -> throw new IllegalArgumentException("Invalid status: " + status);
        };
    }
}
