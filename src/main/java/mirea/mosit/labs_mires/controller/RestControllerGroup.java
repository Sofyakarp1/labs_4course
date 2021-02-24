package mirea.mosit.labs_mires.controller;

import mirea.mosit.labs_mires.bean.Group;
import mirea.mosit.labs_mires.service.IGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerGroup {

    private final IGroup studyGroupJdbc;

    public RestControllerGroup(IGroup IGroup) {
        this.studyGroupJdbc = IGroup;
    }

    @GetMapping("/group/{id}")
    public Group getStudyGroup(@PathVariable int id) {
        Group studyGroup = studyGroupJdbc.getGrop(id);
        return studyGroup;
    }

    @GetMapping("/group/showAllGroup")
    public List<Group> getStudyGroup() {
        return studyGroupJdbc.showAllGroups();
    }
}
