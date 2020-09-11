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
 
 

@Path("/formations")
public class MyResourceFormation {
 
    @GET
    @Path("/getformation")
    @Produces(MediaType.APPLICATION_JSON)
    //ajouter s ..??
    public List<Formations> getFormations() {
        FormationDAO dao = new FormationDAO();
        List formations = dao.getFormations();
        return formations;
    }
 
 
    @POST
    @Path("/create")
    //@Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFormations(Formations form){
    	form.setIdFormation(form.getIdFormation());
        form.setNom(form.getNom());
        form.setDuree(form.getDuree());
        form.setNomCabinet(form.getNomCabinet());
        form.setCommentaire(form.getCommentaire());

        
                
        FormationDAO dao = new FormationDAO();
        dao.addFormations(form);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateFormations(@PathParam("id") int idFormation, Formations form){
    	FormationDAO dao = new FormationDAO();
        int count = dao.updateFormations(idFormation, form);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response deleteFormations(@PathParam("id") int idFormation){
    	FormationDAO dao = new FormationDAO();
        int count = dao.deleteFormations(idFormation);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    


}
























