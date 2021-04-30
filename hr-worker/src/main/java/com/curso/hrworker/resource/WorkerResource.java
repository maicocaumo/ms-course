package com.curso.hrworker.resource;


import com.curso.hrworker.entity.Worker;
import com.curso.hrworker.repository.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
@Slf4j
public class WorkerResource {

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository workerRepository;

    @Value("${test.config}")
    private String value;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<String> getConfig() {
        return ResponseEntity.ok(value);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        log.info("PORT = " + env.getProperty("local.server.port"));

        Optional<Worker> worker = workerRepository.findById(id);
        return ResponseEntity.ok(worker.get());
    }
}
