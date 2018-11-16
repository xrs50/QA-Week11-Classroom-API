package com.qa.interoperability.rest;

import com.qa.business.service.ClassroomService;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/classroom")
public class Endpoint {

    @Inject
    private ClassroomService classroomService;

    @Path("/classroom")
    @GET
    @Produces({"application/json"})
    public String getAllClassrooms(){
        return classroomService.getAllClassrooms();
    }

    @Path("/trainee")
    @GET
    @Produces({"application/json"})
    public String getAllTrainees(){
        return classroomService.getAllTrainees();
    }

    @Path("/classroom")
    @POST
    @Produces({"application/json"})
    public String addClassroom(String classroom){
        return classroomService.addClassroom(classroom);
    }

    @Path("/trainee")
    @POST
    @Produces({"application/json"})
    public String addTrainee(String trainee){
        return classroomService.addTrainee(trainee);
    }

    @Path("/classroom/{id}")
    @PUT
    @Produces({"application/json"})
    public String updateClassroom(@PathParam("id") int id, String classroomToUpdate){
        return classroomService.updateClassroom(id, classroomToUpdate);
    }

    @Path("/trainee/{id}")
    @PUT
    @Produces({"application/json"})
    public String updateTrainee(@PathParam("id") int id, String traineeToUpdate){
        return classroomService.updateTrainee(id, traineeToUpdate);
    }

    @Path("/classroom/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteClassroom(@PathParam("id") int id){
        return classroomService.deleteClassroom(id);
    }

    @Path("/trainee/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteTrainee(@PathParam("id") int id){
        return classroomService.deleteTrainee(id);
    }
}
