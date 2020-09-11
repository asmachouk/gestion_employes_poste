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
import com.topjavatutorial.dao.Postes;
import com.topjavatutorial.dao.PosteDAO;

 

@Path("/postes")
public class MyResourcePoste {
 
    @GET
    @Path("/getposte")
    @Produces(MediaType.APPLICATION_JSON)
    //ajouter s ..??
    public List<Postes> getPostes() {
        PosteDAO dao = new PosteDAO();
        List postes = dao.getPostes();
        return postes;
    }
 
 
    @POST
    @Path("/create")
    //@Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPOstes(Postes pos){
    	pos.setIdPoste(pos.getIdPoste());
       pos.setNom(pos.getNom());
       pos.setDescription(pos.getDescription());
       

        
                
        PosteDAO dao = new PosteDAO();
        dao.addPostes(pos);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updatePostes(@PathParam("id") int idPoste, Postes pos){
        PosteDAO dao = new PosteDAO();
        int count = dao.updatePostes(idPoste, pos);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
   // @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)

    public Response deletePostes(@PathParam("id") int idPoste){
        PosteDAO dao = new PosteDAO();
        int count = dao.deletePostes(idPoste);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    



}
























