package ch.globaz.tmmas.springgateway;

import ch.globaz.tmmas.springgateway.filters.PostRequestFilterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

import static org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTags.uri;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class);
	}
/**
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return customRouteOneOk3(builder);
	}

	private RouteLocator customRouteOneOk3 (RouteLocatorBuilder builder) {
		return builder.routes()


				.route("personnes-service", pathFiltre ->
						pathFiltre.path("/personnes/**")
								.and()
								.weight("per1",90)
								.filters(filtre ->
										filtre.stripPrefix(1)
								).uri("http://localhost:9010"))

				.route("personnes-service-v2", pathFiltre ->
						pathFiltre.path("/personnes/**")
								.and()
								.weight("per1",10)
								.filters(filtre ->
										filtre.stripPrefix(1)
								).uri("http://localhost:9012"))

				.route("rentes-service", pathFiltre ->
						pathFiltre.path("/rentes/**")
								.filters(filtre ->
										filtre.stripPrefix(1)
								)
								.uri("lb://rentes-service"))

				.build();
	}

	private RouteLocator customRouteOneOk2 (RouteLocatorBuilder builder) {
		return builder.routes()


				.route("personnes-service", pathFiltre ->
						pathFiltre.path("/personnes/**")
								.and()
								.weight("per1",90)
								.filters(filtre ->
										filtre.stripPrefix(1)
								).uri("lb://personnes-service"))

				.route("personnes-service-v2", pathFiltre ->
						pathFiltre.path("/personnes/**")
								.and()
								.weight("per1",10)
								.filters(filtre ->
										filtre.stripPrefix(1)
								).uri("lb://personnes-service-v2"))

				.route("rentes-service", pathFiltre ->
						pathFiltre.path("/rentes/**")
								.filters(filtre ->
										filtre.stripPrefix(1)
								)
								.uri("lb://rentes-service"))

				.build();
	}



	private RouteLocator customRouteOneOk (RouteLocatorBuilder builder) {
		return builder.routes()


				.route("personnes-service", pathFiltre ->
						pathFiltre.path("/personnes/**")
								.and()
								.weight("gr1",10)
								.filters(filtre ->
										filtre.stripPrefix(1)
								).uri("lb://personnes-service"))

				.route("rentes-service", pathFiltre ->
						pathFiltre.path("/rentes/**")
								.and()
								.weight("gr1",90)
								.filters(filtre ->
										filtre.stripPrefix(1)
								)
								.uri("lb://rentes-service"))

				.build();
	}

	private RouteLocator customRouteLocator1(RouteLocatorBuilder builder) {

		return builder.routes()

				.route("personnes-service",path -> {
					path.weight("",10);
					path.path("gr1").filters(filtre -> {
						return filtre.stripPrefix(1);
					});

					return path.uri("lb://personnes-service");
				})

				.route("rentes-service",path -> {
					path.weight("",90);
					path.path("gr1").filters(filtre -> {
						return filtre.stripPrefix(1);
					});

					return path.uri("lb://rentes-service");
				})

				.build();
	}




*/


}
