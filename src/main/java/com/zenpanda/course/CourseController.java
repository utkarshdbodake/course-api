package com.zenpanda.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
    public List<Course> getCourses(@PathVariable String topicId) {
        return courseService.getCourses(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String id) {
        return courseService
                .getCourse(id)
                .orElse(null);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public Course addCourse(@PathVariable String topicId, @RequestBody Course course) {
        return courseService.addCourse(topicId, course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
        return courseService.updateCourse(topicId, course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
