package com.devsuperior.dscatalog.controllers;

import com.devsuperior.dscatalog.projections.ProductProjection;
import com.devsuperior.dscatalog.services.ProductService;
import com.devsuperior.dscatalog.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "categoryId", defaultValue = "0") String categoryId,
            Pageable pageable){
        Page<ProductDTO> list = productService.findAllPaged(name, categoryId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
        dto = productService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){
        dto = productService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
