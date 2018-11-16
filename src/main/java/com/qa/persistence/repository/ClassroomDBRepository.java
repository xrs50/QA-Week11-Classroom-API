package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtility;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Default
public class ClassroomDBRepository implements ClassroomRepository{

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtility utility;

    @Override
    public String getAllClassrooms() {
        TypedQuery<Classroom> query = manager.createQuery("SELECT c from Classroom c order by c.classroomId asc ",Classroom.class);
        return utility.getJSONForObject(query.getResultList());
    }

    @Override
    public String createClassroom(String classroom) {
        Classroom classroom1 = utility.getObjectForJSON(classroom, Classroom.class);
        manager.persist(classroom1);
        return "{\"message\": \"classroom has been successfully added\"}";
    }

    @Override
    public String updateClassroom(int id, String classroomToUpdate) {
        Classroom updatedClassroom = utility.getObjectForJSON(classroomToUpdate, Classroom.class);
        Classroom classroomFromDB = findClassroom(id);
        if(classroomFromDB != null){
            classroomFromDB = updatedClassroom;
            manager.merge(classroomFromDB);
        }
        return "{\"message\": \"classroom has been successfully updated\"}";
    }

    private Classroom findClassroom(int id) {
        return manager.find(Classroom.class, id);
    }

    @Override
    public String deleteClassroom(int id) {
        return null;
    }

}
