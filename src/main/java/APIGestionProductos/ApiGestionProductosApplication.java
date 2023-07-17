package APIGestionProductos;

import APIGestionProductos.Modelos.Productos;
import APIGestionProductos.Repositorios.ProductosRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ApiGestionProductosApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiGestionProductosApplication.class, args);
	}


	@Bean
	public CommandLineRunner Datos(ProductosRepositorio productosRepositorio) {
		return (args) -> {
			Productos productos1 = new Productos("Devanador Ovillador De Lana Manual", "Ovillador - Devanador Manual de excelente calidad. Incluye en el precio el Ovillador y el porta madeja. Con este Ovillador conseguirás que tus ovillos sean perfectos.", 9820.99, 5000, LocalDate.now());
			productosRepositorio.save(productos1);
		};
	}
}