package io.testapp.springbootdemo.course;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.testapp.springbootdemo.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/topicId/courses/{id}")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);		
	}
    
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/topicId/courses/{id}")
	public void updateCourse(@RequestBody Course course , @PathVariable String topicId)
	{   
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
		
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/topicId/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	
	
}
