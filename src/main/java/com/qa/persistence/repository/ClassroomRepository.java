package com.qa.persistence.repository;

public interface ClassroomRepository {
    String getAllClassrooms();
    String createClassroom(String classroom);
    String updateClassroom(int id, String classroomToUpdate);
    String deleteClassroom(int id);

    String getAllTrainees();
    String createTrainee(String trainee);
    String updateTrainee(int id, String traineeToUpdate);
    String deleteTrainee(int id);
}
