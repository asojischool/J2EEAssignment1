package webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

import models.*;

@Path("/tours")
public class ToursWS {
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		TourService tourService = new TourService();
		List<Tour> tours = tourService.getAllTours();
		
		String[] tourJSONString = new String[tours.size()];
		
		for (int i = 0; i < tours.size(); i++) {
			Tour tempTour = tours.get(i);
			String tempTourString = "{\"availableSlots\":" + tempTour.getAvailableSlots() + ","
					+ "\"briefDescription\":\"" + tempTour.getBriefDescription() + "\","
					+ "\"fullDescription\":\"" + tempTour.getFullDescription() + "\","
					+ "\"categoryID\":" + tempTour.getCategoryID() + ","
					+ "\"categoryID\":" + tempTour.getCategoryID() + ","
					+ "\"startDate\":\"" + tempTour.getStartDate() + "\","
					+ "\"endDate\":\"" + tempTour.getEndDate()+ "\","
					+ "\"image\":\"" + tempTour.getImage() + "\","
					+ "\"location\":\"" + tempTour.getLocation()+ "\","
					+ "\"price\":" + tempTour.getPrice() + ","
					+ "\"tourID\":" + tempTour.getTourID() + ","
					+ "\"tourName\":\"" + tempTour.getTourName() + "\","
					+ "\"toursBought\":" + tempTour.getToursBought() + "}";
			tourJSONString[i] = tempTourString;
		}
		
		String jsonOutput="{"
				+ "\"tours\" : [" + String.join(",", tourJSONString) + "],"
				+ "\"totalCount\" : " + tours.size()
				+ "}";
		
		return Response.status(Response.Status.OK).entity(jsonOutput).build();
	}
}
