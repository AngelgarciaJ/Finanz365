






package com.pronabc.finanz.api;

import com.pronabc.finanz.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {
    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Student getEstudianteById(Long id) {
        String url = "http://localhost:8080/estudiantes/" + id;
        return restTemplate.getForObject(url, Student.class);
    }
}







//package com.pronabc.finanz.api;
//
//import com.pronabc.finanz.model.Student;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class ApiClient {
//
//    private final RestTemplate restTemplate;
//    private final String apiUrl;
//
//    public ApiClient(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
//        this.restTemplate = restTemplate;
//        this.apiUrl = apiUrl;
//    }
//
//    // Otros métodos para registrar ingresos/egresos, generar informes, etc.
//    // Aquí definirás métodos para realizar las operaciones con la API REST
//    // Por ejemplo, métodos para obtener datos de estudiantes, registrar ingresos/egresos, etc.
//
//
//    // Ejemplo de método para obtener datos de estudiantes desde la API REST
////    public Student getEstudianteById(Long estudianteId) {
////        String url = apiUrl + "/estudiantes/" + estudianteId;
////        return restTemplate.getForObject(url, Estudiante.class);
////    }
//
//    public Student getEstudianteById(Long id) {
//        String url = "http://localhost:8080/api/estudiantes/" + id;
//        return restTemplate.getForObject(url, Estudiante.class);
//    }
//
//
//}
