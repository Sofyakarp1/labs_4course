package mirea.mosit.labs_mires.controller;

import mirea.mosit.labs_mires.bean.Mark;
import mirea.mosit.labs_mires.service.IMark;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerMark {

    private final IMark markJdbc;

    public RestControllerMark(IMark iMark) {
        this.markJdbc = iMark;
    }

    @GetMapping("/mark/{id}")
    public Mark getMark(@PathVariable int id) {
        Mark mark = markJdbc.getMark(id);
        return mark;
    }

    @GetMapping("/mark/showAllGroup")
    public List<Mark> showAll() {
        return markJdbc.showAllMarks();
    }
}
