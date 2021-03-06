package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.findAll());
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getById(@PathVariable Integer productId) {
		return ResponseEntity.ok(productService.findById(productId));
	}

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		return ResponseEntity.ok(productService.update(product));
	}

	@DeleteMapping("/{productId}")
	public void deleteById(@PathVariable Integer productId) {
		productService.deleteById(productId);
	}

}

