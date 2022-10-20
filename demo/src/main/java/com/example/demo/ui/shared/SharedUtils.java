package com.example.demo.ui.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SharedUtils {
	public String generateUUID() {
		return UUID.randomUUID().toString();
	}
}
