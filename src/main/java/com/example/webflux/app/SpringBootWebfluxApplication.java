package com.example.webflux.app;


import com.example.webflux.app.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Flux<Usuario> nombres = Flux.just("Andres", "Juan", "Maria", "Fernando")
                .map(nombre -> new Usuario(nombre.toUpperCase(), null))
                .doOnNext(usuario -> {
                    if (usuario == null) {
                        throw new RuntimeException("Nombre no pueden ser vacíos");
                    }
                    System.out.println(usuario.getNombre());
                })
                .map(usuario -> {
                    String nombre = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });

        nombres.subscribe(e -> log.info(e.toString()),
                error -> log.error(error.getMessage()),
                new Runnable() {


                    @Override
                    public void run() {
                        log.info("Creen en ti mismo y nunca dejes de intentar ");
                    }
                });
    }
}
