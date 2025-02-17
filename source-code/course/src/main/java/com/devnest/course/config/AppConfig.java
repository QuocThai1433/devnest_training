package com.devnest.course.config;

//@Configuration
//@RequiredArgsConstructor
//@EnableMethodSecurity(prePostEnabled = true)
public class AppConfig {
	
	private final String[] whitelistedUrls = {"/auth/**"};
	
//	private final CustomizeRequestFilter requestFilter;
	
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> request.requestMatchers(whitelistedUrls).permitAll()
//                        .anyRequest().authenticated())
//                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
//                .authenticationProvider(authenticationProvider()).addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

	
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(@NonNull CorsRegistry registry) {
//                registry.addMapping("**")
//                        .allowedOrigins("http://localhost:8500")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
//                        .allowedHeaders("*") // Allowed request headers
//                        .allowCredentials(false)
//                        .maxAge(3600);
//            }
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
