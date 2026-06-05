package com.alves.hexagonal.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration
@Profile("dev")
public class WireMockAddressConfig {

    private WireMockServer server;

    @PostConstruct
    public void start() {
        // Sobe WireMock na porta 8082 — mesma usada pelo Feign
        server = new WireMockServer(options().port(8082));
        server.start();

        configureFor("localhost", 8082);

        // =====================
        //       STUBS
        // =====================

        // 1) Sucesso genérico: qualquer CEP com 8 dígitos
        stubFor(get(urlPathMatching("/addresses/\\d{8}"))
                .willReturn(okJson("""
                    {
                      "street": "Rua das Flores",
                      "city": "São Paulo",
                      "state": "SP"
                    }
                """)));

        // 2) CEP inexistente (404)
        stubFor(get(urlEqualTo("/addresses/00000000"))
                .willReturn(aResponse()
                        .withStatus(404)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"erro\":\"CEP não encontrado\"}")));

        // 3) CEP 38400000 — com delay
        stubFor(get(urlEqualTo("/addresses/38400000"))
                .willReturn(aResponse()
                        .withFixedDelay(600)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                            {
                              "street": "Rua Hexagonal",
                              "city": "Uberlândia",
                              "state": "Minas Gerais"
                            }
                        """)));

        // 4) CEP 38400100 — endereço válido extra
        stubFor(get(urlEqualTo("/addresses/38400100"))
                .willReturn(okJson("""
                    {
                      "street": "Avenida do Sol",
                      "city": "Uberlândia",
                      "state": "Minas Gerais"
                    }
                """)));

        // 5) CEP 38400200 — outro endereço válido
        stubFor(get(urlEqualTo("/addresses/38400200"))
                .willReturn(okJson("""
                    {
                      "street": "Praça Central",
                      "city": "Uberlândia",
                      "state": "Minas Gerais"
                    }
                """)));

        // 6) CEP 38400300 — mais um endereço válido
        stubFor(get(urlEqualTo("/addresses/38400300"))
                .willReturn(okJson("""
                    {
                      "street": "Rua das Palmeiras",
                      "city": "Uberlândia",
                      "state": "Minas Gerais"
                    }
                """)));
    }

    @PreDestroy
    public void stop() {
        if (server != null && server.isRunning()) {
            server.stop();
        }
    }
}