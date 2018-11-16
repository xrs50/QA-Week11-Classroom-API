package com.qa.interoperability.rest;

import com.qa.business.service.ClassroomService;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/classroom")
public class Endpoint {

    @Inject
    private ClassroomService classroomService;

    @Path("/retrieveclassroom")
    @GET
    @Produces({"application/json"})
    public String getAllClassrooms(){
        return classroomService.getAllClassrooms();
    }

    @Path("/retrieveclassroom")
    @POST
    @Produces({"application/json"})
    public String addClassroom(String classroom){
        return classroomService.addClassroom(classroom);
    }

    @Path("/changeclassroom/{id}")
    @PUT
    @Produces({"application/json"})
    public String updateClassroom(@PathParam("id") int id, String classroomToUpdate){
        return classroomService.updateClassroom(id, classroomToUpdate);
    }

    @Path("/changeclassroom/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteClassroom(@PathParam("id") int id){
        return classroomService.deleteClassroom(id);
    }
}
