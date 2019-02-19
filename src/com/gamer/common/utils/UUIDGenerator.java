package com.gamer.common.utils;

import java.util.UUID;

public class UUIDGenerator {
	private static UUID uuid = UUID.randomUUID();
	public static String getUUID() {
		String str = uuid.toString();
		return str;
	}
}
