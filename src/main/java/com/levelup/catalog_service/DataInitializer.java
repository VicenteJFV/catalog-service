package com.levelup.catalog_service;

import com.levelup.catalog_service.model.Product;
import com.levelup.catalog_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo poblar si la BD está vacía
        if (productRepository.count() == 0) {
            System.out.println("🔵 Poblando base de datos con productos...");

            productRepository.save(new Product(
                    "PlayStation 5",
                    "Consola de última generación con rendimiento 4K",
                    new BigDecimal("549990"),
                    "http://10.0.2.2:8081/images/ps5.jpg",
                    10,
                    "PS5"
            ));

            productRepository.save(new Product(
                    "Auriculares Gamer HyperX Cloud II",
                    "Auriculares profesionales con sonido 7.1",
                    new BigDecimal("79990"),
                    "http://10.0.2.2:8081/images/hyperx.jpg",
                    25,
                    "PC"
            ));

            productRepository.save(new Product(
                    "Controlador Inalámbrico Xbox Series X",
                    "Control oficial de Xbox con conectividad Bluetooth",
                    new BigDecimal("59990"),
                    "http://10.0.2.2:8081/images/xboxcontroller.jpg",
                    15,
                    "Xbox"
            ));

            productRepository.save(new Product(
                    "Mouse Logitech G502 + Mousepad Razer Goliathus",
                    "Mouse gaming con sensor HERO 25K y mousepad de alto rendimiento",
                    new BigDecimal("49990"),
                    "http://10.0.2.2:8081/images/razer-goliathus.jpg",
                    30,
                    "PC"
            ));

            productRepository.save(new Product(
                    "Silla Gamer Secretlab TITAN",
                    "Silla ergonómica profesional para largas sesiones de gaming",
                    new BigDecimal("389990"),
                    "http://10.0.2.2:8081/images/secretlabtitan.jpg",
                    20,
                    "PC"
            ));

            // Productos adicionales usando las imágenes que tienes
            productRepository.save(new Product(
                    "Laptop Gamer ASUS ROG",
                    "Laptop de alto rendimiento para gaming profesional",
                    new BigDecimal("1299990"),
                    "http://10.0.2.2:8081/images/asus-rog.jpg",
                    8,
                    "PC"
            ));

            productRepository.save(new Product(
                    "Carcasonne Board Game",
                    "Juego de mesa estratégico ganador de múltiples premios",
                    new BigDecimal("29990"),
                    "http://10.0.2.2:8081/images/carcassonne.jpg",
                    15,
                    "Board Game"
            ));

            productRepository.save(new Product(
                    "Juego Catan",
                    "El clásico juego de mesa de estrategia y comercio",
                    new BigDecimal("34990"),
                    "http://10.0.2.2:8081/images/catan.jpg",
                    12,
                    "Board Game"
            ));

            productRepository.save(new Product(
                    "Logitech G502 HERO",
                    "Mouse gaming legendario con sensor de 25,600 DPI",
                    new BigDecimal("54990"),
                    "http://10.0.2.2:8081/images/g502.jpg",
                    20,
                    "PC"
            ));

            productRepository.save(new Product(
                    "Polera Level-Up Gaming",
                    "Polera oficial Level-Up con diseño exclusivo",
                    new BigDecimal("19990"),
                    "http://10.0.2.2:8081/images/polera-levelup.jpg",
                    50,
                    "Merchandise"
            ));

            System.out.println("✅ Base de datos poblada con " + productRepository.count() + " productos");
        } else {
            System.out.println("ℹ️ Base de datos ya contiene productos, omitiendo inicialización");
        }
    }
}