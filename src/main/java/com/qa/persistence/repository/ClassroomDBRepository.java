package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
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
        Classroom classroomInDB = findClassroom(id);
        if(classroomInDB != null){
            manager.remove(classroomInDB);
        }
        return "{\"message\": \"The classroom was successfully deleted\"}";
    }

    @Override
    public String getAllTrainees() {
        TypedQuery<Trainee> query = manager.createQuery("SELECT t from Trainee t order by t.traineeId asc ", Trainee.class);
        return utility.getJSONForObject(query.getResultList());
    }

    @Override
    public String createTrainee(String trainee) {
        Trainee trainee1 = utility.getObjectForJSON(trainee, Trainee.class);
        manager.persist(trainee1);
        return "{\"message\": \"trainee has been successfully added\"}";
    }

    @Override
    public String updateTrainee(int id, String traineeToUpdate) {
        Trainee updatedTrainee = utility.getObjectForJSON(traineeToUpdate, Trainee.class);
        Trainee traineeFromDB = findTrainee(id);
        if(traineeFromDB != null){
            traineeFromDB = updatedTrainee;
            manager.merge(traineeFromDB);
        }
        return "{\"message\": \"trainee has been successfully updated\"}";
    }

    private Trainee findTrainee(int id) {
        return manager.find(Trainee.class, id);
    }

    @Override
    public String deleteTrainee(int id) {
        Trainee traineeInDB = findTrainee(id);
        if(traineeInDB != null){
            manager.remove(traineeInDB);
        }
        return "{\"message\": \"The trainee was successfully deleted\"}";
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public JSONUtility getUtility() {
        return utility;
    }

    public void setUtility(JSONUtility utility) {
        this.utility = utility;
    }
}
