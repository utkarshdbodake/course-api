package com.zenpanda.course;

import com.zenpanda.topic.Topic;
import com.zenpanda.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TopicService topicService;

    public List<Course> getCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository
                .findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(String topicId, Course course) {
        Topic topic = getTopic(topicId);
        course.setTopic(topic);
        return courseRepository.save(course);
    }

    public Course updateCourse(String topicId, Course course) {
        Topic topic = getTopic(topicId);
        course.setTopic(topic);
        return courseRepository.save(course);
}

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public Topic getTopic(String id) {
        return topicService
                .getTopic(id)
                .orElse(null);
    }
}