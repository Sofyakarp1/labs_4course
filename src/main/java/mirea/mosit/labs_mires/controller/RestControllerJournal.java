package mirea.mosit.labs_mires.controller;

import mirea.mosit.labs_mires.bean.Journal;
import mirea.mosit.labs_mires.service.IJournal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerJournal {

    private final IJournal journalJdbc;

    public RestControllerJournal(IJournal iJournal) {
        this.journalJdbc = iJournal;
    }

    @GetMapping("/journal/{id}")
    public Journal getJournal(@PathVariable int id) {
        Journal journal = journalJdbc.getJournal(id);
        return journal;
    }
}
