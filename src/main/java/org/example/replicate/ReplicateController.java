package org.example.replicate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplicateController {
	@GetMapping
	public String replicate() {
		return "Replicate";
	}
}
