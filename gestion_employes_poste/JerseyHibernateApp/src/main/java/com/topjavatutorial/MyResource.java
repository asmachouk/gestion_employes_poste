package com.topjavatutorial;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import com.topjavatutorial.dao.Employes;
import com.topjavatutorial.dao.EmployeeDAO;
import com.topjavatutorial.dao.Formations;
import com.topjavatutorial.dao.FormationDAO;
 
 
@Path("/employes")
//@Path("/formations")
public class MyResource {
 
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    //ajouter s ..??
    public List<Employes> getEmployes() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployes();
        return employees;
    }
 
    
    @POST
    @Path("/create")
    //@Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployes(Employes emp){
    	emp.setIdEmploye(emp.getIdEmploye());
        emp.setNom(emp.getNom());
        emp.setPrenom(emp.getPrenom());
        emp.setAdresse(emp.getAdresse());
        emp.setEmail(emp.getEmail());
        emp.setPostes(emp.getPostes());

        
                
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployes(emp);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateEmployes(@PathParam("id") int idEmploye, Employes emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployes(idEmploye, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response deleteEmployes(@PathParam("id") int idEmploye){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployes(idEmploye);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    
//**************************************************************************************************
   /* @GET
    @Path("/getformation")
    @Produces(MediaType.APPLICATION_JSON)
    //ajouter s ..??
    public List<Formations> getFormations() {
        FormationDAO dao = new FormationDAO();
        List formations = dao.getFormations();
        return formations;
    }
 */
 /*   
    @POST
    @Path("/create")
    //@Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployes(Employes emp){
    	emp.setIdEmploye(emp.getIdEmploye());
        emp.setNom(emp.getNom());
        emp.setPrenom(emp.getPrenom());
        emp.setAdresse(emp.getAdresse());
        emp.setEmail(emp.getEmail());

        
                
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployes(emp);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateEmployes(@PathParam("id") int idEmploye, Employes emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployes(idEmploye, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response deleteEmployes(@PathParam("id") int idEmploye){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployes(idEmploye);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
*/


}
 