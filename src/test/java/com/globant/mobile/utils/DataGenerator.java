package com.globant.mobile.utils;

import java.util.UUID;

public class DataGenerator {

    /**
     * Generates a unique email address using a random UUID.
     * Example output: automation_f47ac10b@test.com
     */
    public static String generateRandomEmail() {
        // Generate a random UUID
        String fullUuid = UUID.randomUUID().toString();

        // We only take the first 8 characters to keep the email short and clean
        String shortUuid = fullUuid.substring(0, 8);

        return "automation_" + shortUuid + "@test.com";
    }
}