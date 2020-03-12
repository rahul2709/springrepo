package io.testapp.springbootdemo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CourseService {
	   
	    @Autowired
	    private CourseRepository courseRepository;
	    
		/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList ( new Topic("1"
	 * ,"spring", "spring"), new Topic("2" ,"spring", "spring"), new Topic("3"
	 * ,"spring", "spring") ));
	 */
		
		public List<Course> getAllCourses(){
			List<Course> topics = new ArrayList<>();
			courseRepository.findAll()
			.forEach(topics::add);
			return topics;			
		}
		
		public Course getCourse(String id)
		{
			//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
			//return topicRepository.f(id);
			return null;
		}

		public void addCourse(Course course) {
			courseRepository.save(course);		 			
		}

		public void updateCourse(Course course) {
		/*
		 * for (int i=0; i<topics.size() ; i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return; } }
		 */
			courseRepository.save(course);
		}

		public void deleteCourse(String id) {
			//topics.removeIf(t->t.getId().equals(id));
			courseRepository.deleteById(id);
			
		}
		
		

}
