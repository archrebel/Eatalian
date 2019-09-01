/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package com.archetypesoftware.eatalian.services;

import com.archetypesoftware.eatalian.domain.orders.GroupRequest;
import com.archetypesoftware.eatalian.repositories.GroupRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GroupRequestService {
    private static final Logger logger = LoggerFactory.getLogger(GroupRequestService.class);

    private final GroupRequestRepository repository;

    @Autowired
    public GroupRequestService(GroupRequestRepository repository) {
        this.repository = repository;
    }

    public Iterable<GroupRequest> findAll() {
        return repository.findAll();
    }

    public GroupRequest findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find GroupRequest by " + id));
    }

    public GroupRequest save(GroupRequest entity) {
        return repository.save(entity);
    }

    public void delete(GroupRequest entity) {
        repository.delete(entity);
    }

    public void delete(Long id) {
        delete(findOne(id));
    }
}